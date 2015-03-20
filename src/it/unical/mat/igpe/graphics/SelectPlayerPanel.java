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
				
			    if ( (x>((int)(width/20))) && (x<((int)(width/20)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
		    	{
		    		back = imageProvider.getBack();
		    		repaint();
		    		mainFrame.goToMenuPanel();
		    	}
			    if ( (x>((int)(width)-(width*0.15))) && (x<((int)(width)-(width*0.15)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
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
			    if ( (x>((int)(width/20))) && (x<((int)(width/20)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
			    {
			    	back = imageProvider.getBackPushed();
			    	repaint();
			    }
			    // done
			    if ( (x>((int)(width)-(width*0.15))) && (x<((int)(width)-(width*0.15)+140)) && (y>(int)(height/10)) && (y<((int)((height/10))+50)) )
		    	{
		    		done = imageProvider.getDonePushed();
		    		repaint();
		    	}
			    // tom
			    if ( (x>((int)(width/8))) && (x<((int)(width/8)+130)) && (y>(int)(height)-(height/10)) && (y<((int)((height)-(height/10))+130)) )
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
		    	}
			    // mario
			    if ( (x>((int)(width*0.29))) && (x<((int)(width*0.29)+130)) && (y>(int)(height)-(height/10)) && (y<((int)((height)-(height/10))+130)) )
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
		    	}
			    // alex
			    if ( (x>((int)(width*0.45))) && (x<((int)(width*0.45)+130)) && (y>(int)(height)-(height/10)) && (y<((int)((height)-(height/10))+130)) )
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
		    	}
			    // erik
			    if ( (x>((int)(width*0.61))) && (x<((int)(width*0.61)+130)) && (y>(int)(height)-(height/10)) && (y<((int)((height)-(height/10))+130)) )
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
		    	}
			    // emily
			    if ( (x>((int)(width*0.76))) && (x<((int)(width*0.76)+130)) && (y>(int)(height)-(height/10)) && (y<((int)((height)-(height/10))+130)) )
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
		    	}
			    // myPlayer selected
			    if ( (x>((int)(width/7))) && (x<((int)(width/7)+320)) && (y>(int)(height/5)) && (y<((int)((height/5))+320)) )
		    	{
			    	if (select == 1)
			    	{
			    		selected = imageProvider.getSelectedMyPlayer();
			    		repaint();
			    		select=0;
			    	}
		    	}
			 // comPlayer selected
			    if ( (x>((int)(width*0.61))) && (x<((int)(width*0.61)+320)) && (y>(int)(height/5)) && (y<((int)((height/5))+320)) )
		    	{
			    	if (select == 0)
			    	{
			    		selected = imageProvider.getSelectedComPlayer();
			    		repaint();
			    		select=1;
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
	    g.drawImage(myPlayerSelected, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(comPlayerSelected, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(players, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(done, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(back, 0, 0, getWidth(),getHeight(),this);
	    g.drawImage(selected, 0, 0, getWidth(),getHeight(),this);
	}

}