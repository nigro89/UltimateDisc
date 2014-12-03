package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

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
	CenterGamePanel centerGamePanel;
	
	public GamePanel(GameManager  gameManager)
	{
		this.setName("GamePanel");
		this.centerGamePanel = new CenterGamePanel(gameManager);
		this.setLayout(new BorderLayout());
		
		this.add(northGamePanel,"North");
		this.add(southGamePanel,"South");
		this.add(eastGamePanel,"East");
		this.add(westGamePanel,"West");
		this.add(centerGamePanel,"Center");
		
	}

	@Override
	public void requestFocus() {

		super.requestFocus();
		centerGamePanel.requestFocus();
	}
	
	
}
