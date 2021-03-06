package it.unical.mat.igpe.ultimateDisc.world;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import it.unical.mat.igpe.ultimateDisc.movingObject.Disc;
import it.unical.mat.igpe.ultimateDisc.staticObject.SmallWall;
import it.unical.mat.igpe.ultimateDisc.staticObject.Wall;

public class WorldManager {

	World world;
	
	public World loadWorld(Disc disc,Integer type)
	{
		World currentWorld=null;
		
		// lettura da file in base al type intero ricevuto in input
		// ricorda assegnare la y ad ogni smallWall ( da grafica )
		
		
		String nameFile = Integer.toString(type)+".txt";
		BufferedReader b;
		String s;
		try {
			b = new BufferedReader(new FileReader("txt/"+nameFile));
			s=b.readLine();
			b.close();
			
			String r = "";
			String[] n = s.split(r);
			
			int size = (n.length-1);
			Wall wallPlayer = new Wall(size);
			Wall wallCom = new Wall(size);
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double height = (screenSize.getHeight()*0.75)/5;
			
			for (int i = 1; i < n.length; i++) {
				System.out.println("height:"+height+" i:"+i+" ="+height*(i-1));
				Integer value = Integer.parseInt(n[i]);
				SmallWall smallWall = new SmallWall(value);
				smallWall.setY_position(height*(i-1));
				wallPlayer.addSmallWall(smallWall);
				wallCom.addSmallWall(smallWall);
			}
			
			currentWorld = new WorldImpl(disc, wallPlayer, wallCom);
			world = currentWorld;
			return currentWorld;
			
		}catch (FileNotFoundException e) {
			System.out.println("Campo da gioco Inesistente! ("+nameFile+")");
		}
		catch (IOException e) {
			System.out.println("Impossibile leggere dal file! ("+nameFile+")");
		}
	
		return currentWorld;
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
