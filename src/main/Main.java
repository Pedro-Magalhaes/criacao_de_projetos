package main;

import java.io.IOException;
import java.text.DateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;

import DAO.PropertyDAO;
import model.*;
import model.MyFile.FileType;
import controller.*;


public class Main {

	static ArrayList<Property> properties = new ArrayList<Property>();
	static PropertyDAO pd;
	static ArrayList<Property> ps;
	static UC1 pController = new UC1();
	public static void main(String[] args) {
		
		mainloop();
		
//		pd = PropertyDAO.getPropertyDAOInstance();
//		File f = new File();
//		f.setName("img");
//		f.setPath("img/foo.png");
//		f.setType(FileType.PNG);
//		f.setSize(0);
//		
//		Info i = new Info("receitas","minhas receitas casa 01");
//		i.addFile(f);
//		
//		Property p = new Property();
//		p.setDescription("minha casa");
//		p.setName("casa");
//		p.setValue(1000);
//		
//		
//		
//		ArrayList<File> ff = i.getFiles();
		
//		for (File file : ff) {
//			System.out.print(file.getName() + " " + file.getPath());
//		}
		
//		Receipt r = new Receipt( Date.from(Instant.now()),2,false);
//		
//		ItemOfInterest item = new ItemOfInterest("primeiro item","primeiro item de interesse");
//		item.addReceipt(r);
//		item.registerInfo(i);
//		
//		p.addItem(item);
		

		
//		ArrayList<Property> ps = new ArrayList<Property>();
//		ps.add(p);
//		pd.saveUserData(user, ps);
//		printProperties(ps);
//		try {
//			ArrayList<Property> psfromfile = pd.loadUserData("01");
//			printProperties(psfromfile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static boolean addProperty(Property p) {
		return ps.add(p);
	}
	
	public static void printProperties(ArrayList<Property> ps) {
		for (Property p : ps) {
			printProperty(p);
		}		
	}
	
	
	public static void printProperty(Property p) {
		System.out.println( "Name: "+ p.getName() + "\n" + "desc: " + p.getDescription());
		System.out.println("Itens:");
		ArrayList<ItemOfInterest> it = p.getItens();
		for (ItemOfInterestInterface item : it) {
			System.out.println("\tname: " + item.getName() + " desc: " + item.getDescription());
			ArrayList<Receipt> rs = item.getReceipts();
			ArrayList<Info> infos = item.getInfos();
			System.out.println("\tReceipts:");
			for (Receipt r : rs) {
				System.out.println("\t\tdate: "+r.getData().toString() + "\n\t\tvalue: " + r.getValue());
			}
			System.out.println("\tinfos:");
			for (Info i : infos) {
				System.out.println("\t\ttitle: "+i.getTitle()+ "\n\t\tdesc: " + i.getDescription());
				ArrayList<MyFile> fs = i.getFiles();
				if( fs.isEmpty() == false) {
					System.out.println("\t\tfiles:");
					for (MyFile f : fs) {
						System.out.println("\t\t\tName: "+f.getName()+ "\n\t\t\tPath: " + f.getPath());
					}
				}
			}
		}	
	}
	
	public static void mainloop() {
		Scanner sc = new Scanner(System.in);
		int option = 1;
		while(option != 0) {
			for(PropertyOptions po: PropertyOptions.values()) {
				System.out.println("Digite " + po.getNumber() + " para " + po.getFrase());
			}
			option = sc.nextInt();
			sc.reset();
			switch (option) {
			case 0:
				pController.save();
				return;
			case 1:
				createProperty(sc);
				break;
			case 2:
				selectProperty(sc);
				break;
			default:
				pController.save();
				break;
			}
		}
	}
	
	private static void createProperty(Scanner sc) {
		String name;
		String description;
		int value;
		try {
			System.out.println("Digite o nome da propriedade(sem espaço):");
			name = sc.next();
			sc.reset();
			System.out.println("Digite uma descrição(sem espaço):");
			description = sc.next();
			sc.reset();
			System.out.println("Digite o valor inteiro:");
			value = sc.nextInt();
			sc.reset();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao criar propriedade! (Crash)");
			return;
		}
		if(pController.createNewProperty(name, description, value) == true) {
			System.out.println("Propriedade criada com sucesso!");
		} else {
			System.out.println("Erro ao criar propriedade, o nome era válido? tem que ser não vazio e único");
		}
		
	}
	
	private static void selectProperty(Scanner sc) {
		int option = -1;
		ArrayList<Property> properties = pController.getProperties();
		while(option != 0) {
			System.out.println("Selecione uma propriedade");
			int i = 0;
			System.out.println("Digite " + i + " para voltar");
			for(Property p: properties) {
				i = i + 1;
				System.out.println("Digite " + i + " para ver propriedade : "+ p.getName());
			}
			option = sc.nextInt();
			sc.reset();
			if(option > 0 && option <= properties.size()) { // option vai ser de [1 a n]
				propertyInterface(properties.get(option - 1),sc);
			}
		}
		
		
	}
	
