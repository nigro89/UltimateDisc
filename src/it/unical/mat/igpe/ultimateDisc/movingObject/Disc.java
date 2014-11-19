package it.unical.mat.igpe.ultimateDisc.movingObject;
import java.util.Random;



public class Disc extends Thread implements MovingObject  {
	
	private int x;
	private int y;
	private final long intervalloAggiornamento;
	private int deltaX;
	private int deltaY;
	private final int posizioneInizialeX;
	private final int posizioneInizialeY;
	private int widthComponent;
	private int heightComponent;
	
//  get set construttore
//	x y è la posizione iniziale da cui deve partire il disco all'avvio, viene settata dalla grafica in quanto non si conosce a priori la dimensione dello schermo, xk 
//	si presuppone k il disco viene lanciato in basso al centro dello schermo da un ipotetico arbitro.

	public Disc(int x,int y,int widthComponent, int heightComponent, int wall) {
		this.widthComponent=widthComponent;
		this.heightComponent=heightComponent-wall; // ?wall
		this.x=x;
		this.y=y;
		this.posizioneInizialeX=x;
		this.posizioneInizialeY=y;
		intervalloAggiornamento = 10 + new Random().nextInt(30);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	
	public void setDirection(int x, int y) {
		this.deltaX=x;
		this.deltaY=y;
	}

	@Override
	public void update() {
		
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

	@Override
	public void reset() {
		this.x=this.posizioneInizialeX;
		this.y=this.posizioneInizialeY;
	}
	
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
}
