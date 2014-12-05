package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ImageProvider {

	private final Image myPlayerFront;
    private final Image myPlayerBack;
    private final Image myPlayerShot1;
    private final Image myPlayerShot2;
    private final ImageIcon one_point;
    private final ImageIcon two_point;
    private final Image frisbee;
    private final Image woodField;
    private final Image woodFieldNorth;
    private final Image woodFieldSouth;
    private final Image introBackground;
    private final Image playGame;
    private final Image playGameWhite;
    private final Image settings;
    private final Image settingsWhite;
    private final Image exit;
    private final Image exitWhite;
    
    private final Image start;
    private final Image startGame;
    private final Image ten;
    private final Image nine;
    private final Image eight;
    private final Image seven;
    private final Image six;
    private final Image five;
    private final Image four;
    private final Image three;
    private final Image two;
    private final Image one;
    private final Image zero;
    
    private final Image gameOver;

    public ImageProvider()
    {
    	  final Toolkit tk = Toolkit.getDefaultToolkit();
    	  myPlayerFront = tk.getImage("img/frontc.gif");
    	  myPlayerBack = tk.getImage("img/retroc.gif");
    	  one_point = new ImageIcon("img/1point.jpg");
    	  two_point = new ImageIcon("img/2points.jpg");
    	  frisbee = tk.getImage("img/frisbee.gif");
    	  woodField = tk.getImage("img/legno.jpg");
    	  woodFieldNorth = tk.getImage("img/nord.jpg");
    	  woodFieldSouth = tk.getImage("img/sud.jpg");
    	  introBackground = tk.getImage("img/introImage.png");
    	  playGame = tk.getImage("img/IntroPlay.png");
    	  playGameWhite = tk.getImage("img/IntroPlayWhite.png");
    	  settings = tk.getImage("img/IntroSettings2.png");
    	  settingsWhite = tk.getImage("img/IntroSettings1.png");
    	  exit = tk.getImage("img/IntroExit.png");
    	  exitWhite = tk.getImage("img/IntroExitWhite.png");
    	  
    	  start = tk.getImage("img/start.png");
    	  startGame = tk.getImage("img/start1.png");
    	  ten = tk.getImage("img/time/ten.png");
    	  nine = tk.getImage("img/time/nine.png");
    	  eight = tk.getImage("img/time/eight.png");
    	  seven = tk.getImage("img/time/seven.png");
    	  six = tk.getImage("img/time/six.png");
    	  five = tk.getImage("img/time/five.png");
    	  four = tk.getImage("img/time/four.png");
    	  three = tk.getImage("img/time/three.png");
    	  two = tk.getImage("img/time/two.png");
    	  one = tk.getImage("img/time/one.png");
    	  zero = tk.getImage("img/time/zero.png");
    	  
    	  gameOver = tk.getImage("img/gameOver.png");
    	  
    	  myPlayerShot1 = tk.getImage("img/cat1.png");
    	  myPlayerShot2 = tk.getImage("img/cat2.png");
    }

    public Image getMyPlayerDirection(final int direction)
    {
        switch (direction)
        {
            case Player.LEFT:
                return myPlayerBack;
            case Player.RIGHT:
                return myPlayerFront;
            case 10:
                return myPlayerShot1;
            case 11:
                return myPlayerShot2;
        }
        return myPlayerFront;
    }
    
	public Image getMyPlayerFront() {
		return myPlayerFront;
	}

	public Image getMyPlayerBack() {
		return myPlayerBack;
	}

	public ImageIcon getOne_point() {
		return one_point;
	}

	public ImageIcon getTwo_point() {
		return two_point;
	}

	public Image getFrisbee() {
		return frisbee;
	}

	public Image getWoodField() {
		return woodField;
	}

	public Image getWoodFieldNorth() {
		return woodFieldNorth;
	}

	public Image getWoodFieldSouth() {
		return woodFieldSouth;
	}

	public Image getIntroBackground() {
		return introBackground;
	}

	public Image getPlayGame() {
		return playGame;
	}

	public Image getSettings() {
		return settings;
	}

	public Image getExit() {
		return exit;
	}

	public Image getSettingsWhite() {
		return settingsWhite;
	}

	public Image getPlayGameWhite() {
		return playGameWhite;
	}

	public Image getExitWhite() {
		return exitWhite;
	}
	
	public Image getStart() {
		return start;
	}
	
	public Image getStartGame() {
		return startGame;
	}
	
	public Image getGameOver() {
		return gameOver;
	}

	
	public Image getTime(int time) 
	{
			switch (time)
			{
			case 10:
				return ten;
			case 9:
				return nine;
			case 8:
				return eight;
			case 7:
				return seven;
			case 6:
				return six;
			case 5:
				return five;
			case 4:
				return four;
			case 3:
				return three;
			case 2:
				return two;
			case 1:
				return one;
			case 0:
				return zero;
			}
			return null;
	}
}
