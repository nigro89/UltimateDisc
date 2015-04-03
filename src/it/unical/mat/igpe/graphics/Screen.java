package it.unical.mat.igpe.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {

	private static Screen instance = null;
	
	private Dimension screenSize;
	private double width;
	private double height;
	
	private Screen(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    width = screenSize.getWidth();
	    height = screenSize.getHeight();
	}
	
	public static Screen getInstance(){
		
		if (instance==null)
		{
			instance = new Screen();
			return instance;
		}
		return instance;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	
}