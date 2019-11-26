package model;

import java.util.ArrayList;

public interface InfoInterface {

	String getTitle();

	void setTitle(String title);

	String getDescription();

	void setDescription(String description);

	ArrayList<MyFile> getFiles();

	void setFiles(ArrayList<MyFile> files);

	// Adiciona arquivo recebido ao final do array
	boolean addFile(MyFile f);

}