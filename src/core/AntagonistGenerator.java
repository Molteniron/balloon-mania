package core;

import java.util.ArrayList;
import java.util.Random;

public class AntagonistGenerator {
	private ArrayList<Antagonist> antagonists;
	private int maxHeight, minWindow, enemyProximity, enemyPeriod;
	private Difficulty difficulty;
	private Random random;
	private double panelWidth, panelHeight;
	
	public AntagonistGenerator(int height, int period, Difficulty difficulty, double panelWidth, double panelHeight){
		this.maxHeight = height;
		this.enemyPeriod = period;
		this.difficulty = difficulty;
		Random random = new Random();
	}
	public ArrayList<Antagonist> getAntList(){
		return antagonists;
	}
	
	public Antagonist generateAntagonist(){
		double xpos = panelWidth + 50; //set to just off screen
		double speed = difficulty.getDifficultyNum();
		Antagonist antagonist = new Antagonist(speed, xpos);
		antagonists.add(antagonist);
		return antagonist;
	}
	
	public void setEnemyProximity(int val){
		
	}
	
	public Obstacle generateObstacle(){
		double xpos = panelWidth + 50; //set to just off screen
		double ypos = random.nextDouble() * panelHeight;
		double width = 50;
		double height = random.nextDouble() * maxHeight;
		double speed = difficulty.getDifficultyNum();
		Obstacle obstacle = new Obstacle(xpos, ypos, width, height, speed);
		return obstacle;
	}
	
	public Enemy generateEnemy(){
		double speed = difficulty.getDifficultyNum();
		double xSpawn = panelWidth + 50;
		double radius = 10;
		double ySpawn = random.nextDouble() * panelHeight;
		//what is yRadius?
		double yRadius = 10;
		Enemy enemy = new Enemy(speed, xSpawn, radius, ySpawn, yRadius);
		return enemy;
	}
}
