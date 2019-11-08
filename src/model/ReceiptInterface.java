package model;

import java.util.ArrayList;
import java.util.Date;

public interface ReceiptInterface {

	boolean registerInfo(Info i);

	Date getData();

	void setData(Date data);

	int getValue();

	void setValue(int value);

	boolean isCash();

	void setCash(boolean cash);

	ArrayList<Info> getInformations();

	void setInformations(ArrayList<Info> informations);

}