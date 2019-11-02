import java.awt.*;

public class GameObject {
    int x;
    int y;
    int width;
    int height;

    public GameObject ( int x, int y, int width, int height) {
    }
    void draw (Graphics g) {
        g.fillRect(7, 10, 100, 100);
    }

    void update () {
    }
}
