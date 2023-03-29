package main;

import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Class that controls drawing the game within the window.
 */

public class GamePanel extends JPanel{
	public GamePanel() {
		
	}
	
	// Override paintComponent from JComponent superclass
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(100, 100, 200, 50);
	}
}
