package core;

public class Antagonist implements MoveHorizontal{
	private double horizontalSpeed;
	private double yPos;
	private double xPos;
	private double width;
	
	public Antagonist(double horizontalSpeed, double xPos, double yPos, double width){
		this.horizontalSpeed = horizontalSpeed;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
	}
	
	public void move (){
		slide(horizontalSpeed);
	}

	public double slide (double val){
		xPos += val;
		return xPos;
	}
	
	public double getHorizontalSpeed(){
		return horizontalSpeed;
	}
	
	public double getXPos(){
		return xPos;
	}
	
	public double getYPos(){
		return yPos;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return width;
	}
	
}
