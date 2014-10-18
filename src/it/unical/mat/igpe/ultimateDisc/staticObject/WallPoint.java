package it.unical.mat.igpe.ultimateDisc.staticObject;


public class WallPoint implements StaticObject {
	
	private int value;
	private int unitSize;
	
	public WallPoint(int value,int size){
		this.value = value;
		this.unitSize = size;
	}

	@Override
	public int getSize() {
		return unitSize;
	}

	@Override
	public void setSize(int size) {
		this.unitSize = size;
	}

	@Override
	public int getValuePoint() {
		return value;
	}

	@Override
	public void setValuePoint(int value) {
		this.value = value;

	}

}
