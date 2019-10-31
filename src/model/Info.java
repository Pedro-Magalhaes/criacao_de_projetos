package model;

import java.util.ArrayList;

public class Info {
	
	private String title;
	private String description;
	private ArrayList<File> files;
	
	public Info(String title, String description, ArrayList<File> files) {
		super();
		this.title = title;
		this.description = description;
		this.files = files;
	}
	
	public Info(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.files = new ArrayList<File>();
	}
	
	public Info() {
		super();
		this.files = new ArrayList<File>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}

	// Adiciona arquivo recebido ao final do array
	public boolean addFile(File f) {
		if(f == null) {
			return false;
		}
		return files.add(f);		
	}
}
