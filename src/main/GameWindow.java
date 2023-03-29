package main;

import javax.swing.JFrame;

/*
 * Class that controls drawing the game window
 */

public class GameWindow {
	private JFrame jframe;
	
	public GameWindow(GamePanel gamePanel) {
		jframe = new JFrame();
		jframe.setSize(400, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.add(gamePanel);
		
		jframe.setLocationRelativeTo(null);
		
		// Should be called last.
		jframe.setVisible(true);
	}
}
