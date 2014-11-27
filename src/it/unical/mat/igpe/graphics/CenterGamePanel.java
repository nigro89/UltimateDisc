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

	final static Toolkit tk = Toolkit.getDefaultToolkit();
    final Image img = tk.getImage("img/legno.jpg");
    final Image imgf = tk.getImage("img/frisbee.gif");
    static Image imgpf = tk.getImage("img/front.png");
    
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
	         public void keyReleased (final KeyEvent e)
			 {
				 switch (e.getKeyCode())
	            	{
						case KeyEvent.VK_UP:
											gameManager.getMyPlayer().setDirection(-1);
											break;
						case KeyEvent.VK_DOWN:
											gameManager.getMyPlayer().setDirection(-1);
											break;
						case KeyEvent.VK_LEFT:
											gameManager.getMyPlayer().setDirection(-1);
											CenterGamePanel.imgpf = tk.getImage("img/front.png");
											break;
						case KeyEvent.VK_RIGHT:
											gameManager.getMyPlayer().setDirection(-1);
											break;
						default:	
							break;
					}
			 }
            @Override
            public void keyPressed(final KeyEvent e)
            {
            	switch (e.getKeyCode())
            	{
					case KeyEvent.VK_UP:
										gameManager.getMyPlayer().setDirection(0);
										break;
					case KeyEvent.VK_DOWN:
										gameManager.getMyPlayer().setDirection(1);
										break;
					case KeyEvent.VK_LEFT:
										gameManager.getMyPlayer().setDirection(2);
										CenterGamePanel.imgpf = tk.getImage("img/retro.png");
										break;
					case KeyEvent.VK_RIGHT:
										gameManager.getMyPlayer().setDirection(3);
										break;
					default:	
						break;
				}
            	
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
		// player
		g.drawImage(imgpf,gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY(),this);
	}
}
