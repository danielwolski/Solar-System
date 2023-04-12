import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;

public class SolarSystemPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private double zoomFactor = 1;

    CelestialBody earth = new CelestialBody(200, 200, 100, Color.BLUE, "Earth");
    CelestialBody moon = new CelestialBody(350, 250, 25, new Color(200, 200, 200), "Moon");

    public SolarSystemPanel() {
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double delta = 0.1 * e.getPreciseWheelRotation();
                zoomFactor += delta;
                repaint();
            }
        });
    }

    public void updateMoonPosition(double xOffset, double yOffset) {
        moon.setX(earth.getX() + (int) xOffset);
        moon.setY(earth.getY() + (int) yOffset);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Apply zoom factor
        g2d.scale(zoomFactor, zoomFactor);

        // Fill the background with black color
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw predicted orbit
        drawPredictedOrbit(g2d, earth, 150);

        // Draw the Earth and Moon
        drawCelestialBody(g2d, earth);
        drawCelestialBody(g2d, moon);
    }

    private void drawPredictedOrbit(Graphics2D g2d, CelestialBody center, int orbitRadius) {
        g2d.setColor(Color.WHITE);
        g2d.drawOval(center.getX() - orbitRadius, center.getY() - orbitRadius, orbitRadius * 2, orbitRadius * 2);
    }

    private void drawCelestialBody(Graphics2D g2d, CelestialBody body) {
        g2d.setColor(body.getColor());
        Ellipse2D.Double shape = new Ellipse2D.Double(body.getX() - body.getRadius(), body.getY() - body.getRadius(),
                body.getRadius() * 2, body.getRadius() * 2);
        g2d.fill(shape);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(body.getName());
        int textHeight = fm.getHeight();

        int textX = body.getX() - textWidth / 2;
        int textY = body.getY() - textHeight / 2 + fm.getAscent();

        g2d.drawString(body.getName(), textX, textY);
    }
}
