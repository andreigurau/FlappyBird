import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;


public class Application extends JFrame {
    
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(800, 650);

        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        
       
                Application ex = new Application();
                ex.setVisible(true);
          
    }
}