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
    
	public SouthGamePanel()
	{
		this.setPreferredSize(new Dimension(1000,45));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),this);
	}
}
