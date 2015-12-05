package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		if(firstPrint == true){
			JLabel background = new JLabel();
			background.setName("background");
			background.setIcon(model.getTheme().getImg());
			this.add(background, BorderLayout.NORTH);
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
						this.add(background, BorderLayout.NORTH);
						model.setThemeChanged(false);
	
					}
						
				}
			
			}
		}

	}
}
