package it.unical.mat.igpe.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final MainFrame mainFrame = new MainFrame();
		//System.out.println(mainFrame.width+"x"+mainFrame.height);
	}

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	GamePanel gamePanel;
	
	public MainFrame()
	{
		gamePanel = new GamePanel();
		this.setContentPane(gamePanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUndecorated(true);
		this.setVisible(true);
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
	}
	
}
