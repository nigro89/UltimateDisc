package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ImageProvider {

	// number of sequence to move player
	static int numberOfSequence=0;
	
	// player
	// array Image of Player's moviments 
	private final Image[] playerRight = new Image[4];
	private final Image[] playerLeft = new Image[4];
	private final Image[] playerUp = new Image[4];
    private final Image[] playerDown = new Image[4];
	private final Image[] playerUpRight = new Image[4];
	private final Image[] playerUpLeft = new Image[4];
	private final Image[] playerDownRight = new Image[4];
	private final Image[] playerDownLeft = new Image[4];
	private final Image[] playerShot = new Image[4];
	
	private final Image playerRightMotionLess;
	private final Image playerLeftMotionLess;
	
	// world
    private final ImageIcon one_pointMyPlayer;
    private final ImageIcon two_pointMyPlayer;
    private final ImageIcon one_pointComPlayer;
    private final ImageIcon two_pointComPlayer;
    private final Image frisbee;
    private final Image woodField;
    private final Image woodFieldNorth;
    private final Image woodFieldSouth;
    private final Image threeWallPoints;
    private final Image fiveWallPoints;
    private final Image woodBoard;
    private final Image woodBoardCom;

    // menu panel
    private final Image introBackground;
    private final Image playGame;
    private final Image playGameWhite;
    private final Image settings;
    private final Image settingsWhite;
    private final Image exit;
    private final Image exitWhite;
    
    // time score Image
    private final Image thirty;
    private final Image twentyNine;
    private final Image twentyEight;
    private final Image twentySeven;
    private final Image twentySix;
    private final Image twentyFive;
    private final Image twentyFour;
	private final Image twentyThree;
    private final Image twentyTwo;
    private final Image twentyOne;
    private final Image twenty;
    private final Image nineteen;
    private final Image eighteen;
    private final Image seventeen;
    private final Image sixteen;
    private final Image fifteen;
    private final Image fourteen;
    private final Image thirteen;
	private final Image twelve;
    private final Image eleven;
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
    
    // number score Image
    private final Image thirtyScore;
    private final Image twentyNineScore;
    private final Image twentyEightScore;
    private final Image twentySevenScore;
    private final Image twentySixScore;
    private final Image twentyFiveScore;
    private final Image twentyFourScore;
	private final Image twentyThreeScore;
    private final Image twentyTwoScore;
    private final Image twentyOneScore;
    private final Image twentyScore;
    private final Image nineteenScore;
    private final Image eighteenScore;
    private final Image seventeenScore;
    private final Image sixteenScore;
    private final Image fifteenScore;
    private final Image fourteenScore;
    private final Image thirteenScore;
	private final Image twelveScore;
    private final Image elevenScore;
    private final Image tenScore;
    private final Image nineScore;
    private final Image eightScore;
    private final Image sevenScore;
    private final Image sixScore;
    private final Image fiveScore;
    private final Image fourScore;
    private final Image threeScore;
    private final Image twoScore;
	private final Image oneScore;
    private final Image zeroScore;
    
    // points score
    private final Image thirtyPoints;
    private final Image twentyNinePoints;
    private final Image twentyEightPoints;
    private final Image twentySevenPoints;
    private final Image twentySixPoints;
    private final Image twentyFivePoints;
    private final Image twentyFourPoints;
	private final Image twentyThreePoints;
    private final Image twentyTwoPoints;
    private final Image twentyOnePoints;
    private final Image twentyPoints;
    private final Image nineteenPoints;
    private final Image eighteenPoints;
    private final Image seventeenPoints;
    private final Image sixteenPoints;
    private final Image fifteenPoints;
    private final Image fourteenPoints;
    private final Image thirteenPoints;
	private final Image twelvePoints;
    private final Image elevenPoints;
    private final Image tenPoints;
    private final Image ninePoints;
    private final Image eightPoints;
    private final Image sevenPoints;
    private final Image sixPoints;
    private final Image fivePoints;
    private final Image fourPoints;
    private final Image threePoints;
    private final Image twoPoints;
	private final Image onePoint;
    private final Image zeroPoints;
    
    // round
    private final Image round1;
    private final Image round2;
    private final Image finalRound;
    private final Image roundResume;
    private final Image score;
    private final Image scoreRound0;
    private final Image scoreRound1;
    private final Image scoreRound2;
    private final Image scoreRound3;
    private final Image scoreRound4;
    private final Image scoreRound5;
    private final Image scoreRound6;
    private final Image scoreRound7;
    
    //pause
    private final Image menuPause;
    
    //game over
    private final Image gameOver;

    // various
    private final Image start;
    private final Image startGame;
    private final Image scoreTime;
    private final Image roundTarget;
    private final Image frisbeeRound;
    private final Image frisbeeRound2;

    public ImageProvider()
    {
    	  final Toolkit tk = Toolkit.getDefaultToolkit();
    	  
    	  // pause
    	  menuPause = tk.getImage("img/imageMenu.png");
    	  
    	  // world
    	  threeWallPoints= tk.getImage("img/points/3points.gif");
    	  fiveWallPoints= tk.getImage("img/points/5points.gif");
    	  one_pointMyPlayer = new ImageIcon("img/1point.png");
    	  two_pointMyPlayer = new ImageIcon("img/2points.png");
    	  one_pointComPlayer = new ImageIcon("img/1pointCom.png");
    	  two_pointComPlayer = new ImageIcon("img/2pointsCom.png");
    	  frisbee = tk.getImage("img/frisbee.png");
    	  woodField = tk.getImage("img/legno.png");
    	  woodFieldNorth = tk.getImage("img/nord.jpg");
    	  woodFieldSouth = tk.getImage("img/sud.jpg");
    	  woodBoard = tk.getImage("img/bordoLegno.png");
    	  woodBoardCom = tk.getImage("img/bordoLegnoCom.png");
    	  
    	  // round
    	  score = tk.getImage("img/score.png");
    	  round1 = tk.getImage("img/round1.gif");
    	  round2 = tk.getImage("img/round2.gif");
    	  finalRound = tk.getImage("img/finalRound.gif");
    	  roundResume = tk.getImage("img/scoreRound.png");
    	  scoreRound0 = tk.getImage("img/scoreRound/scoreRound0.png");
    	  scoreRound1 = tk.getImage("img/scoreRound/scoreRound1.png");;
    	  scoreRound2 = tk.getImage("img/scoreRound/scoreRound2.png");;
    	  scoreRound3 = tk.getImage("img/scoreRound/scoreRound3.png");;
    	  scoreRound4 = tk.getImage("img/scoreRound/scoreRound4.png");;
    	  scoreRound5 = tk.getImage("img/scoreRound/scoreRound5.png");;
    	  scoreRound6 = tk.getImage("img/scoreRound/scoreRound6.png");;
    	  scoreRound7 = tk.getImage("img/scoreRound/scoreRound7.png");;
    	 
    	  // player
    	  playerRightMotionLess = tk.getImage("img/players/P1/right.png");
    	  playerLeftMotionLess = tk.getImage("img/players/P1/left.png");
    	  
    	  //right image
    	  playerRight[0] = tk.getImage("img/players/P1/right/right.png");
    	  playerRight[1] = tk.getImage("img/players/P1/right/right_05.png");
    	  playerRight[2] = tk.getImage("img/players/P1/right/right_09.png");
    	  playerRight[3] = tk.getImage("img/players/P1/right/right_13.png");
    	  
    	  //left image
    	  playerLeft[0] = tk.getImage("img/players/P1/left/left.png");
    	  playerLeft[1] = tk.getImage("img/players/P1/left/left_05.png");
    	  playerLeft[2] = tk.getImage("img/players/P1/left/left_09.png");
    	  playerLeft[3] = tk.getImage("img/players/P1/left/left_13.png");
    	  
    	//Down image
    	  playerDown[0] = tk.getImage("img/players/P1/down/down.png");
    	  playerDown[1] = tk.getImage("img/players/P1/down/down_05.png");
    	  playerDown[2] = tk.getImage("img/players/P1/down/down_09.png");
    	  playerDown[3] = tk.getImage("img/players/P1/down/down_13.png");
    	  
    	//up image
    	  playerUp[0] = tk.getImage("img/players/P1/up/up.png");
    	  playerUp[1] = tk.getImage("img/players/P1/up/up_05.png");
    	  playerUp[2] = tk.getImage("img/players/P1/up/up_09.png");
    	  playerUp[3] = tk.getImage("img/players/P1/up/up_13.png");
    	  
    	//downRight image
    	  playerDownRight[0] = tk.getImage("img/players/P1/downRight/downRight.png");
    	  playerDownRight[1] = tk.getImage("img/players/P1/downRight/downRight_05.png");
    	  playerDownRight[2] = tk.getImage("img/players/P1/downRight/downRight_09.png");
    	  playerDownRight[3] = tk.getImage("img/players/P1/downRight/downRight_13.png");
    	  
    	//downLeft image
    	  playerDownLeft[0] = tk.getImage("img/players/P1/downLeft/downLeft.png");
    	  playerDownLeft[1] = tk.getImage("img/players/P1/downLeft/downLeft_05.png");
    	  playerDownLeft[2] = tk.getImage("img/players/P1/downLeft/downLeft_09.png");
    	  playerDownLeft[3] = tk.getImage("img/players/P1/downLeft/downLeft_13.png");
    	  
    	//upRight image
    	  playerUpRight[0] = tk.getImage("img/players/P1/upRight/upRight.png");
    	  playerUpRight[1] = tk.getImage("img/players/P1/upRight/upRight_05.png");
    	  playerUpRight[2] = tk.getImage("img/players/P1/upRight/upRight_09.png");
    	  playerUpRight[3] = tk.getImage("img/players/P1/upRight/upRight_13.png");
    	  
    	//upLeft image
    	  playerUpLeft[0] = tk.getImage("img/players/P1/upLeft/upLeft.png");
    	  playerUpLeft[1] = tk.getImage("img/players/P1/upLeft/upLeft_05.png");
    	  playerUpLeft[2] = tk.getImage("img/players/P1/upLeft/upLeft_09.png");
    	  playerUpLeft[3] = tk.getImage("img/players/P1/upLeft/upLeft_13.png");
    	  
      	//shot image
    	  playerShot[0] = tk.getImage("img/players/P1/shot/shot_0001.png");
    	  playerShot[1] = tk.getImage("img/players/P1/shot/shot_0009.png");
    	  playerShot[2] = tk.getImage("img/players/P1/shot/shot_0017.png");
    	  playerShot[3] = tk.getImage("img/players/P1/shot/shot_0025.png");
    	  
    	  // menu panel
    	  introBackground = tk.getImage("img/introImage.png");
    	  playGame = tk.getImage("img/IntroPlay.png");
    	  playGameWhite = tk.getImage("img/IntroPlayWhite.png");
    	  settings = tk.getImage("img/IntroSettings2.png");
    	  settingsWhite = tk.getImage("img/IntroSettings1.png");
    	  exit = tk.getImage("img/IntroExit.png");
    	  exitWhite = tk.getImage("img/IntroExitWhite.png");
    	  
    	  // various
    	  start = tk.getImage("img/start.png");
    	  startGame = tk.getImage("img/start1.png");
    	  scoreTime = tk.getImage("img/scoreTime.png");
    	  roundTarget = tk.getImage("img/targaRound.png");
    	  frisbeeRound = tk.getImage("img/frisbeeRound.png");
    	  frisbeeRound2 = tk.getImage("img/frisbeeRound2.png");
    	  
    	  // time score
    	  thirty = tk.getImage("img/timeScore/30.png");
    	  twentyNine = tk.getImage("img/timeScore/29.png");
    	  twentyEight = tk.getImage("img/timeScore/28.png");
    	  twentySeven = tk.getImage("img/timeScore/27.png");
    	  twentySix = tk.getImage("img/timeScore/26.png");
    	  twentyFive = tk.getImage("img/timeScore/25.png");
    	  twentyFour = tk.getImage("img/timeScore/24.png");
    	  twentyThree = tk.getImage("img/timeScore/23.png");
    	  twentyTwo = tk.getImage("img/timeScore/22.png");
    	  twentyOne = tk.getImage("img/timeScore/21.png");
    	  twenty = tk.getImage("img/timeScore/20.png");
    	  nineteen = tk.getImage("img/timeScore/19.png");
    	  eighteen = tk.getImage("img/timeScore/18.png");
    	  seventeen = tk.getImage("img/timeScore/17.png");
    	  sixteen = tk.getImage("img/timeScore/16.png");
    	  fifteen = tk.getImage("img/timeScore/15.png");
    	  fourteen = tk.getImage("img/timeScore/14.png");
    	  thirteen = tk.getImage("img/timeScore/13.png");
    	  twelve = tk.getImage("img/timeScore/12.png");
    	  eleven = tk.getImage("img/timeScore/11.png");
     	  ten = tk.getImage("img/timeScore/10.png");
    	  nine = tk.getImage("img/timeScore/9.png");
    	  eight = tk.getImage("img/timeScore/8.png");
    	  seven = tk.getImage("img/timeScore/7.png");
    	  six = tk.getImage("img/timeScore/6.png");
    	  five = tk.getImage("img/timeScore/5.png");
    	  four = tk.getImage("img/timeScore/4.png");
    	  three = tk.getImage("img/timeScore/3.png");
    	  two = tk.getImage("img/timeScore/2.png");
    	  one = tk.getImage("img/timeScore/1.png");
    	  zero = tk.getImage("img/timeScore/0.png");
    	  
    	  // number score
    	  thirtyScore = tk.getImage("img/numberScore/30.png");
    	  twentyNineScore = tk.getImage("img/numberScore/29.png");
    	  twentyEightScore = tk.getImage("img/numberScore/28.png");
    	  twentySevenScore = tk.getImage("img/numberScore/27.png");
    	  twentySixScore = tk.getImage("img/numberScore/26.png");
    	  twentyFiveScore = tk.getImage("img/numberScore/25.png");
    	  twentyFourScore = tk.getImage("img/numberScore/24.png");
    	  twentyThreeScore = tk.getImage("img/numberScore/23.png");
    	  twentyTwoScore = tk.getImage("img/numberScore/22.png");
    	  twentyOneScore = tk.getImage("img/numberScore/21.png");
    	  twentyScore = tk.getImage("img/numberScore/20.png");
    	  nineteenScore = tk.getImage("img/numberScore/19.png");
    	  eighteenScore = tk.getImage("img/numberScore/18.png");
    	  seventeenScore = tk.getImage("img/numberScore/17.png");
    	  sixteenScore = tk.getImage("img/numberScore/16.png");
    	  fifteenScore = tk.getImage("img/numberScore/15.png");
    	  fourteenScore = tk.getImage("img/numberScore/14.png");
    	  thirteenScore = tk.getImage("img/numberScore/13.png");
    	  twelveScore = tk.getImage("img/numberScore/12.png");
    	  elevenScore = tk.getImage("img/numberScore/11.png");
     	  tenScore = tk.getImage("img/numberScore/10.png");
    	  nineScore = tk.getImage("img/numberScore/9.png");
    	  eightScore = tk.getImage("img/numberScore/8.png");
    	  sevenScore = tk.getImage("img/numberScore/7.png");
    	  sixScore = tk.getImage("img/numberScore/6.png");
    	  fiveScore = tk.getImage("img/numberScore/5.png");
    	  fourScore = tk.getImage("img/numberScore/4.png");
    	  threeScore = tk.getImage("img/numberScore/3.png");
    	  twoScore = tk.getImage("img/numberScore/2.png");
    	  oneScore = tk.getImage("img/numberScore/1.png");
    	  zeroScore = tk.getImage("img/numberScore/0.png");
    	  
    	  // points score
    	  thirtyPoints = tk.getImage("img/pointsScore/30.png");
    	  twentyNinePoints = tk.getImage("img/pointsScore/29.png");
    	  twentyEightPoints = tk.getImage("img/pointsScore/28.png");
    	  twentySevenPoints = tk.getImage("img/pointsScore/27.png");
    	  twentySixPoints = tk.getImage("img/pointsScore/26.png");
    	  twentyFivePoints = tk.getImage("img/pointsScore/25.png");
    	  twentyFourPoints = tk.getImage("img/pointsScore/24.png");
    	  twentyThreePoints = tk.getImage("img/pointsScore/23.png");
    	  twentyTwoPoints = tk.getImage("img/pointsScore/22.png");
    	  twentyOnePoints = tk.getImage("img/pointsScore/21.png");
    	  twentyPoints = tk.getImage("img/pointsScore/20.png");
    	  nineteenPoints = tk.getImage("img/pointsScore/19.png");
    	  eighteenPoints = tk.getImage("img/pointsScore/18.png");
    	  seventeenPoints = tk.getImage("img/pointsScore/17.png");
    	  sixteenPoints = tk.getImage("img/pointsScore/16.png");
    	  fifteenPoints = tk.getImage("img/pointsScore/15.png");
    	  fourteenPoints = tk.getImage("img/pointsScore/14.png");
    	  thirteenPoints = tk.getImage("img/pointsScore/13.png");
    	  twelvePoints = tk.getImage("img/pointsScore/12.png");
    	  elevenPoints = tk.getImage("img/pointsScore/11.png");
     	  tenPoints = tk.getImage("img/pointsScore/10.png");
    	  ninePoints = tk.getImage("img/pointsScore/9.png");
    	  eightPoints = tk.getImage("img/pointsScore/8.png");
    	  sevenPoints = tk.getImage("img/pointsScore/7.png");
    	  sixPoints = tk.getImage("img/pointsScore/6.png");
    	  fivePoints = tk.getImage("img/pointsScore/5.png");
    	  fourPoints = tk.getImage("img/pointsScore/4.png");
    	  threePoints = tk.getImage("img/pointsScore/3.png");
    	  twoPoints = tk.getImage("img/pointsScore/2.png");
    	  onePoint = tk.getImage("img/pointsScore/1.png");
    	  zeroPoints = tk.getImage("img/pointsScore/0.png");
    	  
    	  // game over
    	  gameOver = tk.getImage("img/gameOver.png");
    	  
    }

	public Image getRound() {
		return round1;
	}
	
	public Image getMyPlayerMotionLess() {
		return playerRightMotionLess;
	}
	
	public Image getPass() {
		return roundResume;
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
		if(numberOfSequence>=4)
			numberOfSequence=0;
		
    switch (direction)
    {
        case Player.LEFT:
            return playerLeft[numberOfSequence];
            
        case Player.RIGHT:
            return playerRight[numberOfSequence];
            
        case Player.UP:
            return playerUp[numberOfSequence];
            
        case Player.DOWN:
            return playerDown[numberOfSequence];
            
        case Player.UPRIGHT:
            return playerUpRight[numberOfSequence];
            
        case Player.UPLEFT:
            return playerUpLeft[numberOfSequence];
            
        case Player.DOWNRIGHT:
            return playerDownRight[numberOfSequence];
            
        case Player.DOWNLEFT:
            return playerDownLeft[numberOfSequence];
            
        case 10:
            return playerShot[numberOfSequence];
    }
    return playerRight[0];
}
	
	public Image getPoints(int points)
	{
		 switch (points)
		 {
		   case 3:	return threeWallPoints;
		   case 5:	return fiveWallPoints;
		 }
		return null;
	}
    
	public ImageIcon getOne_point() {
		return one_pointMyPlayer;
	}

	public ImageIcon getTwo_point() {
		return two_pointMyPlayer;
	}
	public Image getGif() {
		return threeWallPoints;
	}

	public Image getFrisbee() {
		return frisbee;
	}
	
	public Image getScoreTime() {
		return scoreTime;
	}
	
	public Image getFivePoints() {
		return fiveWallPoints;
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
			case 30:
				return thirty;
			case 29:
				return twentyNine;
			case 28:
				return twentyEight;
			case 27:
				return twentySeven;
			case 26:
				return twentySix;
			case 25:
				return twentyFive;
			case 24:
				return twentyFour;
			case 23:
				return twentyThree;
			case 22:
				return twentyTwo;
			case 21:
				return twentyOne;
			case 20:
				return twenty;
			case 19:
				return nineteen;
			case 18:
				return eighteen;
			case 17:
				return seventeen;
			case 16:
				return sixteen;
			case 15:
				return fifteen;
			case 14:
				return fourteen;
			case 13:
				return thirteen;
			case 12:
				return twelve;
			case 11:
				return eleven;
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
	
	public Image getNumberScore(int l) 
	{
			switch (l)
			{
			case 30:
				return thirtyScore;
			case 29:
				return twentyNineScore;
			case 28:
				return twentyEightScore;
			case 27:
				return twentySevenScore;
			case 26:
				return twentySixScore;
			case 25:
				return twentyFiveScore;
			case 24:
				return twentyFourScore;
			case 23:
				return twentyThreeScore;
			case 22:
				return twentyTwoScore;
			case 21:
				return twentyOneScore;
			case 20:
				return twentyScore;
			case 19:
				return nineteenScore;
			case 18:
				return eighteenScore;
			case 17:
				return seventeenScore;
			case 16:
				return sixteenScore;
			case 15:
				return fifteenScore;
			case 14:
				return fourteenScore;
			case 13:
				return thirteenScore;
			case 12:
				return twelveScore;
			case 11:
				return elevenScore;
			case 10:
				return tenScore;
			case 9:
				return nineScore;
			case 8:
				return eightScore;
			case 7:
				return sevenScore;
			case 6:
				return sixScore;
			case 5:
				return fiveScore;
			case 4:
				return fourScore;
			case 3:
				return threeScore;
			case 2:
				return twoScore;
			case 1:
				return oneScore;
			case 0:
				return zeroScore;
			}
			return zeroScore;
	}
	
	public Image getScore(long l) 
	{
			switch ((int)l)
			{
			case 30:
				return thirtyPoints;
			case 29:
				return twentyNinePoints;
			case 28:
				return twentyEightPoints;
			case 27:
				return twentySevenPoints;
			case 26:
				return twentySixPoints;
			case 25:
				return twentyFivePoints;
			case 24:
				return twentyFourPoints;
			case 23:
				return twentyThreePoints;
			case 22:
				return twentyTwoPoints;
			case 21:
				return twentyOnePoints;
			case 20:
				return twentyPoints;
			case 19:
				return nineteenPoints;
			case 18:
				return eighteenPoints;
			case 17:
				return seventeenPoints;
			case 16:
				return sixteenPoints;
			case 15:
				return fifteenPoints;
			case 14:
				return fourteenPoints;
			case 13:
				return thirteenPoints;
			case 12:
				return twelvePoints;
			case 11:
				return elevenPoints;
			case 10:
				return tenPoints;
			case 9:
				return ninePoints;
			case 8:
				return eightPoints;
			case 7:
				return sevenPoints;
			case 6:
				return sixPoints;
			case 5:
				return fivePoints;
			case 4:
				return fourPoints;
			case 3:
				return threePoints;
			case 2:
				return twoPoints;
			case 1:
				return onePoint;
			case 0:
				return zeroPoints;
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

	public Image getMyPlayerShot(int index) {
		if (index>3)
			return playerShot[0];
		return playerShot[index];
	}

	public Image getRoundTarget() {
		return roundTarget;
	}

	public Image getFrisbeeRound() {
		return frisbeeRound;
	}
	
	public Image getFrisbeeRound2() {
		return frisbeeRound2;
	}

	public Image getScoreRound(int scoreMyPlayer,int scoreComPlayer) {
		
		GameManager.getWorld().update();
		scoreMyPlayer=GameManager.getWorld().getRoundMyPlayer();
		scoreComPlayer=GameManager.getWorld().getRoundComPlayer();
		
		if(scoreMyPlayer==0 && scoreComPlayer==0)
			return scoreRound0;
		if(scoreMyPlayer==1 && scoreComPlayer==0)
			return scoreRound1;
		if(scoreMyPlayer==2 && scoreComPlayer==0)
			return scoreRound2;
		if(scoreMyPlayer==0 && scoreComPlayer==1)
			return scoreRound3;
		if(scoreMyPlayer==0 && scoreComPlayer==2)
			return scoreRound4;
		if(scoreMyPlayer==1 && scoreComPlayer==1	)
			return scoreRound5;
		if(scoreMyPlayer==2 && scoreComPlayer==1)
			return scoreRound6;
		if(scoreMyPlayer==1 && scoreComPlayer==2)
			return scoreRound7;
		return null;
	}

	public Image getWoodBoard() {
		return woodBoard;
	}

	public Image getWoodBoardCom() {
		return woodBoardCom;
	}

	public ImageIcon getOne_pointComPlayer() {
		return one_pointComPlayer;
	}

	public ImageIcon getTwo_pointComPlayer() {
		return two_pointComPlayer;
	}

	public Image getPlayerLeftMotionLess() {
		return playerLeftMotionLess;
	}
}
