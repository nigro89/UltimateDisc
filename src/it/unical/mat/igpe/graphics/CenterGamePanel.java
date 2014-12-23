package it.unical.mat.igpe.graphics;
import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.Disc;
import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

public class CenterGamePanel extends JPanel {

	 public final class RepainterThread extends Thread
	    {
	        private final GameManager gameManager;
	        public boolean myPlayerGoal=false;
	        public boolean comPlayerGoal=false;
			private boolean endRound=false;
			private boolean finishMatch=false;
			private boolean startGame=true;
			private boolean roundControllerStart=true;
			private int counterOfRounds=0;

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
	        			while(gameManager.timeUp()==false && finishMatch==false)
	        			{
	        				if(GameManager.isPause()==false){
	        					if(roundControllerStart)
	        					{
	        						roundImage = imageProvider.getRound(counterOfRounds);
	        						try
	        						{
	        							sleep(1500);
	        						}
	        						catch (final InterruptedException e)
	        						{
	        							System.out.println("errore run RepainterThread");
	        						}
	        						roundControllerStart=false;
	        						roundImage=null;
	        					}
	        					
	        					if(startGame)
	        					{
	        						System.out.println("start");
	        						gameManager.getDisc().setDirection(-18, 14);
	        						gameManager.update();
	        						startGame=false;
	        					}
	        					
	        					//System.out.println("x_shot: "+CenterGamePanel.xShoot+" y_shot: "+CenterGamePanel.yShoot);
	        					endRound=false;
	        					gameManager.update();
	        					repaint();
	        					
	        					if(GameManager.isStop())
	        					{
	        						frisbeeImage=null;
//	        						System.out.println("punti: "+gameManager.getWorld().getCurrentPoints());
	        						pointsImage = imageProvider.getPoints(gameManager.getWorld().getCurrentPoints());
	        						scoreInfoImage = imageProvider.getScore();
	        						try
	        						{
	        							sleep(2000);
	        						}
	        						catch (final InterruptedException e)
	        						{
	        							System.out.println("errore run RepainterThread GameManager Stopped");
	        						}
	        						gameManager.getDisc().reset();
	        						
	        						if(myPlayerGoal==true){
	        							GameManager.setComPlayerAbility(true);
	        							gameManager.getDisc().setDirection(10, 5);
	        							myPlayerGoal=false;
	        						}
	        						else if(comPlayerGoal==true){
	        							gameManager.getDisc().setDirection(-18, 14);
	        							comPlayerGoal=false;
	        						}
	        						scoreInfoImage = null;
	        						pointsImage = null;
	        						frisbeeImage=imageProvider.getFrisbee();
	        						GameManager.setStop(false);
	        					}
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
	        			
	        			if(gameManager.timeUp()==true && endRound==false && GameManager.isPause()==false){
	        				gameManager.update();
	        				roundResumeImage = imageProvider.getPass();
	        				repaint();
	        				try
	        				{
	        					sleep(1500);
	        				}
	        				catch (final InterruptedException e)
	        				{
	        					System.out.println("errore run RepainterThread");
	        				}
	        				roundResumeImage=null;
	        				repaint();
	        				endRound=true;
	        				roundControllerStart=true;
	        				startGame=true;
	        				counterOfRounds++;
	        				
	        				if(gameManager.getWorld().getMyPlayerScore()>=gameManager.getWorld().getComScore())
	        				{
	        					gameManager.getWorld().setRoundMyPlayer(1);
	        				}
	        				else
	        				{
	        					gameManager.getWorld().setRoundComPlayer(1);
	        				}
	        				
	        				System.out.println("Round "+counterOfRounds+" MYplayer: "+gameManager.getWorld().getMyPlayerScore()+" ComPlayer: "+gameManager.getWorld().getComScore());
	        				System.out.println("Round "+counterOfRounds+" MYplayerR: "+gameManager.getWorld().getRoundMyPlayer()+" ComPlayerR: "+gameManager.getWorld().getRoundComPlayer());
	        				gameManager.getWorld().setMyPlayerScore(0);
	        				gameManager.getWorld().setComScore(0);
	        			}
	        			
	        			if((gameManager.getWorld().getRoundMyPlayer()==2 || gameManager.getWorld().getRoundComPlayer()==2 
	        					|| (gameManager.getWorld().getRoundMyPlayer()+gameManager.getWorld().getRoundComPlayer())==3) && (GameManager.isPause()==false))
	        			{
	        				finishMatch=true;
	        				counterOfRounds=0;
	        				gameOverImage = imageProvider.getGameOver();
	        				repaint();
	        			}
	        			else if(GameManager.isPause()==false)
	        			{
	        				gameManager.getDisc().setAvailableForMyPlayer(false);
	        				gameManager.getDisc().setAvailableForComPlayer(false);
	        				gameManager.restartRound();
	        			}
	        		}
	        	}
	        }
			
