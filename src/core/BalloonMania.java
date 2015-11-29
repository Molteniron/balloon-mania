package core;

public class BalloonMania {

	public static void main(String[] args) {
		// Test..?
		//yo yo yo, this is a test for all you suckaaaaaas
		//yo yo yo, what's up beaches)))))))))((((((((
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);
		
		view.registerListener(controller);
		
	}

}
