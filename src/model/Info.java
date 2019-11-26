package model;

import java.util.ArrayList;

public class Info implements InfoInterface {
	
	private String title;
	private String description;
	private ArrayList<MyFile> files;
	
	public Info(String title, String description, ArrayList<MyFile> files) {
		super();
		this.title = title;
		this.description = description;
		this.files = files;
	}
	
	public Info(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.files = new ArrayList<MyFile>();
	}
	
	public Info() {
		super();
		this.files = new ArrayList<MyFile>();
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
	public ArrayList<MyFile> getFiles() {
		return files;
	}

	@Override
	public void setFiles(ArrayList<MyFile> files) {
		this.files = files;
	}

	// Adiciona arquivo recebido ao final do array
	@Override
	public boolean addFile(MyFile f) {
		if(f == null) {
			return false;
		}
		return files.add(f);		
	}

	@Override
	public String toString() {
		return "Info [title=" + title + ", description=" + description + ", files=" + files + "]";
	}
	
	
}
