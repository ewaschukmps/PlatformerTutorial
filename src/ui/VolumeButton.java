package ui;



import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.LoadSave;
import static utils.Constants.UI.VolumeButtons.*;

public class VolumeButton extends PauseButton {
	
	private BufferedImage[] imgs;
	private BufferedImage slider;
	
	private int index = 0;
	private int buttonX, minX, maxX;
	private boolean mouseOver, mousePressed;
	
	protected VolumeButton(int x, int y, int width, int height) {
		super(x + width/2, y, VOLUME_WIDTH, height);
		bounds.x -= VOLUME_WIDTH / 2;
		
		this.x = x;
		this.width = width;
		
		minX = x + (VOLUME_WIDTH / 2);
		maxX = x + width - (VOLUME_WIDTH / 2);

		buttonX = x + width / 2;
		loadVolumeImages();
	}

	private void loadVolumeImages() {
		BufferedImage tmp = LoadSave.getSpriteAtlas(LoadSave.VOLUME_BUTTONS); 
		imgs = new BufferedImage[3];
		
		for (int i = 0; i < imgs.length; i ++)
			imgs[i] = tmp.getSubimage(i * VOLUME_WIDTH_DEFAULT, 0, VOLUME_WIDTH_DEFAULT, VOLUME_HEIGHT_DEFAULT);
		
		slider = tmp.getSubimage(3 * VOLUME_WIDTH_DEFAULT, 0, SLIDER_WIDTH_DEFAULT, VOLUME_HEIGHT_DEFAULT);
	}

	public void update() {
		index = 0;
		if (mouseOver) 
			index = 1;
		if (mousePressed)
			index = 2;
	}
	
	public void draw(Graphics g) {
		g.drawImage(slider, x, y, width, height, null);
		g.drawImage(imgs[index], buttonX - (VOLUME_WIDTH / 2), y, VOLUME_WIDTH, height, null);
	}
	
	public void changeX(int x) {
		if (x < minX)
			buttonX = minX;
		else if(x > maxX)
			buttonX = maxX;
		else 
			buttonX = x;
		
		bounds.x = buttonX - (VOLUME_WIDTH / 2);
	}
	
	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
}
