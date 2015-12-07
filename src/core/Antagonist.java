package core;

public class Antagonist implements MoveHorizontal{
	private double horizontalSpeed;
	private double yPos;
	private double xPos;
	private double width;
	public String type;
	
	public Antagonist(double horizontalSpeed, double xPos, double yPos, double width){
		this.horizontalSpeed = horizontalSpeed;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		type = "";
	}
	
	public void move (){
		slide(horizontalSpeed);
	}

	public void slide (double val){
		xPos += val;
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

	public void setXPos(double val){
		xPos = val;
	}
	
	public void setYPos(double val){
		yPos = val;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return width;
	}
	
}
