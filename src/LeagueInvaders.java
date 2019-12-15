import javax.swing.*;
import java.awt.*;

public class LeagueInvaders {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    JFrame _mainFrame = null;
    GamePanel _gPanel = null;

    public LeagueInvaders() {
        _mainFrame = new JFrame();
        _gPanel = new GamePanel();
        _mainFrame.addKeyListener( _gPanel);
    }

    public void setup() {
        _mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // make sure app closes
        _mainFrame.setPreferredSize( new Dimension(500, 800));
        _mainFrame.add( _gPanel);
        _mainFrame.pack();
        _mainFrame.setVisible( true);

        _gPanel.startGame();
    }
}
