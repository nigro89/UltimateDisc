package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.movingObject.Player;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ImageProvider {

	private final Image myPlayerFront;

    private final Image myPlayerBack;

    private final ImageIcon one_point;

    private final ImageIcon two_point;

    private final Image frisbee;

    private final Image woodField;

    private final Image woodFieldNorth;

    private final Image woodFieldSouth;

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
    }

    public Image getMyPlayerDirection(final int direction)
    {
        switch (direction)
        {
            case Player.LEFT:
                return myPlayerBack;
            case Player.RIGHT:
                return myPlayerFront;
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
    
    
}
