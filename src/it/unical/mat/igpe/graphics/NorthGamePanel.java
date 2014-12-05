package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

public class NorthGamePanel extends JPanel {

	 final class RepainterThread extends Thread
	    {
	        private final GameManager gameManager;

	        private RepainterThread(final GameManager gameManager)
	        {
	            super("Repainter");
	            this.gameManager = gameManager;
	        }

			@Override
	        public void run()
	        {
	        	while(true)
	        	{	
	        			if (gameManager.timeUp())
	        				time = imageProvider.getTimeUp();
	        			else
	        				time = imageProvider.getTime(10-gameManager.getTime());
	        				
	        			repaint();
	        		try
	        		{
	        			Thread.sleep(10 + new Random().nextInt(30));
	        		}
	        		catch (final InterruptedException e)
	        		{
	        			System.out.println("errore run RepainterThread");
	        		}
	        	}
	        }
	    }
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    ImageProvider imageProvider = new ImageProvider();
    Image woodFieldNorth = imageProvider.getWoodFieldNorth();
    
    Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight()*0.20;
	
	Image time = imageProvider.getTime(0);
	static RepainterThread repainterThread;
	GameManager gameManager;
	
	public NorthGamePanel(GameManager gameManager)
	{
		this.setPreferredSize(new Dimension((int)width,(int)height));
		this.gameManager = gameManager;
		repainterThread = new RepainterThread(gameManager);
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(woodFieldNorth,0,0,getWidth(),getHeight(),this);
		g.drawImage(time,(getWidth()/2)-50,15,this);
	}
}
