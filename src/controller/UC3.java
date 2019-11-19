package controller;

import java.util.ArrayList;

import model.File;
import model.Info;
import model.ItemOfInterest;
import model.Receipt;

public class UC3 {
	private ItemOfInterest item;
	
	public UC3(ItemOfInterest i) {
		this.item = i;
	}
	
	public ArrayList<Receipt> getReceipts() {
		return this.item.getReceipts();
	}
	
	public ArrayList<Info> getInfosFromReceipt(Receipt r) {
		return r.getInformations();
	}
	
	public ArrayList<File> getFilesFromInfo(Info i) {
		return i.getFiles();
	}
	
	public String getImagePathFromFile(File f) {
		return f.getPath();		
	}
}