			public void setMyPlayerGoal(boolean myPlayerGoal) {
				this.myPlayerGoal = myPlayerGoal;
			}

			public void setComPlayerGoal(boolean comPlayerGoal) {
				this.comPlayerGoal = comPlayerGoal;
			}

			public boolean isFinish() {
				return finishMatch;
			}

			public void setFinish(boolean finish) {
				this.finishMatch = finish;
			}

			public void setStartGame(boolean startGame) {
				this.startGame = startGame;
			}

	    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/// IMAGE ///
	static ImageProvider imageProvider = new ImageProvider();
// world Image
	static Image fieldImage = imageProvider.getWoodField();
	static Image frisbeeImage = imageProvider.getFrisbee();
	static Image pointsImage = null;	
// player Image
	static Image myPlayerImage = imageProvider.getMyPlayerDirection(Player.RIGHT);
	static Image comPlayerImage = imageProvider.getMyPlayerDirection(Player.LEFT);
// round Image
	static Image gameOverImage = null;
	private Image roundImage = null;
	private Image roundResumeImage = null;
	static Image scoreInfoImage = null;	
// pause menu Image
	static Image pauseMenuImage=null;

// shoot 
    private static int xShoot=5;
    private static int yShoot=0;
// screen info
	Screen screen = Screen.getInstance();
    double width = screen.getWidth();
    double height = screen.getHeight()*0.75;
	int dimensionOfDisc = (int)width/17;
	int radius = dimensionOfDisc/2;
// utility object
    private final GameManager gameManager;
    static RepainterThread repainterThread;
    static ProgressBar energyShoot;
    
