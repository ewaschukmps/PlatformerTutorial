package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

/*
 * Class that controls drawing the game within the window.
 */

public class GamePanel extends JPanel{
	
	MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private float xDir = 0.003f, yDir = 0.003f;
	private Color color = new Color(150, 20, 90);
	private Random random;
	
	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		KeyboardInputs keyboardInputs = new KeyboardInputs(this);
		
		addKeyListener(keyboardInputs);
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
	}
	
	// Override paintComponent from JComponent superclass
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		updateRectangle();
		g.setColor(color);
		g.fillRect((int) xDelta, (int) yDelta, 200, 50);
	}
	
	private void updateRectangle() {
		xDelta += xDir;
		if(xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			color = getRndColor();
		}
		
		yDelta += yDir;
		if(yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			color = getRndColor();
		}
	}
	
	private Color getRndColor() {
		int r = random.nextInt(0, 255);
		int g = random.nextInt(0, 255);
		int b = random.nextInt(0, 255);
		
		return new Color(r, g, b);
	}
}
