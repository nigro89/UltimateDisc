package it.unical.mat.igpe.graphics;

public class ShotComPlayer extends Thread {

	public void run()
	{
		int count = 0;
		while(count < 4)
		{
			CenterGamePanel.comPlayerImage = CenterGamePanel.imageProvider.getComPlayerShot(count);
			count++;
			try {
				sleep(70);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		CenterGamePanel.comPlayerImage = CenterGamePanel.imageProvider.getComPlayerLeftMotionLess();
		CenterGamePanel.frisbeeImage=CenterGamePanel.imageProvider.getFrisbee();
	}
}
