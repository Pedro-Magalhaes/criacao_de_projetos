package model;

import model.MyFile.FileType;

public interface FileInterface {

	String getName();

	void setName(String name);

	String getPath();

	void setPath(String path);

	int getSize();

	void setSize(int size);

	FileType getType();

	void setType(FileType type);

}