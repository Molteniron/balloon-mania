package core;

import java.awt.Color;

public class Theme {
	private Color backColor1, backColor2, balloonColor1, enemyColor1, obstacleColor1;
	
	public Theme(){
		setBackColor1(Color.blue);
		setBackColor2(Color.white);
		setBalloonColor1(Color.cyan);
		setEnemyColor1(Color.black);
		setObstacleColor1(Color.green);
	}

	public Color getBackColor1() {
		return backColor1;
	}

	public void setBackColor1(Color backColor1) {
		this.backColor1 = backColor1;
	}

	public Color getBackColor2() {
		return backColor2;
	}

	public void setBackColor2(Color backColor2) {
		this.backColor2 = backColor2;
	}

	public Color getBalloonColor1() {
		return balloonColor1;
	}

	public void setBalloonColor1(Color balloonColor1) {
		this.balloonColor1 = balloonColor1;
	}

	public Color getEnemyColor1() {
		return enemyColor1;
	}

	public void setEnemyColor1(Color enemyColor1) {
		this.enemyColor1 = enemyColor1;
	}

	public Color getObstacleColor1() {
		return obstacleColor1;
	}

	public void setObstacleColor1(Color obstacleColor1) {
		this.obstacleColor1 = obstacleColor1;
	}
	
}
