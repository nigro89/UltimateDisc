package it.unical.mat.igpe.ultimateDisc.world;

import it.unical.mat.igpe.ultimateDisc.movingObject.MovingObject;
import it.unical.mat.igpe.ultimateDisc.staticObject.Wall;

public class WorldImpl implements World {

	private MovingObject disc; 
	private Wall wallMyPlayer;
	private Wall wallCom;
	private double x_limit_myPlayer;
	private double x_limit_com;
	
	int myPlayerScore;
	int comScore;
	
	public WorldImpl(MovingObject d,Wall wmp, Wall  wc)
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


	@Override
	public void update() {
		
		int x = disc.getX();
		int y = disc.getY();
		int point=0;
		
		if (x >= this.x_limit_com)
		{
			point = this.wallCom.getValuePoint(y);
			this.comScore+=point;
		}
		else if (x <= this.x_limit_myPlayer)
		{
			point = this.wallMyPlayer.getValuePoint(y);
			this.myPlayerScore+=point;
		}
		
	}

	
}
