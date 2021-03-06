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
	private JPanel optionsPanel;
	private boolean firstPaint;
	public Options(Model model, View view){
		theme = new Theme();
		this.model = model;
		this.view = view;
		optionsPanel = new JPanel();
		firstPaint = true;

	}

	public void drawOptions(){
		
		if(firstPaint == true){
			optionsPanel.setEnabled(true);
			add(optionsPanel);
			optionsPanel.setBackground(Color.white);
			optionsPanel.requestFocus();
			optionsPanel.setLayout(new GridLayout(3,1));
		
			optionsPanel.add(new JLabel("Volume"));
			JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, (int)model.getVolume());
			slider.setName("Volume");
			optionsPanel.add(slider);
		
			optionsPanel.add(new JLabel("Theme"));
			slider = new JSlider(JSlider.HORIZONTAL, 1 ,3, model.getTheme().getThemeInt());
			slider.setName("Theme");
			optionsPanel.add(slider);
		
			Component [] components = optionsPanel.getComponents();
			for (Component component : components) {
				if( component instanceof JSlider ) {
					JSlider slide = (JSlider) component;
					view.setMenuController(slide);
				}
			}
			
			JButton closeButton = new JButton("Close Options");
			optionsPanel.add(closeButton);
			closeButton.addActionListener(view.getMenuController());
			this.setLocation( ((int)model.getPanelWidth() + 50), 10);
			this.setSize(400, 400);
			firstPaint = false;
			this.addWindowListener(view.getMenuController());
			
		}
		this.setVisible(true);
	}
	public void closeOptions(){
		this.setVisible(false);
		
	}
	 
}
