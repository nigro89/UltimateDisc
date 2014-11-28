package it.unical.mat.igpe.ultimateDisc.movingObject;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;



public class Disc extends Thread implements MovingObject  {
	
	private int x;
	private int y;
	private final long intervalloAggiornamento;
	private int deltaX;
	private int deltaY;
	private int posizioneInizialeX;
	private int posizioneInizialeY;
	private int widthComponent;
	private int heightComponent;
	boolean myplayer;
	boolean complayer;
	private boolean availableForTheMyPlayer = false;
	
	
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    int dimensionOfDisc = (int)width/17;
//  get set construttore
//	x y è la posizione iniziale da cui deve partire il disco all'avvio, viene settata dalla grafica in quanto non si conosce a priori la dimensione dello schermo, xk 
//	si presuppone k il disco viene lanciato in basso al centro dello schermo da un ipotetico arbitro.

	public Disc(int x,int y,int widthComponent, int heightComponent, int wall) {
		this.widthComponent=widthComponent;
		this.heightComponent=heightComponent-wall; 
		this.x=x;
		this.y=y;
		this.posizioneInizialeX=x;
		this.posizioneInizialeY=y;
		intervalloAggiornamento = 10 + new Random().nextInt(30);
		myplayer=complayer=false;
	}

	public Disc() {
		intervalloAggiornamento = 10 + new Random().nextInt(30);
		posizioneInizialeX=0;
		posizioneInizialeY=0;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}


	public void setPosition (int x, int y){
		this.x=x;
		this.y=y;
		this.posizioneInizialeX=x;
		this.posizioneInizialeY=y;
		this.setAvailableForTheMyPlayer(true);
	}
	
	public void setDirection(int x, int y) {
		this.deltaX=x;
		this.deltaY=y;
	}

	@Override
	public void update() {
		
		if(isAvailableForTheMyPlayer() == false){
			if (getX() <= 0 && deltaX < 0 || getX() >= this.widthComponent && deltaX > 0)
	        {
	            deltaX = -deltaX;
	        }
			if (getY() <= 0 && deltaY < 0 || getY() >= this.heightComponent && deltaY > 0)
	        {
	            deltaY = -deltaY;
	        }
			
	        this.x=this.x+deltaX;
	        this.y=this.y+deltaY;
		}
		
	}

	
	
	public boolean isMyplayer() {
		return myplayer;
	}

	public void setMyplayer(boolean myplayer) {
		this.myplayer = myplayer;
	}

	public boolean isComplayer() {
		return complayer;
	}

	public void setComplayer(boolean complayer) {
		this.complayer = complayer;
	}

	@Override
	public void reset() {
		this.x=this.posizioneInizialeX;
		this.y=this.posizioneInizialeY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(this.x,this.y,(int)(dimensionOfDisc*0.6),(int)(dimensionOfDisc*0.6));
	}
	
	//////////////////////////////////////////////////////////// lasciare???
	public void run(){
		
		try {
			while(true){
				sleep(intervalloAggiornamento);
				
				update();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public boolean isAvailableForTheMyPlayer() {
		return availableForTheMyPlayer;
	}

	public void setAvailableForTheMyPlayer(boolean availableForTheMyPlayer) {
		this.availableForTheMyPlayer = availableForTheMyPlayer;
	}
}
