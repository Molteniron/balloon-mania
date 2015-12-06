package core;

import java.util.ArrayList;
import java.util.Random;

public class AntagonistGenerator {
	private ArrayList<Antagonist> antagonists;
	private double maxHeight, minWindow;
	private Difficulty difficulty;
	private Random rand;
	private double panelWidth, panelHeight;
	private double antagonistWidth;
	
	public AntagonistGenerator(Difficulty difficulty, double panelWidth, double panelHeight){
		antagonists = new ArrayList<Antagonist>();
		this.difficulty = difficulty;
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		minWindow = panelHeight / 4;
		maxHeight = panelHeight - minWindow;
		antagonistWidth = panelHeight / 12;
		rand = new Random();
	}
	public ArrayList<Antagonist> getAntList(){
		return antagonists;
	}
	
	/**
	 * generate an Antagonist and add it to the Arraylist.
	 * Antagonists will be randomly selected as Enemy or Obstacle 
	 * based on Difficulty (0-10). Difficulty also determines Antagonist
	 * speed.
	 */
	public void generateAntagonist(){
		double xPos = panelWidth + 50; //set to just off screen
		double diff = difficulty.getDifficultyNum();
		double h, yPos;
		Antagonist antagonist;
		if (rand.nextInt(100) < diff*10) {
			antagonist = new Enemy(0 - diff - 1, xPos, rand.nextDouble()*panelHeight, antagonistWidth, panelHeight / 4);
		} else {
			do {
				h = rand.nextDouble() * maxHeight;
				yPos = rand.nextDouble() * panelHeight;
				yPos -= Math.min(h, yPos);
			}
			while (yPos < minWindow || panelHeight - (h + yPos) < minWindow);
			antagonist = new Obstacle(0 - diff - 1, xPos, yPos, antagonistWidth, h);
		}
		antagonists.add(antagonist);
	}
	
	public void moveAntagonists() {
		int i;
		for (i = 0; i < antagonists.size(); i++) {
			antagonists.get(i).move();
		}
		
	}
	
	/*
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
	*/
}
