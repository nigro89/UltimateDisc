package it.unical.mat.igpe.graphics;
import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.Disc;
import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
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
//	        	while(gameManager.timeUp()==false)
	        	while(true)
	        	{	//System.out.println("x_shot: "+CenterGamePanel.xShoot+" y_shot: "+CenterGamePanel.yShoot);
	        		gameManager.update();
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
//	        	event = imageProvider.getGameOver();
//	        	repaint();
	        }
	    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static ImageProvider imageProvider = new ImageProvider();
	static Image woodField = imageProvider.getWoodField();
	static Image frisbee = imageProvider.getFrisbee();
	static Image myPlayer = imageProvider.getMyPlayerDirection(Player.RIGHT);


	final static Toolkit tk = Toolkit.getDefaultToolkit();
    final Image img = tk.getImage("img/legno.jpg");
    final static Image imgf = tk.getImage("img/frisbee.gif");
    static Image imgpf = tk.getImage("img/frontc.gif");
    
    static Image event = null;

    private static int xShoot=5;
    private static int yShoot=0;

	Screen screen = Screen.getInstance();
    double width = screen.getWidth();
    double height = screen.getHeight()*0.75;
	int dimensionOfDisc = (int)width/17;

    private final GameManager gameManager;
    
    final RepainterThread repainterThread;
    
    static ProgressBar energyShoot;

	public CenterGamePanel(final GameManager gameManager)
	{
		this.gameManager=gameManager;
		
		CenterGamePanel.energyShoot=new ProgressBar();
		this.add(CenterGamePanel.energyShoot);
		CenterGamePanel.energyShoot.setVisible(false);
		
		this.setPreferredSize(new Dimension((int)width,(int)height));

		final KeyProcessor keyProcessor = new KeyProcessor(50,null,gameManager);

		this.addKeyListener(new KeyAdapter()
        {
			@Override
	        public void keyReleased (final KeyEvent e)
			 {
					keyProcessor.setKeystate(e.getKeyCode(),false);
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
						 					CenterGamePanel.myPlayer = CenterGamePanel.imageProvider.getMyPlayerDirection(Player.RIGHT);
						 					break;

					 case KeyEvent.VK_RIGHT:
						 					CenterGamePanel.myPlayer = CenterGamePanel.imageProvider.getMyPlayerDirection(Player.RIGHT);
						 					gameManager.getMyPlayer().setDirection(-1);
						 					break;

					 default:	
						 	break;
					 }

					 if(e.getKeyCode()==KeyEvent.VK_SPACE && gameManager.getDisc().isAvailableForTheMyPlayer()==true){
						 CenterGamePanel.myPlayer = CenterGamePanel.imageProvider.getMyPlayerDirection(11);
						 gameManager.getDisc().setPosition(gameManager.getMyPlayer().getX()+(int)(Player.getWithimage()*0.5), gameManager.getMyPlayer().getY());
						 gameManager.getDisc().setAvailableForTheMyPlayer(false);
						 gameManager.getDisc().setDirection(getxShoot()+Math.abs(getyShoot()), getyShoot());
						 CenterGamePanel.xShoot=5;
						 CenterGamePanel.yShoot=0;
						 CenterGamePanel.energyShoot.reset();
						 CenterGamePanel.energyShoot.setVisible(false);
					 }
			 }

            @Override
            public void keyPressed(final KeyEvent e)
            {
            	keyProcessor.setKeystate(e.getKeyCode(),true);
            }
        });
		
		repainterThread = new RepainterThread(gameManager);
		keyProcessor.start();
	}
	  public static int getxShoot() {
			return xShoot;
		}

		public static void setxShoot(int xShoot) {
			CenterGamePanel.xShoot += xShoot;
		}

		public static int getyShoot() {
			return yShoot;
		}

		public static void setyShoot(int yShoot) {
			CenterGamePanel.yShoot += yShoot;
		}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// playground
		g.drawImage(woodField,0,0,getWidth(),getHeight(),this);
		//energyBar
		CenterGamePanel.energyShoot.setLocation(gameManager.getMyPlayer().getX()-15, gameManager.getMyPlayer().getY());
		// player
		g.drawImage(myPlayer,gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY(),this);
		// disc
		g.drawImage(frisbee,gameManager.getDisc().getX(),gameManager.getDisc().getY(),dimensionOfDisc,dimensionOfDisc,this); 
		//event
		g.drawImage(event,(getWidth()/2)-130,(getHeight()/2)-130,260,260,this); 
		
	}

}
