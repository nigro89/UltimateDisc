package it.unical.mat.igpe.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NorthGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final Toolkit tk = Toolkit.getDefaultToolkit();
    final Image img = tk.getImage("img/nord.jpg");
	
	public NorthGamePanel()
	{
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setPreferredSize(new Dimension(1000,200));
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),this);
	}
}
