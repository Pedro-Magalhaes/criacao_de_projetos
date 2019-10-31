package model;

public class File {
	private String name;
	private String path;
	private int size;
	private FileType type;
	
	public File() {
		super();
	}

	public File(String name, String path, int size, FileType type) {
		super();
		this.name = name;
		this.path = path;
		this.size = size;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public enum FileType {JPG,PNG,PDF}
	
}
