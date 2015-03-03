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
	        		if(GameManager.isPause()==false){
	        			if (gameManager.timeUp())
	        				time = imageProvider.getTime(0);
	        			else
	        				time = imageProvider.getTime(GameManager.getEndTime()-GameManager.getTime());
	        			
	        			repaint();
	        			try
	        			{
	        				sleep(10 + new Random().nextInt(30));
	        			}
	        			catch (final InterruptedException e)
	        			{
	        				System.out.println("errore run RepainterThread");
	        			}
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
    Image scoreTime = imageProvider.getScoreTime();
    Image pointsScoreMyPlayer = null;
    Image pointsScoreComPlayer = null;
    
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
		g.drawImage(scoreTime,(int) ((width/2)-300),0,this);
		g.drawImage(time,(getWidth()/2)-50,15,this);
		
		pointsScoreMyPlayer = imageProvider.getScore(GameManager.getWorld().getMyPlayerScore());
		pointsScoreComPlayer = imageProvider.getScore(GameManager.getWorld().getComScore());
		g.drawImage(pointsScoreMyPlayer,(getWidth()/2)-(getWidth()/5),10,this);
		g.drawImage(pointsScoreComPlayer,(getWidth()/2)+(getWidth()/11),10,this);
		
	}
}
