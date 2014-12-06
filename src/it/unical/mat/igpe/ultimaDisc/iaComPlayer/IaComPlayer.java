package it.unical.mat.igpe.ultimaDisc.iaComPlayer;

import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.ComPlayer;

public class IaComPlayer {
	
	static GameManager gameManager;
	
	
	public IaComPlayer(GameManager gameManager){ //nel costruttore dovremmo passare anche la difficoltà
		this.gameManager=gameManager;
	}
	
	public void moveComPlayer() {
		
		if(gameManager.getDisc().getY() != gameManager.getComPlayer().getY()){
			if(gameManager.getDisc().getY()>gameManager.getComPlayer().getY()){
				gameManager.getComPlayer().setDirection(1);//down
			}
			else if(gameManager.getDisc().getY()<gameManager.getComPlayer().getY()){
				gameManager.getComPlayer().setDirection(0);//up
			}
			else
				gameManager.getComPlayer().setDirection(2);//left
		}
		
		gameManager.getComPlayer().update();
	}

	public static void shoot() {
		gameManager.getDisc().setPositionCom(gameManager.getComPlayer().getX()-(int)(ComPlayer.getWithimage()*0.5), gameManager.getComPlayer().getY());
		gameManager.getDisc().setDirection(-10, 5);
		gameManager.getDisc().setAvailableForComPlayer(false);
	}

}
