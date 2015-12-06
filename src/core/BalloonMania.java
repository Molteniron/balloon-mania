package core;

import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.Timer;

public class BalloonMania {

	public static void main(String[] args)   {
		// Test..?
		//yo yo yo, this is a test for all you suckaaaaaas
		//yo yo yo, what's up beaches)))))))))((((((((
		int panelWidth = 1200;
		int panelHeight = 900;
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);
		menuController menuController = new menuController(model, view);
		view.registerListener(controller, menuController);
		
		RepaintController repaintController = new RepaintController(model, view);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(panelWidth,panelHeight);
		view.sizeSetting();
		view.setVisible(true);
		
		AntagonistController antagonistController = new AntagonistController(model, view);
		new Timer(3000, antagonistController).start();
		
		new Timer(25, repaintController).start();
		
	}

}
