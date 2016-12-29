import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;


public class Bird {
	private Image birdImage;
	private int y;
	private int dy;
	private int x;
	private int height;
	private int width;
	private int acceleration = 1;
	
	public Bird(){
		System.out.println("bird created");
		ImageIcon bird = new ImageIcon("bird.png");
		birdImage = bird.getImage();
		x = 200;
		y = 300;
		height = bird.getIconHeight();
		width = bird.getIconWidth();
	}
	
	public void move() {
		acceleration++;
		y += acceleration;
		
	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	
	public Image getImage() {
		
		return birdImage;
	}
	
	public void jump(){
		
		acceleration = 1;
		y += -75;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y, width, height);
	}
	
}
