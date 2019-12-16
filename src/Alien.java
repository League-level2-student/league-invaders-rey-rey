import java.awt.*;

public class Alien extends GameObject {
    int speed = 10;

    public Alien(int x, int y, int width, int height) {
        super( x, y, width, height);
    }

    void draw (Graphics g) {
        //g.setColor(Color.YELLOW);
        //g.fillRect(x, y, width, height);
        g.drawImage(GamePanel.alienImg, x, y, width, height, null);
    }

    void update () {
        super.update();
        y += speed;
        if ( y > LeagueInvaders.HEIGHT) {
            y = 0;
        }
    }
}
