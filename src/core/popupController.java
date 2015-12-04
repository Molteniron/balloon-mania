package core;

import java.awt.event.MouseAdapter;

public class popupController extends MouseAdapter{
	private Model model;
	private View view;
	
	public popupController(Model model, View view){
		this.model = model;
		this.view = view;
	}
	
}