	public CenterGamePanel(final GameManager gameManager)
	{
		this.gameManager=gameManager;
		CenterGamePanel.energyShoot=new ProgressBar();
		this.add(CenterGamePanel.energyShoot);
		CenterGamePanel.energyShoot.setVisible(false);
		
		this.setPreferredSize(new Dimension((int)width,(int)height));

		final KeyProcessor keyProcessor = new KeyProcessor(50,null,gameManager);

		//Mouse Listener
		this.addMouseListener(new MouseAdapter() {
				@Override
			    public void mouseReleased(final MouseEvent e){
					
					if(GameManager.isPause()==true){
						 final int x = e.getX();
					     final int y = e.getY();
					     
					     //resume
					     if((x>screen.getWidth()*0.37) && (x<screen.getWidth()*0.60) && (y>screen.getHeight()*0.15) && (y<screen.getHeight()*0.23)){
					    	 setImageMenu();
					     }
//					     else if(){
//					    	 funzione di distruzione del gioco e ritorno al menu con switchTo
//					     }
					     //exit
					     else if((x>screen.getWidth()*0.37) && (x<screen.getWidth()*0.60) && (y>screen.getHeight()*0.25) && (y<screen.getHeight()*0.35)){
					    	 System.exit(0);
					     }
					}
				}
		});

		this.addKeyListener(new KeyAdapter()
        {
			@Override
	        public void keyReleased (final KeyEvent e)
			 {
					keyProcessor.setKeystate(e.getKeyCode(),false);
					
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            		if(GameManager.isPause()==false)
	            		{
	            			setImageMenu();
	            		}
	            		else if(GameManager.isPause()==true)
	            		{
	            			setImageMenu();
	            		}
	            	}
					
					switch (e.getKeyCode())
					{
					 case KeyEvent.VK_UP:
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerMotionLess();
						 					ImageProvider.numberOfSequence=0;
					 						gameManager.getMyPlayer().setDirection(-1);
					 						break;

					 case KeyEvent.VK_DOWN:
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerMotionLess();
						 					ImageProvider.numberOfSequence=0;
						 					gameManager.getMyPlayer().setDirection(-1);
						 					break;

					 case KeyEvent.VK_LEFT:
						 					gameManager.getMyPlayer().setDirection(-1);
						 					ImageProvider.numberOfSequence=0;
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerMotionLess();
						 					break;

					 case KeyEvent.VK_RIGHT:
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerMotionLess();
						 					ImageProvider.numberOfSequence=0;
						 					gameManager.getMyPlayer().setDirection(-1);
						 					break;

					 default:	
						 	break;
					 }

					 if(e.getKeyCode()==KeyEvent.VK_SPACE && gameManager.getDisc().isAvailableForMyPlayer()==true){
						 CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerDirection(11);
						 gameManager.getDisc().setPosition(gameManager.getMyPlayer().getX()+((int)(Player.getWithimage()))+1, gameManager.getMyPlayer().getY());
						 gameManager.getDisc().setAvailableForMyPlayer(false);
						 gameManager.getDisc().setDirection(getxShoot()+Math.abs(getyShoot()), getyShoot());
						 CenterGamePanel.xShoot=5;
						 CenterGamePanel.yShoot=0;
						 CenterGamePanel.energyShoot.reset();
						 CenterGamePanel.energyShoot.setVisible(false);
						 GameManager.setComPlayerAbility(true);
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
		
		public static ProgressBar getEnergyShoot() {
			return energyShoot;
		}
		
		public void setImageMenu() {
			
			if(GameManager.isPause()==false)
    		{
				pauseMenuImage = imageProvider.getMenuPause();
				GameManager.setPause(true);
    		}
    		else if(GameManager.isPause()==true)
    		{
    			pauseMenuImage = null;
    			GameManager.setPause(false);
    		}
			repaint();
		}
		public static void setEnergyShoot(ProgressBar energyShoot) {
			CenterGamePanel.energyShoot = energyShoot;
		}
	@Override
	protected  void paintComponent(Graphics g) {
		super.paintComponent(g);
		// playground
		g.drawImage(fieldImage,0,0,getWidth(),getHeight(),this);
		//energyBar
		CenterGamePanel.energyShoot.setLocation(gameManager.getMyPlayer().getX()-15, gameManager.getMyPlayer().getY());
		// My player
		g.drawImage(myPlayerImage,gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY(),this);
		// COM player
		g.drawImage(comPlayerImage,gameManager.getComPlayer().getX(),gameManager.getComPlayer().getY(),this);
		// disc
		g.drawImage(frisbeeImage,gameManager.getDisc().getX(),gameManager.getDisc().getY(),dimensionOfDisc,dimensionOfDisc,this); 
		//event
		g.drawImage(gameOverImage,(getWidth()/2)-130,(getHeight()/2)-130,260,260,this); 
		
		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		
		g.setColor(Color.RED);
		g.drawLine((int)(width*0.25), 0, (int)width/4, getHeight());
		
		g.drawLine((int)(width*0.69), 0, (int)(width*0.69), getHeight());
		
		g.drawRect(gameManager.getComPlayer().getX(),gameManager.getComPlayer().getY() , (int)(Player.getWithimage()), (int)(Player.getHeightimage()));
		
		g.drawRect(gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY() ,Player.getWithimage(),Player.getHeightimage());

		g.drawRect(gameManager.getDisc().getX()+((int)(Disc.getWithimage()*0.25)),gameManager.getDisc().getY()+((int)(Disc.getHeightimage()*0.25)) ,(int)(Disc.getWithimage()*0.6), (int)(Disc.getHeightimage()*0.6));
		
		//gif goal
		g.drawImage(pointsImage, gameManager.getDisc().getX(), gameManager.getDisc().getY(),this);
		//score
		g.drawImage(scoreInfoImage, (int)(width*0.25), 0,this);
		
		//fine round
		g.drawImage(roundImage, (int)(width*0.25), 0,this);
		//fine pass
		g.drawImage(roundResumeImage, (int)(width*0.25), 0,this);
		//pause
		g.drawImage(pauseMenuImage, (int)(width*0.35), (int)(height*0.10), (int)(width*0.25), (int)(height*0.50),this);
	}
	
	public static RepainterThread getRepainterThread() {
		return repainterThread;
	}
}
