package it.unical.mat.igpe.ultimaDisc.iaComPlayer;



import java.util.Random;

import it.unical.mat.igpe.graphics.CenterGamePanel;
import it.unical.mat.igpe.graphics.Screen;
import it.unical.mat.igpe.graphics.ShotComPlayer;
import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.ComPlayer;
import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

public class IaComPlayer {
	
	 public final static class LoadShotComPlayerThread extends Thread
	    {
	        private static GameManager gameManager;
	        boolean loadShoot;

	        private LoadShotComPlayerThread(GameManager gameManagerNew)
	        {
	            gameManager = gameManagerNew;
	            loadShoot=false;
	        }

	        public void setLoadShoot(boolean loadShoot) {
				this.loadShoot = loadShoot;
			}

//			private void shoot()
//	        {
//	        	int randomX = -40+new Random().nextInt(35);
//	        	int randomY = -30+new Random().nextInt(60);
//	        	
//	        	try
//        		{
//        			sleep(3000);
//        		}
//        		catch (final InterruptedException e)
//        		{
//        			System.out.println("errore run RepainterThread");
//        		}
//	        	
//	        	gameManager.getDisc().setDirection(randomX, randomY);
//	        }
	        
	        @Override
	        public void run()
	        {
	        	while(true)
	        	{	
	        		if (loadShoot==true)
	        		{
	        			int randomX = -40+new Random().nextInt(35);
	    	        	int randomY = -30+new Random().nextInt(60);
	    	        	
	    	        	try
	            		{
	            			sleep(500);
	            		}
	            		catch (final InterruptedException e)
	            		{
	            			System.out.println("errore run LoadShotComPlayerThread");
	            		}
	    	        	
	    	        	ShotComPlayer s= new ShotComPlayer();
	    	        	s.start();
	    	        	gameManager.getDisc().setDirection(randomX, randomY);
//	    	        	resetPositionComPlayer();
	        		}
	        		loadShoot=false;
	        	}
	        }
	    }
	
	static GameManager gameManager;
	public static LoadShotComPlayerThread loadShotComPlayerThread;
	
	public IaComPlayer(GameManager gameManagerNew){ //nel costruttore dovremmo passare anche la difficoltà
		gameManager=gameManagerNew;
		loadShotComPlayerThread = new LoadShotComPlayerThread(gameManagerNew);
	}
	
	public void moveComPlayer() {

		if(gameManager.getDisc().getY() != gameManager.getComPlayer().getY())
		{
			final int differenceDiscX = gameManager.getDisc().getX() - gameManager.getComPlayer().getX();
			final int differenceDiscY = gameManager.getDisc().getY() - gameManager.getComPlayer().getY();
			
			final int differencePlayerX = gameManager.getComPlayer().getX() - gameManager.getDisc().getX();
			final int differencePlayerY = gameManager.getComPlayer().getY() - gameManager.getDisc().getY();
			
			//UP
			if(differencePlayerY>25 && differencePlayerX>35)
			{
				gameManager.getComPlayer().setDirection(0);//up
				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UP));
			}
			//UPLEFT
			else if(differencePlayerY>5 && differencePlayerX>=35)
			{
				gameManager.getComPlayer().setDirection(5);//UPLEFT
				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UPLEFT));
			}
			
			//DOWN
			else if(differenceDiscY>25 && differencePlayerX>35)
			{
				gameManager.getComPlayer().setDirection(1);//down
				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWN));
			}
			//DOWNLEFT
			else if(differenceDiscY>5 && differencePlayerX>=35)
			{
				gameManager.getComPlayer().setDirection(7);//DOWNLEFT
				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWNLEFT));
			}
			
			//UPRIGHT
			else if(differencePlayerY>5 && differenceDiscX>=10)
			{
				gameManager.getComPlayer().setDirection(4);//UPRIGHT
				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UPRIGHT));
			}
			//DOWNRIGHT
			else if(differenceDiscY>5 && differenceDiscX>=10)
			{
				gameManager.getComPlayer().setDirection(6);//DOWNRIGHT
				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWNRIGHT));
			}
		}
		
		gameManager.getComPlayer().update();
	}

	public static  void shoot() {
		
		gameManager.getDisc().setPositionCom(gameManager.getComPlayer().getX()-(int)(ComPlayer.getWithimage()*0.5), gameManager.getComPlayer().getY());
//		//		loadShotComPlayerThread.shoot();
		loadShotComPlayerThread.setLoadShoot(true);
		gameManager.getDisc().setAvailableForComPlayer(false);
	}

	public static void resetPositionComPlayer() {
		
	}

}
