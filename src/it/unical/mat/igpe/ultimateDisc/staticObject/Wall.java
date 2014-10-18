package it.unical.mat.igpe.ultimateDisc.staticObject;

public class Wall implements StaticObject {
	
	private int height;
	
	public Wall(int height){
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
	public String getValuePoint() {
		return null;
	}

	@Override
	public void setValuePoint(String valuePoint) {
	}

}
