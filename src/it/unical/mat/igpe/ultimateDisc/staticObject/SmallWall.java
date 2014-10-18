package it.unical.mat.igpe.ultimateDisc.staticObject;

public class SmallWall implements StaticObject {
	
	private int height;
	
	public SmallWall(int height){
		this.height=height;
	}

	@Override
	public int getSize() {
		return height;
	}

	@Override
	public void setSize(int size) {
		this.height=size;
	}

	@Override
	public int getValuePoint() {
		return 0;
	}

	@Override
	public void setValuePoint(int valuePoint) {
	}

}
