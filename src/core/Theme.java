package core;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Theme {
	private Color backColor1, backColor2, balloonColor1, enemyColor1, obstacleColor1;
	private int themeInt;
	private ImageIcon img;
	private BufferedImage Sky, Cloud, MorningSky, currentImage;
	public Theme(){
		themeInt = 1;
		setBackColor1(Color.green);
		setBackColor2(Color.white);
		setBalloonColor1(Color.cyan);
		setEnemyColor1(Color.black);
		setObstacleColor1(Color.green);
		try {
			Sky = ImageIO.read(new File("16BitSky.jpg"));
			Cloud = ImageIO.read(new File("Cloud.jpg"));
			MorningSky = ImageIO.read(new File("MorningSky.jpg"));
		}catch (IOException e){ }
		changeTheme(1);
	}
	public void changeTheme(int themeInt){
		this.themeInt = themeInt;
		String imageName = "";
		if(themeInt == 1){
			img = new ImageIcon("16BitSky.jpg");
			currentImage = Sky;
			//imageName = "16BitSky.jpg";
		}else if(themeInt == 2){
			img = new ImageIcon("Cloud.jpg");
			currentImage = Cloud;
			//imageName = "Cloud.jpg";
		}else if(themeInt == 3){
			img = new ImageIcon("MorningSky.jpg");
			currentImage = MorningSky;
			//imageName = "MorningSky.jpg";
		}
		/*try {
			image = ImageIO.read(new File(imageName));
		}catch (IOException e){ }*/
		
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
	public BufferedImage getImage(){
		return currentImage;
	}
		
}
