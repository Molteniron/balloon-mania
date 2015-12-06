package core;

import java.awt.Graphics;

import javax.swing.JPanel;

public class AntagonistPainter extends JPanel {
	private Model model;
	private View view;
	
	public AntagonistPainter(Model model, View view)  {
		this.model = model;
		this.view = view;
	}
	
	public void paintComponent(Graphics g){
		for (Antagonist a : model.getAntagGen().getAntList()) {
			g.drawRect((int) a.getXPos(), (int) a.getYPos(), (int) a.getWidth(), (int) a.getHeight());
		}
	}

}
