package core;

public class Enemy extends Antagonist implements MoveVertical{
	private double horizontalSpeed;
	private double xPos;
	private double yPos;
	private double xSpawn;
	private double ySpawn;
	private double moveRadius;
	
	public Enemy(double horizontalSpeed, double xSpawn, double ySpawn, double width, double moveRadius){
		super(horizontalSpeed, xSpawn, ySpawn, width);
		this.ySpawn = ySpawn;
		this.xSpawn = xSpawn;
		this.moveRadius = moveRadius;
	}
	
	/**
	 * move in sin wave to the left
	 */
	public void move(){
		raise(Math.atan(Math.tan(yPos-ySpawn/xPos-xSpawn))*horizontalSpeed*moveRadius);
		slide(horizontalSpeed);
	}
	
	public double raise(double val){
		yPos += val;
		return yPos;
	}
	

}
