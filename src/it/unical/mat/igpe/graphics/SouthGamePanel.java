package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class SouthGamePanel extends JPanel {
	
	 final class RepainterThread extends Thread
	    {
	        private final GameManager gameManager;
	        
	        private RepainterThread(final GameManager gameManager)
	        {
	            super("Repainter");
	            this.gameManager = gameManager;
	        }
	        
	        public void restart()
	        {
	        	frisbeeRound1 = imageProvider.getFrisbeeRound();
	    	    frisbeeRound2 = imageProvider.getFrisbeeRound();
	    	    frisbeeRound3 = imageProvider.getFrisbeeRound();
	    	    frisbeeRound4 = imageProvider.getFrisbeeRound();
	        }
	        
	        public void stopT()
	        {
	        	woodFieldSouth = null;
	    	    roundTarget = null;
	    	    frisbeeRound1 = null;
	    	    frisbeeRound2 = null;
	    	    frisbeeRound3 = null;
	    	    frisbeeRound4 = null;
	        }

			@Override
	        public void run()
	        {
				while(!CenterGamePanel.repainterThread.end)
				{
					//System.out.println("SGP");
					if(GameManager.getWorld().getRoundMyPlayer()==1)
						frisbeeRound1 = imageProvider.getFrisbeeRound2();
					if(GameManager.getWorld().getRoundComPlayer()==1)
						frisbeeRound3 = imageProvider.getFrisbeeRound2();
					if(GameManager.getWorld().getRoundMyPlayer()==2)
						frisbeeRound2 = imageProvider.getFrisbeeRound2();
					if(GameManager.getWorld().getRoundComPlayer()==2)
						frisbeeRound4 = imageProvider.getFrisbeeRound2();
					repaint();
				}
	        }

			public GameManager getGameManager() {
				return gameManager;
			}
	    }
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    static ImageProvider imageProvider = new ImageProvider();
    static Image woodFieldSouth;
    static Image roundTarget;
    Image frisbeeRound1;
    Image frisbeeRound2;
    Image frisbeeRound3;
    Image frisbeeRound4;
    
    Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight()*0.05;
    
	static RepainterThread repainterThread;
	GameManager gameManager;
	
	public SouthGamePanel(GameManager gameManager,ImageProvider newImageProvider)
	{
		SouthGamePanel.imageProvider=newImageProvider;
		
		woodFieldSouth = imageProvider.getWoodFieldSouth();
	    roundTarget = imageProvider.getRoundTarget();
	    frisbeeRound1 = imageProvider.getFrisbeeRound();
	    frisbeeRound2 = imageProvider.getFrisbeeRound();
	    frisbeeRound3 = imageProvider.getFrisbeeRound();
	    frisbeeRound4 = imageProvider.getFrisbeeRound();
		
		this.setPreferredSize(new Dimension((int)width,(int)height));
		repainterThread = new RepainterThread(gameManager);
	}
	
	public static void load()
	{
		woodFieldSouth = imageProvider.getWoodFieldSouth();
	    roundTarget = imageProvider.getRoundTarget();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(woodFieldSouth,0,0,getWidth(),getHeight(),this);
		g.drawImage(roundTarget,(int) ((width/2)-90),2,180,34,this);
		
		g.drawImage(frisbeeRound1,(int) ((width/2)-(width/10)),4,this);
		g.drawImage(frisbeeRound2,(int) ((width/2)-(width/10))-40,4,this);
		g.drawImage(frisbeeRound3,(int) ((width/2)+(width/14)),4,this);
		g.drawImage(frisbeeRound4,(int) ((width/2)+(width/14))+40,4,this);
	}
}
