package core;

public class Balloon implements MoveVertical{
		private int xPos, yPos, width, height;
	public Balloon() {
		setxPos(100);
		setyPos(100);
		setWidth(50);
		setHeight(50);
	}

	@Override
	public void raise(double val) {
		setyPos((int)(getyPos() + val));
		
	}

	@Override
	public void move() {
		raise(10);
		
	}
	
	public void gravity(double val){
		raise(-val);
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
