package it.unical.mat.igpe.graphics;

import it.unical.mat.igpe.ultimateDisc.GameManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final GameManager gameManager = new GameManager();
		final MainFrame mainFrame = new MainFrame(gameManager);
	}

	Screen screen = Screen.getInstance();
	double width = screen.getWidth();
	double height = screen.getHeight();
	Color colorBar = new Color(26, 109, 222);
	
	GamePanel gamePanel;
	MenuPanel menuPanel;
	JPanel contentPanel;
	
	GameManager gameManager;
	
	public MainFrame(GameManager gameManager)
	{
		this.contentPanel = new JPanel(new BorderLayout());
		this.gameManager = gameManager;
		
		menuPanel = new MenuPanel(this);
		
		contentPanel.setSize(new Dimension((int)width,(int)height));
		contentPanel.add(menuPanel,"Center");
		this.setContentPane(contentPanel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUndecorated(true);
		this.setVisible(true);
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

            ProgressPainter painter = new ProgressPainter(Color.WHITE, Color.RED);
            UIManager.getLookAndFeelDefaults().put("ProgressBar[Enabled+Finished].foregroundPainter", painter);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
	}
	
	public void startGame()
	{
		gamePanel = new GamePanel(this.gameManager);
		this.switchTo(gamePanel);
		gameManager.start();
		gamePanel.centerGamePanel.repainterThread.start();
		NorthGamePanel.repainterThread.start();
		WestGamePanel.repainterThread.start();
		EastGamePanel.repainterThread.start();
	}
	
    void switchTo(final JPanel panel)
    {
        SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    contentPanel.removeAll();
                    contentPanel.add(panel);
                    contentPanel.updateUI();
                    panel.requestFocus();
                }
            });
    }
}