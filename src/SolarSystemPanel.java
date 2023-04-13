import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SolarSystemPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private Point lastDragPoint;
    private int offsetX = 0;
    private int offsetY = 0;
    private double zoomFactor = 0.1;

    CelestialBody earth = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Earth.SUN_EARTH_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Earth.MASS, CelestialConstants.Earth.RADIUS, CelestialConstants.Earth.COLOR, CelestialConstants.Earth.NAME, CelestialConstants.Earth.ROTATION_SPEED);
    CelestialBody moon = new CelestialBody(earth.getX() + CelestialConstants.Moon.EARTH_MOON_DISTANCE, earth.getY(),
            CelestialConstants.Moon.MASS, CelestialConstants.Moon.RADIUS, CelestialConstants.Moon.COLOR, CelestialConstants.Moon.NAME, CelestialConstants.Moon.ROTATION_SPEED);
    CelestialBody sun = new CelestialBody(CelestialConstants.Sun.X, CelestialConstants.Sun.Y,
            CelestialConstants.Sun.MASS, CelestialConstants.Sun.RADIUS, CelestialConstants.Sun.COLOR, CelestialConstants.Sun.NAME, CelestialConstants.Sun.ROTATION_SPEED);

    public SolarSystemPanel() {

        // Set the background color to black
        setBackground(Color.BLACK);

        //zooming in and out
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double delta = 0.04 * e.getPreciseWheelRotation();
                zoomFactor += delta;
                repaint();
            }
        });

        //dragging the view
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastDragPoint = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = (int) ((e.getX() - lastDragPoint.getX()) / zoomFactor);
                int dy = (int) ((e.getY() - lastDragPoint.getY()) / zoomFactor);
                offsetX += dx;
                offsetY += dy;
                lastDragPoint = e.getPoint();
                repaint();
            }
        });

        //initial view
        initializeOffset();
    }

    public void updateOrbitingBodyPosition(CelestialBody bodyOrbiting, CelestialBody bodyOrbited, double xOffset, double yOffset) {
        bodyOrbiting.setX(bodyOrbited.getX() + (int) xOffset);
        bodyOrbiting.setY(bodyOrbited.getY() + (int) yOffset);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Apply zoom factor
        g2d.scale(zoomFactor, zoomFactor);

        // Apply the offset (move the user's view)
        g2d.translate(offsetX, offsetY);

        // Draw orbits
        drawPredictedOrbit(g2d, earth, CelestialConstants.Moon.EARTH_MOON_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Earth.SUN_EARTH_DISTANCE);

        // Draw bodies
        drawCelestialBody(g2d, earth);
        drawCelestialBody(g2d, moon);
        drawCelestialBody(g2d, sun);

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

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, body.getRadius()/2));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(body.getName());
        int textHeight = fm.getHeight();

        int textX = body.getX() - textWidth / 2;
        int textY = body.getY() - textHeight / 2 + fm.getAscent();

        g2d.drawString(body.getName(), textX, textY);
    }

    public int getWidth() {
        return (int) (super.getWidth() / zoomFactor);
    }

    public int getHeight() {
        return (int) (super.getHeight() / zoomFactor);
    }

    private void initializeOffset() {
        offsetX = (sun.getX());
        offsetY = (sun.getY()/2);
    }
}
