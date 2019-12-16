import java.awt.*;

public class GameObject {
    int x;
    int y;
    int width;
    int height;
    boolean isAlive = true;

    Rectangle _collisionBox = null;

    public GameObject ( int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        _collisionBox =  new Rectangle( x, y, width, height);
    }

    public GameObject() {

    }

    void draw (Graphics g) {
    }



    void update () {
        _collisionBox.setBounds( x, y, width, height);
    }
}
