package model;

import java.util.ArrayList;

public class Info implements InfoInterface {
	
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

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
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
	public ArrayList<File> getFiles() {
		return files;
	}

	@Override
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}

	// Adiciona arquivo recebido ao final do array
	@Override
	public boolean addFile(File f) {
		if(f == null) {
			return false;
		}
		return files.add(f);		
	}
}
