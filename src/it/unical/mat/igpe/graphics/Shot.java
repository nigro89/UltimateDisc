package it.unical.mat.igpe.graphics;

public class Shot extends Thread {

	public void run()
	{
		int count = 0;
		while(count < 15)
		{
			CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerShot(count);
			count++;
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		CenterGamePanel.myPlayerImage = CenterGamePanel.imageProvider.getMyPlayerMotionLess();
		CenterGamePanel.frisbeeImage = CenterGamePanel.imageProvider.getFrisbee();
	}
}
