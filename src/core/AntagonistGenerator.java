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
	 * based on difficulty's attributes.
	 */
	public void generateAntagonist(){
		double xPos = panelWidth + 50; //set to just off screen
		double speed = difficulty.getSpeed();
		double freq = difficulty.getFreq();
		double h, yPos;
		Antagonist antagonist;
		if (rand.nextDouble() < freq) {
			antagonist = new Enemy(speed, xPos, rand.nextDouble()*panelHeight, antagonistWidth, panelHeight / 4);
		} else {
			do {
				h = rand.nextDouble() * maxHeight;
				yPos = rand.nextDouble() * panelHeight;
				yPos -= Math.min(h, yPos);
			}
			while (yPos < minWindow || panelHeight - (h + yPos) < minWindow);
			antagonist = new Obstacle(speed, xPos, yPos, antagonistWidth, h);
		}
		antagonists.add(antagonist);
	}
	
	public void moveAntagonists() {
		int i = 0;
		int j = antagonists.size();
		while (i < j){
			antagonists.get(i).move();
			if (antagonists.get(i).getXPos() + antagonists.get(i).getWidth() < 0){
				antagonists.remove(i);
				i--;
				j--;
			}
			i++;
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
