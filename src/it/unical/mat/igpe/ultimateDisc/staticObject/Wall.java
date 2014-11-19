package it.unical.mat.igpe.ultimateDisc.staticObject;

import java.util.Vector;


public class Wall implements StaticObject {
	
	private int size;
	private Vector<SmallWall> arrayBlock;
	
	public Wall(int size){
		this.size=size;
	}

	public void addSmallWall(SmallWall block)
	{
		arrayBlock.add(block);
	}
	
	
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getValuePoint(double y) {
		
		if (arrayBlock.size()==size)
		{
			for (int i = (size-1); i <= 0; i--) {
				if(arrayBlock.get(i).getY_position() >= y)
					return arrayBlock.get(i).getValuePoint(y);
			}
			return -1;
		}		
		return -1;
	}

	@Override
	public void setValuePoint(int value) {

	}

}
