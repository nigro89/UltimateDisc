package it.unical.mat.igpe.graphics;

import java.util.Random;

import it.unical.mat.igpe.ultimateDisc.GameManager;


public class Frisbee extends Thread {

	GameManager gameManager;
	static int potenzaTiro;
	
	public Frisbee(GameManager gameManager)
	{
		this.gameManager=gameManager;
		potenzaTiro=10;
	}
	
	public void run()
	{
		while(!CenterGamePanel.repainterThread.end)
		{
			try {
//				sleep(40 + new Random().nextInt(10));
				sleep(40-potenzaTiro);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!GameManager.isPause() || !GameManager.isStop())
			{
				gameManager.getDisc().update();
			}
		}
	}

	public static void setPotenzaTiro(int potenzaTiroNew) {
		potenzaTiro = potenzaTiroNew;
	}
}
