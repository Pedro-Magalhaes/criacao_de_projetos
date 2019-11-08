package model;

import java.util.ArrayList;

public interface InfoInterface {

	String getTitle();

	void setTitle(String title);

	String getDescription();

	void setDescription(String description);

	ArrayList<File> getFiles();

	void setFiles(ArrayList<File> files);

	// Adiciona arquivo recebido ao final do array
	boolean addFile(File f);

}