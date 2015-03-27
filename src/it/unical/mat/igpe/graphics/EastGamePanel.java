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
	static ImageIcon pointsPosition0; 
	static ImageIcon pointsPosition1;
	static ImageIcon pointsPosition2; 
	static ImageIcon pointsPosition3;
	static ImageIcon pointsPosition4;
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
		pointsPosition0 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 0); 
		pointsPosition1 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 1);
		pointsPosition2 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 2); 
		pointsPosition3 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 3);
		pointsPosition4 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 4); 
		woodBorder = imageProvider.getWoodBoardCom();
			
		  this.gameManager = gameManager;
		  
		  this.setPreferredSize(new Dimension((int)width,(int)height));
		  this.setLayout(new GridLayout(5,1));
		  l.setIcon(pointsPosition0);
		  this.add(l);
		  l1.setIcon(pointsPosition1);
		  this.add(l1);
		  l2.setIcon(pointsPosition2);
		  this.add(l2);
		  l3.setIcon(pointsPosition3);
		  this.add(l3);
		  l4.setIcon(pointsPosition4);
		  this.add(l4);
	 }
	  
	  public static void load()
	  {
		  	pointsPosition0 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 0); 
			pointsPosition1 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 1);
			pointsPosition2 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 2); 
			pointsPosition3 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 3);
			pointsPosition4 = imageProvider.getWorldPointComPlayer(CenterGamePanel.playGroundCGP, 4);
			woodBorder = imageProvider.getWoodBoardCom();
	  }

		@Override
		protected  void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(woodBorder,0,0,getWidth(),(int)(height),this);
		}
}
