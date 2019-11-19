package controller;

import java.io.IOException;
import java.util.ArrayList;

import DAO.PropertyDAO;
import model.Property;

// Cadastrar uma propriedade
public class UC1 {

	private String userId = "01"; // para essa implementação usaremos apenas um usuario
	private ArrayList<Property> properties;
	PropertyDAO pDAO = PropertyDAO.getPropertyDAOInstance();
	
	public UC1() {
		properties = new ArrayList<Property>();
		try {
			properties = pDAO.loadUserData(userId);
		} catch (IOException e) { // se não conseguir sera vazio
			System.out.println("Arquivo não encontrado,inicializando vazio");
		}
	}
	// Nome deve ser unico e diferente de vazio
	public boolean createNewProperty(String name, String description, int value) {
		if( name == null || name.equals("")) {
			return false;
		} else {
			for (Property property : properties) { // nome tem que ser unico
				if(name.equals(property.getName())) {
					return false;
				}
			}
		}
		Property p = new Property(name, description, value);
		properties.add(p);
		return true;
	}
	
	public void save() {
		pDAO.saveUserData(userId, properties);
	}
	
	public ArrayList<Property> getProperties() {
		return properties;
	}
 

}
