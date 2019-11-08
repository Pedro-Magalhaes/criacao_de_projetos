package model;

import java.util.ArrayList;

public class Property implements PropertyInterface {

	private String name;
	private String description;
	private int value;
	private ArrayList<ItemOfInterestInterface> itens;
	
	/**
	 * @param name
	 * @param description
	 * @param value
	 */
	public Property(String name, String description, int value) {
		super();
		this.name = name;
		this.description = description;
		this.value = value;
		this.itens = new ArrayList<ItemOfInterestInterface>();
	}
	
	public Property() {
		super();
		this.itens = new ArrayList<ItemOfInterestInterface>();
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int getValue() {
		return value;
	}
	@Override
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public ArrayList<ItemOfInterestInterface> getItens() {
		return itens;
	}
	@Override
	public void setItens(ArrayList<ItemOfInterestInterface> itens) {
		this.itens = itens;
	}
	@Override
	public boolean addItem(ItemOfInterestInterface item) {
		return this.itens.add(item);
	}
	
}
