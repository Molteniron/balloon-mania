package core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class DifficultyPopUp extends JFrame{
	private Model model;
	private View view;
	private boolean firstPaint;
	private JDialog dialog;
	
	public DifficultyPopUp(Model model, View view) {
		this.model = model;
		this.view = view;
		firstPaint = true;

	}
	public void setUp(){
		dialog = new JDialog(this, "Start Settings", Dialog.ModalityType.APPLICATION_MODAL);
		
		dialog.setBackground(Color.black);
		dialog.setLayout(new GridLayout(8,1));
		
		dialog.add(new JLabel("Diffuclty"));
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
		slider.setName("Difficulty");
		dialog.add(slider);
		view.setMenuController(slider);
		
		dialog.add(new JLabel("Volume"));
		slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		slider.setName("Volume");
		dialog.add(slider);	
		view.setMenuController(slider);
		
		dialog.add(new JLabel("Theme"));
		slider = new JSlider(JSlider.HORIZONTAL, 1, 3, 1);
		slider.setName("Theme");
		dialog.add(slider);
		view.setMenuController(slider);
		
		JButton playButton = new JButton("Play");
		dialog.add(playButton);
		playButton.addActionListener(view.getMenuController());
		
		dialog.addWindowListener(view.getMenuController()); 

	}
	public void drawDiffPop(){
		if(firstPaint == true){
			setUp();
			dialog.setLocation( (int)( model.getPanelWidth() / 2) - 100, (int)(model.getPanelHeight() / 2) - 100);
			dialog.setSize(200, 200);
			firstPaint = false;
		}
		dialog.setVisible(true);
	}
	
	public void closeDiffPop(){
		this.setVisible(false);
	}

}
