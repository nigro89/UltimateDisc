package it.unical.mat.igpe.ultimaDisc.iaComPlayer;



import java.util.Random;

import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.ComPlayer;

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
	    	        	
	    	        	gameManager.getDisc().setDirection(randomX, randomY);
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
			if(gameManager.getDisc().getY()>gameManager.getComPlayer().getY())
			{
				gameManager.getComPlayer().setDirection(1);//down
//				CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWN));
			}
			else if(gameManager.getDisc().getY()<gameManager.getComPlayer().getY())
				{
					gameManager.getComPlayer().setDirection(0);//up
//					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UP));
				}
				else
				{
					gameManager.getComPlayer().setDirection(2);//left
//					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.LEFT));
				}
		}
		
		gameManager.getComPlayer().update();
	}

	public static  void shoot() {
		
		gameManager.getDisc().setPositionCom(gameManager.getComPlayer().getX()-(int)(ComPlayer.getWithimage()*0.5), gameManager.getComPlayer().getY());
//		loadShotComPlayerThread.shoot();
		loadShotComPlayerThread.setLoadShoot(true);
		gameManager.getDisc().setAvailableForComPlayer(false);
	}

}
