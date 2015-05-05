package it.unical.mat.igpe.graphics;


import java.util.Random;

import it.unical.mat.igpe.ultimateDisc.GameManager;


public class Frisbee extends Thread {

	GameManager gameManager;
	static int potenzaTiro;
	int absYdisc;
	int sleep;
	
	public Frisbee(GameManager gameManager)
	{
		this.gameManager=gameManager;
		potenzaTiro=CenterGamePanel.getxShoot();
		absYdisc=Math.abs(gameManager.getDisc().getY());
		sleep=absYdisc*potenzaTiro;
	}
	
	public void run()
	{
		while(!CenterGamePanel.repainterThread.end)
		{
			while(!GameManager.isPause() || !GameManager.isStop())
			{
				try {
					absYdisc=Math.abs(gameManager.getDisc().getY());
					potenzaTiro=CenterGamePanel.getxShoot();
					if(absYdisc==0) absYdisc=1;
					sleep=absYdisc*potenzaTiro;
					
					if(sleep>25)
						sleep(10 + new Random().nextInt(30));
					else
						sleep(absYdisc*potenzaTiro);
					System.out.println("--------------------------------");
					System.out.println("X:           "+gameManager.getDisc().getX());
					System.out.println("Y:           "+gameManager.getDisc().getY());
					System.out.println("absY:        "+absYdisc);
					System.out.println("potenzaTiro: "+potenzaTiro);
					System.out.println("sleep:       "+sleep);
					System.out.println("--------------------------------");
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				gameManager.getDisc().update();
			}
		}
	}

	public static void setPotenzaTiro(int potenzaTiroNew) {
		potenzaTiro = potenzaTiroNew;
	}
}
