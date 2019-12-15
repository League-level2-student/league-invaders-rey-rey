import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {
    RocketShip _rs = null;
    ArrayList<Projectile> projs = new ArrayList<>();

    public ObjectManager( RocketShip rs) {
       _rs = rs;
    }

    public void addProjectile () {
        int middle = _rs.x + (int)(_rs.width*.5);
        projs.add( new Projectile( middle, _rs.y, 10, 10));
    }

    public void draw (Graphics g ) {
        for (Projectile proj : projs ) {
            if ( proj.isAlive) {
                proj.draw(g);
            }
        }
       _rs.draw(g);
    }
    public void update () {
        for (Projectile proj : projs ) {
            if ( proj.isAlive) {
                proj.update();
            }  else  {
                //projs.remove( proj); // dead, so remove it
            }
        }
        _rs.update();
    }
}
