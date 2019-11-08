package model;

import java.util.ArrayList;

public interface PropertyInterface {

	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	int getValue();

	void setValue(int value);
	
	public ArrayList<ItemOfInterestInterface> getItens();

	public void setItens(ArrayList<ItemOfInterestInterface> itens);
	
	public boolean addItem(ItemOfInterestInterface item);

}