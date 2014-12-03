package it.unical.mat.igpe.graphics;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuPanel(final MainFrame mainFrame)
	{
		  final JButton buttonStart = new JButton("Start Game");
	        add(buttonStart);
	        buttonStart.addActionListener(new ActionListener()
	            {
	                @Override
	                public void actionPerformed(final ActionEvent e)
	                {
	                    mainFrame.startGame();
	                }
	            });
	}
}
