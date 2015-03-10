package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EastGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	ImageProvider imageProvider = new ImageProvider();
	ImageIcon one_point = imageProvider.getOne_pointComPlayer(); 
	ImageIcon two_point = imageProvider.getTwo_pointComPlayer();
	Image woodBorder = imageProvider.getWoodBoardCom();
	
	JLabel l = new JLabel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();

    Screen screen = Screen.getInstance();
	double width = screen.getWidth()*0.03;
	double height = screen.getHeight()*0.75;
	    
	GameManager gameManager;
	    
	  public EastGamePanel(GameManager gameManager)
	 {
		  this.gameManager = gameManager;
		  
		  this.setPreferredSize(new Dimension((int)width,(int)height));
		  this.setLayout(new GridLayout(5,1));
		  l.setIcon(one_point);
		  this.add(l);
		  l1.setIcon(one_point);
		  this.add(l1);
		  l2.setIcon(two_point);
		  this.add(l2);
		  l3.setIcon(one_point);
		  this.add(l3);
		  l4.setIcon(one_point);
		  this.add(l4);
	 }

		@Override
		protected  void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(woodBorder,0,0,getWidth(),(int)(height),this);
		}
}
