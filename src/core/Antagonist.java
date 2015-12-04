package core;
import java.awt.*;

public class Antagonist implements MoveHorizontal{
	private double horizontalSpeed;
	private double xPos;
	
	public Antagonist(double horizontalSpeed, double xPos){
		this.horizontalSpeed = horizontalSpeed;
		this.xPos = xPos;
	}

	public double slide (double val){
		xPos += val;
		return xPos;
	}
	
	public double getHorizontalSpeed(){
		return horizontalSpeed;
	}
	
}
