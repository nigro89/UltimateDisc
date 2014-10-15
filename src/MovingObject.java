public interface MovingObject {

	public abstract int getX();
	public abstract int getY();
	public abstract void setDirection(int x, int y);
	public abstract void update();
	public abstract void reset();
}
