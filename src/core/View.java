package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class View extends JFrame{
	private Options options;
	private Model model;
	private JMenu menu;
	private JPopupMenu popupMenu;
	private PaintPanel paintPanel;
	private JLabel background;
	private MediaPlayer mediaPlayer;
	private PaintAntagonists paintAg;
	//used to register menu sliders separately from
	//registerListener method
	private menuController menuController;
	private JLayeredPane layer;
	
	public View(Model model)    {
		this.model = model;
		//need to initialize JFXPanel like this in order to play music.
		new JFXPanel();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(900, 900);
		menuController = null;
		options = new Options(model, this);
		//PaintView paintView = new PaintView(model, this);
		//add(paintView);
		JLayeredPane layer = new JLayeredPane();
		//add(layer);
		//paintView.add(layer);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//layer.add(menuBar, 1);
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
		
		paintAg = new PaintAntagonists(model, this);
		add(paintAg);
		//paintView.add(paintAg, BorderLayout.CENTER);
		//layer.setLayer(paintAg, new Integer(0) );
		//layer.add(paintAg, 0);
		paintPanel = new PaintPanel(model, this);
		add(paintPanel);
		//paintView.add(paintPanel, BorderLayout.CENTER);
		//layer.setLayer(paintPanel, new Integer(1) );
		//layer.add(paintPanel, 0);

	//	add(paintAg);
		this.add(layer, BorderLayout.CENTER);
		this.setContentPane(paintPanel);
		background = null;

		
		File file = new File("Underclocked.mp3");
		Media music = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(music);
		mediaPlayer.setStopTime(Duration.seconds(183));
		mediaPlayer.setVolume(.5);
		mediaPlayer.play();
		
		
		
		
	
		//lets paintpanel listen to keyboard
		//paintPanel.requestFocus();
		
	}

	public void sizeSetting(){
		Dimension size = this.getSize();
		model.setSize(size.width, size.height);
		
		//System.out.println(this.getSize().toString());
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
	
	public MediaPlayer getMediaPlayer(){
		return mediaPlayer;
	}
	public JLayeredPane getLayer() {
		return layer;
	}
	public PaintAntagonists getPaintAg(){
		return paintAg;
	}
	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	/*public void setLayer(JLayeredPane layer) {
		this.layer = layer;
	}*/
}
