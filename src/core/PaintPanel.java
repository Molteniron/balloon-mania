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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//System.out.println(model.getPause());
		for (Antagonist a : model.getAntagGen().getAntList()) {
			g.drawRect((int) a.getXPos() - 100, (int) a.getYPos() - 100, (int) a.getWidth(), (int) a.getHeight());
			System.out.println("Drawing an Antagonist at " + (a.getXPos() - 100) + ", " + (a.getYPos() - 100));
		}
		if(firstPrint == true){
			System.out.println("first print");
			JLabel background = new JLabel();
			background.setName("background");
			background.setIcon(model.getTheme().getImg());
			this.add(background, BorderLayout.SOUTH);
			//JFrame frame = new JFrame();
			//frame.setLocation(100, 100);
			//this.add(frame, BorderLayout.CENTER);
			
			//JOptionPane optionPane= new JOptionPane("This is an optionPane");
			//this.add(optionPane);
			firstPrint = false;
		} else{
			if(model.isThemeChanged() == true){
				Component [] components = this.getComponents();
				for( Component component : components) {
					if(component.getName() == "background"){
						this.remove(component);
						this.revalidate();
						JLabel background = new JLabel();
						background.setName("background");
						background.setIcon(model.getTheme().getImg());
						this.add(background, BorderLayout.SOUTH);
						model.setThemeChanged(false);
					}	
				} 
			}//end background code
			if(view.getMediaPlayer().getCurrentTime().equals(Duration.millis(183000.0)) ){
				System.out.println("trying to replay");
				view.getMediaPlayer().seek(Duration.ZERO);
			}
		}//end else

	}
	
}
