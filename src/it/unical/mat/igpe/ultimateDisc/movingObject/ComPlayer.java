package it.unical.mat.igpe.ultimateDisc.movingObject;

import java.awt.Rectangle;

import it.unical.mat.igpe.graphics.Screen;


public class ComPlayer extends Player {
	
	Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight();
	double sizeOfTheComPlayer = 2.5;
	final static int speedPlayer = 5;

	public ComPlayer(int x,int y,int widthComponent, int heightComponent, int wallNorth,int wallSouth) {
		super(x,y,widthComponent, heightComponent, wallNorth,wallSouth);
	}
	
	@Override
	public Rectangle getBounds(){
		return new Rectangle(this.x,this.y,(int)(Player.getWithimage()*sizeOfTheComPlayer),(int)(Player.getHeightimage()*sizeOfTheComPlayer));
	}
	
	@Override
	public void update() {
		
		final int y = getY();
        final int x = getX();
        switch (direction)
        {
        	case UPRIGHT:
        		if (y > 0 && (y-speedPlayer>wallNorth) && (x < (width*0.86) - 1 && (x+speedPlayer<(width*0.86)))){
        			setY(y-speedPlayer);
        			setX(x + speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
        	case UPLEFT:
        		if (y > 0 && (y-speedPlayer>wallNorth) && (x > widthComponent && (x-speedPlayer>0))){
        			setY(y-speedPlayer);
        			setX(x - speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
        	case DOWNRIGHT:
        		if (y < this.heightComponent - 1 && (y+speedPlayer<this.heightComponent-wallSouth) && (x < (width*0.86) && (x+speedPlayer<(width*0.86))) ){
        			setY(y + speedPlayer);
        			setX(x + speedPlayer);
        		}
        		else
                {
                    setDirection(STOP);
                }
                break;
        	case DOWNLEFT:
        		if (y < this.heightComponent - 1 && (y+speedPlayer<this.heightComponent-wallSouth) && (x > widthComponent && (x-speedPlayer>0)) ){
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
                if (x > widthComponent && (x-speedPlayer>0))
                {
                    setX(x - speedPlayer);
                }
                else
                {
                    setDirection(STOP);
                }
                break;
            case RIGHT:
                if (x < (width*0.86) && (x+speedPlayer>widthComponent-1)) 
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
}
