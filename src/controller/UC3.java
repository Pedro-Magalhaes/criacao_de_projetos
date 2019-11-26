package controller;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.MyFile;
import model.Info;
import model.ItemOfInterest;
import model.Receipt;

public class UC3 {
	private ItemOfInterest item;
	
	public UC3(ItemOfInterest i) {
		this.item = i;
	}
	
	public ArrayList<Receipt> getReceipts() {
		return this.item.getReceipts();
	}
	
	public ArrayList<Info> getInfosFromReceipt(Receipt r) {
		return r.getInformations();
	}
	
	public ArrayList<MyFile> getFilesFromInfo(Info i) {
		return i.getFiles();
	}
	
	public String getImagePathFromFile(MyFile f) {
		return f.getPath();		
	}
	
	public void openImage(MyFile f) {
		String path = System.getProperty("user.dir") + File.separatorChar + f.getPath().replace('/', File.separatorChar);
		
		try
		{
			BufferedImage img=ImageIO.read(new File(path));
	        ImageIcon icon=new ImageIcon(img);
	        JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());
	        frame.setSize(400,550);
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        frame.add(lbl);
	        frame.setVisible(true);
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch (IOException e)
		{
		    String workingDir = System.getProperty("user.dir");
		    System.out.println("Current working directory : " + workingDir);
		    e.printStackTrace();
		}
	}
}
