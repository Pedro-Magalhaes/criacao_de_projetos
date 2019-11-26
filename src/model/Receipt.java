package model;

import java.util.ArrayList;
import java.util.Date;

public class Receipt implements ReceiptInterface {
	
	private Date data; 
	private int value;
	private boolean cash;
	private ArrayList<Info> informations;
	
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
	
	@Override
	public boolean registerInfo(Info i) {
		if(i == null) {
			return false;
		}
		return informations.add(i);
	}

	@Override
	public Date getData() {
		return data;
	}

	@Override
	public void setData(Date data) {
		this.data = data;
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
	public boolean isCash() {
		return cash;
	}

	@Override
	public void setCash(boolean cash) {
		this.cash = cash;
	}

	@Override
	public ArrayList<Info> getInformations() {
		return informations;
	}

	@Override
	public void setInformations(ArrayList<Info> informations) {
		this.informations = informations;
	}

	@Override
	public String toString() {
		return "Receipt [data=" + data + ", value=" + value + ", cash=" + cash + ", informations=" + informations + "]";
	}
	
	
}
