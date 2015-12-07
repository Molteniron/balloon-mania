package core;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintBackground extends JPanel{
	private Model model;
	private View view;
	public PaintBackground(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	public void paintComponenet(Graphics g){
		super.paintComponent(g);
		g.drawImage(model.getTheme().getImage(), 0, 0, null);
	}

}
