package it.unical.mat.igpe.graphics;
import it.unical.mat.igpe.ultimateDisc.GameManager;
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
			public boolean gameFinished = false;
			public boolean end;
			public int yDisc;

			private RepainterThread(final GameManager gameManager)
	        {
	            super("Repainter");
	            this.gameManager = gameManager;
	            end=false;
	            yDisc = 0;
	        }
			
			public void restart()
			{
				gameFinished=false;
				myPlayerGoal=false;
			    comPlayerGoal=false;
				endRound=false;
				finishMatch=false;
				startGame=true;
				roundControllerStart=true;
				counterOfRounds=0;
				gameFinished = false;
				yDisc = 0;
			}
			
			public void stopT()
			{
				gameFinished=false;
				myPlayerGoal=false;
			    comPlayerGoal=false;
				endRound=false;
				finishMatch=false;
				startGame=true;
				roundControllerStart=true;
				counterOfRounds=0;
				gameFinished = false;
				yDisc = 0;
			}

			@Override
	        public void run()
	        {
	        	while(!end)
		        {	//System.out.println("CGP");
	        		if(!gameFinished){
		        		if(GameManager.isPause()==false){
		        			while(gameManager.timeUp()==false && finishMatch==false)
		        			{
		        				if(GameManager.isPause()==false){
		        					if(roundControllerStart)
		        					{
		        						// side MyPlayer
		        						pointMyPlayerPosition0 = imageProvider.getPoints(playGroundCGP,0);
		        						pointMyPlayerPosition1 = imageProvider.getPoints(playGroundCGP,1);
		        						pointMyPlayerPosition2 = imageProvider.getPoints(playGroundCGP,2);
		        						pointMyPlayerPosition3 = imageProvider.getPoints(playGroundCGP,3);
		        						pointMyPlayerPosition4 = imageProvider.getPoints(playGroundCGP,4);
		        						// side ComPlayer
		        						pointComPlayerPosition0 = imageProvider.getPoints(playGroundCGP,0);
		        						pointComPlayerPosition1 = imageProvider.getPoints(playGroundCGP,1);
		        						pointComPlayerPosition2 = imageProvider.getPoints(playGroundCGP,2);
		        						pointComPlayerPosition3 = imageProvider.getPoints(playGroundCGP,3);
		        						pointComPlayerPosition4 = imageProvider.getPoints(playGroundCGP,4);
		        						roundImage = imageProvider.getRound(counterOfRounds);
		        						repaint();
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
		        						// side MyPlayer
		        						pointMyPlayerPosition0 = null;
		        						pointMyPlayerPosition1 = null;
		        						pointMyPlayerPosition2 = null;
		        						pointMyPlayerPosition3 = null;
		        						pointMyPlayerPosition4 = null;
		        						// side ComPlayer
		        						pointComPlayerPosition0 = null;
		        						pointComPlayerPosition1 = null;
		        						pointComPlayerPosition2 = null;
		        						pointComPlayerPosition3 = null;
		        						pointComPlayerPosition4 = null;
		        					}
		        					
		        					if(startGame)
		        					{
		        						if(end)
		        							break;
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
	//	        						pointsImage = imageProvider.getPoints(gameManager.getWorld().getCurrentPoints());
		        						int numberOfImageToActivate = getNumberOfImageToActivate();
		        						scoreInfoImage = imageProvider.getScore();
		        						myPlayerNumberScore = imageProvider.getNumberScore(GameManager.getWorld().getMyPlayerScore());
		        						comPlayerNumberScore = imageProvider.getNumberScore(GameManager.getWorld().getComScore());
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
		        						myPlayerNumberScore = null;
		        						comPlayerNumberScore = null;
		        						deActivateImagePoints(numberOfImageToActivate);
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
		        			
		        			// caso pareggio
		        			if(gameManager.timeUp()==true && endRound==false && GameManager.isPause()==false
		        					&& (GameManager.getWorld().getMyPlayerScore()==GameManager.getWorld().getComScore()) )
		        			{
		        				
		        				gameManager.getDisc().reset();
		        				gameManager.getMyPlayer().reset();
		        				gameManager.getComPlayer().reset();
		        				gameManager.getDisc().setAvailableForMyPlayer(false);
		        				gameManager.getDisc().setAvailableForComPlayer(false);
		        				myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerRightMotionLess();
		        				comPlayerImage = CenterGamePanel.imageProvider.getComPlayerLeftMotionLess();
		        				frisbeeImage=imageProvider.getFrisbee();
		        				gameManager.update();
	        					repaint();
		        				lastShot = imageProvider.getLastShot();
		        				try
	        					{
	        						sleep(1500);
	        					}
	        					catch (final InterruptedException e)
	        					{
	        						System.out.println("errore run RepainterThread");
	        					}
		        				lastShot = null;
		        				gameManager.getDisc().setDirection(-18, 14);
		        			}
		        			
		        			while(gameManager.timeUp()==true && endRound==false && GameManager.isPause()==false
		        					&& (GameManager.getWorld().getMyPlayerScore()==GameManager.getWorld().getComScore()) )
		        			{
		        				GameManager.setEqualize(true);
		        				
		        				gameManager.update();
	        					repaint();
	        					if(GameManager.isStop())
	        					{
	        						frisbeeImage=null;
//	        						System.out.println("punti: "+gameManager.getWorld().getCurrentPoints());
//	        						pointsImage = imageProvider.getPoints(gameManager.getWorld().getCurrentPoints());
	        						int numberOfImageToActivate = getNumberOfImageToActivate();
	        						scoreInfoImage = imageProvider.getScore();
	        						myPlayerNumberScore = imageProvider.getNumberScore(GameManager.getWorld().getMyPlayerScore());
	        						comPlayerNumberScore = imageProvider.getNumberScore(GameManager.getWorld().getComScore());
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
	        						myPlayerNumberScore = null;
	        						comPlayerNumberScore = null;
	        						deActivateImagePoints(numberOfImageToActivate);
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
		        			GameManager.setEqualize(false);
		        			
		        			if(gameManager.timeUp()==true && endRound==false && GameManager.isPause()==false){
		        				
		        				gameManager.update();
		        				
		        				if(GameManager.getWorld().getMyPlayerScore()>=GameManager.getWorld().getComScore())
		        					GameManager.getWorld().setRoundMyPlayer(1);
		        				else
		        					GameManager.getWorld().setRoundComPlayer(1);
		        				
		        				roundResumeImage = imageProvider.getScoreRound(GameManager.getWorld().getRoundMyPlayer(), GameManager.getWorld().getRoundComPlayer());
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
		        				
		        				System.out.println("Round "+counterOfRounds+" MYplayer: "+GameManager.getWorld().getMyPlayerScore()+" ComPlayer: "+GameManager.getWorld().getComScore());
		        				System.out.println("Round "+counterOfRounds+" MYplayerR: "+GameManager.getWorld().getRoundMyPlayer()+" ComPlayerR: "+GameManager.getWorld().getRoundComPlayer());
		        				GameManager.getWorld().setMyPlayerScore(0);
		        				GameManager.getWorld().setComScore(0);
		        				
		        				gameManager.getDisc().reset();
		        				gameManager.getMyPlayer().reset();
		        				gameManager.getComPlayer().reset();
		        				gameManager.getDisc().setAvailableForMyPlayer(false);
		        				gameManager.getDisc().setAvailableForComPlayer(false);
		        				myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerRightMotionLess();
		        				comPlayerImage = CenterGamePanel.imageProvider.getComPlayerLeftMotionLess();
		        				frisbeeImage=imageProvider.getFrisbee();
		        				gameManager.update();
	        					repaint();
		        			}
		        			
		        			if((GameManager.getWorld().getRoundMyPlayer()==2 || GameManager.getWorld().getRoundComPlayer()==2 
		        					|| (GameManager.getWorld().getRoundMyPlayer()+GameManager.getWorld().getRoundComPlayer())==3) && (GameManager.isPause()==false))
		        			{
		        				finishMatch=true;
		        				counterOfRounds=0;
		        				// image you win or game over!
		        				if(GameManager.getWorld().getRoundMyPlayer()==2)
		        					gameOverImage = imageProvider.getYouWin();
		        				else
		        					gameOverImage = imageProvider.getGameOver();
		        				repaint();
		        				try{
		        					sleep(1000);
		        				}catch(InterruptedException e){}
		        				gameFinished=true;
		        			}
		        			else if(GameManager.isPause()==false)
		        			{
		        				gameManager.getDisc().setAvailableForMyPlayer(false);
		        				gameManager.getDisc().setAvailableForComPlayer(false);
		        				gameManager.restartRound();
		        			}
		        		}
		        	}
	        		if (end)
	        			break;
		        }
	        }
			
			private void deActivateImagePoints(int numberOfImageToActivate) {
				switch (numberOfImageToActivate) {
				
				case 0: pointComPlayerPosition0 = null;
						pointMyPlayerPosition0 = null;
						break;
				case 1: pointComPlayerPosition1 = null;
						pointMyPlayerPosition1 = null;
						break;
				case 2: pointComPlayerPosition2 = null;
						pointMyPlayerPosition2 = null;
						break;
				case 3: pointComPlayerPosition3 = null;
						pointMyPlayerPosition3 = null;
						break;		
				case 4: pointComPlayerPosition4 = null;
						pointMyPlayerPosition4 = null;
						break;
				default:
						break;
				}
			}

			private int getNumberOfImageToActivate() {
				int positionHit = GameManager.getWorld().getWallCom().getStrickenWall(getyDisc());
				if (CenterGamePanel.getRepainterThread().isMyPlayerGoal())
				{
					switch (positionHit) {
						
						case 0: pointComPlayerPosition0 = imageProvider.getPoints(playGroundCGP,0);
								return 0;
						case 1: pointComPlayerPosition1 = imageProvider.getPoints(playGroundCGP,1);
								return 1;
						case 2: pointComPlayerPosition2 = imageProvider.getPoints(playGroundCGP,2);
								return 2;
						case 3: pointComPlayerPosition3 = imageProvider.getPoints(playGroundCGP,3);
								return 3;		
						case 4: pointComPlayerPosition4 = imageProvider.getPoints(playGroundCGP,4);
								return 4;
						default:
								return 0;
					}
				}
				else
				{
					switch (positionHit) {
						
						case 0: pointMyPlayerPosition0 = imageProvider.getPoints(playGroundCGP,0);
								return 0;
						case 1: pointMyPlayerPosition1 = imageProvider.getPoints(playGroundCGP,1);
								return 1;
						case 2: pointMyPlayerPosition2 = imageProvider.getPoints(playGroundCGP,2);
								return 2;
						case 3: pointMyPlayerPosition3 = imageProvider.getPoints(playGroundCGP,3);
								return 3;		
						case 4: pointMyPlayerPosition4 = imageProvider.getPoints(playGroundCGP,4);
								return 4;
						default:
								return 0;
					}
				}
			}

			public void setMyPlayerGoal(boolean myPlayerGoal) {
				this.myPlayerGoal = myPlayerGoal;
			}

			public void setComPlayerGoal(boolean comPlayerGoal) {
				this.comPlayerGoal = comPlayerGoal;
			}
			
			public boolean isMyPlayerGoal() {
				return myPlayerGoal;
			}

			public boolean isComPlayerGoal() {
				return comPlayerGoal;
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

			public int getyDisc() {
				return yDisc;
			}

			public void setyDiscMyPlayer(int yDisc) {
				this.yDisc = yDisc;
			}
	    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/// IMAGE ///
	public static ImageProvider imageProvider;
// world Image
	static Image fieldImage;
	public static Image frisbeeImage;
	static Image pointsImage = null;
	static Image point3 = null;
	static Image point5 = null;
	static Image pointMyPlayerPosition0 = null;
	static Image pointMyPlayerPosition1 = null;
	static Image pointMyPlayerPosition2 = null;
	static Image pointMyPlayerPosition3 = null;
	static Image pointMyPlayerPosition4 = null;
	static Image pointComPlayerPosition0 = null;
	static Image pointComPlayerPosition1 = null;
	static Image pointComPlayerPosition2 = null;
	static Image pointComPlayerPosition3 = null;
	static Image pointComPlayerPosition4 = null;
	static Image myPlayerNumberScore = null;
	static Image comPlayerNumberScore = null;
// player Image
	static Image myPlayerImage=null;
	public static Image comPlayerImage=null;
// round Image
	static Image gameOverImage = null;
	private Image roundImage = null;
	private Image roundResumeImage = null;
	static Image scoreInfoImage = null;	
// pause menu Image
	static Image pauseMenuImage=null;
// window finish
	static Image backGroundWindowFinish = null;
	static Image restartWindowFinish = null;
	static Image menuWindowFinish = null;
	static Image exitWindowFinish = null;
// window pause
	static Image backGroundWindowPause = null;
	static Image resumeWindowPause= null;
	static Image restartWindowPause = null;
	static Image menuWindowPause = null;
	static Image exitWindowPause = null;	
	
	static Image shadow=null;
	static Image lastShot=null;

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
    public static RepainterThread repainterThread;
    static ProgressBar energyShoot;
    static int myPlayerCGP;
    static int comPlayerCGP;
    static int playGroundCGP;
    
	public CenterGamePanel(final GameManager gameManager,ImageProvider imageProviderNew,int myPlayer,int comPlayer,int playGround)
	{
		CenterGamePanel.imageProvider=imageProviderNew;
		
		myPlayerCGP=myPlayer;
		comPlayerCGP=comPlayer;
		playGroundCGP=playGround;
		
		CenterGamePanel.imageProvider.setPlayGround(playGround);
		CenterGamePanel.imageProvider.setMyPlayer(myPlayer);
		CenterGamePanel.imageProvider.setComPlayer(comPlayer);
		
		CenterGamePanel.imageProvider.loadPlayGround();
		CenterGamePanel.imageProvider.loadPlayers();
		
		fieldImage = imageProvider.getWoodField();
		frisbeeImage = imageProvider.getFrisbee();
		
		myPlayerImage = imageProvider.getMyPlayerRightMotionLess();
		comPlayerImage = imageProvider.getComPlayerLeftMotionLess();
		
		shadow = imageProvider.getShadow();
		
		backGroundWindowFinish = imageProvider.getBackgroundWindowFinish();
	    restartWindowFinish = imageProvider.getRestartWindowFinish();
	    menuWindowFinish = imageProvider.getMenuWindowFinish();
	    exitWindowFinish = imageProvider.getExitWindowFinish();
	    
		this.gameManager=gameManager;
		CenterGamePanel.energyShoot=new ProgressBar();
		this.add(CenterGamePanel.energyShoot);
		CenterGamePanel.energyShoot.setVisible(false);
		
		this.setPreferredSize(new Dimension((int)width,(int)height));

		final KeyProcessor keyProcessor = new KeyProcessor(50,null,gameManager);

		//Mouse Listener
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				final int x = e.getX();
			    final int y = e.getY();
			    
			    // window finish
			    if (CenterGamePanel.repainterThread.gameFinished==true)
			    {
					// restart
			    	if(x>((int)(width*0.29)) && x<((int)(width*0.43)) && y>((int)(height*0.1)) && y<((int)(height*0.17)))
				    {
				    	restartWindowFinish = imageProvider.getRestartPushedWindowFinish();
				    	repaint();
				    }
				    // menu
			    	if(x>((int)(width*0.29)) && x<((int)(width*0.41)) && y>((int)(height*0.23)) && y<((int)(height*0.3)))
				    {
				    	menuWindowFinish = imageProvider.getMenuPushedWindowFinish();
				    	repaint();
				    }
				    // exit
			    	if(x>((int)(width*0.29)) && x<((int)(width*0.38)) && y>((int)(height*0.36)) && y<((int)(height*0.43)))
				    {
				    	exitWindowFinish = imageProvider.getExitPushedWindowFinish();
				    	repaint();
				    }
			    }
			    // window pause
			    if(GameManager.isPause()==true)
			    {
			    	// resume
				    if(x>((int)(width*0.28)) && x<((int)(width*0.42)) && y>((int)(height*0.08)) && y<((int)(height*0.13)))
				    {
				    	resumeWindowPause = imageProvider.getResumePushedWindowPause();
				    	repaint();
				    }
				    // restart
				    if(x>((int)(width*0.28)) && x<((int)(width*0.41)) && y>((int)(height*0.19)) && y<((int)(height*0.24)))
				    {
				    	restartWindowPause = imageProvider.getRestartPushedWindowPause();
				    	repaint();
				    }
				    // menu
				    if(x>((int)(width*0.28)) && x<((int)(width*0.39)) && y>((int)(height*0.31)) && y<((int)(height*0.36)))
				    {
				    	menuWindowPause = imageProvider.getMenuPushedWindowPause();
				    	repaint();
				    }
				    // exit
				    if(x>((int)(width*0.28)) && x<((int)(width*0.36)) && y>((int)(height*0.42)) && y<((int)(height*0.47)))
				    {
				    	exitWindowPause = imageProvider.getExitPushedWindowPause();
				    	repaint();
				    }
			    }
			};
			@Override
		    public void mouseReleased(final MouseEvent e){
				
				final int x = e.getX();
			    final int y = e.getY();
			    
			    // window finish
			    if (CenterGamePanel.repainterThread.gameFinished==true)
			    {
					// restart
			    	if(x>((int)(width*0.29)) && x<((int)(width*0.43)) && y>((int)(height*0.1)) && y<((int)(height*0.17)))
				    {
			    		AudioProvider.stopMusicPlay();
				    	restartWindowFinish = imageProvider.getRestartWindowFinish();
				    	repaint();
				    	MainFrame.reStartGame(myPlayerCGP,comPlayerCGP,playGroundCGP);
				    	CenterGamePanel.repainterThread.gameFinished=false;
				    	AudioProvider.musicPlay();
				    }
				    // menu
			    	if(x>((int)(width*0.29)) && x<((int)(width*0.41)) && y>((int)(height*0.23)) && y<((int)(height*0.3)))
				    {
			    		AudioProvider.stopMusicPlay();
				    	menuWindowFinish = imageProvider.getMenuWindowFinish();
				    	repaint();
				    	MainFrame.stop();
				    	MainFrame.goToMenuPanel();
				    	CenterGamePanel.repainterThread.end=true;
				    	MainFrame.goToMenuPanel();
				    }
				    // exit
			    	if(x>((int)(width*0.29)) && x<((int)(width*0.38)) && y>((int)(height*0.36)) && y<((int)(height*0.43)))
				    {
				    	exitWindowFinish = imageProvider.getExitWindowFinish();
				    	repaint();
				    	System.exit(0);
				    }
			    }
			    
			    // window pause
				if(GameManager.isPause()==true){
					// resume
					if(x>((int)(width*0.28)) && x<((int)(width*0.42)) && y>((int)(height*0.08)) && y<((int)(height*0.13)))
				    {
				    	resumeWindowPause = imageProvider.getResumeWindowPause();
				    	repaint();
				    	setImageMenu();
				    }
				    // restart
					if(x>((int)(width*0.28)) && x<((int)(width*0.41)) && y>((int)(height*0.19)) && y<((int)(height*0.24)))
				    {
						AudioProvider.stopMusicPlay();
				    	restartWindowPause = imageProvider.getRestartWindowPause();
				    	repaint();
				    	setImageMenu();
				    	MainFrame.reStartGame(myPlayerCGP,comPlayerCGP,playGroundCGP);
				    	CenterGamePanel.repainterThread.gameFinished=false;
				    	AudioProvider.musicPlay();
				    }
				    // menu
					if(x>((int)(width*0.28)) && x<((int)(width*0.39)) && y>((int)(height*0.31)) && y<((int)(height*0.36)))
				    {
						AudioProvider.stopMusicPlay();
				    	menuWindowPause = imageProvider.getMenuWindowPause();
				    	repaint();
				    	CenterGamePanel.repainterThread.end=true;
				    	setImageMenu();
				    	MainFrame.stop();
				    	AudioProvider.musicMainMenu();
				    	MainFrame.goToMenuPanel();
				    	
				    }
				    // exit
					if(x>((int)(width*0.28)) && x<((int)(width*0.36)) && y>((int)(height*0.42)) && y<((int)(height*0.47)))
				    {
				    	exitWindowPause = imageProvider.getExitWindowPause();
				    	repaint();
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
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerRightMotionLess();
						 					ImageProvider.numberOfSequenceMyPlayer=0;
					 						gameManager.getMyPlayer().setDirection(-1);
					 						break;

					 case KeyEvent.VK_DOWN:
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerRightMotionLess();
						 					ImageProvider.numberOfSequenceMyPlayer=0;
						 					gameManager.getMyPlayer().setDirection(-1);
						 					break;

					 case KeyEvent.VK_LEFT:
						 					gameManager.getMyPlayer().setDirection(-1);
						 					ImageProvider.numberOfSequenceMyPlayer=0;
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerRightMotionLess();
						 					break;

					 case KeyEvent.VK_RIGHT:
						 					CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerRightMotionLess();
						 					ImageProvider.numberOfSequenceMyPlayer=0;
						 					gameManager.getMyPlayer().setDirection(-1);
						 					break;

					 default:	
						 	break;
					 }

					 if(e.getKeyCode()==KeyEvent.VK_SPACE && gameManager.getDisc().isAvailableForMyPlayer()==true){
						 
						 Shot s = new Shot();
						 s.start();
						 
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
	
	public static void restart()
	{
		CenterGamePanel.imageProvider.loadPlayGround();
		CenterGamePanel.imageProvider.loadPlayers();
		
		fieldImage = imageProvider.getWoodField();
		frisbeeImage = imageProvider.getFrisbee();
		
		myPlayerImage = imageProvider.getMyPlayerRightMotionLess();
		comPlayerImage = imageProvider.getComPlayerLeftMotionLess();
		
		shadow = imageProvider.getShadow();
		
		backGroundWindowFinish = imageProvider.getBackgroundWindowFinish();
	    restartWindowFinish = imageProvider.getRestartWindowFinish();
	    menuWindowFinish = imageProvider.getMenuWindowFinish();
	    exitWindowFinish = imageProvider.getExitWindowFinish();
		
	}
	
	public static void stop()
	{
		fieldImage = null;
		frisbeeImage = null;
		myPlayerImage = null;
		comPlayerImage = null;
		shadow = null;
		backGroundWindowFinish = null;
	    restartWindowFinish = null;
	    menuWindowFinish = null;
	}
	
	public static void load(int myPlayer,int comPlayer,int playGround)
	{
		myPlayerCGP=myPlayer;
		comPlayerCGP=comPlayer;
		playGroundCGP=playGround;
		CenterGamePanel.imageProvider.setPlayGround(playGround);
		CenterGamePanel.imageProvider.setMyPlayer(myPlayer);
		CenterGamePanel.imageProvider.setComPlayer(comPlayer);
		CenterGamePanel.imageProvider.loadPlayGround();
		CenterGamePanel.imageProvider.loadPlayers();
		fieldImage = imageProvider.getWoodField();
		frisbeeImage = imageProvider.getFrisbee();
		myPlayerImage = imageProvider.getMyPlayerRightMotionLess();
		comPlayerImage = imageProvider.getComPlayerLeftMotionLess();
		shadow = imageProvider.getShadow();
		backGroundWindowFinish = imageProvider.getBackgroundWindowFinish();
	    restartWindowFinish = imageProvider.getRestartWindowFinish();
	    menuWindowFinish = imageProvider.getMenuWindowFinish();
	    exitWindowFinish = imageProvider.getExitWindowFinish();
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
				//pauseMenuImage = imageProvider.getMenuPause();
				backGroundWindowPause = imageProvider.getBackgroundWindowPause();
				resumeWindowPause = imageProvider.getResumeWindowPause();
				restartWindowPause = imageProvider.getRestartWindowPause();
				menuWindowPause = imageProvider.getMenuWindowPause();
				exitWindowPause = imageProvider.getExitWindowPause();
				GameManager.setPause(true);
    		}
    		else if(GameManager.isPause()==true)
    		{
    			//pauseMenuImage = null;
    			backGroundWindowPause = null;
				resumeWindowPause = null;
				restartWindowPause = null;
				menuWindowPause = null;
				exitWindowPause = null;
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
		CenterGamePanel.energyShoot.setLocation(gameManager.getMyPlayer().getX(), gameManager.getMyPlayer().getY());
		// My player
		g.drawImage(myPlayerImage,gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY(),this);
		// COM player
		g.drawImage(comPlayerImage,gameManager.getComPlayer().getX(),gameManager.getComPlayer().getY(),this);
		// disc
		g.drawImage(frisbeeImage,gameManager.getDisc().getX(),gameManager.getDisc().getY(),dimensionOfDisc,dimensionOfDisc,this); 
		//event
		g.drawImage(gameOverImage,(int)(width*0.33),(int)(height*0.20),this); 
		
//		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		
		g.setColor(Color.RED);
//		g.drawLine((int)(width*0.25), 0, (int)width/4, getHeight());
//		
//		g.drawLine((int)(width*0.69), 0, (int)(width*0.69), getHeight());
		
//		g.drawRect(gameManager.getComPlayer().getX(),gameManager.getComPlayer().getY(), (int)(Player.getWithimage()), (int)(Player.getHeightimage()));
//		
//		g.drawRect(gameManager.getMyPlayer().getX(),gameManager.getMyPlayer().getY() ,Player.getWithimage(),Player.getHeightimage());
//
//		g.drawRect(gameManager.getDisc().getX()+((int)(Disc.getWithimage()*0.25)),gameManager.getDisc().getY()+((int)(Disc.getHeightimage()*0.25)) ,(int)(Disc.getWithimage()*0.6), (int)(Disc.getHeightimage()*0.6));
		
		//gif goal
//		if (CenterGamePanel.getRepainterThread().isMyPlayerGoal())
//			g.drawImage(pointsImage, (int)(width*0.80), gameManager.getDisc().getY(),this);
//		}
//		else
//			g.drawImage(pointsImage, 1, gameManager.getDisc().getY(),this);
		
			//myplayer side
		g.drawImage(pointMyPlayerPosition0, 1, (int)(height*0.02),this);
		g.drawImage(pointMyPlayerPosition1, 1, (int)(height*0.22),this);
		g.drawImage(pointMyPlayerPosition2, 1, (int)(height*0.42),this);
		g.drawImage(pointMyPlayerPosition3, 1, (int)(height*0.62),this);
		g.drawImage(pointMyPlayerPosition4, 1, (int)(height*0.82),this);
			//complayer side
		g.drawImage(pointComPlayerPosition0, (int)(width*0.80), (int)(height*0.02),this);
		g.drawImage(pointComPlayerPosition1, (int)(width*0.80), (int)(height*0.22),this);
		g.drawImage(pointComPlayerPosition2, (int)(width*0.80), (int)(height*0.42),this);
		g.drawImage(pointComPlayerPosition3, (int)(width*0.80), (int)(height*0.62),this);
		g.drawImage(pointComPlayerPosition4, (int)(width*0.80), (int)(height*0.82),this);	

		//score
		g.drawImage(scoreInfoImage, (int)(width*0.29),(int)(height*0.3) ,this);
		g.drawImage(myPlayerNumberScore, (int)(width*0.33),(int)(height*0.4) ,this);
		g.drawImage(comPlayerNumberScore, (int)(width*0.49),(int)(height*0.4) ,this);
		//fine round
		g.drawImage(roundImage, (int)(width*0.26), 0,this);
		g.drawImage(lastShot, (int)(width*0.26), 0,this);
		//fine pass
		g.drawImage(roundResumeImage, (int)(width*0.36), 0,this);
		//pause
		g.drawImage(pauseMenuImage, (int)(width*0.35), (int)(height*0.10), (int)(width*0.25), (int)(height*0.50),this);
		
		g.drawImage(backGroundWindowPause,(int)(width*0.25),0,this);
		g.drawImage(resumeWindowPause,(int)(width*0.25),0,this);
		g.drawImage(restartWindowPause,(int)(width*0.25),0,this);
		g.drawImage(menuWindowPause,(int)(width*0.25),0,this);
		g.drawImage(exitWindowPause,(int)(width*0.25),0,this);
		
		//shadow
		g.drawImage(shadow,gameManager.getMyPlayer().getX()+((int)(width*0.021)),gameManager.getMyPlayer().getY()+((int)(width*0.095)),this);
		g.drawImage(shadow,gameManager.getComPlayer().getX()+((int)(width*0.021)),gameManager.getComPlayer().getY()+((int)(width*0.095)),this);
		
//		g.drawImage(shadow,(int) (gameManager.getMyPlayer().getX()*(1.25)),(int) (gameManager.getMyPlayer().getY()*(1.68)),(int)(width*0.073),(int)(height*0.049),this);
//		g.drawImage(shadow,(int) (gameManager.getComPlayer().getX()*(0.2)),(int) (gameManager.getComPlayer().getY()*(0.5)),this);		
	
		// window finish
		if (CenterGamePanel.repainterThread.gameFinished==true)
		{
			gameOverImage = null;
			g.drawImage(backGroundWindowFinish,(int)(width*0.25),0,this);
			g.drawImage(restartWindowFinish,(int)(width*0.25),0,this);
			g.drawImage(menuWindowFinish,(int)(width*0.25),0,this);
			g.drawImage(exitWindowFinish,(int)(width*0.25),0,this);
		}
		
	}
	
	public static RepainterThread getRepainterThread() {
		return repainterThread;
	}
	public static void setComPlayerImage(Image comPlayerImage) {
		CenterGamePanel.comPlayerImage = comPlayerImage;
	}
	public static ImageProvider getImageProvider() {
		return imageProvider;
	}
}
