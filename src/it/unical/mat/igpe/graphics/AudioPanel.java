package it.unical.mat.igpe.graphics;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class AudioPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ImageProvider image = new ImageProvider();
	private static Image background = image.getIntroBackground();
	private Screen screen = Screen.getInstance();
	private static Image selected = image.getEasySelected();
	private static Image enableDisable = image.getEnableDisable();
	
	public AudioPanel(final MainFrame mainFrame){
		addMouseListener(new MouseAdapter() {
			
			@Override
		    public void mousePressed(final MouseEvent e){
				
				 final int x = e.getX();
			     final int y = e.getY();
			     
			     //enable
			     if((x>screen.getWidth()*0.60) && (x<screen.getWidth()*0.80) && (y>screen.getHeight()*0.42) && (y<screen.getHeight()*0.60))
			     {
			    	 selected = image.getEasySelected();
			    	 repaint();
			    	 AudioProvider.clickAudio();
			    	 AudioProvider.audioOn();
			     }
			     //disable
			     else if((x>screen.getWidth()*0.40) && (x<screen.getWidth()*0.85) && (y>screen.getHeight()*0.62) && (y<screen.getHeight()*0.72))
			     {
			    	 selected = image.getMediumSelected();
			    	 repaint();
			    	 AudioProvider.clickAudio();
			    	 AudioProvider.audioOff();
			     }
			}
			
			@Override
		    public void mouseReleased(final MouseEvent e){
				
				 final int x = e.getX();
			     final int y = e.getY();
			     
			   //enable
			     if((x>screen.getWidth()*0.60) && (x<screen.getWidth()*0.80) && (y>screen.getHeight()*0.42) && (y<screen.getHeight()*0.60))
			     {
			    	 AudioProvider.audioOn();
			    	 AudioProvider.musicMainMenu();
			     }
			     //disable
			     else if((x>screen.getWidth()*0.40) && (x<screen.getWidth()*0.85) && (y>screen.getHeight()*0.62) && (y<screen.getHeight()*0.72))
			     {
			    	 AudioProvider.audioOff();
			     }
			   //back
			     else if((x>screen.getWidth()*0.10) && (x<screen.getWidth()*0.35) && (y>screen.getHeight()*0.68) && (y<screen.getHeight()*0.75)){
			    	 mainFrame.goToSettingPanel();
			    	 AudioProvider.clickAudio();
			     }
			     //main menu
			     else if((x>screen.getWidth()*0.10) && (x<screen.getWidth()*0.50) && (y>screen.getHeight()*0.79) && (y<screen.getHeight()*0.87)){
			    	 MainFrame.goToMenuPanel();
			    	 AudioProvider.clickAudio();
			     }
			}
		});
		
		
	}
	
	
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(background, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(enableDisable, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(selected, 0, 0, getWidth(),getHeight(),this);
	}

}
