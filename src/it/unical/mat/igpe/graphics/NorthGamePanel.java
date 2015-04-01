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
	        
	        public void stopT()
	        {
	        	woodFieldNorth = null;
	    		scoreTime = null;
	        }

			@Override
	        public void run()
	        {
				while(!CenterGamePanel.repainterThread.end)
	        	{	
					
					//System.out.println("NGP");
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

    static ImageProvider imageProvider;
    static Image woodFieldNorth;
    Image scoreTime;
    Image pointsScoreMyPlayer = null;
    Image pointsScoreComPlayer = null;
    Image myPlayerName = null;
    Image comPlayerName = null;
    
    Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight()*0.20;
	
	Image time;
	static RepainterThread repainterThread;
	GameManager gameManager;
	
	public NorthGamePanel(GameManager gameManager,ImageProvider newImageProvider)
	{
		NorthGamePanel.imageProvider=newImageProvider;
		myPlayerName = imageProvider.getNameMyPlayer(CenterGamePanel.myPlayerCGP);
		comPlayerName = imageProvider.getNameComPlayer(CenterGamePanel.comPlayerCGP);
		time = imageProvider.getTime(0);
		woodFieldNorth = imageProvider.getWoodFieldNorth();
		scoreTime = imageProvider.getScoreTime();
		this.setPreferredSize(new Dimension((int)width,(int)height));
		this.gameManager = gameManager;
		repainterThread = new RepainterThread(gameManager);
	}
	
	public static void load()
	{
		woodFieldNorth = imageProvider.getWoodFieldNorth();
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(woodFieldNorth,0,0,getWidth(),getHeight(),this);
		g.drawImage(scoreTime,(int)(width*0.28),0,this);
		g.drawImage(time,(int)(width*0.46),(int)(height*0.09),this);
		
		pointsScoreMyPlayer = imageProvider.getScore(GameManager.getWorld().getMyPlayerScore());
		pointsScoreComPlayer = imageProvider.getScore(GameManager.getWorld().getComScore());
		g.drawImage(pointsScoreMyPlayer,(int)(width*0.3),(int)(height*0.07),this);
		g.drawImage(pointsScoreComPlayer,(int)(width*0.59),(int)(height*0.07),this);
		
		g.drawImage(myPlayerName,0,0,this);
		g.drawImage(comPlayerName,(int)(width*0.78),0,this);
		
	}
}
