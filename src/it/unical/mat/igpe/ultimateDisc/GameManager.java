package it.unical.mat.igpe.ultimateDisc;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	private World world=null;
	private WorldManager worldManager = new WorldManager();
	private IaComPlayer iaComPlayer;
	private static boolean comPlayerAbility = false;
	
	static long startTime = 0;
	static long currentTime = 0;
	static long stoppedTime=0;
	static long endTime = 10;
	
	Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight();
	int dimensionOfDisc = (int)width/17;
	int radius = dimensionOfDisc/2;
	static boolean pause=false;
	
	static boolean stop=false;
		
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


	public World getWorld() {
		return world;
	}


	public void start()
	{
//		stabilire i parametri da inizializzare a disc, myplayer e complayer. (tramite la grafica ci regoliamo)
//		condidioni iniziali: disco in mano al myplayer
		this.myPlayer = new MyPlayer(0, 0, (int)(width/4)-146,(int)(height*0.75),0,(int)(height*0.18));
		this.comPlayer = new ComPlayer((int)(width*0.85), 400, (int)(width*0.69),(int)(height*0.75),0,(int)(height*0.18));
		this.disc = new Disc(((int)(width*0.4)+radius),((int)(height*0.7)-radius),(int)width-(int)(width*0.115),(int)(height*0.75),(int)(height*0.1));
		iaComPlayer = new IaComPlayer(this);
		// in loadWorld passo type=0 come se fosse il campo di tipo 0
		world = this.worldManager.loadWorld(disc, 0);
		this.startTime = (System.currentTimeMillis())/1000;
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
		if(pause==false){
			if(timeUp()) 
			{
				disc.reset();
				myPlayer.reset();
				comPlayer.reset();
				this.startTime=0;
			}
			else
			{
				if(!stop){
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
	

	public static synchronized boolean isPause() {
		return pause;
	}

	private void checkCollision() {
		if(disc.getBounds().intersects(myPlayer.getBounds())){
			disc.setPosition(myPlayer.getX(), myPlayer.getY());
		}
		else if(disc.getBounds().intersects(comPlayer.getBounds())){
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
		this.startTime = (System.currentTimeMillis())/1000;
		endTime=10;
	}
}
