package it.unical.mat.igpe.ultimateDisc.staticObject;

public class SmallWall implements StaticObject {
	
	private double y_position;
	private int value;
	
	public SmallWall(int value){
		this.value=value;
		this.y_position=0;
	}

	public double getY_position() {
		return y_position;
	}

	public void setY_position(double y_position) {
		this.y_position = y_position;
	}

	
	@Override
	public int getSize() {
		return 1;			
	}

	@Override
	public void setSize(int size) {
		
	}

	@Override
	public int getValuePoint(double y) {
		return value;
	}

	@Override
	public void setValuePoint(int valuePoint) {
		this.value=valuePoint;
	}


}
