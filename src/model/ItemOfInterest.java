package model;

import java.util.ArrayList;

public class ItemOfInterest implements ItemOfInterestInterface {
	String name;
	String description;
	
	ArrayList<Info> infos;
	ArrayList<Receipt> receipts;
	
	public ItemOfInterest() {
		super();
		this.name = "";
		this.description = "";
		this.infos = new ArrayList<Info>();
		this.receipts = new ArrayList<Receipt>();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public ItemOfInterest(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.infos = new ArrayList<Info>();
		this.receipts = new ArrayList<Receipt>();
	}
	

	public ItemOfInterest(String name, String description, ArrayList<Info> infos, ArrayList<Receipt> receipts) {
		super();
		this.name = name;
		this.description = description;
		this.infos = infos;
		this.receipts = receipts;
	}

	@Override
	public boolean registerInfo(Info i) {
		return infos.add(i);
	}
	
	@Override
	public boolean addReceipt(Receipt r) {
		return this.receipts.add(r);
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
	public ArrayList<Info> getInfos() {
		return infos;
	}

	@Override
	public void setInfos(ArrayList<Info> infos) {
		this.infos = infos;
	}

	@Override
	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

	@Override
	public void setReceipts(ArrayList<Receipt> receipts) {
		this.receipts = receipts;
	}

	@Override
	public String toString() {
		return "ItemOfInterest [name=" + name + ", description=" + description + ", infos=" + infos + ", receipts="
				+ receipts + "]";
	}

}
