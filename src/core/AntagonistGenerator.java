package core;

import java.util.ArrayList;

public class AntagonistGenerator {
	private ArrayList<Antagonist> antagonists;
	private int maxHeight, minWindow, enemyProximity, enemyPeriod;
	private Difficulty difficulty;
	
	public AntagonistGenerator(int height, int period, Difficulty difficulty){
		this.maxHeight = height;
		this.enemyPeriod = period;
		this.difficulty = difficulty;
	}
	public ArrayList<Antagonist> getAntList(){
		return antagonists;
	}
	
	public Antagonist generateAntagonist(){
		Antagonist antagonist = new Antagonist();
		antagonists.add(antagonist);
		return antagonist;
	}
	
	public void setEnemyProximity(int val){
		
	}
	
	public Obstacle generateObstacle(){
		Obstacle obstacle = new Obstacle();
		return obstacle;
	}
	public Enemy generateEnemy(){
		Enemy enemy = new Enemy();
		return enemy;
	}
}
