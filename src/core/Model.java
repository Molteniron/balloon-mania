package core;

public class Model {
	private AntagonistGenerator ag;
	private int height, period;
	private Difficulty difficulty;
	public Model(){
		height = 5;
		period = 5;
		difficulty = new Difficulty();
		ag = new AntagonistGenerator(height, period, difficulty);
		
	}
	
	public int getHeight(){
		return height;
	}
	public void setHeight(int val){
		height = val;
	}
	public int getPeriod(){
		return period;
	}
	public void setPeriod(int val){
		period = val;
	}
}
