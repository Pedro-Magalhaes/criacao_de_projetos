package main;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import DAO.PropertyDAO;
import model.*;
import model.File.FileType;
import controller.*;


public class Main {

	static ArrayList<Property> properties = new ArrayList<Property>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		File f = new File();
		f.setName("img");
		f.setPath("img/foo.png");
		f.setType(FileType.PNG);
		f.setSize(0);
		
		Info i = new Info("receitas","minhas receitas casa 01");
		i.addFile(f);
		
		Property p = new Property();
		p.setDescription("minha casa");
		p.setName("casa");
		p.setValue(1000);
		
		
		
		ArrayList<File> ff = i.getFiles();
		
//		for (File file : ff) {
//			System.out.print(file.getName() + " " + file.getPath());
//		}
		
		Receipt r = new Receipt( Date.from(Instant.now()),2,false);
		
		ItemOfInterest item = new ItemOfInterest("primeiro item","primeiro item de interesse");
		item.addReceipt(r);
		item.registerInfo(i);
		
		p.addItem(item);
		

		PropertyDAO pd = PropertyDAO.getPropertyDAOInstance();
		ArrayList<Property> ps = new ArrayList<Property>();
		ps.add(p);
		pd.saveUserData("01", ps);
		printProperties(ps);
//		try {
//			ArrayList<Property> psfromfile = pd.loadUserData("01");
//			printProperties(psfromfile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static boolean addProperty(Property p) {
		return properties.add(p);
	}
	
	public static void printProperties(ArrayList<Property> ps) {
		for (Property p : ps) {
			System.out.println( "Name: "+ p.getName() + "\n" + "desc: " + p.getDescription());
			System.out.println("Itens:");
			ArrayList<ItemOfInterest> it = p.getItens();
			for (ItemOfInterestInterface item : it) {
				ArrayList<Receipt> rs = item.getReceipts();
				ArrayList<Info> infos = item.getInfos();
				System.out.println("\tReceipts:");
				for (Receipt r : rs) {
					System.out.println("\t\tdate: "+r.getData().toString() + "\n\t\tvalue: " + r.getValue());
				}
				System.out.println("\tinfos:");
				for (Info i : infos) {
					System.out.println("\t\ttitle: "+i.getTitle()+ "\n\t\tdesc: " + i.getDescription());
					ArrayList<File> fs = i.getFiles();
					if( fs.isEmpty() == false) {
						System.out.println("\t\tfiles:");
						for (File f : fs) {
							System.out.println("\t\t\tName: "+f.getName()+ "\n\t\t\tPath: " + f.getPath());
						}
					}
				}
				
			}			
		}
		
	}

}
