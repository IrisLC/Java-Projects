import java.awt.Color;
import java.util.ArrayList;

public class SmallEnemy extends Enemy {
    /**
     * 
     */
    private static final long serialVersionUID = 2397783612233314942L;

    /**
     * constructor for the SmallEnemy object.
     * 
     * @param panelWidth  the width of the GamePanel.
     * @param panelHeight the height of the GamePanel.
     */
    public SmallEnemy(int panelWidth, int panelHeight) {
        super((int) Math.random() * panelHeight,
                (int) Math.random() * panelHeight, 30, 30, 6);
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

        if (speed > 0) {
            setEnemySpeed(speed + 0.05);
        } else {
            setEnemySpeed(speed - 0.05);
        }
    }

    @Override
    public void processCollision(ArrayList<Enemy> list, int smallEnemy) {
        if (getWidth() - 10 <= 0 || getHeight() - 10 <= 0) {
            list.remove(smallEnemy);
        }
        setSize(getWidth() - 10, getHeight() - 10);
    }

}