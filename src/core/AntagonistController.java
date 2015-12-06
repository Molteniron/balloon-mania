package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AntagonistController implements ActionListener {
	private Model model;
	private View view;
	
	public AntagonistController(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.getAntagGen().generateAntagonist();

	}

}
