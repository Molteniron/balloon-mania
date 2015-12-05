package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
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
	private JLabel background;
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
		
		background = null;
		//this.background = new JLabel("", model.getTheme().getImg(), JLabel.CENTER);
		//paintPanel.add(background, BorderLayout.CENTER);
		
		//lets paintpanel listen to keyboard
		paintPanel.requestFocus();
		
	}
	public void sizeSetting(){
		Dimension size = this.getSize();
		model.setSize(size.width, size.height);
		
		System.out.println(this.getSize().toString());
	}
	public void registerListener(Controller controller, menuController controller1) {
		// TODO Auto-generated method stub
		paintPanel.addKeyListener(controller1);
		
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
	//used so Options can add listeners to its stuff.
	public menuController getMenuController(){
		return menuController;
	}
	
	public JLabel returnBackground(){
		return background;
	}
	public void setBackground(JLabel background){
		this.background = background;
		/*JLabel background1 = new JLabel("", model.getTheme().getImg(), JLabel.CENTER);
		paintPanel.add(background1);
		if(background == null){
			System.out.println(model.getTheme().getThemeInt());
		}*/
	}
	public void removeBackground(JLabel background){
		remove(background);
	}
}
