import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public abstract class Enemy extends JComponent {
    /**
     * 
     */
    private static final long serialVersionUID = -2829278085745741666L;
    /**
     * the speed that the enemy will move at in game.
     */
    private double enemySpeed;
    /**
     * The color the enemy will be drawn in.
     */
    private Color enemyColor;

    /**
     * The constructor for the enemy object.
     * 
     * @param x          the x position of the object.
     * @param y          the y position of the object.
     * @param height     the height of the object.
     * @param width      the width of the object.
     * @param enemySpeed the speed the enemy will be set to.
     */
    public Enemy(int x, int y, int height, int width, double enemySpeed) {
        this.enemySpeed = enemySpeed;
        setBounds(x, y, width, height);
    }

    /**
     * A method that runs when a missile hits an enemy, makes the enemy smaller,
     * until it removes the enemy entirely.
     * 
     * @param list  the ArrayList holding the enemy.
     * @param enemy the enemy's position in the ArrayList.
     */
    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    /**
     * Randomly assigns an RGB value for the object.
     */
    public abstract void setColor();

    /**
     * Moves the object from side to side across the screen.
     * 
     * @param frameWidth  the width of the GamePanel.
     * @param frameHeight the height of the GamePanel.
     */
    public abstract void move(int frameWidth, int frameHeight);

    /**
     * Paints the object onto the canvas.
     */
    public void paintComponent(Graphics g) {
        g.setColor(enemyColor);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Gets the enemySpeed variable and returns it.
     * 
     * @return the enemy's speed.
     */
    public double getEnemySpeed() {
        return enemySpeed;
    }

    /**
     * Changes the enemySpeed variable.
     * 
     * @param enemySpeed what the enemy's speed will be changed to.
     */
    public void setEnemySpeed(double enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    /**
     * Gets the enemyColor variable and returns it.
     * 
     * @return the enemy's color.
     */
    public Color getEnemyColor() {
        return enemyColor;
    }

    /**
     * Changes the enemyColor variable.
     * 
     * @param enemyColor what the enemy's color will be changed to.
     */
    public void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }

}
