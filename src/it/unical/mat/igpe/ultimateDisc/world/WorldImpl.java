package it.unical.mat.igpe.ultimateDisc.world;

import java.awt.Dimension;
import java.awt.Toolkit;

import it.unical.mat.igpe.graphics.CenterGamePanel;
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
	int roundMyPlayer;
	int roundComPlayer;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int dimensionOfDisc = (int)width/17;
	int radius = dimensionOfDisc/2;
	
	int currentPoints;
	
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
		this.roundMyPlayer=0;
		this.roundComPlayer=0;
		
		this.currentPoints=0;
	}
	

	
	
	public int getRoundMyPlayer() {
		return roundMyPlayer;
	}

	public void setRoundMyPlayer(int roundMyPlayer) {
		this.roundMyPlayer += roundMyPlayer;
	}

	public int getRoundComPlayer() {
		return roundComPlayer;
	}

	public void setRoundComPlayer(int roundComPlayer) {
		this.roundComPlayer += roundComPlayer;
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

	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}


	@Override
	public void update() {
		
		int y = disc.getY()+radius;
		int point=0;
		if (disc.isComplayer()==true)
		{
			point = this.wallCom.getValuePoint(y);
			this.currentPoints=point;
			this.comScore+=point;
			disc.setComplayer(false);
			CenterGamePanel.getRepainterThread().setComPlayerGoal(true);
			GameManager.setStop(true);
		}
		else if (disc.isMyplayer()==true)
		{
			point = this.wallMyPlayer.getValuePoint(y);
			this.currentPoints=point;
			GameManager.setComPlayerAbility(false);
			this.myPlayerScore+=point;
			disc.setMyplayer(false);
			CenterGamePanel.getRepainterThread().setMyPlayerGoal(true);
			GameManager.setStop(true);
		}
		
	}
	
}
