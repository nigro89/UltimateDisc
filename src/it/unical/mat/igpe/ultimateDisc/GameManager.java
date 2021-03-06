package it.unical.mat.igpe.ultimateDisc;

import it.unical.mat.igpe.graphics.CenterGamePanel;
import it.unical.mat.igpe.graphics.Screen;
import it.unical.mat.igpe.ultimaDisc.iaComPlayer.IaComPlayer;
import it.unical.mat.igpe.ultimateDisc.movingObject.ComPlayer;
import it.unical.mat.igpe.ultimateDisc.movingObject.Disc;
import it.unical.mat.igpe.ultimateDisc.movingObject.MyPlayer;
import it.unical.mat.igpe.ultimateDisc.world.World;
import it.unical.mat.igpe.ultimateDisc.world.WorldManager;

public class GameManager {

	private MyPlayer myPlayer=null;
	private ComPlayer comPlayer=null;
	private Disc disc=null;
	static private World world=null;
	private WorldManager worldManager = new WorldManager();
	private IaComPlayer iaComPlayer;
	private static boolean comPlayerAbility = false;
	private static int difficultyLevel = 0; //0=easy; 1=medium; 2=hard
	
	static long startTime = 0;
	static long currentTime = 0;
	static long stoppedTime=0;
	static long endTime = 30;
	
	Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight();
	int dimensionOfDisc = (int)width/17;
	int radius = dimensionOfDisc/2;
	static boolean pause=false;
	
	static boolean stop=false;
	
	static boolean equalize=false;
		
	public MyPlayer getMyPlayer() {
		return myPlayer;
	}
	
	public static synchronized void setPause(boolean pause) {
		if(pause==true){
			GameManager.pause = pause;
			GameManager.stopTime();
		}
		else{
			GameManager.pause = pause;
			GameManager.restartTime();
		}
	}


	public ComPlayer getComPlayer() {
		return comPlayer;
	}


	public Disc getDisc() {
		return disc;
	}


	public static World getWorld() {
		return world;
	}


	public void start(int playGround)
	{
//		stabilire i parametri da inizializzare a disc, myplayer e complayer. (tramite la grafica ci regoliamo)
//		condidioni iniziali: disco in mano al myplayer
		this.myPlayer = new MyPlayer((int)(width*0.1), (int)(height*0.25), (int)(width/4)-146,(int)(height*0.75),0,(int)(height*0.18));
		this.comPlayer = new ComPlayer((int)(width*0.78), (int)(height*0.25), (int)(width*0.69),(int)(height*0.75),0,(int)(height*0.18));
		this.disc = new Disc(((int)(width*0.4)+radius),((int)(height*0.7)-radius),(int)width-(int)(width*0.115),(int)(height*0.75),(int)(height*0.1));
		iaComPlayer = new IaComPlayer(this);
		// in loadWorld passo type=0 come se fosse il campo di tipo 0
		world = this.worldManager.loadWorld(disc, playGround);
		startTime = (System.currentTimeMillis())/1000;
	}
	
	public void reStart()
	{
		this.myPlayer.restart();
		this.comPlayer.restart();
		this.disc.restart();
		world = this.worldManager.getWorld();
		world.restart();
		endTime=30;
		startTime = (System.currentTimeMillis())/1000;
	}

	public void stop()
	{
		myPlayer=null;
		comPlayer=null;
		disc=null;
		world=null;
		startTime=0;
	}

	public boolean timeUp()
	{
		if(GameManager.isPause()==false){
			currentTime = (System.currentTimeMillis())/1000;
			if ((currentTime-startTime)>=endTime){
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean isGameOver()
	{
		if (world.getMyPlayerScore()<world.getComScore())
			return true;
		return false;
	}


	public void update()
	{
		if (disc!=null && myPlayer!=null && comPlayer!=null && iaComPlayer!=null && world!=null)
		{
			if(pause==false)
			{
				if(timeUp() && equalize==true)
				{
					if(!stop)
					{
						disc.update();
						myPlayer.update();
						if(comPlayerAbility)
							iaComPlayer.moveComPlayer(); 
						checkCollision();
					}
				}
				else if(timeUp()) 
				{
					disc.reset();
					myPlayer.reset();
					comPlayer.reset();
					startTime=0;
				}
				else
				{
					if(!stop)
					{
						disc.update();
						myPlayer.update();
						if(comPlayerAbility)
							iaComPlayer.moveComPlayer(); 
						checkCollision();
					}
				}
				world.update();
			}
		}
	}
	

	public static synchronized boolean isPause() {
		return pause;
	}

	private void checkCollision() {
		if(disc.getBounds().intersects(myPlayer.getBounds())){
			disc.setPosition(myPlayer.getX(), myPlayer.getY());
		}
		else if(disc.getBounds().intersects(comPlayer.getBounds())){
			CenterGamePanel.comPlayerImage = CenterGamePanel.imageProvider.getComPlayerShot(14);
			CenterGamePanel.frisbeeImage=null;
			comPlayerAbility = false;
			disc.setPositionCom(comPlayer.getX(), comPlayer.getY());
			IaComPlayer.shoot();
		}
	}
	
	public static void stopTime(){
		stoppedTime=getTime();
	}
	
	public static void restartTime(){
		startTime = (System.currentTimeMillis())/1000;
		endTime -= stoppedTime;
	}


	public static int getTime()
	{
		currentTime = (System.currentTimeMillis())/1000;
		return (int) (currentTime-startTime);
	}


	public static long getEndTime() {
		return endTime;
	}

	public static boolean isComPlayerAbility() {
		return comPlayerAbility;
	}


	public static void setComPlayerAbility(boolean comPlayerAbilityNew) {
		comPlayerAbility = comPlayerAbilityNew;
	}


	public static boolean isStop() {
		return stop;
	}


	public static void setStop(boolean stopNew) {
		stop = stopNew;
	}


	public void restartRound() {
		startTime = (System.currentTimeMillis())/1000;
		endTime=30;
	}

	public static int getDifficultyLevel() {
		return difficultyLevel;
	}

	public static void setDifficultyLevel(int difficultyLevel) {
		GameManager.difficultyLevel = difficultyLevel;
	}

	public static boolean isEqualize() {
		return equalize;
	}

	public static void setEqualize(boolean equalize) {
		GameManager.equalize = equalize;
	}
}
