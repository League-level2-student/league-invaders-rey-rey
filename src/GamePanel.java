import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    final int FPS_60 = 1000/60;
    Timer _timer = null;
    GameObject _go = null;
    public GamePanel() {
        _timer = new Timer( FPS_60, this);
        _go = new GameObject( 10, 10, 100, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println( "action");
        repaint();
    }

    public void startGame() {
        _timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        _go.draw( g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
 System.out.println("KeyTyped.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
System.out.println("Key Pressed.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
System.out.println("Key Released.");
    }
}
