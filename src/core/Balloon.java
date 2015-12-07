package core;

public class Balloon implements MoveVertical{
		private int xPos, yPos, width, height;
		private Difficulty difficulty;
		private double helium, pullStrength;
	public Balloon(Difficulty difficulty) {
		setxPos(100);
		setyPos(400);
		setWidth(50);
		setHeight(50);
		this.difficulty = difficulty;
		helium = difficulty.getSpeed();
		pullStrength = difficulty.getSpeed();
	}

	@Override
	public void raise(double val) {
		setyPos((int)(getyPos() + val));
		
	}

	@Override
	public void move() {
		raise(pullStrength * ( (-15) +  helium) );
		
	}
	
	public void gravity(){
		if (yPos > 0) {
			raise(helium);
		}
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

	public double getHelium() {
		return helium;
	}

	public void increaseHelium() {
		helium -= .5;
	}
	
}
