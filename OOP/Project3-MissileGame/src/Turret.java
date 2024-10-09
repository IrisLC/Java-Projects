import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Turret extends JComponent {
    /**
     * 
     */
    private static final long serialVersionUID = -6909696243102668476L;
    private Rectangle base;
    private Rectangle turret;
    private Color turretColor;

    public Turret() {
        base = new Rectangle(325, 375, 50, 25);
        turret = new Rectangle(345, 350, 10, 50);
        turretColor = new Color(126, 126, 126);
    }

    public void paintComponent(Graphics g) {
        g.setColor(turretColor);
        g.fillRect((int) base.getX(), (int) base.getY(), (int) base.getWidth(),
                (int) base.getHeight());
        g.fillRect((int) turret.getX(), (int) turret.getY(),
                (int) turret.getWidth(), (int) turret.getHeight());
    }

}
