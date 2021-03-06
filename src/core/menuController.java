package core;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class menuController extends KeyAdapter implements ActionListener, ChangeListener, WindowListener {
	private Model model;
	private View view;
	private PaintPanel options;
	public menuController(Model model, View view){
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String command = event.getActionCommand();
		if(command.equals("Quit")) {
			view.dispose();
			System.exit(0);
		} else if (command.equals("Pause/Continue")) {
			model.setPause( ! model.getPause() );
		} else if (command.equals("Options")){
			model.setPause(true);
			view.drawOptions();
		} else if(command.equals("Close Options")){
			view.closeOptions();
			model.setPause(false);
		} else if(command.equals("Play")){
			System.out.println("play now");
			model.gameReset();
			model.setPause(false);
			model.setGameOver(false);
			view.closeDiffPop();
			
		}
	}
	public void stateChanged(ChangeEvent e){
		JSlider source = (JSlider)e.getSource();
		if(source.getName() == "Difficulty"){
			model.getDifficulty().setDifficulty(source.getValue());
			System.out.printf("Difficulty = ");
		} else if(source.getName() == "Volume" && model.getVolume() != source.getValue()){
			
				view.getMediaPlayer().setVolume(  (double)source.getValue() / 10.0  );
				model.setVolume(source.getValue());
				//System.out.printf("Volume = %f", view.getMediaPlayer().getVolume());
				
		} else if(source.getName() == "Theme" && model.getTheme().getThemeInt() != source.getValue()){
				
				model.setTheme(source.getValue());
				model.setThemeChanged(true);
				//System.out.printf("Theme = ");
		}
		//System.out.printf("%d\n", source.getValue());
	}
	public void windowClosed(WindowEvent e){
		model.setPause(false);
		model.setGameOver(false);
		System.out.println("closed");
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Clicked");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		model.setPause(false);
		model.setGameOver(false);
		System.out.println("closing");
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
