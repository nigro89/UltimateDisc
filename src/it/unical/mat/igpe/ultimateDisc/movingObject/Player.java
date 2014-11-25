package it.unical.mat.igpe.ultimateDisc.movingObject;
public abstract class Player implements MovingObject {

	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int STOP=-1;
	private int x;
	private int y;
	private final int startPositionX;
	private final int startPositionY;
	private int direction;
	private int points;
	private int widthComponent;
	private int heightComponent;
	private int wallNorth;
	private int wallSouth;
	static final int dimensionEnergyShot = 7;
	private int energyShot;
	
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
            case UP:
                if (y > 0 && (y-1>wallNorth)){
                    setY(y-1);
                }
                else{
                    setDirection(STOP);
                }
                break;
                
            case DOWN:
                if (y < this.heightComponent - 1 && (y+1<this.heightComponent-wallSouth)) 
                {
                    setY(y + 1);
                }
                else
                {
                    setDirection(STOP);
                }
                break;
            case LEFT:
                if (x > 0 && (x-1>0))
                {
                    setX(x - 1);
                }
                else
                {
                    setDirection(STOP);
                }
                break;
            case RIGHT:
                if (x < widthComponent - 1 && (x+1<widthComponent-1)) 
                {
                    setX(x + 1);
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

	

}
