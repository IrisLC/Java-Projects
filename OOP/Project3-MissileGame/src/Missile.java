import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Missile extends JComponent {
    /**
     * 
     */
    private static final long serialVersionUID = 8116060725557690358L;
    /**
     * the speed that the missile will move at in game.
     */
    private int missileSpeed;
    /**
     * The color the missile will be drawn in.
     */
    private Color missileColor;

    /**
     * Constructor for the missile object.
     * 
     * @param x the x coordinate of the missile tip.
     * @param y the y coordinate of the missile tip.
     */
    public Missile(int x, int y) {
        setBounds(x, y, 15, 15);
        missileSpeed = 5;
        setMissileColor();
    }

    /**
     * Assigns a random RGB code for the missile color.
     */
    public void setMissileColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        missileColor = new Color(r, g, b);
    }

    /**
     * Paints the object onto the canvas.
     */
    public void paintComponent(Graphics g) {
        g.setColor(missileColor);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Moves the missile upwards and, if the missile leaves the screen, deletes
     * it.
     * 
     * @param panelWidth  the width of the GamePanel.
     * @param panelHeight the height of the GamePanel.
     * @param list        the ArrayList the missile is in.
     * @param missile     the missile's position in the ArrayList.
     */
    public void move(int panelWidth, int panelHeight, ArrayList<Missile> list,
            int missile) {
        if (getY() <= 0) {
            list.remove(missile);
        }

        setLocation(getX(), getY() - missileSpeed);
    }

    /**
     * A method that returns the missile's speed.
     * 
     * @return the missile speed
     */
    public int getMissileSpeed() {
        return missileSpeed;
    }
}
