import java.awt.*;

public class RocketShip extends GameObject {
    int speed = 5;

    public RocketShip ( int x, int y, int width, int height) {
        super( x, y, width, height);
    }

    void draw (Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    void updateX (int xDelta ) {
        x += (xDelta * speed );
    }

    void updateY (int yDelta) {
        y += (yDelta * speed );
    }

    void update () {
    }
}
