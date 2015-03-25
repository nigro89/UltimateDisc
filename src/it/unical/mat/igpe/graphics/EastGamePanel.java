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

	static ImageProvider imageProvider;
	static ImageIcon one_point; 
	static ImageIcon two_point;
	static Image woodBorder;
	
	JLabel l = new JLabel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();

    Screen screen = Screen.getInstance();
	double width = screen.getWidth()*0.03;
	double height = screen.getHeight()*0.75;
	    
	GameManager gameManager;
	    
	  public EastGamePanel(GameManager gameManager,ImageProvider newImageProvider)
	 {
		EastGamePanel.imageProvider=newImageProvider;
		one_point = imageProvider.getOne_pointComPlayer(); 
		two_point = imageProvider.getTwo_pointComPlayer();
		woodBorder = imageProvider.getWoodBoardCom();
			
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
	  
	  public static void load()
	  {
		  one_point = imageProvider.getOne_pointComPlayer(); 
			two_point = imageProvider.getTwo_pointComPlayer();
			woodBorder = imageProvider.getWoodBoardCom();
	  }

		@Override
		protected  void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(woodBorder,0,0,getWidth(),(int)(height),this);
		}
}
