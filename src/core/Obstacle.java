package core;

public class Obstacle extends Antagonist{
	private double height;
	
	public Obstacle(double horizontalSpeed, double xPos, double yPos, double width, double height){
		super(horizontalSpeed, xPos, yPos, width);
		this.height = height;
	}
	
	public double getHeight(){
		return height;
	}
	
}
