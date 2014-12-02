package it.unical.mat.igpe.graphics;



import it.unical.mat.igpe.ultimateDisc.GameManager;



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

	        	while(true)
<<<<<<< HEAD

	        	{	//System.out.println("x_shot: "+CenterGamePanel.xShoot+" y_shot: "+CenterGamePanel.yShoot);

=======
	        	{	//System.out.println("x_shot: "+CenterGamePanel.xShoot+" y_shot: "+CenterGamePanel.yShoot);
>>>>>>> origin/master
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

	        }

	    }

	/**

	 * 

	 */

	private static final long serialVersionUID = 1L;



	final static Toolkit tk = Toolkit.getDefaultToolkit();

    final Image img = tk.getImage("img/legno.jpg");

    final static Image imgf = tk.getImage("img/frisbee.gif");

    static Image imgpf = tk.getImage("img/frontc.gif");
<<<<<<< HEAD

    private static int xShoot=1;

=======
    private static int xShoot=1;
>>>>>>> origin/master
    private static int yShoot=0;

    

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

		
<<<<<<< HEAD

		final KeyProcessor keyProcessor = new KeyProcessor(30,null,gameManager);

=======
		final KeyProcessor keyProcessor = new KeyProcessor(30,null,gameManager);
>>>>>>> origin/master
		

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

						 CenterGamePanel.imgpf = tk.getImage("img/frontc.gif");

						 break;

					 case KeyEvent.VK_RIGHT:

						 gameManager.getMyPlayer().setDirection(-1);

						 break;

					 default:	

						 break;

					 }

					 if(e.getKeyCode()==KeyEvent.VK_SPACE && gameManager.getDisc().isAvailableForTheMyPlayer()==true){

						 gameManager.getDisc().setPosition(gameManager.getMyPlayer().getX()+(int)(gameManager.getMyPlayer().withImage*0.5), gameManager.getMyPlayer().getY());

						 gameManager.getDisc().setAvailableForTheMyPlayer(false);
<<<<<<< HEAD

						 gameManager.getDisc().setDirection(getxShoot()+Math.abs(getyShoot()), getyShoot());

=======
						 gameManager.getDisc().setDirection(getxShoot()+Math.abs(getyShoot()), getyShoot());
>>>>>>> origin/master
						 CenterGamePanel.xShoot=1;

						 CenterGamePanel.yShoot=0; 

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

		g.drawImage(img,0,0,getWidth(),getHeight(),this);

		// player

		g.drawImage(imgpf,gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY(),this);

		// disc

		g.drawImage(imgf,gameManager.getDisc().getX(),gameManager.getDisc().getY(),dimensionOfDisc,dimensionOfDisc,this); 

	}

}
