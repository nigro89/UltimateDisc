package it.unical.mat.igpe.ultimateDisc.world;

import it.unical.mat.igpe.ultimateDisc.staticObject.Wall;

public interface World {
	
	public abstract int getMyPlayerScore();

	public abstract void setMyPlayerScore(int myPlayerScore);

	public abstract int getComScore();

	public abstract void setComScore(int comScore);

	public abstract Wall getWallMyPlayer();

	public abstract void setWallMyPlayer(Wall wallMyPlayer);

	public abstract Wall getWallCom();

	public abstract void setWallCom(Wall wallCom);

	public abstract double getX_limit_myPlayer();

	public abstract void setX_limit_myPlayer(double x_limit_myPlayer);

	public abstract double getX_limit_com();

	public abstract void setX_limit_com(double x_limit_com);
	
	 public abstract void update();
}
