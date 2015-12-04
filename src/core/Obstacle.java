package core;
import java.awt.*;

public class Obstacle extends Antagonist{
	private double xPos;
	private double yPos;
	private double width;
	private double height;
	private double horizontalSpeed;
	
	public Obstacle(double xPos, double yPos, double width, double height, double horizontalSpeed){
		super(horizontalSpeed, xPos);
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	public void move(){
		slide(horizontalSpeed);
	}
}
