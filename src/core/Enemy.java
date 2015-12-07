package core;

public class Enemy extends Antagonist implements MoveVertical{
	private double xSpawn;
	private double ySpawn;
	private double moveRadius;
	
	public Enemy(double horizontalSpeed, double xSpawn, double ySpawn, double width, double moveRadius){
		super(horizontalSpeed, xSpawn, ySpawn, width);
		this.ySpawn = ySpawn;
		this.xSpawn = xSpawn;
		this.moveRadius = moveRadius;
		type = "Enemy";
	}
	
	/**
	 * move in sin wave to the left
	 */
	public void move(){
		raise(Math.asin(Math.sin((xSpawn-getXPos()) / 50))*moveRadius / 4);
		slide(getHorizontalSpeed());
	}
	
	public void raise(double val){
		setYPos(getYPos() + val);
	}
	

}
