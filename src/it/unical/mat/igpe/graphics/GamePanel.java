package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	SouthGamePanel southGamePanel;
	CenterGamePanel centerGamePanel;
	NorthGamePanel northGamePanel;
	WestGamePanel westGamePanel;
	EastGamePanel eastGamePanel;
	
	
	public GamePanel(GameManager  gameManager,ImageProvider imageProvider,int myPlayer,int comPlayer)
	{
		this.setName("GamePanel");
		this.centerGamePanel = new CenterGamePanel(gameManager,imageProvider,myPlayer,comPlayer);
		this.northGamePanel = new NorthGamePanel(gameManager);
		this.westGamePanel = new WestGamePanel(gameManager);
		this.eastGamePanel = new EastGamePanel(gameManager);
		this.southGamePanel = new SouthGamePanel(gameManager);
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
