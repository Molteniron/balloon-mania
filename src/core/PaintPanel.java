package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class PaintPanel extends JPanel{
	private Model model;
	private View view;
	private boolean firstPrint;
	public PaintPanel(Model model, View view){
		this.model = model;
		this.view = view;
		firstPrint = true;
		this.setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//System.out.println("paintPanel");
		
		//drawBackground
		g.drawImage(model.getTheme().getImage(), 0, 0, null);
		//g.drawImage(model.getTheme().getBalloonImg(), 100, 100, null);
		//drawBalloon
		Balloon balloon = model.getBalloon();
		if(balloon != null)
			//g.fillRect(balloon.getxPos(), balloon.getyPos(), balloon.getWidth(), balloon.getHeight());
			g.drawImage(model.getTheme().getBalloonImg(), balloon.getxPos(), balloon.getyPos(), null);
		if(firstPrint == true || model.isGameOver() == true){
			firstPrint = false;
			view.drawDiffPop();		
		} else{
			if(view.getMediaPlayer().getCurrentTime().equals(Duration.millis(183000.0)) ){
				System.out.println("trying to replay");
				view.getMediaPlayer().seek(Duration.ZERO);
			}
		}//end else
		view.getPaintAg().paintComponent(g);
	}
	
	
}
