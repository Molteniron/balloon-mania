package core;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintAntagonists extends JPanel{
	private Model model;
	private View view;
	
	public PaintAntagonists(Model model, View view) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//view.setContentPane(this);
		System.out.println("paintAg");
		g.drawRect(100, 100, 100, 100);
		for (Antagonist a : model.getAntagGen().getAntList()) {
			g.drawRect((int) a.getXPos() - 100, (int) a.getYPos() - 100, (int) a.getWidth(), (int) a.getHeight());
			System.out.println("Drawing an " + a.type + " at " + (a.getXPos() - 100) + ", " + (a.getYPos() - 100));
		}
	}

}
