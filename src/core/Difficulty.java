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
		difficultyNum = newDifficulty % 6;
		setSpeed();
		setFreq();
		setTime();
	}
	
	private void setSpeed(){
		switch (difficultyNum){
		case 0: speed = -.5 * 2;
		break;
		case 1: speed = -1 * 2;
		break;
		case 2: speed = -1.5 * 2;
		break;
		case 3: speed = -2.5 * 2;
		break;
		case 4: speed = -3.5 * 2;
		break;
		case 5: speed = -4 * 2;
		break;
		}
	}
	
	private void setFreq(){
		switch (difficultyNum){
		case 0: freq = 0;
		break;
		case 1: freq = .1;
		break;
		case 2: freq = .2;
		break;
		case 3: freq = .4;
		break;
		case 4: freq = .75;
		break;
		case 5: freq = 1;
		break;
		}
	}

	private void setTime(){
		switch (difficultyNum){
		case 0: time = 5000;
		break;
		case 1: time = 4000;
		break;
		case 2: time = 3000;
		break;
		case 3: time = 2000;
		break;
		case 4: time = 1500;
		break;
		case 5: time = 1000;
		break;
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
