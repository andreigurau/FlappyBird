import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.geom.*;


public class Wall {
	private int y;
	private int dx;
	private int x;
	private int height;
	private int width;
	private int gapHeight;
	public Rectangle topWall;
	public Rectangle bottomWall;
	public Rectangle gap;
	
	public Wall(int x){
		this.x = x;
		height = (int)(Math.random() * 350);
		width = 100;
		topWall = new Rectangle(x,0, width, height);
		
		dx = -10;
		gapHeight = 150;
		gap = new Rectangle(x + width, height, 1, gapHeight);
		bottomWall = new Rectangle(x, height + gapHeight, width, 504 - height - gapHeight);
	}
	
	
	public void paintWalls(Graphics2D g2){
		g2.fillRect(x, 0, width, height);
		g2.fillRect(x, height + gapHeight, width, 504 - height - gapHeight);
		
		g2.setColor(Color.GREEN);
		
	}
	
	public void move(){
		x += dx;
	}
	
	public Rectangle getTopBounds(){
		return new Rectangle(x,0, width, height);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle(x, height + gapHeight, width, 504 - height - gapHeight);
	}
	
	public Rectangle getGapBounds(){
		return new Rectangle(x + width, height, 1, gapHeight);
	}
	
}
