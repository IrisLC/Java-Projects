import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies, turret, and
 * missile. It also keeps track of the
 * 
 * @author DJ Rao
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
    /**
     * The list of enemies in the game. Objects are added in the addEnemy method
     * and removed in the detectCollison method.
     */
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    /**
     * The list of missiles in the game. Objects are added in the addMissile
     * method and removed in the detectCollison method.
     */
    private ArrayList<Missile> missileList = new ArrayList<Missile>();

    /**
     * The current score in the game. This value is updated in the
     * detectCollision method.
     */
    private int totalScore = 0;

    /**
     * A boolean toggle that alternates spawning a big enemy or a small enemy.
     */
    private boolean isNextEnemyBig = false;

    /**
     * The turret object.
     */
    private Turret turret = new Turret();

    /**
     * The default constructor for the object.
     */
    public GamePanel() {
        addEnemy();
        addEnemy();
    }

    /**
     * Draws the various objects in the game.
     */
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, 700, 500);
        for (Enemy e : enemyList) {
            e.paintComponent(g);
        }

        for (Missile e : missileList) {
            e.paintComponent(g);
        }

        turret.paintComponent(g);
    }

    /**
     * Moves the missile and enemy objects.
     */
    public void move() {
        for (Enemy e : enemyList) {
            e.move(700, 500);
        }

        for (int i = 0; i < missileList.size(); i++) {
            missileList.get(i).move(700, 500, missileList, i);
        }
    }

    /**
     * Creates a missile and adds it to the missileList array.
     */
    public void addMissile() {
        Missile m = new Missile(342, 350);
        missileList.add(m);
    }

    /**
     * Creates an enemy and adds it to the enemyList array.
     */
    public void addEnemy() {
        Enemy e;

        if (isNextEnemyBig) {
            e = new BigEnemy(700, 500);
        } else {
            e = new SmallEnemy(700, 500);
        }

        isNextEnemyBig = !isNextEnemyBig;

        enemyList.add(e);
    }

    /**
     * Gets the totalScore variable and returns it to the player.
     * 
     * @return the totalScore variable.
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Method detects the collision of the missile and all the enemies. This is
     * done by drawing invisible rectangles around the enemies and missiles, if
     * they intersect, then they collide.
     */
    public void detectCollision() {
        // Uses bounds for enemies and missiles to detect intersection.
        for (int i = 0; i < enemyList.size(); i++) {
            Rectangle enemyRec = enemyList.get(i).getBounds();
            for (int j = 0; j < missileList.size(); j++) {
                Rectangle missileRec = missileList.get(j).getBounds();
                if (missileRec.intersects(enemyRec)) {
                    // Missile has hit an enemy!
                    enemyList.get(i).processCollision(enemyList, i);
                    missileList.remove(j);
                    if (enemyList.get(i) instanceof BigEnemy) {
                        totalScore += 100;
                    } else {
                        totalScore += 150;
                    }
                }
            }
        }
    }
}
