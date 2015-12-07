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
	private Difficulty difficulty;
	private boolean firstPaint;
	private JPanel popPanel;
	public DifficultyPopUp(Model model, View view) {
		this.model = model;
		this.view = view;
		difficulty = model.getDifficulty();
		popPanel = new JPanel();
		firstPaint = true;
	}
	
	public void drawDiffPop(){
		if(firstPaint == true){
	
			JDialog dialog = new JDialog(this, "Start Settings", Dialog.ModalityType.APPLICATION_MODAL);
			

			dialog.setBackground(Color.black);
			dialog.setLayout(new GridLayout(7,1));
			
			dialog.add(new JLabel("Diffuclty"));
			JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
			slider.setName("Difficulty");
			dialog.add(slider);
			//slider.addChangeListener(view.getMenuController());
			view.setMenuController(slider);
			
			dialog.add(new JLabel("Volume"));
			slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
			slider.setName("Volume");
			dialog.add(slider);	
			//slider.addChangeListener(view.getMenuController());
			view.setMenuController(slider);
			
			dialog.add(new JLabel("Theme"));
			slider = new JSlider(JSlider.HORIZONTAL, 1, 3, 1);
			slider.setName("Theme");
			dialog.add(slider);
			//slider.addChangeListener(view.getMenuController());
			view.setMenuController(slider);
			
			JButton playButton = new JButton("Play");
			dialog.add(playButton);
			playButton.addActionListener(view.getMenuController());
			dialog.setLocation( (int)( model.getPanelWidth() / 2) - 100, (int)(model.getPanelHeight() / 2) - 100);
			//dialog.setSize(400, 400);
			firstPaint = false;
			dialog.addWindowListener(view.getMenuController()); 
			dialog.setSize(200, 200);
			dialog.setVisible(true);
			//this.add(dialog);
			
			}
		}
	public void closeDiffPop(){
		this.setVisible(false);
	}

}
