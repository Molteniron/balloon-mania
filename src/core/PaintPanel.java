package core;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintPanel extends JPanel{
	private Model model;
	private View view;
	
	public PaintPanel(Model model, View view){
		this.model = model;
		this.view = view;
		
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(model.getTheme().getBackColor1());
		
	}
}
