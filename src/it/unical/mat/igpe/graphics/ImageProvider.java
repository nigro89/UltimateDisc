package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;
import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ImageProvider {
	
	// path players
	String myPlayerRightMotionLessPath = null;
	String myPlayerLeftMotionLessPath = null;
	String myPlayerRightPath = null;
	String myPlayerLeftPath = null;
	String myPlayerDownPath = null;
	String myPlayerUpPath = null;
	String myPlayerDownRightPath = null;
	String myPlayerDownLeftPath = null;
	String myPlayerUpRightPath = null;
	String myPlayerUpLeftPath = null;
	String myPlayerShotPath = null;
	
	String comPlayerRightMotionLessPath = null;
	String comPlayerLeftMotionLessPath = null;
	String comPlayerRightPath = null;
	String comPlayerLeftPath = null;
	String comPlayerDownPath = null;
	String comPlayerUpPath = null;
	String comPlayerDownRightPath = null;
	String comPlayerDownLeftPath = null;
	String comPlayerUpRightPath = null;
	String comPlayerUpLeftPath = null;
	String comPlayerShotPath = null;
	
	// number of sequence to move myPlayer
	static int numberOfSequenceMyPlayer=0;
	static int numberOfSequenceComPlayer=0;
	
	// player
	// array Image of Player's moviments 
	private final Image[] myPlayerRight = new Image[4];
	private final Image[] myPlayerLeft = new Image[4];
	private final Image[] myPlayerUp = new Image[4];
    private final Image[] myPlayerDown = new Image[4];
	private final Image[] myPlayerUpRight = new Image[4];
	private final Image[] myPlayerUpLeft = new Image[4];
	private final Image[] myPlayerDownRight = new Image[4];
	private final Image[] myPlayerDownLeft = new Image[4];
	private final Image[] myPlayerShot = new Image[4];
	private  Image myPlayerRightMotionLess;
	private  Image myPlayerLeftMotionLess;
	
	private final Image[] comPlayerRight = new Image[4];
	private final Image[] comPlayerLeft = new Image[4];
	private final Image[] comPlayerUp = new Image[4];
    private final Image[] comPlayerDown = new Image[4];
	private final Image[] comPlayerUpRight = new Image[4];
	private final Image[] comPlayerUpLeft = new Image[4];
	private final Image[] comPlayerDownRight = new Image[4];
	private final Image[] comPlayerDownLeft = new Image[4];
	private final Image[] comPlayerShot = new Image[4];
	private  Image comPlayerRightMotionLess;
	private  Image comPlayerLeftMotionLess;
	
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
    
    // selectPlayerPanel
    private final Image selectPlayerPanelBackground;

    private final Image myPlayerSelectedTom;
    private final Image comPlayerSelectedTom;
    private final Image myPlayerSelectedMario;
    private final Image comPlayerSelectedMario;
    private final Image myPlayerSelectedAlex;
    private final Image comPlayerSelectedAlex;
    private final Image myPlayerSelectedErik;
    private final Image comPlayerSelectedErik;
    private final Image myPlayerSelectedEmily;
    private final Image comPlayerSelectedEmily;
    
    private final Image myPlayerSelected;
    private final Image comPlayerSelected;
    private final Image done;
    private final Image donePushed;
    private final Image back;
    private final Image backPushed;
    private final Image playersBarName;
    private final Image selectedMyPlayer;
    private final Image selectedComPlayer;
    
    // select Arena
    private final Image selectArenaPanelBackGround;
    private final Image backArenaPanel;
    private final Image backPushedArenaPanel;
    private final Image playArenaPanel;
    private final Image playPushedArenaPanel;
    private final Image arena1;
    private final Image arena2;
    private final Image arena3;
    private final Image selectedArena1;
    private final Image selectedArena2;
    private final Image selectedArena3;
    
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
    private final Image score;
    private final Image scoreRound0;
    private final Image scoreRound1;
    private final Image scoreRound2;
    private final Image scoreRound3;
    private final Image scoreRound4;
    private final Image scoreRound5;
    private final Image scoreRound6;
    private final Image scoreRound7;
    private final Image roundTarget;
    private final Image frisbeeRound;
    private final Image frisbeeRound2;
    
    private final Image scoreTime;
    
    //pause
    private final Image menuPause;
    
    //game over
    private final Image gameOver;

    
    
    public ImageProvider()
    {
    	  final Toolkit tk = Toolkit.getDefaultToolkit();
    	  
    	  // pause
    	  menuPause = tk.getImage("img/imageMenu.png");
    	  
    	  // world
    	  threeWallPoints= tk.getImage("img/points/3points.gif");
    	  fiveWallPoints= tk.getImage("img/points/5points.gif");
    	  frisbee = tk.getImage("img/frisbee.png");
    	  // playGround
    	  one_pointMyPlayer = new ImageIcon("img/playGround/woodPlayGround/1point.png");
    	  two_pointMyPlayer = new ImageIcon("img/playGround/woodPlayGround/2points.png");
    	  one_pointComPlayer = new ImageIcon("img/playGround/woodPlayGround/1pointCom.png");
    	  two_pointComPlayer = new ImageIcon("img/playGround/woodPlayGround/2pointsCom.png");
    	  woodField = tk.getImage("img/playGround/woodPlayGround/legno.png");
    	  woodFieldNorth = tk.getImage("img/playGround/woodPlayGround/nord.jpg");
    	  woodFieldSouth = tk.getImage("img/playGround/woodPlayGround/sud.jpg");
    	  woodBoard = tk.getImage("img/playGround/woodPlayGround/bordoLegno.png");
    	  woodBoardCom = tk.getImage("img/playGround/woodPlayGround/bordoLegnoCom.png");
    	  
    	  // round
    	  score = tk.getImage("img/round/score.png");
    	  round1 = tk.getImage("img/round/round1.gif");
    	  round2 = tk.getImage("img/round/round2.gif");
    	  finalRound = tk.getImage("img/round/finalRound.gif");
    	  scoreRound0 = tk.getImage("img/round/scoreRound/scoreRound0.png");
    	  scoreRound1 = tk.getImage("img/round/scoreRound/scoreRound1.png");
    	  scoreRound2 = tk.getImage("img/round/scoreRound/scoreRound2.png");
    	  scoreRound3 = tk.getImage("img/round/scoreRound/scoreRound3.png");
    	  scoreRound4 = tk.getImage("img/round/scoreRound/scoreRound4.png");
    	  scoreRound5 = tk.getImage("img/round/scoreRound/scoreRound5.png");
    	  scoreRound6 = tk.getImage("img/round/scoreRound/scoreRound6.png");
    	  scoreRound7 = tk.getImage("img/round/scoreRound/scoreRound7.png");
    	  roundTarget = tk.getImage("img/round/targaRound.png");
    	  frisbeeRound = tk.getImage("img/round/frisbeeRound.png");
    	  frisbeeRound2 = tk.getImage("img/round/frisbeeRound2.png");
    	  
    	  scoreTime = tk.getImage("img/round/scoreTime.png");
    	 
    	  // player
    	  myPlayerRightMotionLess = tk.getImage(myPlayerRightMotionLessPath+"right.png");
    	  myPlayerLeftMotionLess = tk.getImage(myPlayerLeftMotionLessPath+"left.png");
    	  comPlayerRightMotionLess = tk.getImage(comPlayerRightMotionLessPath+"right.png");
    	  comPlayerLeftMotionLess = tk.getImage(comPlayerLeftMotionLessPath+"left.png");
    	  
    	  //right image
    	  myPlayerRight[0] = tk.getImage(myPlayerRightPath+"right.png");
    	  myPlayerRight[1] = tk.getImage(myPlayerRightPath+"right_05.png");
    	  myPlayerRight[2] = tk.getImage(myPlayerRightPath+"right_09.png");
    	  myPlayerRight[3] = tk.getImage(myPlayerRightPath+"right_13.png");
    	  comPlayerRight[0] = tk.getImage(comPlayerRightPath+"right.png");
    	  comPlayerRight[1] = tk.getImage(comPlayerRightPath+"right_05.png");
    	  comPlayerRight[2] = tk.getImage(comPlayerRightPath+"right_09.png");
    	  comPlayerRight[3] = tk.getImage(comPlayerRightPath+"right_13.png");
    	  
    	  //left image
    	  myPlayerLeft[0] = tk.getImage(myPlayerLeftPath+"left.png");
    	  myPlayerLeft[1] = tk.getImage(myPlayerLeftPath+"left_05.png");
    	  myPlayerLeft[2] = tk.getImage(myPlayerLeftPath+"left_09.png");
    	  myPlayerLeft[3] = tk.getImage(myPlayerLeftPath+"left_13.png");
    	  comPlayerLeft[0] = tk.getImage(comPlayerLeftPath+"left.png");
    	  comPlayerLeft[1] = tk.getImage(comPlayerLeftPath+"left_05.png");
    	  comPlayerLeft[2] = tk.getImage(comPlayerLeftPath+"left_09.png");
    	  comPlayerLeft[3] = tk.getImage(comPlayerLeftPath+"left_13.png");
    	  
    	//Down image
    	  myPlayerDown[0] = tk.getImage(myPlayerDownPath+"down.png");
    	  myPlayerDown[1] = tk.getImage(myPlayerDownPath+"down_05.png");
    	  myPlayerDown[2] = tk.getImage(myPlayerDownPath+"down_09.png");
    	  myPlayerDown[3] = tk.getImage(myPlayerDownPath+"down_13.png");
    	  comPlayerDown[0] = tk.getImage(comPlayerDownPath+"down.png");
    	  comPlayerDown[1] = tk.getImage(comPlayerDownPath+"down_05.png");
    	  comPlayerDown[2] = tk.getImage(comPlayerDownPath+"down_09.png");
    	  comPlayerDown[3] = tk.getImage(comPlayerDownPath+"down_13.png");
    	  
    	//up image
    	  myPlayerUp[0] = tk.getImage(myPlayerUpPath+"up.png");
    	  myPlayerUp[1] = tk.getImage(myPlayerUpPath+"up_05.png");
    	  myPlayerUp[2] = tk.getImage(myPlayerUpPath+"up_09.png");
    	  myPlayerUp[3] = tk.getImage(myPlayerUpPath+"up_13.png");
    	  comPlayerUp[0] = tk.getImage(comPlayerUpPath+"up.png");
    	  comPlayerUp[1] = tk.getImage(comPlayerUpPath+"up_05.png");
    	  comPlayerUp[2] = tk.getImage(comPlayerUpPath+"up_09.png");
    	  comPlayerUp[3] = tk.getImage(comPlayerUpPath+"up_13.png");
    	  
    	//downRight image
    	  myPlayerDownRight[0] = tk.getImage(myPlayerDownRightPath+"downRight.png");
    	  myPlayerDownRight[1] = tk.getImage(myPlayerDownRightPath+"downRight_05.png");
    	  myPlayerDownRight[2] = tk.getImage(myPlayerDownRightPath+"downRight_09.png");
    	  myPlayerDownRight[3] = tk.getImage(myPlayerDownRightPath+"downRight_13.png");
    	  comPlayerDownRight[0] = tk.getImage(comPlayerDownRightPath+"downRight.png");
    	  comPlayerDownRight[1] = tk.getImage(comPlayerDownRightPath+"downRight_05.png");
    	  comPlayerDownRight[2] = tk.getImage(comPlayerDownRightPath+"downRight_09.png");
    	  comPlayerDownRight[3] = tk.getImage(comPlayerDownRightPath+"downRight_13.png");
    	  
    	//downLeft image
    	  myPlayerDownLeft[0] = tk.getImage(myPlayerDownLeftPath+"downLeft.png");
    	  myPlayerDownLeft[1] = tk.getImage(myPlayerDownLeftPath+"downLeft_05.png");
    	  myPlayerDownLeft[2] = tk.getImage(myPlayerDownLeftPath+"downLeft_09.png");
    	  myPlayerDownLeft[3] = tk.getImage(myPlayerDownLeftPath+"downLeft_13.png");
    	  comPlayerDownLeft[0] = tk.getImage(comPlayerDownLeftPath+"downLeft.png");
    	  comPlayerDownLeft[1] = tk.getImage(comPlayerDownLeftPath+"downLeft_05.png");
    	  comPlayerDownLeft[2] = tk.getImage(comPlayerDownLeftPath+"downLeft_09.png");
    	  comPlayerDownLeft[3] = tk.getImage(comPlayerDownLeftPath+"downLeft_13.png");
    	  
    	//upRight image
    	  myPlayerUpRight[0] = tk.getImage(myPlayerUpRightPath+"upRight.png");
    	  myPlayerUpRight[1] = tk.getImage(myPlayerUpRightPath+"upRight_05.png");
    	  myPlayerUpRight[2] = tk.getImage(myPlayerUpRightPath+"upRight_09.png");
    	  myPlayerUpRight[3] = tk.getImage(myPlayerUpRightPath+"upRight_13.png");
    	  comPlayerUpRight[0] = tk.getImage(comPlayerUpRightPath+"upRight.png");
    	  comPlayerUpRight[1] = tk.getImage(comPlayerUpRightPath+"upRight_05.png");
    	  comPlayerUpRight[2] = tk.getImage(comPlayerUpRightPath+"upRight_09.png");
    	  comPlayerUpRight[3] = tk.getImage(comPlayerUpRightPath+"upRight_13.png");
    	  
    	//upLeft image
    	  myPlayerUpLeft[0] = tk.getImage(myPlayerUpLeftPath+"upLeft.png");
    	  myPlayerUpLeft[1] = tk.getImage(myPlayerUpLeftPath+"upLeft_05.png");
    	  myPlayerUpLeft[2] = tk.getImage(myPlayerUpLeftPath+"upLeft_09.png");
    	  myPlayerUpLeft[3] = tk.getImage(myPlayerUpLeftPath+"upLeft_13.png");
    	  comPlayerUpLeft[0] = tk.getImage(comPlayerUpLeftPath+"upLeft.png");
    	  comPlayerUpLeft[1] = tk.getImage(comPlayerUpLeftPath+"upLeft_05.png");
    	  comPlayerUpLeft[2] = tk.getImage(comPlayerUpLeftPath+"upLeft_09.png");
    	  comPlayerUpLeft[3] = tk.getImage(comPlayerUpLeftPath+"upLeft_13.png");
    	  
      	//shot image
    	  myPlayerShot[0] = tk.getImage(myPlayerShotPath+"shot_0001.png");
    	  myPlayerShot[1] = tk.getImage(myPlayerShotPath+"shot_0009.png");
    	  myPlayerShot[2] = tk.getImage(myPlayerShotPath+"shot_0017.png");
    	  myPlayerShot[3] = tk.getImage(myPlayerShotPath+"shot_0025.png");
    	  comPlayerShot[0] = tk.getImage(comPlayerShotPath+"shot_0001.png");
    	  comPlayerShot[1] = tk.getImage(comPlayerShotPath+"shot_0009.png");
    	  comPlayerShot[2] = tk.getImage(comPlayerShotPath+"shot_0017.png");
    	  comPlayerShot[3] = tk.getImage(comPlayerShotPath+"shot_0025.png");
    	  
    	  // menu panel
    	  introBackground = tk.getImage("img/menu/introImage.png");
    	  playGame = tk.getImage("img/menu/IntroPlay.png");
    	  playGameWhite = tk.getImage("img/menu/IntroPlayWhite.png");
    	  settings = tk.getImage("img/menu/IntroSettings2.png");
    	  settingsWhite = tk.getImage("img/menu/IntroSettings1.png");
    	  exit = tk.getImage("img/menu/IntroExit.png");
    	  exitWhite = tk.getImage("img/menu/IntroExitWhite.png");
    	  
    	  // selectPlayerPanel
    	  selectPlayerPanelBackground = tk.getImage("img/selectPlayer/background.png");

    	  myPlayerSelectedTom = tk.getImage("img/selectPlayer/myPlayerSelectedTom.png");
    	  comPlayerSelectedTom = tk.getImage("img/selectPlayer/comPlayerSelectedTom.png");
    	  myPlayerSelectedMario = tk.getImage("img/selectPlayer/myPlayerSelectedMario.png");
    	  comPlayerSelectedMario = tk.getImage("img/selectPlayer/comPlayerSelectedMario.png");
    	  myPlayerSelectedAlex = tk.getImage("img/selectPlayer/myPlayerSelectedAlex.png");
    	  comPlayerSelectedAlex = tk.getImage("img/selectPlayer/comPlayerSelectedAlex.png");
    	  myPlayerSelectedErik = tk.getImage("img/selectPlayer/myPlayerSelectedErik.png");
    	  comPlayerSelectedErik = tk.getImage("img/selectPlayer/comPlayerSelectedErik.png");
    	  myPlayerSelectedEmily = tk.getImage("img/selectPlayer/myPlayerSelectedEmily.png");
    	  comPlayerSelectedEmily = tk.getImage("img/selectPlayer/comPlayerSelectedEmily.png");
    	  
    	  myPlayerSelected = tk.getImage("img/selectPlayer/myPlayerSelected.png");
    	  comPlayerSelected = tk.getImage("img/selectPlayer/comPlayerSelected.png");
    	  done = tk.getImage("img/selectPlayer/done.png");;
    	  donePushed = tk.getImage("img/selectPlayer/donePushed.png");;
    	  back = tk.getImage("img/selectPlayer/back.png");;
    	  backPushed = tk.getImage("img/selectPlayer/backPushed.png");;
    	  playersBarName = tk.getImage("img/selectPlayer/playersBarNames.png");
    	  selectedMyPlayer = tk.getImage("img/selectPlayer/selectedMyPlayer.png");
    	  selectedComPlayer = tk.getImage("img/selectPlayer/selectedComPlayer.png");
    	  
    	  // select Arena
    	  selectArenaPanelBackGround = tk.getImage("img/selectArena/background.png");
    	  backArenaPanel = tk.getImage("img/selectArena/back.png");
    	  backPushedArenaPanel = tk.getImage("img/selectArena/backPushed.png");
    	  playArenaPanel = tk.getImage("img/selectArena/play.png");
    	  playPushedArenaPanel = tk.getImage("img/selectArena/playPushed.png");
    	  arena1 = tk.getImage("img/selectArena/arena1.png");
    	  arena2 = tk.getImage("img/selectArena/arena2.png");
    	  arena3 = tk.getImage("img/selectArena/arena3.png");
    	  selectedArena1 = tk.getImage("img/selectArena/arena1Selected.png");
    	  selectedArena2 = tk.getImage("img/selectArena/arena2Selected.png");
    	  selectedArena3 = tk.getImage("img/selectArena/arena3Selected.png");
    	    
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

	public void setMyPlayer(int player)
	{
		switch(player)
		{
			case 1:	myPlayerRightMotionLessPath = "img/players/P1/";
	    			myPlayerLeftMotionLessPath = "img/players/P1/";
			    	myPlayerRightPath = "img/players/P1/right/";
			    	myPlayerLeftPath = "img/players/P1/left/";
			    	myPlayerDownPath = "img/players/P1/down/";
			    	myPlayerUpPath = "img/players/P1/up/";
			    	myPlayerDownRightPath = "img/players/P1/downRight/";
			    	myPlayerDownLeftPath = "img/players/P1/downLeft/";
			    	myPlayerUpRightPath = "img/players/P1/upRight/";
			    	myPlayerUpLeftPath = "img/players/P1/upLeft/";
			    	myPlayerShotPath = "img/players/P1/shot/";
			    	break;
			case 2:	myPlayerRightMotionLessPath = "img/players/P2/";
			    	myPlayerLeftMotionLessPath = "img/players/P2/";
			    	myPlayerRightPath = "img/players/P2/right/";
			    	myPlayerLeftPath = "img/players/P2/left/";
			    	myPlayerDownPath = "img/players/P2/down/";
			    	myPlayerUpPath = "img/players/P2/up/";
			    	myPlayerDownRightPath = "img/players/P2/downRight/";
			    	myPlayerDownLeftPath = "img/players/P2/downLeft/";
			    	myPlayerUpRightPath = "img/players/P2/upRight/";
			    	myPlayerUpLeftPath = "img/players/P2/upLeft/";
			    	myPlayerShotPath = "img/players/P2/shot/";
			    	break;
			case 3:	myPlayerRightMotionLessPath = "img/players/P3/";
			    	myPlayerLeftMotionLessPath = "img/players/P3/";
			    	myPlayerRightPath = "img/players/P3/right/";
			    	myPlayerLeftPath = "img/players/P3/left/";
			    	myPlayerDownPath = "img/players/P3/down/";
			    	myPlayerUpPath = "img/players/P3/up/";
			    	myPlayerDownRightPath = "img/players/P3/downRight/";
			    	myPlayerDownLeftPath = "img/players/P3/downLeft/";
			    	myPlayerUpRightPath = "img/players/P3/upRight/";
			    	myPlayerUpLeftPath = "img/players/P3/upLeft/";
			    	myPlayerShotPath = "img/players/P3/shot/";
			    	break;
			case 4:	myPlayerRightMotionLessPath = "img/players/P4/";
			    	myPlayerLeftMotionLessPath = "img/players/P4/";
			    	myPlayerRightPath = "img/players/P4/right/";
			    	myPlayerLeftPath = "img/players/P4/left/";
			    	myPlayerDownPath = "img/players/P4/down/";
			    	myPlayerUpPath = "img/players/P4/up/";
			    	myPlayerDownRightPath = "img/players/P4/downRight/";
			    	myPlayerDownLeftPath = "img/players/P4/downLeft/";
			    	myPlayerUpRightPath = "img/players/P4/upRight/";
			    	myPlayerUpLeftPath = "img/players/P4/upLeft/";
			    	myPlayerShotPath = "img/players/P4/shot/";
			    	break;
			case 5:	myPlayerRightMotionLessPath = "img/players/P5/";
			    	myPlayerLeftMotionLessPath = "img/players/P5/";
			    	myPlayerRightPath = "img/players/P5/right/";
			    	myPlayerLeftPath = "img/players/P5/left/";
			    	myPlayerDownPath = "img/players/P5/down/";
			    	myPlayerUpPath = "img/players/P5/up/";
			    	myPlayerDownRightPath = "img/players/P5/downRight/";
			    	myPlayerDownLeftPath = "img/players/P5/downLeft/";
			    	myPlayerUpRightPath = "img/players/P5/upRight/";
			    	myPlayerUpLeftPath = "img/players/P5/upLeft/";
			    	myPlayerShotPath = "img/players/P5/shot/";
			    	break;
		   default:	myPlayerRightMotionLessPath = "img/players/P1/";
					myPlayerLeftMotionLessPath = "img/players/P1/";
			    	myPlayerRightPath = "img/players/P1/right/";
			    	myPlayerLeftPath = "img/players/P1/left/";
			    	myPlayerDownPath = "img/players/P1/down/";
			    	myPlayerUpPath = "img/players/P1/up/";
			    	myPlayerDownRightPath = "img/players/P1/downRight/";
			    	myPlayerDownLeftPath = "img/players/P1/downLeft/";
			    	myPlayerUpRightPath = "img/players/P1/upRight/";
			    	myPlayerUpLeftPath = "img/players/P1/upLeft/";
			    	myPlayerShotPath = "img/players/P1/shot/";
			    	break;
		}
	}
	
	public void setComPlayer(int player)
	{
		switch(player)
		{
			case 1:	comPlayerRightMotionLessPath = "img/players/P1/";
					comPlayerLeftMotionLessPath = "img/players/P1/";
					comPlayerRightPath = "img/players/P1/right/";
					comPlayerLeftPath = "img/players/P1/left/";
					comPlayerDownPath = "img/players/P1/down/";
					comPlayerUpPath = "img/players/P1/up/";
					comPlayerDownRightPath = "img/players/P1/downRight/";
					comPlayerDownLeftPath = "img/players/P1/downLeft/";
					comPlayerUpRightPath = "img/players/P1/upRight/";
					comPlayerUpLeftPath = "img/players/P1/upLeft/";
					comPlayerShotPath = "img/players/P1/shot/";
			    	break;
			case 2:	comPlayerRightMotionLessPath = "img/players/P2/";
					comPlayerLeftMotionLessPath = "img/players/P2/";
					comPlayerRightPath = "img/players/P2/right/";
					comPlayerLeftPath = "img/players/P2/left/";
					comPlayerDownPath = "img/players/P2/down/";
					comPlayerUpPath = "img/players/P2/up/";
					comPlayerDownRightPath = "img/players/P2/downRight/";
					comPlayerDownLeftPath = "img/players/P2/downLeft/";
					comPlayerUpRightPath = "img/players/P2/upRight/";
					comPlayerUpLeftPath = "img/players/P2/upLeft/";
					comPlayerShotPath = "img/players/P2/shot/";
			    	break;
			case 3:	comPlayerRightMotionLessPath = "img/players/P3/";
					comPlayerLeftMotionLessPath = "img/players/P3/";
					comPlayerRightPath = "img/players/P3/right/";
					comPlayerLeftPath = "img/players/P3/left/";
					comPlayerDownPath = "img/players/P3/down/";
					comPlayerUpPath = "img/players/P3/up/";
					comPlayerDownRightPath = "img/players/P3/downRight/";
					comPlayerDownLeftPath = "img/players/P3/downLeft/";
					comPlayerUpRightPath = "img/players/P3/upRight/";
					comPlayerUpLeftPath = "img/players/P3/upLeft/";
					comPlayerShotPath = "img/players/P3/shot/";
			    	break;
			case 4:	comPlayerRightMotionLessPath = "img/players/P4/";
					comPlayerLeftMotionLessPath = "img/players/P4/";
					comPlayerRightPath = "img/players/P4/right/";
					comPlayerLeftPath = "img/players/P4/left/";
					comPlayerDownPath = "img/players/P4/down/";
					comPlayerUpPath = "img/players/P4/up/";
					comPlayerDownRightPath = "img/players/P4/downRight/";
					comPlayerDownLeftPath = "img/players/P4/downLeft/";
					comPlayerUpRightPath = "img/players/P4/upRight/";
					comPlayerUpLeftPath = "img/players/P4/upLeft/";
					comPlayerShotPath = "img/players/P4/shot/";
			    	break;
			case 5:	comPlayerRightMotionLessPath = "img/players/P5/";
					comPlayerLeftMotionLessPath = "img/players/P5/";
					comPlayerRightPath = "img/players/P5/right/";
					comPlayerLeftPath = "img/players/P5/left/";
					comPlayerDownPath = "img/players/P5/down/";
					comPlayerUpPath = "img/players/P5/up/";
					comPlayerDownRightPath = "img/players/P5/downRight/";
					comPlayerDownLeftPath = "img/players/P5/downLeft/";
					comPlayerUpRightPath = "img/players/P5/upRight/";
					comPlayerUpLeftPath = "img/players/P5/upLeft/";
					comPlayerShotPath = "img/players/P5/shot/";
			    	break;
		   default:	comPlayerRightMotionLessPath = "img/players/P1/";
					comPlayerLeftMotionLessPath = "img/players/P1/";
					comPlayerRightPath = "img/players/P1/right/";
					comPlayerLeftPath = "img/players/P1/left/";
					comPlayerDownPath = "img/players/P1/down/";
					comPlayerUpPath = "img/players/P1/up/";
					comPlayerDownRightPath = "img/players/P1/downRight/";
					comPlayerDownLeftPath = "img/players/P1/downLeft/";
					comPlayerUpRightPath = "img/players/P1/upRight/";
					comPlayerUpLeftPath = "img/players/P1/upLeft/";
					comPlayerShotPath = "img/players/P1/shot/";
			    	break;
		}
	}
	
	public void loadPlayers()
	{
		final Toolkit tk = Toolkit.getDefaultToolkit();
		// player
	  	  myPlayerRightMotionLess = tk.getImage(myPlayerRightMotionLessPath+"right.png");
	  	  myPlayerLeftMotionLess = tk.getImage(myPlayerLeftMotionLessPath+"left.png");
	  	  comPlayerRightMotionLess = tk.getImage(comPlayerRightMotionLessPath+"right.png");
	  	  comPlayerLeftMotionLess = tk.getImage(comPlayerLeftMotionLessPath+"left.png");
	  	  
	  	  //right image
	  	  myPlayerRight[0] = tk.getImage(myPlayerRightPath+"right.png");
	  	  myPlayerRight[1] = tk.getImage(myPlayerRightPath+"right_05.png");
	  	  myPlayerRight[2] = tk.getImage(myPlayerRightPath+"right_09.png");
	  	  myPlayerRight[3] = tk.getImage(myPlayerRightPath+"right_13.png");
	  	  comPlayerRight[0] = tk.getImage(comPlayerRightPath+"right.png");
	  	  comPlayerRight[1] = tk.getImage(comPlayerRightPath+"right_05.png");
	  	  comPlayerRight[2] = tk.getImage(comPlayerRightPath+"right_09.png");
	  	  comPlayerRight[3] = tk.getImage(comPlayerRightPath+"right_13.png");
	  	  
	  	  //left image
	  	  myPlayerLeft[0] = tk.getImage(myPlayerLeftPath+"left.png");
	  	  myPlayerLeft[1] = tk.getImage(myPlayerLeftPath+"left_05.png");
	  	  myPlayerLeft[2] = tk.getImage(myPlayerLeftPath+"left_09.png");
	  	  myPlayerLeft[3] = tk.getImage(myPlayerLeftPath+"left_13.png");
	  	  comPlayerLeft[0] = tk.getImage(comPlayerLeftPath+"left.png");
	  	  comPlayerLeft[1] = tk.getImage(comPlayerLeftPath+"left_05.png");
	  	  comPlayerLeft[2] = tk.getImage(comPlayerLeftPath+"left_09.png");
	  	  comPlayerLeft[3] = tk.getImage(comPlayerLeftPath+"left_13.png");
	  	  
	  	//Down image
	  	  myPlayerDown[0] = tk.getImage(myPlayerDownPath+"down.png");
	  	  myPlayerDown[1] = tk.getImage(myPlayerDownPath+"down_05.png");
	  	  myPlayerDown[2] = tk.getImage(myPlayerDownPath+"down_09.png");
	  	  myPlayerDown[3] = tk.getImage(myPlayerDownPath+"down_13.png");
	  	  comPlayerDown[0] = tk.getImage(comPlayerDownPath+"down.png");
	  	  comPlayerDown[1] = tk.getImage(comPlayerDownPath+"down_05.png");
	  	  comPlayerDown[2] = tk.getImage(comPlayerDownPath+"down_09.png");
	  	  comPlayerDown[3] = tk.getImage(comPlayerDownPath+"down_13.png");
	  	  
	  	//up image
	  	  myPlayerUp[0] = tk.getImage(myPlayerUpPath+"up.png");
	  	  myPlayerUp[1] = tk.getImage(myPlayerUpPath+"up_05.png");
	  	  myPlayerUp[2] = tk.getImage(myPlayerUpPath+"up_09.png");
	  	  myPlayerUp[3] = tk.getImage(myPlayerUpPath+"up_13.png");
	  	  comPlayerUp[0] = tk.getImage(comPlayerUpPath+"up.png");
	  	  comPlayerUp[1] = tk.getImage(comPlayerUpPath+"up_05.png");
	  	  comPlayerUp[2] = tk.getImage(comPlayerUpPath+"up_09.png");
	  	  comPlayerUp[3] = tk.getImage(comPlayerUpPath+"up_13.png");
	  	  
	  	//downRight image
	  	  myPlayerDownRight[0] = tk.getImage(myPlayerDownRightPath+"downRight.png");
	  	  myPlayerDownRight[1] = tk.getImage(myPlayerDownRightPath+"downRight_05.png");
	  	  myPlayerDownRight[2] = tk.getImage(myPlayerDownRightPath+"downRight_09.png");
	  	  myPlayerDownRight[3] = tk.getImage(myPlayerDownRightPath+"downRight_13.png");
	  	  comPlayerDownRight[0] = tk.getImage(comPlayerDownRightPath+"downRight.png");
	  	  comPlayerDownRight[1] = tk.getImage(comPlayerDownRightPath+"downRight_05.png");
	  	  comPlayerDownRight[2] = tk.getImage(comPlayerDownRightPath+"downRight_09.png");
	  	  comPlayerDownRight[3] = tk.getImage(comPlayerDownRightPath+"downRight_13.png");
	  	  
	  	//downLeft image
	  	  myPlayerDownLeft[0] = tk.getImage(myPlayerDownLeftPath+"downLeft.png");
	  	  myPlayerDownLeft[1] = tk.getImage(myPlayerDownLeftPath+"downLeft_05.png");
	  	  myPlayerDownLeft[2] = tk.getImage(myPlayerDownLeftPath+"downLeft_09.png");
	  	  myPlayerDownLeft[3] = tk.getImage(myPlayerDownLeftPath+"downLeft_13.png");
	  	  comPlayerDownLeft[0] = tk.getImage(comPlayerDownLeftPath+"downLeft.png");
	  	  comPlayerDownLeft[1] = tk.getImage(comPlayerDownLeftPath+"downLeft_05.png");
	  	  comPlayerDownLeft[2] = tk.getImage(comPlayerDownLeftPath+"downLeft_09.png");
	  	  comPlayerDownLeft[3] = tk.getImage(comPlayerDownLeftPath+"downLeft_13.png");
	  	  
	  	//upRight image
	  	  myPlayerUpRight[0] = tk.getImage(myPlayerUpRightPath+"upRight.png");
	  	  myPlayerUpRight[1] = tk.getImage(myPlayerUpRightPath+"upRight_05.png");
	  	  myPlayerUpRight[2] = tk.getImage(myPlayerUpRightPath+"upRight_09.png");
	  	  myPlayerUpRight[3] = tk.getImage(myPlayerUpRightPath+"upRight_13.png");
	  	  comPlayerUpRight[0] = tk.getImage(comPlayerUpRightPath+"upRight.png");
	  	  comPlayerUpRight[1] = tk.getImage(comPlayerUpRightPath+"upRight_05.png");
	  	  comPlayerUpRight[2] = tk.getImage(comPlayerUpRightPath+"upRight_09.png");
	  	  comPlayerUpRight[3] = tk.getImage(comPlayerUpRightPath+"upRight_13.png");
	  	  
	  	//upLeft image
	  	  myPlayerUpLeft[0] = tk.getImage(myPlayerUpLeftPath+"upLeft.png");
	  	  myPlayerUpLeft[1] = tk.getImage(myPlayerUpLeftPath+"upLeft_05.png");
	  	  myPlayerUpLeft[2] = tk.getImage(myPlayerUpLeftPath+"upLeft_09.png");
	  	  myPlayerUpLeft[3] = tk.getImage(myPlayerUpLeftPath+"upLeft_13.png");
	  	  comPlayerUpLeft[0] = tk.getImage(comPlayerUpLeftPath+"upLeft.png");
	  	  comPlayerUpLeft[1] = tk.getImage(comPlayerUpLeftPath+"upLeft_05.png");
	  	  comPlayerUpLeft[2] = tk.getImage(comPlayerUpLeftPath+"upLeft_09.png");
	  	  comPlayerUpLeft[3] = tk.getImage(comPlayerUpLeftPath+"upLeft_13.png");
	  	  
	    	//shot image
	  	  myPlayerShot[0] = tk.getImage(myPlayerShotPath+"shot_0001.png");
	  	  myPlayerShot[1] = tk.getImage(myPlayerShotPath+"shot_0009.png");
	  	  myPlayerShot[2] = tk.getImage(myPlayerShotPath+"shot_0017.png");
	  	  myPlayerShot[3] = tk.getImage(myPlayerShotPath+"shot_0025.png");
	  	  comPlayerShot[0] = tk.getImage(comPlayerShotPath+"shot_0001.png");
	  	  comPlayerShot[1] = tk.getImage(comPlayerShotPath+"shot_0009.png");
	  	  comPlayerShot[2] = tk.getImage(comPlayerShotPath+"shot_0017.png");
	  	  comPlayerShot[3] = tk.getImage(comPlayerShotPath+"shot_0025.png");
	}
	
	public Image getMyPlayerDirection(final int direction)
    {
		numberOfSequenceMyPlayer++;
		if(numberOfSequenceMyPlayer>=4)
			numberOfSequenceMyPlayer=0;
		
	    switch (direction)
	    {
	        case Player.LEFT:
	            return myPlayerLeft[numberOfSequenceMyPlayer];
	            
	        case Player.RIGHT:
	            return myPlayerRight[numberOfSequenceMyPlayer];
	            
	        case Player.UP:
	            return myPlayerUp[numberOfSequenceMyPlayer];
	            
	        case Player.DOWN:
	            return myPlayerDown[numberOfSequenceMyPlayer];
	            
	        case Player.UPRIGHT:
	            return myPlayerUpRight[numberOfSequenceMyPlayer];
	            
	        case Player.UPLEFT:
	            return myPlayerUpLeft[numberOfSequenceMyPlayer];
	            
	        case Player.DOWNRIGHT:
	            return myPlayerDownRight[numberOfSequenceMyPlayer];
	            
	        case Player.DOWNLEFT:
	            return myPlayerDownLeft[numberOfSequenceMyPlayer];
	            
	        case 10:
	            return myPlayerShot[numberOfSequenceMyPlayer];
	    }
	    return myPlayerRight[0];
}
	
	public Image getComPlayerDirection(final int direction)
    {
		numberOfSequenceComPlayer++;
		if(numberOfSequenceComPlayer>=4)
			numberOfSequenceComPlayer=0;
		
	    switch (direction)
	    {
	        case Player.LEFT:
	            return comPlayerLeft[numberOfSequenceComPlayer];
	            
	        case Player.RIGHT:
	            return comPlayerRight[numberOfSequenceComPlayer];
	            
	        case Player.UP:
	            return comPlayerUp[numberOfSequenceComPlayer];
	            
	        case Player.DOWN:
	            return comPlayerDown[numberOfSequenceComPlayer];
	            
	        case Player.UPRIGHT:
	            return comPlayerUpRight[numberOfSequenceComPlayer];
	            
	        case Player.UPLEFT:
	            return comPlayerUpLeft[numberOfSequenceComPlayer];
	            
	        case Player.DOWNRIGHT:
	            return comPlayerDownRight[numberOfSequenceComPlayer];
	            
	        case Player.DOWNLEFT:
	            return comPlayerDownLeft[numberOfSequenceComPlayer];
	            
	        case 10:
	            return comPlayerShot[numberOfSequenceComPlayer];
	    }
	    return comPlayerRight[0];
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
			return myPlayerShot[0];
		return myPlayerShot[index];
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

	public Image getSelectPlayerPanelBackground() {
		return selectPlayerPanelBackground;
	}

	public Image getTom() {
		return myPlayerSelectedTom;
	}

	public Image getTom1() {
		return comPlayerSelectedTom;
	}

	public Image getMario() {
		return myPlayerSelectedMario;
	}

	public Image getMario1() {
		return comPlayerSelectedMario;
	}

	public Image getAlex() {
		return myPlayerSelectedAlex;
	}

	public Image getAlex1() {
		return comPlayerSelectedAlex;
	}

	public Image getErik() {
		return myPlayerSelectedErik;
	}

	public Image getErik1() {
		return comPlayerSelectedErik;
	}

	public Image getEmily() {
		return myPlayerSelectedEmily;
	}

	public Image getEmily1() {
		return comPlayerSelectedEmily;
	}

	public Image getMyPlayerSelected() {
		return myPlayerSelected;
	}

	public Image getDone() {
		return done;
	}

	public Image getDonePushed() {
		return donePushed;
	}

	public Image getBack() {
		return back;
	}

	public Image getBackPushed() {
		return backPushed;
	}

	public Image getPlayersBarName() {
		return playersBarName;
	}

	public Image getComPlayerSelected() {
		return comPlayerSelected;
	}

	public Image getSelectedMyPlayer() {
		return selectedMyPlayer;
	}

	public Image getSelectedComPlayer() {
		return selectedComPlayer;
	}

	public Image getMyPlayerRightMotionLess() {
		return myPlayerRightMotionLess;
	}
	
	public Image getMyPlayerLeftMotionLess() {
		return myPlayerLeftMotionLess;
	}

	public Image getComPlayerRightMotionLess() {
		return comPlayerRightMotionLess;
	}

	public Image getComPlayerLeftMotionLess() {
		return comPlayerLeftMotionLess;
	}

	public Image getSelectArenaPanelBackGround() {
		return selectArenaPanelBackGround;
	}

	public Image getBackArenaPanel() {
		return backArenaPanel;
	}

	public Image getBackPushedArenaPanel() {
		return backPushedArenaPanel;
	}

	public Image getPlayArenaPanel() {
		return playArenaPanel;
	}

	public Image getPlayPushedArenaPanel() {
		return playPushedArenaPanel;
	}

	public Image getArena1() {
		return arena1;
	}

	public Image getArena2() {
		return arena2;
	}

	public Image getArena3() {
		return arena3;
	}

	public Image getSelectedArena1() {
		return selectedArena1;
	}

	public Image getSelectedArena2() {
		return selectedArena2;
	}

	public Image getSelectedArena3() {
		return selectedArena3;
	}
}
