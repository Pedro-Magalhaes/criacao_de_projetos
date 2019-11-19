package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.Property;

public class PropertyDAO {
	
	private final String path = "data";
	Type propertiesType = new TypeToken<ArrayList<Property>>(){}.getType();
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static PropertyDAO instance;
	
	
	
	private PropertyDAO() {
		File directory = new File(path);
		directory.mkdir(); // cria se não houver a pasta, não faz nada caso contrario
	}
	
	public static PropertyDAO getPropertyDAOInstance() {
		if( instance == null ) {
			instance = new PropertyDAO();
		}
		return instance;
	}
	
	public ArrayList<Property> loadUserData(String userid) throws IOException {
		File f = new File( String.join(File.separator, path,userid+".txt") );
//		System.out.println(f.getAbsolutePath());
		JsonReader reader = new JsonReader(new FileReader(f));
		ArrayList<Property> ps = this.gson.fromJson(reader, propertiesType);
//		for (Property property : ps) {
//			System.out.println(property.toString());
//		}
		
		return ps; 
	}
	
	public void saveUserData(String userid, ArrayList<Property> ps) {
		try {
			FileWriter fw = new FileWriter(String.join(File.separator, path,userid+".txt"));
			this.gson.toJson(ps, fw);
			fw.flush();
			fw.close();
		} catch (JsonIOException | IOException e) {
			System.out.println("Não foi possivel escrever o arquivo. Path: \n" + String.join(File.pathSeparator, path,userid+".json"));
			e.printStackTrace();
		}
	}
	
	static String readFile(String path, Charset encoding ) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
