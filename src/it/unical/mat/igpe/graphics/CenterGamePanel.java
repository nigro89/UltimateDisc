package it.unical.mat.igpe.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final Toolkit tk = Toolkit.getDefaultToolkit();
    final Image img = tk.getImage("img/legno.jpg");
    final Image imgf = tk.getImage("img/frisbee.gif");
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight()*0.75;
    
	public CenterGamePanel()
	{
		this.setPreferredSize(new Dimension((int)width,(int)height));
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),this);
		g.drawImage(imgf,this.getWidth()/6,this.getHeight()/2,80,80,this);  
	}
}
