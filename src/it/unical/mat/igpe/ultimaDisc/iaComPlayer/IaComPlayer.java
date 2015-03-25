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

	        @SuppressWarnings("deprecation")
			@Override
	        public void run()
	        {
	        	while(true)
	        	{	
	        		if (loadShoot==true)
	        		{
	        			int randomY=0;
	        			int randomX=-15;
//	        			randomY = -30+new Random().nextInt(60);
//        				randomX = -40+new Random().nextInt(35);
	        			
//	        			int startPositionPlayerX = 192;
	        			int startPositionPlayerY = 270;
	        			
//	        			int xPlayer = gameManager.getMyPlayer().getX();
	        			int yPlayer = gameManager.getMyPlayer().getY();
	        			
	        			//EASY
	        			if(GameManager.getDifficultyLevel() == 0){
	        				if(yPlayer>(startPositionPlayerY+10)){
	        					randomY=4;
	        				}
	        				else if (yPlayer<=(startPositionPlayerY+10)){
	        					randomY=-4;
	        				}
	        			}
	        			//MEDIUM
	        			else if(GameManager.getDifficultyLevel() == 1){
	        				if(yPlayer>(startPositionPlayerY+10)){
	        					randomY = 4+new Random().nextInt(6);
	        				}
	        				else if (yPlayer<=(startPositionPlayerY+10)){
	        					randomY = -10+new Random().nextInt(9);
	        				}
	        				randomX=-35;
	        			}
	        			//HARD
	        			else if(GameManager.getDifficultyLevel() == 2){
	        				if(yPlayer>(startPositionPlayerY+10)){
	        					randomY = -10+new Random().nextInt(9);
	        				}
	        				else if (yPlayer<=(startPositionPlayerY+10)){
	        					randomY = 4+new Random().nextInt(6);
	        				}
	        				randomX=-45;
	        			}
	    	        	
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
			double startX = gameManager.getComPlayer().getStartPositionX()-(gameManager.getComPlayer().getStartPositionX()*0.1);
			double startY = gameManager.getComPlayer().getStartPositionY()-(gameManager.getComPlayer().getStartPositionY()*0.4);
			
			double x = gameManager.getComPlayer().getX();
			double y = gameManager.getComPlayer().getY();
			
			if(((y+20)<gameManager.getComPlayer().getStartPositionY()) && ((x+20)<gameManager.getComPlayer().getStartPositionX())){
				for (int i = 0; i < 14; i++) {
					gameManager.getComPlayer().setDirection(6);//DOWNRIGHT
					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWNRIGHT));
					gameManager.getComPlayer().update();
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			else if (((x-20)>gameManager.getComPlayer().getStartPositionX())&& ((y+20)<gameManager.getComPlayer().getStartPositionY())){
				for (int i = 0; i < 14; i++) {
					gameManager.getComPlayer().setDirection(7);//DOWNLEFT
					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWNLEFT));
					gameManager.getComPlayer().update();
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			else if (((x+20)<gameManager.getComPlayer().getStartPositionX()) && ((y-20)>gameManager.getComPlayer().getStartPositionY())){
				for (int i = 0; i < 14; i++) {
					gameManager.getComPlayer().setDirection(4);//UPRIGHT
					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UPRIGHT));
					gameManager.getComPlayer().update();
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			else if (((x-20)>gameManager.getComPlayer().getStartPositionX()) && ((y-20)>gameManager.getComPlayer().getStartPositionY())){
				for (int i = 0; i < 14; i++) {
					gameManager.getComPlayer().setDirection(5);//UPLEFT
					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UPLEFT));
					gameManager.getComPlayer().update();
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
//			if((x+20)<gameManager.getComPlayer().getStartPositionX()){
//				for (int i = 0; i < 14; i++) {
//					gameManager.getComPlayer().setDirection(3);//RIGHT
//					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.RIGHT));
//					gameManager.getComPlayer().update();
//					try {
//						Thread.sleep(25);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			else if((x-20)>gameManager.getComPlayer().getStartPositionX()){
//				for (int i = 0; i < 14; i++) {
//					gameManager.getComPlayer().setDirection(2);//LEFT
//					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.LEFT));
//					gameManager.getComPlayer().update();
//					try {
//						Thread.sleep(25);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			if((y-20)>gameManager.getComPlayer().getStartPositionY()){
//				for (int i = 0; i < 14; i++) {
//					gameManager.getComPlayer().setDirection(0);//UP
//					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.UP));
//					gameManager.getComPlayer().update();
//					try {
//						Thread.sleep(25);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			else if((y+20)<gameManager.getComPlayer().getStartPositionY()){
//				for (int i = 0; i < 14; i++) {
//					gameManager.getComPlayer().setDirection(1);//DOWN
//					CenterGamePanel.setComPlayerImage(CenterGamePanel.getImageProvider().getComPlayerDirection(Player.DOWN));
//					gameManager.getComPlayer().update();
//					try {
//						Thread.sleep(25);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			System.out.println("X: "+x+" y: "+y+" posX:"+gameManager.getComPlayer().getX()+" posY "+gameManager.getComPlayer().getY());
			
			CenterGamePanel.comPlayerImage = CenterGamePanel.imageProvider.getComPlayerLeftMotionLess();
	}

}
