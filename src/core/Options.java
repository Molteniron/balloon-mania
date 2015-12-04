package core;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Options extends JFrame {
	private Theme theme;
	private Difficulty difficulty;
	private Model model;
	private View view;
	private PaintPanel optionsPanel;
	private boolean firstPaint;
	public Options(Model model, View view){
		theme = new Theme();
		difficulty = new Difficulty();
		this.model = model;
		this.view = view;
		optionsPanel = new PaintPanel(model, view);
		firstPaint = true;

	}

	public void drawOptions(){
		//optionsPanel.repaint();
		if(firstPaint == true){
			optionsPanel.setEnabled(true);
			add(optionsPanel);
			optionsPanel.setBackground(Color.white);
			optionsPanel.requestFocus();
			optionsPanel.setLayout(new GridLayout(4,1));
		
			optionsPanel.add(new JLabel("Difficulty"));
			JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
			slider.setName("Difficulty");
			optionsPanel.add(slider);
		
			optionsPanel.add(new JLabel("Volume"));
			slider = new JSlider(JSlider.HORIZONTAL, 1, 11, 5);
			slider.setName("Volume");
			optionsPanel.add(slider);
		
			optionsPanel.add(new JLabel("Theme"));
			slider = new JSlider(JSlider.HORIZONTAL, 1 ,4, 1);
			slider.setName("Theme");
			optionsPanel.add(slider);
		
			Component [] components = optionsPanel.getComponents();
			for (Component component : components) {
				if( component instanceof JSlider ) {
					JSlider slide = (JSlider) component;
					slide.addChangeListener(view.getMenuController());
				}
			}
		
			JButton closeButton = new JButton("Close Options");
			optionsPanel.add(closeButton);
			closeButton.addActionListener(view.getMenuController());
			this.setLocation(600, 10);
			this.setSize(400, 400);
			firstPaint = false;
			
		}
		this.setVisible(true);
	}
	public void closeOptions(){
		//optionsPanel.setEnabled(false);
		//remove(optionsPanel);
		this.setVisible(false);
		
	}
	 
}
