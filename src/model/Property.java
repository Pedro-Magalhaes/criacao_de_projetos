package model;

public abstract class Property {

	private String name;
	private String description;
	
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
	}
	
	public Property() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private int value;
	
}
