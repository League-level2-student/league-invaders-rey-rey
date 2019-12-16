import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
    long enemyTimer = 0;
    long enemySpawnTime = 5 * 1000;
    int _score = 0;


    RocketShip _rs = null;
    ArrayList<Projectile> _projs = new ArrayList<>();
    ArrayList<Alien> _aliens = new ArrayList<>();
    public ObjectManager( RocketShip rs) {
        _rs = rs;
    }


    public void addAlien ( Alien ali) {
       _aliens.add( ali ) ;
    }
    public void addProjectile () {
        int middle = _rs.x + (int)(_rs.width*.5);
        _projs.add( new Projectile( middle, _rs.y, 10, 10));
    }

    public void checkCollision() {
        for(Alien ali : _aliens){
            if(_rs._collisionBox.intersects(ali._collisionBox) ) {
                _rs.isAlive = false;
            }
        }
        checkCollisionProjectiles();
    }

    private void checkCollisionProjectiles() {
        for(Projectile proj : _projs) {
            for(Alien  ali : _aliens) {
                if(proj._collisionBox.intersects(ali._collisionBox) ){
                    _score += 1;
                    ali.isAlive = false;
                }
            }
        }
    }


    public void draw (Graphics g ) {
        for (Alien ali : _aliens) {
            if ( ali.isAlive) {
                ali.draw(g);
            }
        }

        for (Projectile proj : _projs) {
            if ( proj.isAlive) {
                proj.draw(g);
            }
        }
        if ( _rs.isAlive ) {
            _rs.draw(g);
        }

    }

    public int getScore() {
        return _score;
    }

    public void manageEnemies() {
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
            enemyTimer = System.currentTimeMillis();
        }
    }
    public void purgeObjects() {
        Iterator<Alien> itr = _aliens.iterator();
        while ( itr.hasNext()) {
            Alien ali = itr.next();
            if ( !ali.isAlive) {
                itr.remove();
            }
        }

        Iterator<Projectile> itr2 = _projs.iterator();
        while ( itr2.hasNext()) {
            Projectile proj = itr2.next();
            if ( !proj.isAlive) {
                itr2.remove();
            }
        }
    }

    public void update () {

        for (Alien ali : _aliens) {
            if ( ali.isAlive) {
                ali.update();
            }
        }

        for (Projectile proj : _projs) {
            if ( proj.isAlive) {
                proj.update();
            }  else  {
                //projs.remove( proj); // dead, so remove it
            }
        }
        _rs.update();
    }
}
