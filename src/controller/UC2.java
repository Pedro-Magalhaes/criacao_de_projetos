package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Info;
import model.ItemOfInterest;
import model.Receipt;

public class UC2 {

	private ItemOfInterest myItem; 
	
	public UC2( ItemOfInterest i ) {
		myItem = i;
	}
	
	public void addReceipt( Date data, int value, boolean iscash ) {
		Receipt r = this.createReceipt(data, value, iscash);
		this.myItem.addReceipt(r);
	}
	
	public void addReceipt( Date data, int value, boolean iscash, Info info ) {
		Receipt r = this.createReceipt(data, value, iscash);
		r.registerInfo(info);
		this.myItem.addReceipt(r);
	}
	
	public void addReceipt( Date data, int value, boolean iscash, ArrayList<Info> infos ) {
		Receipt r = this.createReceipt(data, value, iscash);
		r.setInformations(infos);
		this.myItem.addReceipt(r);
	}
	
	public ItemOfInterest getIoI() {
		return this.myItem;
	}
	
	private Receipt createReceipt(Date data, int value, boolean iscash) {
		return new Receipt(data,value, iscash);
	}
	
	
}
