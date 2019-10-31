package model;

import java.util.ArrayList;
import java.util.Date;

public class Receipt {
	
	/**
	 * @param data
	 * @param value
	 * @param cash
	 */
	public Receipt(Date data, int value, boolean cash) {
		super();
		this.informations = new ArrayList<Info>();
		this.data = data;
		this.value = value;
		this.cash = cash;
	}
	
	public Receipt() {
		super();
		this.informations = new ArrayList<Info>();
	}

	private Date data; 
	private int value;
	private boolean cash;
	
	private ArrayList<Info> informations;
	
	public boolean registerInfo(Info i) {
		if(i == null) {
			return false;
		}
		return informations.add(i);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isCash() {
		return cash;
	}

	public void setCash(boolean cash) {
		this.cash = cash;
	}

	public ArrayList<Info> getInformations() {
		return informations;
	}

	public void setInformations(ArrayList<Info> informations) {
		this.informations = informations;
	}
	
	
}
