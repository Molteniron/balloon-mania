package core;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintAntagonists extends JPanel{
	private Model model;
	private View view;
	
	public PaintAntagonists(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(model.isGameOver() == false){
			for (Antagonist a : model.getAntagGen().getAntList()) {
				g.drawRect((int) a.getXPos(), (int) a.getYPos() , (int) a.getWidth(), (int) a.getHeight());
				System.out.println("Drawing an " + a.type + " at " + (a.getXPos()) + ", " + (a.getYPos()));
			}
		}
	}

}
