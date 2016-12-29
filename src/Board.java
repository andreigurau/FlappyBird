
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.geom.*;

public class Board extends JPanel implements ActionListener {

    private Bird bird;
    private Timer timer;
    private int delay = 30;
    private ImageIcon background;
    private Wall wall1;
    private Wall wall2;
    private int score;
    public Board() {
    	initBoard();
        
    }
    private void initBoard(){
    	addKeyListener(new TAdapter());
    	setFocusable(true);
    	
    	background = new ImageIcon("background.png");
    	bird = new Bird();
    	timer = new Timer(delay, this);
    	timer.start();
    	score = 0;
    	wall1 = new Wall(700);
    	wall2 = new Wall(1200);
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		bird.move();
		wall1.move();
		wall2.move();
		repaint();
		checkCollisions();
	}
    
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		createDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void createDrawing(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(background.getImage(), 0 , 0, null);
		g2.drawImage(bird.getImage(), bird.getX(), bird.getY(), this);
		Rectangle ground = new Rectangle(0, 504, 1000, 1000);
		g2.fillRect((int)ground.getX(), (int)ground.getY(), (int)ground.getWidth(), (int)ground.getHeight());
		g2.setColor(Color.ORANGE);
		g2.fill(ground);
		String scoreString = "Score: " + score;
		g2.drawString(scoreString, 50, 50);
		
		g2.setColor(Color.GREEN);
		wall1.paintWalls(g2);
		wall2.paintWalls(g2);
	}
	
	private class TAdapter extends KeyAdapter {

       
        public void keyReleased(KeyEvent e) {
        	
        }

      
        public void keyPressed(KeyEvent e) {
        	
        	bird.jump();
        }

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
	
	public void checkCollisions(){
		Rectangle birdBounds = bird.getBounds();
		Rectangle topBounds = wall1.getTopBounds();
		Rectangle bottomBounds = wall1.getBottomBounds();
		Rectangle gapBounds = wall1.getGapBounds();
		Rectangle topBounds2 = wall2.getTopBounds();
		Rectangle bottomBounds2 = wall2.getBottomBounds();
		Rectangle gapBounds2 = wall2.getGapBounds();
		if (bird.getY() > 450){
			timer.stop();
			
			
		}
		
		if((birdBounds.intersects(topBounds)) || (birdBounds.intersects(bottomBounds)) ||
				(birdBounds.intersects(topBounds2)) || (birdBounds.intersects(bottomBounds2))){
			timer.stop();
			
		}
		if(birdBounds.intersects(gapBounds)){
			score++;
			wall1 = new Wall(1200);
		}
		if(birdBounds.intersects(gapBounds2)){
			score++;
			wall2 = new Wall(1200);
		}
		
		
		
		
	}
    
}