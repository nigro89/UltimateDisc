package it.unical.mat.igpe.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class NorthGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    ImageProvider imageProvider = new ImageProvider();
    Image woodFieldNorth = imageProvider.getWoodFieldNorth();
    
    Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight()*0.20;
	
	public NorthGamePanel()
	{
		this.setPreferredSize(new Dimension((int)width,(int)height));
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(woodFieldNorth,0,0,getWidth(),getHeight(),this);
	}
}
