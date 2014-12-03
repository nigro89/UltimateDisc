package it.unical.mat.igpe.graphics;



import it.unical.mat.igpe.ultimateDisc.GameManager;



import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.util.Hashtable;

import java.util.Map;



class KeyProcessor extends javax.swing.Timer {

    
<<<<<<< HEAD
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final static int KEY_UP = KeyEvent.VK_UP;
=======

    final static int KEY_UP = KeyEvent.VK_UP;

>>>>>>> origin/master
    final static int KEY_DOWN = KeyEvent.VK_DOWN;

    final static int KEY_RIGHT = KeyEvent.VK_RIGHT;

    final static int KEY_LEFT = KeyEvent.VK_LEFT;

    final static int KEY_S = KeyEvent.VK_S;

    final static int KEY_SPACE = KeyEvent.VK_SPACE;

    private final GameManager gameManager;

    final static Toolkit tk = Toolkit.getDefaultToolkit();

    

    Map<Integer,Boolean> keystate = new Hashtable<Integer,Boolean>();

    public KeyProcessor(int delay, ActionListener listener,GameManager gm) {

        super(delay, null);

        this.gameManager=gm;

        keystate.put (KEY_UP,false);

        keystate.put(KEY_DOWN,false);

        keystate.put (KEY_RIGHT,false);

        keystate.put(KEY_LEFT,false);

        keystate.put(KEY_S, false);

        keystate.put(KEY_SPACE, false);

        

        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

            	

            	if(gameManager.getDisc().isAvailableForTheMyPlayer()==false){

	                if (keystate.get(KEY_UP)&&keystate.get(KEY_RIGHT)){

	                	gameManager.getMyPlayer().setDirection(4);

	                }

	                

	                else if (keystate.get(KEY_UP)&&keystate.get(KEY_LEFT)){

	                	gameManager.getMyPlayer().setDirection(5);

	                }

	                	

	                else if (keystate.get(KEY_DOWN)&&keystate.get(KEY_LEFT)){

	                	gameManager.getMyPlayer().setDirection(7);

	                }

	                	

	            	else if (keystate.get(KEY_DOWN)&&keystate.get(KEY_RIGHT)){

	            		gameManager.getMyPlayer().setDirection(6);

	            	}

	            	

	            	else if (keystate.get(KEY_UP)){

	            		gameManager.getMyPlayer().setDirection(0);

	            	}

	                    

	                else if (keystate.get(KEY_DOWN)){

	                	gameManager.getMyPlayer().setDirection(1);

	                }

	                	

	                else if (keystate.get(KEY_LEFT)){

	                	gameManager.getMyPlayer().setDirection(2);

	        			CenterGamePanel.imgpf = tk.getImage("img/retroc.gif");

	                }

	                	

	            	else if (keystate.get(KEY_RIGHT)){

	            		gameManager.getMyPlayer().setDirection(3);

	            	}

            	}

            	

            	else if(gameManager.getDisc().isAvailableForTheMyPlayer()==true){

            		

            		gameManager.getDisc().setDirection(1, 0);

            		

            		if (keystate.get(KEY_UP)){

            			if(CenterGamePanel.getyShoot()>-30)

            				CenterGamePanel.setyShoot(-3);

	            	}

	                    

	                else if (keystate.get(KEY_DOWN)){

	                	if(CenterGamePanel.getyShoot()<30)

	                		CenterGamePanel.setyShoot(3);

	                }
<<<<<<< HEAD
            		
=======

>>>>>>> origin/master
	                else if (keystate.get(KEY_RIGHT)){

	                	CenterGamePanel.setyShoot(0);

	                }
<<<<<<< HEAD
            		
=======

	             

>>>>>>> origin/master
            		if(keystate.get(KEY_SPACE))

            		{
<<<<<<< HEAD
            			if(CenterGamePanel.getxShoot()>=5 && CenterGamePanel.getxShoot()<=40)
            				CenterGamePanel.setxShoot(5);
=======

            			if(CenterGamePanel.getxShoot()>=1 && CenterGamePanel.getxShoot()<=40)

            				CenterGamePanel.setxShoot(10);

>>>>>>> origin/master
            		}

            	}

            	

            	if (keystate.get(KEY_S))

            	{

            		gameManager.getDisc().setDirection(-18, 14);

            		

            	}

            }

        });

    }

    

    public void setKeystate(int keycode, boolean pressed){

        keystate.put(keycode, pressed);

    }

    

}