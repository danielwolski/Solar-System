import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystemPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private Point lastDragPoint;
    private int offsetX = 0;
    private int offsetY = 0;
    private double zoomFactor = 0.08;
    private double targetZoomFactor = zoomFactor;
    private Timer zoomAnimationTimer;

    CelestialBody earth = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Earth.SUN_EARTH_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Earth.MASS, CelestialConstants.Earth.RADIUS, CelestialConstants.Earth.COLOR, CelestialConstants.Earth.NAME, CelestialConstants.Earth.ORBITAL_SPEED);
    CelestialBody moon = new CelestialBody(earth.getX() + CelestialConstants.Moon.EARTH_MOON_DISTANCE, earth.getY(),
            CelestialConstants.Moon.MASS, CelestialConstants.Moon.RADIUS, CelestialConstants.Moon.COLOR, CelestialConstants.Moon.NAME, CelestialConstants.Moon.ORBITAL_SPEED);
    CelestialBody sun = new CelestialBody(CelestialConstants.Sun.X, CelestialConstants.Sun.Y,
            CelestialConstants.Sun.MASS, CelestialConstants.Sun.RADIUS, CelestialConstants.Sun.COLOR, CelestialConstants.Sun.NAME, CelestialConstants.Sun.ORBITAL_SPEED);
    CelestialBody mercury = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Mercury.SUN_MERCURY_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Mercury.MASS, CelestialConstants.Mercury.RADIUS, CelestialConstants.Mercury.COLOR, CelestialConstants.Mercury.NAME, CelestialConstants.Mercury.ORBITAL_SPEED);
    CelestialBody venus = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Venus.SUN_VENUS_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Venus.MASS, CelestialConstants.Venus.RADIUS, CelestialConstants.Venus.COLOR, CelestialConstants.Venus.NAME, CelestialConstants.Venus.ORBITAL_SPEED);
    CelestialBody mars = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Mars.SUN_MARS_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Mars.MASS, CelestialConstants.Mars.RADIUS, CelestialConstants.Mars.COLOR, CelestialConstants.Mars.NAME, CelestialConstants.Mars.ORBITAL_SPEED);
    CelestialBody jupiter = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Jupiter.SUN_JUPITER_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Jupiter.MASS, CelestialConstants.Jupiter.RADIUS, CelestialConstants.Jupiter.COLOR, CelestialConstants.Jupiter.NAME, CelestialConstants.Jupiter.ORBITAL_SPEED);
    CelestialBody saturn = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Saturn.SUN_SATURN_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Saturn.MASS, CelestialConstants.Saturn.RADIUS, CelestialConstants.Saturn.COLOR, CelestialConstants.Saturn.NAME, CelestialConstants.Saturn.ORBITAL_SPEED);
    CelestialBody uranus = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Uranus.SUN_URANUS_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Uranus.MASS, CelestialConstants.Uranus.RADIUS, CelestialConstants.Uranus.COLOR, CelestialConstants.Uranus.NAME, CelestialConstants.Uranus.ORBITAL_SPEED);
    CelestialBody neptune = new CelestialBody(CelestialConstants.Sun.X + CelestialConstants.Neptune.SUN_NEPTUNE_DISTANCE, CelestialConstants.Sun.Y,
            CelestialConstants.Neptune.MASS, CelestialConstants.Neptune.RADIUS, CelestialConstants.Neptune.COLOR, CelestialConstants.Neptune.NAME, CelestialConstants.Neptune.ORBITAL_SPEED);

    public SolarSystemPanel() {

        // Set the background color to black
        setBackground(Color.BLACK);

        // Zooming in and out
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double delta = 0.05 * e.getPreciseWheelRotation();
                targetZoomFactor -= delta;
                zoomFactor = targetZoomFactor;
                repaint();
            }
        });

        //Dragging the view
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

        //Initial view
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
        drawPredictedOrbit(g2d, sun, CelestialConstants.Mercury.SUN_MERCURY_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Venus.SUN_VENUS_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Mars.SUN_MARS_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Jupiter.SUN_JUPITER_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Saturn.SUN_SATURN_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Uranus.SUN_URANUS_DISTANCE);
        drawPredictedOrbit(g2d, sun, CelestialConstants.Neptune.SUN_NEPTUNE_DISTANCE);

        // Draw bodies
        drawCelestialBody(g2d, earth);
        drawCelestialBody(g2d, moon);
        drawCelestialBody(g2d, sun);
        drawCelestialBody(g2d, mercury);
        drawCelestialBody(g2d, venus);
        drawCelestialBody(g2d, mars);
        drawCelestialBody(g2d, jupiter);
        drawCelestialBody(g2d, saturn);
        drawCelestialBody(g2d, uranus);
        drawCelestialBody(g2d, neptune);

        // Draw small white cross at the center of the screen, always the same size
        g2d.setTransform(new AffineTransform());
        g.setColor(Color.WHITE);
        int centerX = getRawWidth() / 2;
        int centerY = getRawHeight() / 2;
        g.drawLine(centerX - 1, centerY, centerX + 1, centerY);
        g.drawLine(centerX, centerY - 1, centerX, centerY + 1);
    }

    // Draw orbit on which celestial body moves
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

    public int getRawWidth() {
        return super.getWidth();
    }

    public int getRawHeight() {
        return super.getHeight();
    }


    private void initializeOffset() {
        offsetX = (sun.getX());
        offsetY = (sun.getY()/2);
    }
}
