package model;

import java.util.ArrayList;

public interface ItemOfInterestInterface {

	boolean registerInfo(Info i);

	boolean addReceipt(Receipt r);

	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	ArrayList<Info> getInfos();

	void setInfos(ArrayList<Info> infos);

	ArrayList<Receipt> getReceipts();

	void setReceipts(ArrayList<Receipt> receipts);

}