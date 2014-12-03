package it.unical.mat.igpe.graphics;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WestGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	ImageIcon img = new ImageIcon("img/1point.jpg");
	ImageIcon img1 = new ImageIcon("img/2points.jpg");
    JLabel l = new JLabel();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();

    Screen screen = Screen.getInstance();
	double width = screen.getWidth()*0.03;
	double height = screen.getHeight()*0.75;
	double heightLabel = height*0.2;

	public WestGamePanel()
	{
		  this.setPreferredSize(new Dimension((int)width,(int)height));
		  this.setLayout(new GridLayout(5,1));
		  l.setIcon(img);
		  this.add(l);
		  l1.setIcon(img);
		  this.add(l1);
		  l2.setIcon(img1);
		  this.add(l2);
		  l3.setIcon(img);
		  this.add(l3);
		  l4.setIcon(img);
		  this.add(l4);
	}
}
