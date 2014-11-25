package it.unical.mat.igpe.ultimateDisc;

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
	
	long startTime = 0;
	long currentTime = 0;
	
	
		
	public MyPlayer getMyPlayer() {
		return myPlayer;
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
//		this.myPlayer = new MyPlayer(x, y, widthComponent, heightComponent, wallNorth, wallSouth);
//		this.comPlayer = new ComPlayer(x, y, widthComponent, heightComponent, wallNorth, wallSouth);
//		this.disc = new Disc(x, y, widthComponent, heightComponent, wall);
		
		// in loadWorld passo type=0 come se fosse il campo di tipo 0
		world = this.worldManager.loadWorld(disc, 0);
		 this.startTime = (System.currentTimeMillis())/1000;
	}

	public boolean timeUp()
	{
		currentTime = (System.currentTimeMillis())/1000;
		if ((currentTime-startTime)>=100)
			return true;
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
		if(timeUp())
		{
			disc.reset();
			myPlayer.reset();
			comPlayer.reset();
			this.startTime=0;
		}
		else
		{
			disc.update();
			myPlayer.update();
			comPlayer.update(); // da fare (ia comPlayer)
		}
		world.update();
	}


	public int getTime()
	{
		currentTime = (System.currentTimeMillis())/1000;
		return (int) (currentTime-startTime);
	}

}
