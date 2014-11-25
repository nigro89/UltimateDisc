package it.unical.mat.igpe.graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	NorthGamePanel northGamePanel = new NorthGamePanel();
	SouthGamePanel southGamePanel = new SouthGamePanel();
	WestGamePanel westGamePanel = new WestGamePanel();
	EastGamePanel eastGamePanel = new EastGamePanel();
	CenterGamePanel centerGamePanel = new CenterGamePanel();
	
	public GamePanel()
	{
		this.setLayout(new BorderLayout());
		
		this.add(northGamePanel,"North");
		this.add(southGamePanel,"South");
		this.add(eastGamePanel,"East");
		this.add(westGamePanel,"West");
		this.add(centerGamePanel,"Center");
	}

}
