package main;

import java.awt.Graphics;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

/*
 * Class that controls drawing the game within the window.
 */

public class GamePanel extends JPanel{
	private int xDelta = 100, yDelta = 100;
	
	public GamePanel() {
		MouseInputs mouseInputs = new MouseInputs(this);
		KeyboardInputs keyboardInputs = new KeyboardInputs(this);
		
		addKeyListener(keyboardInputs);
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	
	// Override paintComponent from JComponent superclass
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(xDelta, yDelta, 200, 50);
	}
}
