package it.unical.mat.igpe.ultimateDisc.movingObject;

import java.awt.Rectangle;

public abstract class Player implements MovingObject {

	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int UPRIGHT = 4;
	public static final int UPLEFT = 5;
	public static final int DOWNRIGHT = 6;
	public static final int DOWNLEFT = 7;
	public static final int STOP=-1;
	protected int x;
	protected int y;
	private final int startPositionX;
	private final int startPositionY;
	protected int direction;
	private int points;
	protected int widthComponent;
	protected int heightComponent;
	protected int wallNorth;
	protected int wallSouth;
	static final int dimensionEnergyShot = 7;
	private int energyShot;
	private final static int withImage=146;
	private final static int heightImage=160;
	private final static int speedPlayer = 17;
	
	public Player(int x, int y,int widthComponent, int heightComponent, int wallNorth,int wallSouth){
		this.x=x;
		this.y=y;
		this.startPositionX=x;
		this.startPositionY=y;
		this.points=0;
		this.widthComponent=widthComponent;
		this.heightComponent=heightComponent;
		this.wallNorth=wallNorth;
		this.wallSouth=wallSouth;
		this.energyShot = 0;
		this.direction= -1;
	}
	
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	public void setDirection(final int direction) {
		this.direction=direction;
	}
	
	public int getDirection(){
		return direction;
	}

	@Override
	public void update() {

		final int y = getY();
        final int x = getX();
        switch (direction)
        {
        	case UPRIGHT:
        		if (y > 0 && (y-speedPlayer>wallNorth) && (x < widthComponent - 1 && (x+speedPlayer<widthComponent-1))){
        			setY(y-speedPlayer);
        			setX(x + speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
        	case UPLEFT:
        		if (y > 0 && (y-speedPlayer>wallNorth) && (x > 0 && (x-speedPlayer>0))){
        			setY(y-speedPlayer);
        			setX(x - speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
        	case DOWNRIGHT:
        		if (y < this.heightComponent - 1 && (y+speedPlayer<this.heightComponent-wallSouth) && (x < widthComponent - 1 && (x+speedPlayer<widthComponent-1)) ){
        			setY(y + speedPlayer);
        			 setX(x + speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
        	case DOWNLEFT:
        		if (y < this.heightComponent - 1 && (y+speedPlayer<this.heightComponent-wallSouth) && (x > 0 && (x-speedPlayer>0)) ){
        			setY(y + speedPlayer);
        			setX(x - speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
            case UP:
                if (y > 0 && (y-speedPlayer>wallNorth)){
                    setY(y-speedPlayer);
                }
                else{
                    setDirection(STOP);
                }
                break;
                
            case DOWN:
                if (y < this.heightComponent - 1 && (y+speedPlayer<this.heightComponent-wallSouth)) 
                {
                    setY(y + speedPlayer);
                }
                else
                {
                    setDirection(STOP);
                }
                break;
            case LEFT:
                if (x > 0 && (x-speedPlayer>0))
                {
                    setX(x - speedPlayer);
                }
                else
                {
                    setDirection(STOP);
                }
                break;
            case RIGHT:
                if (x < widthComponent - 1 && (x+speedPlayer<widthComponent-1)) 
                {
                    setX(x + speedPlayer);
                }
                else
                {
                    setDirection(STOP);
                }
                break;
            case STOP:
                break;
            default:
                throw new RuntimeException("Direction not supported " + direction);
        }
		
	}

	@Override
	public void reset() {
		
		x=startPositionX;
		y=startPositionY;
		
	}
	
	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean availableEnergyShot() {
		if(this.energyShot == dimensionEnergyShot){
			return true;
		}
		return false;
	}


	public void setEnergyShot() {
		this.energyShot++;
	}

	public Rectangle getBounds(){
//		return new Rectangle(this.x+((int)(Player.getWithimage()*0.25)),this.y+((int)(Player.getHeightimage()*0.25)),(int)(Player.getWithimage()*0.5),(int)(Player.getHeightimage()*0.5));
		return new Rectangle(this.x,this.y,Player.getWithimage(),Player.getHeightimage());
	}


	public static int getHeightimage() {
		return heightImage;
	}


	public static int getWithimage() {
		return withImage;
	}
	

}