    private static void propertyInterface(Property p, Scanner sc) {
    	System.out.println("PROPRIEDADE:");
    	printProperty(p);
    	int option = 1;
		while(option != 0) {
			System.out.println("Digite 0 para voltar");
			System.out.println("Digite 1 para selecionar um item de interesse");
			System.out.println("Digite 2 para criar um item de interesse");
			option = sc.nextInt();
			sc.reset();
			if(option == 1) {
				itensInterface(p.getItens(),sc);
			} else if (option == 2) {
				createAndAddItem(p, sc);
			}
		}
    }
    
    private static void createAndAddItem(Property p, Scanner sc) {
    	String name;
		String description;
		try {
			System.out.println("Digite o nome da propriedade(sem espaço):");
			name = sc.next();
			sc.reset();
			System.out.println("Digite uma descrição(sem espaço):");
			description = sc.next();
			sc.reset();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao criar Item! (Crash)");
			return;
		}
		if(name.equals("")) {
			System.out.println("não foi possivel criar o Item (nome vazio)");
			return;
		}
		ItemOfInterest i = new ItemOfInterest(name,description);
		p.addItem(i);
		
    }
    
    private static void itensInterface(ArrayList<ItemOfInterest> its, Scanner sc) {
    	System.out.println("ITENS:");
    	int i = 0;
    	
    	for (ItemOfInterest item: its) {
    		System.out.println(i + " para item nome:" + item.getName() + " desc: " + item.getDescription());
    		i++;
		}
    	
    	i = sc.nextInt();
		sc.reset();
		if(i >= 0 && i < its.size()) {
			itemInterface(its.get(i),sc);
		}
    }
	
    private static void itemInterface(ItemOfInterest i, Scanner sc) {
    	ArrayList<Receipt> recpts = i.getReceipts();
    	UC3 u3 = new UC3(i);
    	int option = 1;
    	System.out.println("Digite 0 para voltar");
    	for (Receipt r : recpts) {
    		System.out.println(option + " para selecionar recibo data: " + r.getData().toString());
    		option++;
		}
		
		System.out.println("Digite "+ option + " para criar um recibo");
		option = getOption(sc,"itemInterface erro");
		if(option > 0 && option <= recpts.size()) {
			receiptInterface(recpts.get(option-1),sc,u3);
		} else if (option == recpts.size() + 1) {
			createReceipt(i,sc);
		}
    }
    
    private static void receiptInterface(Receipt r, Scanner sc,UC3 u3) {
    	System.out.println("Receipt:");
    	System.out.println("\tValor: " + r.getValue());
    	if( r.getInformations().size() > 0) {
    		int option = 0;
        	Info i = r.getInformations().get(0); //Simplificando! deixando apenas uma info
        	System.out.println("\tInfo: " + i.getTitle() + " desc: " + i.getDescription());
        	if(i.getFiles().size() > 0) {
        		MyFile f = i.getFiles().get(0); //Simplificando!
            	
            	
            	System.out.println("\tFile: " + f.getPath());
            	
            	System.out.println("Digite 0 para voltar." + "1 para abrir a imagem");
            	option = getOption(sc,"ReceiptInterface erro");
            	if(option == 1) {
            		new Thread(() -> u3.openImage(f)).start(); 
            	}
        	}
        	
    	}
    	
    }

	private static int getOption(Scanner sc, String errorInfo) {
		int option = -1;
		try {
			option = sc.nextInt();
			sc.reset();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(errorInfo);
		}
		return option;
	}
    
    private static void createReceipt(ItemOfInterest i, Scanner sc) {
    	int valor;
		boolean cash = true;
		
		// info
		String nome;
		String desc;
		String filePath;
		try {
			System.out.println("Digite o valor do recibo(int):");
			valor = sc.nextInt();
			sc.reset();
			System.out.println("Digite o nome do anexo ao recibo:");
			nome = sc.next();
			sc.reset();
			System.out.println("Digite uma descriçao:");
			desc = sc.next();
			sc.reset();
			System.out.println("Digite o path relativo da imagem:");
			filePath = sc.next();
			sc.reset();
			
			Info info = new Info(nome,desc);
			MyFile f = new MyFile(nome,filePath,1,FileType.JPG);
			info.addFile(f);
			Receipt r = new Receipt(Date.from(Instant.now()), valor, cash);
			r.registerInfo(info);
			i.addReceipt(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao criar propriedade! (Crash)");
			return;
		}
    }
    
	private enum PropertyOptions {
		Terminar(0,"Terminar programa"),
		Criar(1,"Criar nova propriedade"),
		Mostrar(2,"Selceionar uma propriedade existente");
		private final int number;
		private final String frase;
		PropertyOptions(int i, String f) {
			this.frase = f;
			this.number = i;
		}
		public String getFrase() {
			return frase;
		}
		public int getNumber() {
			return number;
		}
		
	}

}
