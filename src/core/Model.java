package core;

public class Model {
	private AntagonistGenerator ag;
	private int antagHeight, period;
	private Difficulty difficulty;
	private Theme theme;
	
	private double panelWidth, panelHeight;
	private double score;
	private boolean pause, themeChanged;
	private double volume;
	public Model(){
		theme = new Theme();
		setScore(0);
		setVolume(5);
		antagHeight = 5;
		period = 5;
		difficulty = new Difficulty();
		pause = false;
		setThemeChanged(true);
	}
	
	public AntagonistGenerator getAntagGen(){
		ag = new AntagonistGenerator(antagHeight, period, difficulty, panelWidth, panelHeight);
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
}
