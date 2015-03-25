package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class ChooseDifficultyPanel extends JPanel {
	
	private static ImageProvider image = new ImageProvider();
	private static Image background = image.getIntroBackground();
	private static Image easyMediumHard = image.getEasyMediumHard();
	private Screen screen = Screen.getInstance();
	
	public ChooseDifficultyPanel(final MainFrame mainFrame){
		addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseReleased(final MouseEvent e){
				
				 final int x = e.getX();
			     final int y = e.getY();
			     
			     //easy
			     if((x>screen.getWidth()*0.60) && (x<screen.getWidth()*0.80) && (y>screen.getHeight()*0.42) && (y<screen.getHeight()*0.60)){
			    	 GameManager.setDifficultyLevel(0);
			    	 mainFrame.goToSettingPanel();
			     }
			     //medium
			     else if((x>screen.getWidth()*0.40) && (x<screen.getWidth()*0.85) && (y>screen.getHeight()*0.62) && (y<screen.getHeight()*0.72)){
			    	 GameManager.setDifficultyLevel(1);
			    	 mainFrame.goToSettingPanel();
			     }
			     //hard
			     else if((x>screen.getWidth()*0.60) && (x<screen.getWidth()*0.80) && (y>screen.getHeight()*0.75) && (y<screen.getHeight()*0.90)){
			    	 GameManager.setDifficultyLevel(2);
			    	 mainFrame.goToSettingPanel();
			     }
			     
			     //back
			     else if((x>screen.getWidth()*0.10) && (x<screen.getWidth()*0.35) && (y>screen.getHeight()*0.68) && (y<screen.getHeight()*0.75)){
			    	 mainFrame.goToSettingPanel();
			     }
			     //main menu
			     else if((x>screen.getWidth()*0.10) && (x<screen.getWidth()*0.50) && (y>screen.getHeight()*0.79) && (y<screen.getHeight()*0.87)){
			    	 mainFrame.goToMenuPanel();
			     }
			}
		});
		
		
	}
	
	
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(background, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(easyMediumHard, 0, 0, getWidth(),getHeight(),this);
	}

}
