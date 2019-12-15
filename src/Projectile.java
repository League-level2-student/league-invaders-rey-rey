import java.awt.*;

public class Projectile extends GameObject {
    int speed = 10;

    public Projectile(int x, int y, int width, int height) {
        super( x, y, width, height);
    }

    void draw (Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    void update () {
        y -= speed;
        if ( y < 0 ) {
            isAlive = false;
        }
    }
}
