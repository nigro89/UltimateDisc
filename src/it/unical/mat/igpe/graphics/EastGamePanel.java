package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EastGamePanel extends JPanel {

	 public final class RepainterThread extends Thread
	    {
	        private final GameManager gameManager;
	        int sw;

	        private RepainterThread(final GameManager gameManager)
	        {
	            super("Repainter");
	            this.gameManager = gameManager;
	            sw=0;
	        }
	        
	        public void setSW(int s)
	        {
	        	this.sw=s;
	        }

			@Override
	        public void run()
	        {
	        	while(true)
	        	{	
	        		if (gameManager.getDisc().isMyplayer()==true){
	        		
	        			System.out.println("sw: "+sw);
	        			
	        			switch (sw) {
							case 0:	l.setIcon(two_point);
									break;
							case 1:	l1.setIcon(two_point);
									break;
							case 2:	l2.setIcon(one_point);
									break;
							case 3:	l3.setIcon(two_point);
									break;
							case 4:	l4.setIcon(two_point);
									break;
							default:
								break;
							}
		        			repaint();
		        			
		        			try
			        		{
			        			Thread.sleep(100);
			        		}
			        		catch (final InterruptedException e)
			        		{
			        			System.out.println("errore run RepainterThread");
			        		}
	        			}
	        			if (gameManager.getDisc().isMyplayer()==false){
	        				  l.setIcon(one_point);
	        				  l1.setIcon(one_point);
	        				  l2.setIcon(two_point);
	        				  l3.setIcon(one_point);
	        				  l4.setIcon(one_point);
	        			}
	        	}
	        }
	    }
	 
	private static final long serialVersionUID = 1L;

	ImageProvider imageProvider = new ImageProvider();
	ImageIcon one_point = imageProvider.getOne_point(); 
	ImageIcon two_point = imageProvider.getTwo_point();
	
	JLabel l = new JLabel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();

    Screen screen = Screen.getInstance();
	double width = screen.getWidth()*0.03;
	double height = screen.getHeight()*0.75;
	    
	GameManager gameManager;
	static RepainterThread repainterThread;
	
	    
	  public EastGamePanel(GameManager gameManager)
	 {
		  this.gameManager = gameManager;
		  repainterThread = new RepainterThread(gameManager);
		  
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

	public static RepainterThread getRepainterThread() {
		return repainterThread;
	}
	
}
