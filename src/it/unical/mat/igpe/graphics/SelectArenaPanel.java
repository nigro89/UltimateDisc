package it.unical.mat.igpe.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SelectArenaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ImageProvider imageProvider = new ImageProvider();
	private static Image background = imageProvider.getSelectArenaPanelBackGround();
	Image arena1 = imageProvider.getArena1();
	Image arena2 = imageProvider.getArena2();
	Image arena3 = imageProvider.getArena3();
	Image play = imageProvider.getPlayArenaPanel();
	Image back = imageProvider.getBackArenaPanel();
	Image selected = imageProvider.getSelectedArena1();
	int select = 0;
	static int myPlayer=0;
	static int comPlayer=0;
	
	Screen screen = Screen.getInstance();
    double width = screen.getWidth();
    double height = screen.getHeight()*0.75;
    
    public SelectArenaPanel(final MainFrame mainFrame,int my_Player,int com_Player)
    {
    	myPlayer=my_Player;
    	comPlayer=com_Player;
    	
    	this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
	
					final int x = e.getX();
				    final int y = e.getY();
					
				    if ( (x>((int)(width/20))) && (x<((int)(width/20)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
			    	{
			    		back = imageProvider.getBackArenaPanel();
			    		repaint();
			    		mainFrame.goBackSelectPlayerPanel();
			    	}
				    if ( (x>((int)(width)-(width*0.15))) && (x<((int)(width)-(width*0.15)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
			    	{
			    		play = imageProvider.getPlayArenaPanel();
			    		repaint();

			    		mainFrame.startGame(SelectArenaPanel.myPlayer,SelectArenaPanel.comPlayer);
				    	CenterGamePanel.getRepainterThread().setFinish(false);
				    	CenterGamePanel.getRepainterThread().setStartGame(true);
			    	}
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
						
					final int x = e.getX();
				    final int y = e.getY();
				    
				    // back
				    if ( (x>((int)(width/20))) && (x<((int)(width/20)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
				    {
				    	back = imageProvider.getBackPushedArenaPanel();
				    	repaint();
				    }
				    // done
				    if ( (x>((int)(width)-(width*0.15))) && (x<((int)(width)-(width*0.15)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
			    	{
			    		play = imageProvider.getPlayPushedArenaPanel();
			    		repaint();
			    	}

				    
				    // arena1 selected
				    if ( (x>((int)(width/45))) && (x<((int)(width/45)+350)) && (y>(int)(height*0.4)) && (y<((int)((height*0.4))+200)) )
			    	{
				    	if (select != 0)
				    	{
				    		selected = imageProvider.getSelectedArena1();
				    		repaint();
				    		select=0;
				    	}
			    	}
				    // arena2 selected
				    if ( (x>((int)(width*0.35))) && (x<((int)(width*0.35)+350)) && (y>(int)(height*0.4)) && (y<((int)((height*0.4))+200)) )
			    	{
				    	if (select != 1)
				    	{
				    		selected = imageProvider.getSelectedArena2();
				    		repaint();
				    		select=1;
				    	}
			    	}
				    // arena3 selected
				    if ( (x>((int)(width*0.69))) && (x<((int)(width*0.69)+350)) && (y>(int)(height*0.4)) && (y<((int)((height*0.4))+200)) )
			    	{
				    	if (select != 2)
				    	{
				    		selected = imageProvider.getSelectedArena3();
				    		repaint();
				    		select=2;
				    	}
			    	}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
    }
    
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(background, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(arena1, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(arena2, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(arena3, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(play, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(selected, 0, 0, getWidth(),getHeight(),this);
	    
	    g.setColor(Color.red);
	    //g.drawRect((int)(width*0.69), (int)(height*0.4), 350, 200);
	}

}