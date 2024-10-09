import java.awt.Color;
import java.util.ArrayList;

public class BigEnemy extends Enemy {
    /**
     * 
     */
    private static final long serialVersionUID = -2245725913286379324L;

    /**
     * constructor for the BigEnemy object.
     * 
     * @param panelWidth  the width of the GamePanel.
     * @param panelHeight the height of the GamePanel.
     */
    public BigEnemy(int panelWidth, int panelHeight) {
        super((int) Math.random() * panelHeight,
                (int) Math.random() * panelHeight, 56, 56, 4);
        setColor();
    }

    @Override
    public void setColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        setEnemyColor(new Color(r, g, b));
    }

    @Override
    public void move(int frameWidth, int frameHeight) {
        int x = getX();
        double speed = getEnemySpeed();
        if (x + speed > frameWidth || x + speed < 0) {
            speed *= -1;
            setEnemySpeed(speed);
        }

        setBounds((int) (x + speed), getY(), getWidth(), getHeight());
    }

    @Override
    public void processCollision(ArrayList<Enemy> list, int bigEnemy) {
        if (getWidth() - 20 <= 0 || getHeight() - 20 <= 0) {
            list.remove(bigEnemy);
        }
        setSize(getWidth() - 20, getHeight() - 20);
    }

}
