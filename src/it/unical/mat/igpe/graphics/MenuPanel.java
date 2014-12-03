package it.unical.mat.igpe.graphics;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static ImageProvider image = new ImageProvider();
	private static Image background = image.getIntroBackground();
	private static Image play = image.getPlayGame();
	private static Image settingsImg = image.getSettings();
	private Screen screen = Screen.getInstance();
	
	public MenuPanel(final MainFrame mainFrame)
	{
		addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseReleased(final MouseEvent e){
				 background = image.getIntroBackground();
		    	 repaint();
		    	 
				 final int x = e.getX();
			     final int y = e.getY();
			     
			     //play now
			     if((x>screen.getWidth()*0.32) && (x<screen.getWidth()*0.75) && (y>screen.getHeight()*0.42) && (y<screen.getHeight()*0.60)){
			    	 mainFrame.startGame();
			     }
			     //settings
			     else if((x>screen.getWidth()*0.42) && (x<screen.getWidth()*0.75) && (y>screen.getHeight()*0.62) && (y<screen.getHeight()*0.76)){
			    	 System.out.println("Settings");
			     }
			     //exit
			     else if((x>screen.getWidth()*0.58) && (x<screen.getWidth()*0.75) && (y>screen.getHeight()*0.82) && (y<screen.getHeight()*0.95)){
			    	 mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			     }
			}
			@Override
		    public void mousePressed(final MouseEvent e){
				 final int x = e.getX();
			     final int y = e.getY();
			     
			     //play now
			     if((x>screen.getWidth()*0.32) && (x<screen.getWidth()*0.75) && (y>screen.getHeight()*0.42) && (y<screen.getHeight()*0.60)){
			    	 background = image.getPlayGame();
			    	 repaint();
			     }
			     //settings
			     else if((x>screen.getWidth()*0.42) && (x<screen.getWidth()*0.75) && (y>screen.getHeight()*0.62) && (y<screen.getHeight()*0.76)){
			    	 background = image.getSettings();
			    	 repaint();
			     }
			     //exit
			     else if((x>screen.getWidth()*0.58) && (x<screen.getWidth()*0.75) && (y>screen.getHeight()*0.82) && (y<screen.getHeight()*0.95)){
			    	 background = image.getExit();
			    	 repaint();
			     }
			}
		});
	}
	
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    if (background != null)
	        g.drawImage(background, 0, 0, getWidth(),getHeight(),this);
	}
}
