package core;

public class Difficulty {
	private double difficultyNum;
	
	public Difficulty(){
		difficultyNum = 0;
	}
	
	public void setDifficulty(int newDifficulty){
		if(newDifficulty > 0 && newDifficulty < 10)
			difficultyNum = newDifficulty;
	}
	
	public double getDifficultyNum(){
		return difficultyNum;
	}
}
