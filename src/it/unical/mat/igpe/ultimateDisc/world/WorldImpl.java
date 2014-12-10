package it.unical.mat.igpe.ultimateDisc.world;

import java.awt.Dimension;
import java.awt.Toolkit;

import it.unical.mat.igpe.graphics.EastGamePanel;
import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.Disc;
import it.unical.mat.igpe.ultimateDisc.staticObject.Wall;

public class WorldImpl implements World {

	private Disc disc; 
	private Wall wallMyPlayer;
	private Wall wallCom;
	private double x_limit_myPlayer;
	private double x_limit_com;
	
	int myPlayerScore;
	int comScore;
	int strickenWallMyPlayer = 0;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int dimensionOfDisc = (int)width/17;
	int radius = dimensionOfDisc/2;
	
	public WorldImpl(Disc d,Wall wmp, Wall  wc)
	{
		this.disc=d;
		this.wallMyPlayer=wmp;
		this.wallCom=wc;
		this.x_limit_myPlayer=0;
		this.x_limit_com=0;
		
		// stabilire le x di default del muro (da grafica)
		this.myPlayerScore=0;
		this.comScore=0;
	}
	

	public int getMyPlayerScore() {
		return myPlayerScore;
	}


	public void setMyPlayerScore(int myPlayerScore) {
		this.myPlayerScore = myPlayerScore;
	}


	public int getComScore() {
		return comScore;
	}


	public void setComScore(int comScore) {
		this.comScore = comScore;
	}


	public Wall getWallMyPlayer() {
		return wallMyPlayer;
	}

	public void setWallMyPlayer(Wall wallMyPlayer) {
		this.wallMyPlayer = wallMyPlayer;
	}

	public Wall getWallCom() {
		return wallCom;
	}

	public void setWallCom(Wall wallCom) {
		this.wallCom = wallCom;
	}

	public double getX_limit_myPlayer() {
		return x_limit_myPlayer;
	}

	public void setX_limit_myPlayer(double x_limit_myPlayer) {
		this.x_limit_myPlayer = x_limit_myPlayer;
	}

	public double getX_limit_com() {
		return x_limit_com;
	}

	public void setX_limit_com(double x_limit_com) {
		this.x_limit_com = x_limit_com;
	}

	public int getStrickenWALL() {
		return strickenWallMyPlayer;
	}

	public void setStrickenWall(int strickenWall) {
		this.strickenWallMyPlayer = strickenWall;
	}


	@Override
	public void update() {
		
		int y = disc.getY()+radius;
		int point=0;
		if (disc.isComplayer()==true)
		{
			point = this.wallCom.getValuePoint(y);
			this.comScore+=point;
			disc.setComplayer(false);
//			System.out.println(point+" punto al com "+comScore);
		}
		else if (disc.isMyplayer()==true)
		{
			point = this.wallMyPlayer.getValuePoint(y);
			this.strickenWallMyPlayer = this.wallMyPlayer.getStrickenWall(y);
			EastGamePanel.getRepainterThread().setSW(strickenWallMyPlayer);
			System.out.println("SW: "+strickenWallMyPlayer);
			GameManager.setComPlayerAbility(false);
			this.myPlayerScore+=point;
			disc.setMyplayer(false);
//			System.out.println(point+" punto al my "+myPlayerScore);
		}
		
	}
	
}
