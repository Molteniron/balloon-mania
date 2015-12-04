package core;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class View extends JFrame{
	private Options options;
	private Model model;
	private JMenu menu;
	private JPopupMenu popupMenu;
	private PaintPanel paintPanel;
	public View(Model model) {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("options");
		menuBar.add(menu);
		
		JMenuItem volume = new JMenuItem("Volume");
		menu.add(volume);
		
		JMenuItem difficulty = new JMenuItem("Difficulty");
		menu.add(difficulty);
		
		JMenuItem theme = new JMenuItem("Theme");
		menu.add(theme);
		
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(quit);
		
		popupMenu = new JPopupMenu();
		popupMenu.add(new JMenuItem("Volume"));
		popupMenu.add(new JMenuItem("Difficulty"));
		popupMenu.add(new JMenuItem("Theme"));
		popupMenu.add(new JMenuItem("Quit"));
		
		
	}
	public void registerListener(Controller controller) {
		// TODO Auto-generated method stub
		
	}

}
