package it.unical.mat.igpe.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SelectPlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ImageProvider imageProvider = new ImageProvider();
	private static Image background = imageProvider.getSelectPlayerPanelBackground();
	Image myPlayerSelected = imageProvider.getMyPlayerSelected();
	Image comPlayerSelected = imageProvider.getComPlayerSelected();
	Image players = imageProvider.getPlayersBarName();
	Image done = imageProvider.getDone();
	Image back = imageProvider.getBack();
	Image selected = imageProvider.getSelectedMyPlayer();
	int select = 0;
	int myPlayer = 0;
	int comPlayer = 0;
	
	Screen screen = Screen.getInstance();
    double width = screen.getWidth();
    double height = screen.getHeight()*0.75;
	
	public SelectPlayerPanel(final MainFrame mainFrame)
	{
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

				final int x = e.getX();
			    final int y = e.getY();
				
			    // back
			    if ( (x>((int)(width*0.05))) && (x<((int)(width*0.15))) && (y>(int)(height*0.1)) && (y<((int)((height*0.18)))) )
		    	{
		    		back = imageProvider.getBack();
		    		repaint();
		    		MainFrame.goToMenuPanel();
		    	}
			    // done
			    if ( (x>((int)(width*0.85))) && (x<((int)(width*0.95))) && (y>(int)(height*0.1)) && (y<((int)((height*0.19)))) )
		    	{
		    		done = imageProvider.getDone();
		    		repaint();
		    		mainFrame.goToSelectArenaPanel(myPlayer, comPlayer);
		    	}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
					
				final int x = e.getX();
			    final int y = e.getY();
			    
			    // back
			    if ( (x>((int)(width*0.05))) && (x<((int)(width*0.15))) && (y>(int)(height*0.1)) && (y<((int)((height*0.18)))) )
			    {
			    	back = imageProvider.getBackPushed();
			    	repaint();
			    	AudioProvider.clickAudio2();
			    }
			    // done
			    if ( (x>((int)(width*0.85))) && (x<((int)(width*0.95))) && (y>(int)(height*0.1)) && (y<((int)((height*0.19)))) )
		    	{
		    		done = imageProvider.getDonePushed();
		    		repaint();
		    		AudioProvider.clickAudio2();
		    	}
			    // tom
			    if ( (x>((int)(width*0.125))) && (x<((int)(width*0.22))) && (y>(int)(height*0.9)) && (y<((int)((height*1.13)))) )
		    	{
			    	if(select==0)
			    	{
			    		myPlayerSelected = imageProvider.getTom();
			    		myPlayer=1;
			    	}
			    	else
			    	{
			    		comPlayerSelected = imageProvider.getTom1();
			    		comPlayer=1;
			    	}
		    		repaint();
		    		AudioProvider.clickAudio2();
		    	}
			    // mario
			    if ( (x>((int)(width*0.29))) && (x<((int)(width*0.385))) && (y>(int)(height*0.9)) && (y<((int)((height*1.13)))) )
		    	{
			    	if(select==0)
			    	{
			    		myPlayerSelected = imageProvider.getMario();
			    		myPlayer=2;
			    	}
			    	else
			    	{
			    		comPlayerSelected = imageProvider.getMario1();
			    		comPlayer=2;
			    	}
		    		repaint();
		    		AudioProvider.clickAudio2();
		    	}
			    // alex
			    if ( (x>((int)(width*0.45))) && (x<((int)(width*0.545))) && (y>(int)(height*0.9)) && (y<((int)((height*1.13)))) )
		    	{
			    	if(select==0)
			    	{
			    		myPlayerSelected = imageProvider.getAlex();
			    		myPlayer=3;
			    	}
			    	else
			    	{
			    		comPlayerSelected = imageProvider.getAlex1();
			    		comPlayer=3;
			    	}
		    		repaint();
		    		AudioProvider.clickAudio2();
		    	}
			    // erik
			    if ( (x>((int)(width*0.61))) && (x<((int)(width*0.705))) && (y>(int)(height*0.9)) && (y<((int)((height*1.13)))) )
		    	{
			    	if(select==0)
			    	{
			    		myPlayerSelected = imageProvider.getErik();
			    		myPlayer=4;
			    	}
			    	else
			    	{
			    		comPlayerSelected = imageProvider.getErik1();
			    		comPlayer=4;
			    	}
		    		repaint();
		    		AudioProvider.clickAudio2();
		    	}
			    // emily
			    if ( (x>((int)(width*0.76))) && (x<((int)(width*0.855))) && (y>(int)(height*0.9)) && (y<((int)((height*1.13)))) )
		    	{
			    	if(select==0)
			    	{
			    		myPlayerSelected = imageProvider.getEmily();
			    		myPlayer=5;
			    	}
			    	else
			    	{
			    		comPlayerSelected = imageProvider.getEmily1();
			    		comPlayer=5;
			    	}
		    		repaint();
		    		AudioProvider.clickAudio2();
		    	}
			    // myPlayer selected
			    if ( (x>((int)(width*0.142))) && (x<((int)(width*0.375))) && (y>(int)(height*0.2)) && (y<((int)((height*0.75)))) )
		    	{
			    	if (select == 1)
			    	{
			    		selected = imageProvider.getSelectedMyPlayer();
			    		repaint();
			    		select=0;
			    		AudioProvider.clickAudio2();
			    	}
		    	}
			 // comPlayer selected
			    if ( (x>((int)(width*0.61))) && (x<((int)(width*0.843))) && (y>(int)(height*0.2)) && (y<((int)((height*0.75)))) )
		    	{
			    	if (select == 0)
			    	{
			    		selected = imageProvider.getSelectedComPlayer();
			    		repaint();
			    		select=1;
			    		AudioProvider.clickAudio2();
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
	    g.drawImage(selected, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(myPlayerSelected, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(comPlayerSelected, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(players, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(done, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	    
	    
	}

}
