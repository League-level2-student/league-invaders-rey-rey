import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;

    final int MENU_STATE = 0;
    final int GAME_STATE = 1;
    final int END_STATE = 2;
    final int FPS_60 = 1000/60;

    int currentState = MENU_STATE;

    Font _titleFont = null;
    boolean test = true;

    Timer _timer = null;
    RocketShip _rs = null;
    ObjectManager _om = null;
    Font titleFont = new Font( "Arial", Font.PLAIN, 48);

    public GamePanel() {
        _titleFont = new Font( "Arial", Font.PLAIN, 48);
        _timer = new Timer( FPS_60, this);
        _rs = new RocketShip( 250, 700, 50, 50);
        _om = new ObjectManager(_rs);


        try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void drawMenuState( Graphics g) {
        g.setColor( Color.BLUE);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        g.setFont( _titleFont);
        g.setColor( Color.BLACK);
        g.drawString( "Space Invaders", 50 , 50);
    }

    void drawGameState(Graphics g) {
        if ( test ) {
            //g.setColor(Color.BLACK);
            //g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
            g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
            g.setColor( Color.GREEN);
            g.drawString( "Score:  " + _om.getScore(), 50 , 50);
        }
        _om.draw(g);
    }

    void drawEndState( Graphics g ) {
        g.setColor( Color.RED);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

        g.setFont( _titleFont);
        g.setColor( Color.BLACK);
        g.drawString( "GAME OVER", 50 , 50);
    }

    void UpdateMenuState( ) {
        currentState = MENU_STATE;
    }

    void UpdateGameState() {
        currentState = GAME_STATE;
        _om.update();
        _om.manageEnemies();
        _om.checkCollision();
        _om.purgeObjects();
        if ( !_rs.isAlive) {
           UpdateEndState();
        }
    }

    void UpdateEndState( ) {
        currentState = END_STATE;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentState == MENU_STATE) {
            UpdateMenuState();
        } else if (currentState == GAME_STATE) {
            UpdateGameState();
        } else if (currentState == END_STATE) {
            UpdateEndState();
        }
        repaint();  // redraws the panel, ie calls paintComponent
    }

    public void startGame() {
        _timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        if (currentState == MENU_STATE) {
            drawMenuState(g);
        } else if (currentState == GAME_STATE) {
            drawGameState(g);
        } else if (currentState == END_STATE) {
            drawEndState(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
 System.out.println("KeyTyped.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            _om.addProjectile();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            _rs.updateX( -1 );;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            _rs.updateX( 1 );;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            _rs.updateY( -1 );;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            _rs.updateY( 1 );;
        } else if (e.getKeyCode() != KeyEvent.VK_ENTER) {
            // not an enter key
        } else if ( currentState == MENU_STATE) {
            currentState = GAME_STATE;
        } else if ( currentState == GAME_STATE) {
            currentState = END_STATE;
        } else if ( currentState == END_STATE) {
            currentState = MENU_STATE;
            _rs = new RocketShip( 250, 700, 50, 50);
            _om = new ObjectManager(_rs);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
