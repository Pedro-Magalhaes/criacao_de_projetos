package model;

import java.util.ArrayList;

public interface PropertyInterface {

	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	int getValue();

	void setValue(int value);
	
	public ArrayList<ItemOfInterest> getItens();

	public void setItens(ArrayList<ItemOfInterest> itens);
	
	public boolean addItem(ItemOfInterest item);

}