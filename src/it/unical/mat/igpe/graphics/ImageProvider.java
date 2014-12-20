package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ImageProvider {

	static int numberOfSequence=0;

	private final Image[] myPlayerRight = new Image[15];
    private final Image[] myPlayerLeft = new Image[15];
    private final Image[] myPlayerUp = new Image[15];
    private final Image[] myPlayerDown = new Image[15];
	private final Image[] myPlayerUpRight = new Image[15];
	private final Image[] myPlayerUpLeft = new Image[15];
	private final Image[] myPlayerDownRight = new Image[15];
	private final Image[] myPlayerDownLeft = new Image[15];
    private final Image myPlayerMotionLess;
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
    private final Image gif;
    private final Image score;
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
    private final Image round1;
    private final Image round2;
    private final Image finalRound;
    private final Image pass;
    private final Image menuPause;
    
    private final Image gameOver;

    public ImageProvider()
    {
    	  final Toolkit tk = Toolkit.getDefaultToolkit();
    	  
    	  menuPause = tk.getImage("img/imageMenu.png");
    	  gif= tk.getImage("img/italiav1.gif");
    	  score = tk.getImage("img/score.jpg");
    	  round1 = tk.getImage("img/round1.png");
    	  round2 = tk.getImage("img/round2.png");
    	  finalRound = tk.getImage("img/finalRound.png");
    	  
    	  pass = tk.getImage("img/fail-pass.jpg");
    	  myPlayerMotionLess = tk.getImage("img/characterMotionLess/right.png");
    	  
    	  //right image
    	  myPlayerRight[0] = tk.getImage("img/characterMotion/right/right.png");
    	  myPlayerRight[1] = tk.getImage("img/characterMotion/right/right_02.png");
    	  myPlayerRight[2] = tk.getImage("img/characterMotion/right/right_03.png");
    	  myPlayerRight[3] = tk.getImage("img/characterMotion/right/right_04.png");
    	  myPlayerRight[4] = tk.getImage("img/characterMotion/right/right_05.png");
    	  myPlayerRight[5] = tk.getImage("img/characterMotion/right/right_06.png");
    	  myPlayerRight[6] = tk.getImage("img/characterMotion/right/right_07.png");
    	  myPlayerRight[7] = tk.getImage("img/characterMotion/right/right_08.png");
    	  myPlayerRight[8] = tk.getImage("img/characterMotion/right/right_09.png");
    	  myPlayerRight[9] = tk.getImage("img/characterMotion/right/right_10.png");
    	  myPlayerRight[10] = tk.getImage("img/characterMotion/right/right_11.png");
    	  myPlayerRight[11] = tk.getImage("img/characterMotion/right/right_12.png");
    	  myPlayerRight[12] = tk.getImage("img/characterMotion/right/right_13.png");
    	  myPlayerRight[13] = tk.getImage("img/characterMotion/right/right_14.png");
    	  myPlayerRight[14] = tk.getImage("img/characterMotion/right/right_15.png");
    	  
    	  //left image
    	  myPlayerLeft[0] = tk.getImage("img/characterMotion/left/left.png");
    	  myPlayerLeft[1] = tk.getImage("img/characterMotion/left/left_02.png");
    	  myPlayerLeft[2] = tk.getImage("img/characterMotion/left/left_03.png");
    	  myPlayerLeft[3] = tk.getImage("img/characterMotion/left/left_04.png");
    	  myPlayerLeft[4] = tk.getImage("img/characterMotion/left/left_05.png");
    	  myPlayerLeft[5] = tk.getImage("img/characterMotion/left/left_06.png");
    	  myPlayerLeft[6] = tk.getImage("img/characterMotion/left/left_07.png");
    	  myPlayerLeft[7] = tk.getImage("img/characterMotion/left/left_08.png");
    	  myPlayerLeft[8] = tk.getImage("img/characterMotion/left/left_09.png");
    	  myPlayerLeft[9] = tk.getImage("img/characterMotion/left/left_10.png");
    	  myPlayerLeft[10] = tk.getImage("img/characterMotion/left/left_11.png");
    	  myPlayerLeft[11] = tk.getImage("img/characterMotion/left/left_12.png");
    	  myPlayerLeft[12] = tk.getImage("img/characterMotion/left/left_13.png");
    	  myPlayerLeft[13] = tk.getImage("img/characterMotion/left/left_14.png");
    	  myPlayerLeft[14] = tk.getImage("img/characterMotion/left/left_15.png");
    	  
    	//Down image
    	  myPlayerDown[0] = tk.getImage("img/characterMotion/down/down.png");
    	  myPlayerDown[1] = tk.getImage("img/characterMotion/down/down_02.png");
    	  myPlayerDown[2] = tk.getImage("img/characterMotion/down/down_03.png");
    	  myPlayerDown[3] = tk.getImage("img/characterMotion/down/down_04.png");
    	  myPlayerDown[4] = tk.getImage("img/characterMotion/down/down_05.png");
    	  myPlayerDown[5] = tk.getImage("img/characterMotion/down/down_06.png");
    	  myPlayerDown[6] = tk.getImage("img/characterMotion/down/down_07.png");
    	  myPlayerDown[7] = tk.getImage("img/characterMotion/down/down_08.png");
    	  myPlayerDown[8] = tk.getImage("img/characterMotion/down/down_09.png");
    	  myPlayerDown[9] = tk.getImage("img/characterMotion/down/down_10.png");
    	  myPlayerDown[10] = tk.getImage("img/characterMotion/down/down_11.png");
    	  myPlayerDown[11] = tk.getImage("img/characterMotion/down/down_12.png");
    	  myPlayerDown[12] = tk.getImage("img/characterMotion/down/down_13.png");
    	  myPlayerDown[13] = tk.getImage("img/characterMotion/down/down_14.png");
    	  myPlayerDown[14] = tk.getImage("img/characterMotion/down/down_15.png");
    	  
    	//up image
    	  myPlayerUp[0] = tk.getImage("img/characterMotion/up/up.png");
    	  myPlayerUp[1] = tk.getImage("img/characterMotion/up/up_02.png");
    	  myPlayerUp[2] = tk.getImage("img/characterMotion/up/up_03.png");
    	  myPlayerUp[3] = tk.getImage("img/characterMotion/up/up_04.png");
    	  myPlayerUp[4] = tk.getImage("img/characterMotion/up/up_05.png");
    	  myPlayerUp[5] = tk.getImage("img/characterMotion/up/up_06.png");
    	  myPlayerUp[6] = tk.getImage("img/characterMotion/up/up_07.png");
    	  myPlayerUp[7] = tk.getImage("img/characterMotion/up/up_08.png");
    	  myPlayerUp[8] = tk.getImage("img/characterMotion/up/up_09.png");
    	  myPlayerUp[9] = tk.getImage("img/characterMotion/up/up_10.png");
    	  myPlayerUp[10] = tk.getImage("img/characterMotion/up/up_11.png");
    	  myPlayerUp[11] = tk.getImage("img/characterMotion/up/up_12.png");
    	  myPlayerUp[12] = tk.getImage("img/characterMotion/up/up_13.png");
    	  myPlayerUp[13] = tk.getImage("img/characterMotion/up/up_14.png");
    	  myPlayerUp[14] = tk.getImage("img/characterMotion/up/up_15.png");
    	  
    	//downRight image
    	  myPlayerDownRight[0] = tk.getImage("img/characterMotion/downRight/downRight.png");
    	  myPlayerDownRight[1] = tk.getImage("img/characterMotion/downRight/downRight_02.png");
    	  myPlayerDownRight[2] = tk.getImage("img/characterMotion/downRight/downRight_03.png");
    	  myPlayerDownRight[3] = tk.getImage("img/characterMotion/downRight/downRight_04.png");
    	  myPlayerDownRight[4] = tk.getImage("img/characterMotion/downRight/downRight_05.png");
    	  myPlayerDownRight[5] = tk.getImage("img/characterMotion/downRight/downRight_06.png");
    	  myPlayerDownRight[6] = tk.getImage("img/characterMotion/downRight/downRight_07.png");
    	  myPlayerDownRight[7] = tk.getImage("img/characterMotion/downRight/downRight_08.png");
    	  myPlayerDownRight[8] = tk.getImage("img/characterMotion/downRight/downRight_09.png");
    	  myPlayerDownRight[9] = tk.getImage("img/characterMotion/downRight/downRight_10.png");
    	  myPlayerDownRight[10] = tk.getImage("img/characterMotion/downRight/downRight_11.png");
    	  myPlayerDownRight[11] = tk.getImage("img/characterMotion/downRight/downRight_12.png");
    	  myPlayerDownRight[12] = tk.getImage("img/characterMotion/downRight/downRight_13.png");
    	  myPlayerDownRight[13] = tk.getImage("img/characterMotion/downRight/downRight_14.png");
    	  myPlayerDownRight[14] = tk.getImage("img/characterMotion/downRight/downRight_15.png");
    	  
    	//downLeft image
    	  myPlayerDownLeft[0] = tk.getImage("img/characterMotion/downLeft/downLeft.png");
    	  myPlayerDownLeft[1] = tk.getImage("img/characterMotion/downLeft/downLeft_02.png");
    	  myPlayerDownLeft[2] = tk.getImage("img/characterMotion/downLeft/downLeft_03.png");
    	  myPlayerDownLeft[3] = tk.getImage("img/characterMotion/downLeft/downLeft_04.png");
    	  myPlayerDownLeft[4] = tk.getImage("img/characterMotion/downLeft/downLeft_05.png");
    	  myPlayerDownLeft[5] = tk.getImage("img/characterMotion/downLeft/downLeft_06.png");
    	  myPlayerDownLeft[6] = tk.getImage("img/characterMotion/downLeft/downLeft_07.png");
    	  myPlayerDownLeft[7] = tk.getImage("img/characterMotion/downLeft/downLeft_08.png");
    	  myPlayerDownLeft[8] = tk.getImage("img/characterMotion/downLeft/downLeft_09.png");
    	  myPlayerDownLeft[9] = tk.getImage("img/characterMotion/downLeft/downLeft_10.png");
    	  myPlayerDownLeft[10] = tk.getImage("img/characterMotion/downLeft/downLeft_11.png");
    	  myPlayerDownLeft[11] = tk.getImage("img/characterMotion/downLeft/downLeft_12.png");
    	  myPlayerDownLeft[12] = tk.getImage("img/characterMotion/downLeft/downLeft_13.png");
    	  myPlayerDownLeft[13] = tk.getImage("img/characterMotion/downLeft/downLeft_14.png");
    	  myPlayerDownLeft[14] = tk.getImage("img/characterMotion/downLeft/downLeft_15.png");
    	  
    	//upRight image
//    	  myPlayerUpRight[0] = tk.getImage("img/characterMotion/upRight/upRight.png");
//    	  myPlayerUpRight[1] = tk.getImage("img/characterMotion/upRight/upRight_02.png");
//    	  myPlayerUpRight[2] = tk.getImage("img/characterMotion/upRight/upRight_03.png");
//    	  myPlayerUpRight[3] = tk.getImage("img/characterMotion/upRight/upRight_04.png");
//    	  myPlayerUpRight[4] = tk.getImage("img/characterMotion/upRight/upRight_05.png");
//    	  myPlayerUpRight[5] = tk.getImage("img/characterMotion/upRight/upRight_06.png");
//    	  myPlayerUpRight[6] = tk.getImage("img/characterMotion/upRight/upRight_07.png");
//    	  myPlayerUpRight[7] = tk.getImage("img/characterMotion/upRight/upRight_08.png");
//    	  myPlayerUpRight[8] = tk.getImage("img/characterMotion/upRight/upRight_09.png");
//    	  myPlayerUpRight[9] = tk.getImage("img/characterMotion/upRight/upRight_10.png");
//    	  myPlayerUpRight[10] = tk.getImage("img/characterMotion/upRight/upRight_11.png");
//    	  myPlayerUpRight[11] = tk.getImage("img/characterMotion/upRight/upRight_12.png");
//    	  myPlayerUpRight[12] = tk.getImage("img/characterMotion/upRight/upRight_13.png");
//    	  myPlayerUpRight[13] = tk.getImage("img/characterMotion/upRight/upRight_14.png");
//    	  myPlayerUpRight[14] = tk.getImage("img/characterMotion/upRight/upRight_15.png");
    	  
    	//upLeft image
    	  myPlayerUpLeft[0] = tk.getImage("img/characterMotion/upLeft/upLeft.png");
    	  myPlayerUpLeft[1] = tk.getImage("img/characterMotion/upLeft/upLeft_02.png");
    	  myPlayerUpLeft[2] = tk.getImage("img/characterMotion/upLeft/upLeft_03.png");
    	  myPlayerUpLeft[3] = tk.getImage("img/characterMotion/upLeft/upLeft_04.png");
    	  myPlayerUpLeft[4] = tk.getImage("img/characterMotion/upLeft/upLeft_05.png");
    	  myPlayerUpLeft[5] = tk.getImage("img/characterMotion/upLeft/upLeft_06.png");
    	  myPlayerUpLeft[6] = tk.getImage("img/characterMotion/upLeft/upLeft_07.png");
    	  myPlayerUpLeft[7] = tk.getImage("img/characterMotion/upLeft/upLeft_08.png");
    	  myPlayerUpLeft[8] = tk.getImage("img/characterMotion/upLeft/upLeft_09.png");
    	  myPlayerUpLeft[9] = tk.getImage("img/characterMotion/upLeft/upLeft_10.png");
    	  myPlayerUpLeft[10] = tk.getImage("img/characterMotion/upLeft/upLeft_11.png");
    	  myPlayerUpLeft[11] = tk.getImage("img/characterMotion/upLeft/upLeft_12.png");
    	  myPlayerUpLeft[12] = tk.getImage("img/characterMotion/upLeft/upLeft_13.png");
    	  myPlayerUpLeft[13] = tk.getImage("img/characterMotion/upLeft/upLeft_14.png");
    	  myPlayerUpLeft[14] = tk.getImage("img/characterMotion/upLeft/upLeft_15.png");
    	  
    	  
    	  
    	  
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

	public Image getRound() {
		return round1;
	}
	
	public Image getMyPlayerMotionLess() {
		return myPlayerMotionLess;
	}
	
	public Image getPass() {
		return pass;
	}
	
	public Image getRound(int round)
    {
        switch (round)
        {
            case 0:
                return round1;
            case 1:
                return round2;
            case 2:
                return finalRound;
        }
        return round1;
    }

	public Image getMyPlayerDirection(final int direction)
    {
		numberOfSequence++;
		if(numberOfSequence>=15)
    		numberOfSequence=0;
			
        switch (direction)
        {
            case Player.LEFT:
                return myPlayerLeft[numberOfSequence];
                
            case Player.RIGHT:
                return myPlayerRight[numberOfSequence];
                
            case Player.UP:
                return myPlayerUp[numberOfSequence];
                
            case Player.DOWN:
                return myPlayerDown[numberOfSequence];
                
            case Player.UPRIGHT:
                return myPlayerUpRight[numberOfSequence];
                
            case Player.UPLEFT:
                return myPlayerUpLeft[numberOfSequence];
                
            case Player.DOWNRIGHT:
                return myPlayerDownRight[numberOfSequence];
                
            case Player.DOWNLEFT:
                return myPlayerDownLeft[numberOfSequence];
                
            case 10:
                return myPlayerShot1;
            case 11:
                return myPlayerShot2;
        }
        return myPlayerRight[0];
    }
    
	public ImageIcon getOne_point() {
		return one_point;
	}

	public ImageIcon getTwo_point() {
		return two_point;
	}
	public Image getGif() {
		return gif;
	}

	public Image getFrisbee() {
		return frisbee;
	}
	
	public Image getScore() {
		return score;
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

	
	public Image getTime(long l) 
	{
			switch ((int)l)
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
	
	public Image getMenuPause() {
		return menuPause;
	}

	public Image getRound2() {
		return round2;
	}

	public Image getFinalRound() {
		return finalRound;
	}
}
