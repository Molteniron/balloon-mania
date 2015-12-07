package core;

public class Difficulty {
	private int  difficultyNum;
	private double speed;
	private double freq;
	private int time;
	

	public Difficulty(){
		difficultyNum = 1;
		setSpeed();
		setFreq();
		setTime();
	}
	
	public Difficulty(int num){
		difficultyNum = num % 6;
		setSpeed();
		setFreq();
		setTime();
	}
	
	public void setDifficulty(int newDifficulty){
		if(newDifficulty >= 0 && newDifficulty <= 5)
			difficultyNum = newDifficulty;
		setSpeed();
		setFreq();
		setTime();
	}
	
	private void setSpeed(){
		switch (difficultyNum){
		case 0: speed = -.5 * 1;
		case 1: speed = -1 * 1;
		case 2: speed = -1.5 * 1;
		case 3: speed = -2.5 * 1;
		case 4: speed = -3.5 * 1;
		case 5: speed = -5 * 1;
		}
	}
	
	private void setFreq(){
		switch (difficultyNum){
		case 0: freq = 0;
		case 1: freq = .1;
		case 2: freq = .2;
		case 3: freq = .4;
		case 4: freq = .75;
		case 5: freq = 1;
		}
	}

	private void setTime(){
		switch (difficultyNum){
		case 0: time = 3000;
		case 1: time = 2800;
		case 2: time = 2500;
		case 3: time = 2200;
		case 4: time = 1800;
		case 5: time = 1500;
		}
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public double getFreq(){
		return freq;
	}
	
	public int getTime(){
		return time;
	}
}
