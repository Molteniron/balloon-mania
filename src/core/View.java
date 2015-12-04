package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;

public class View extends JFrame{
	private Options options;
	private Model model;
	private JMenu menu;
	private JPopupMenu popupMenu;
	private PaintPanel paintPanel;
	//used to register menu sliders separately from
	//registerListener method
	private menuController menuController;
	
	public View(Model model) {
		this.model = model;
		
		menuController = null;
		options = new Options(model, this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem Pause = new JMenuItem("Pause/Continue");
		menu.add(Pause);
		
		JMenuItem Options = new JMenuItem("Options");
		menu.add(Options);
		
		JMenuItem quit = new JMenuItem("Quit");
		menu.add(quit);
		
		popupMenu = new JPopupMenu();
		popupMenu.add(new JMenuItem("Pause/Continue"));
		popupMenu.add(new JMenuItem("Options"));

		popupMenu.add(new JMenuItem("Quit"));
		
		paintPanel = new PaintPanel(model, this);
		add(paintPanel, BorderLayout.CENTER);
		Dimension size = paintPanel.getSize();
		model.setSize(size.width, size.height);
		
		//lets paintpanel listen to keyboard
		paintPanel.requestFocus();
		
		
	}
	public void registerListener(Controller controller, menuController controller1, popupController controller2) {
		// TODO Auto-generated method stub
		paintPanel.addKeyListener(controller1);
		
		this.addMouseListener(controller2);
		menuController = controller1;
		Component [] components = menu.getMenuComponents();
		for (Component component : components) {
			if( component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller1);
			}
		}
		components = popupMenu.getComponents();
		for( Component component : components) {
			if(component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller1);
			}
		}
	}
	
	public void drawOptions(){
		options.drawOptions();
	}
	public void closeOptions(){
		options.closeOptions();
	}
	public menuController getMenuController(){
		return menuController;
	}
}
