package main;

import javax.swing.JFrame;

/*
 * Class that controls drawing the game window
 */

public class GameWindow {
	private JFrame jframe;
	
	public GameWindow(GamePanel gamePanel) {
		jframe = new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.pack();
		
		// Should be called last.
		jframe.setVisible(true);
	}
}
