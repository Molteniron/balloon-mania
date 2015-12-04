package core;

public class Enemy extends Antagonist implements MoveVertical{
	private double horizontalSpeed;
	private double xPos;
	private double yPos;
	private double ySpawn;
	private double xSpawn;
	private double radius;
	private double yRadius;
	
	public Enemy(double horizontalSpeed, double xSpawn, double radius, double ySpawn, double yRadius){
		super(horizontalSpeed, xSpawn);
		this.radius = radius;
		this.ySpawn = ySpawn;
		this.xSpawn = xSpawn;
		this.yPos = ySpawn;
		this.yRadius = yRadius;
	}
	
	/**
	 * move in sin wave to the left
	 */
	public void move(){
		raise(Math.atan(Math.tan(yPos-ySpawn/xPos-xSpawn))*horizontalSpeed*yRadius);
		slide(horizontalSpeed);
	}
	
	public double raise(double val){
		yPos += val;
		return yPos;
	}
	
	public double getXPos(){
		return xPos;
	}
	
	public double getYPos(){
		return yPos;
	}
	
	public double getRadius(){
		return radius;
	}
	

}
