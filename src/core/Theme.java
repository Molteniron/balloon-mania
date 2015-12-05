package core;

import java.awt.Color;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Theme {
	private Color backColor1, backColor2, balloonColor1, enemyColor1, obstacleColor1;
	private int themeInt;
	private ImageIcon img;
	public Theme(){
		themeInt = 1;
		setBackColor1(Color.green);
		setBackColor2(Color.white);
		setBalloonColor1(Color.cyan);
		setEnemyColor1(Color.black);
		setObstacleColor1(Color.green);
		changeTheme(1);
	}
	public void changeTheme(int themeInt){
		this.themeInt = themeInt;
		if(themeInt == 1){
			img = new ImageIcon("16BitSky.jpg");
		}else if(themeInt == 2){
			img = new ImageIcon("Cloud.jpg");
		}else if(themeInt == 3){
			img = new ImageIcon("MorningSky.jpg");
		}
		
	}
	public int getThemeInt(){
		return themeInt;
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
	public ImageIcon getImg() {
		return img;
	}
		
}
