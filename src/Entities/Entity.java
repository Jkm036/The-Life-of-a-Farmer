package Entities;


public abstract class Entity {
protected int x;
protected int y;
	
	
	public abstract void tick();
	public abstract void render();

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
