package core;

public class Model {
	private AntagonistGenerator ag;
	private int antagHeight, period;
	private Difficulty difficulty;
	private Theme theme;
	
	private double panelWidth, panelHeight;
	private double score;
	private boolean pause, themeChanged, gameOver;
	private double volume;
	private Balloon balloon;
	public Model(){
		theme = new Theme();
		setScore(0);
		setVolume(5);
		antagHeight = 5;
		period = 5;
		difficulty = new Difficulty();
		pause = true;
		//setBalloon(new Balloon());
		setThemeChanged(false);
		setGameOver(true);
	}
	public void gameReset(){
		pause = true;
		setBalloon(new Balloon(difficulty));
		ag = new AntagonistGenerator( difficulty, panelWidth, panelHeight);
	}
	public AntagonistGenerator getAntagGen(){
		return ag;
	}
	public Difficulty getDifficulty(){
		return difficulty;
	}
	public int getAntagonistHeight(){
		return antagHeight;
	}
	public void setHeight(int val){
		antagHeight = val;
	}
	public int getPeriod(){
		return period;
	}
	public void setPeriod(int val){
		period = val;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setSize(int width, int height) {
		panelWidth = width;
		panelHeight = height;
		//ag = new AntagonistGenerator( difficulty, panelWidth, panelHeight);
	}
	public double getPanelWidth(){
		return panelWidth;
	}
	public double getPanelHeight(){
		return panelHeight;
	}
	public void setPause(boolean pause){
		this.pause = pause;
	}
	public boolean getPause() {
		// TODO Auto-generated method stub
		return pause;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(int themeInt) {
		theme.changeTheme(themeInt);
	}

	public boolean isThemeChanged() {
		return themeChanged;
	}

	public void setThemeChanged(boolean themeChanged) {
		this.themeChanged = themeChanged;
	}

	public Balloon getBalloon() {
		return balloon;
	}

	public void setBalloon(Balloon balloon) {
		this.balloon = balloon;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public void checkForCollision(){
		for (Antagonist a : getAntagGen().getAntList()){
			if (a.getXPos() < balloon.getxPos() + balloon.getWidth() && a.getXPos() + a.getWidth() > balloon.getxPos()){
				//Vertically Aligned
				if (a.getYPos() < balloon.getyPos() + balloon.getHeight() && a.getYPos() + a.getHeight() > balloon.getyPos()){
					//Horizontally aligned
					setGameOver(true);
				}
			}
		}
		if (balloon.getyPos() == 0 ) {
			setGameOver(true);
		}
		if (balloon.getyPos() + balloon.getHeight() + 60 > panelHeight) {
			setGameOver(true);
		}
	}

}
