package it.unical.mat.igpe.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class SouthGamePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final Toolkit tk = Toolkit.getDefaultToolkit();
    final Image img = tk.getImage("img/sud.jpg");

    Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight()*0.05;
    
	public SouthGamePanel()
	{
		this.setPreferredSize(new Dimension((int)width,(int)height));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),this);
	}
}
