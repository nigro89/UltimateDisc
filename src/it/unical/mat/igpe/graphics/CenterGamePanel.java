package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.Disc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterGamePanel extends JPanel {

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
	        		gameManager.update();
	        		repaint();
	        		try
	        		{
	        			Thread.sleep(50);
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

	final Toolkit tk = Toolkit.getDefaultToolkit();
    final Image img = tk.getImage("img/legno.jpg");
    final Image imgf = tk.getImage("img/frisbee.gif");
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight()*0.75;
    int dimensionOfDisc = (int)width/17;
    
    private final GameManager gameManager;
    
    final RepainterThread repainterThread;
    
	public CenterGamePanel(final GameManager gameManager)
	{
		this.gameManager=gameManager;
		this.setPreferredSize(new Dimension((int)width,(int)height));

		
		this.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(final KeyEvent e)
            {
            	
            	if (e.getKeyCode()==KeyEvent.VK_S)
            	{
            		gameManager.getDisc().setDirection(8, 6);
            	}
            }
        });
		
		repainterThread = new RepainterThread(gameManager);
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		// playground
		g.drawImage(img,0,0,getWidth(),getHeight(),this);
		// disc
		g.drawImage(imgf,gameManager.getDisc().getX(),gameManager.getDisc().getY(),dimensionOfDisc,dimensionOfDisc,this);  
	}
}
