package model;

public class MyFile implements FileInterface {
	private String name;
	private String path;
	private int size;
	private FileType type;
	
	public MyFile() {
		super();
	}

	public MyFile(String name, String path, int size, FileType type) {
		super();
		this.name = name;
		this.path = path;
		this.size = size;
		this.type = type;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public FileType getType() {
		return type;
	}

	@Override
	public void setType(FileType type) {
		this.type = type;
	}
	
	

	@Override
	public String toString() {
		return "File [name=" + name + ", path=" + path + ", size=" + size + ", type=" + type + "]";
	}



	public enum FileType {JPG,PNG,PDF}
	
}
