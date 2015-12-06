package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class RepaintController implements ActionListener{
	private Model model;
	private View view;
	public RepaintController(Model model, View view){
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		model.getAntagGen().moveAntagonists();
		view.repaint();
		
	}

}
