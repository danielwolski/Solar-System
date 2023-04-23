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
    CelestialBody[] celestialBodies;

    //declare manually objects which are parents of other objects
    CelestialBody sun = new CelestialBody(CelestialConstants.Sun.X, CelestialConstants.Sun.Y, CelestialConstants.Sun.RADIUS, CelestialConstants.Sun.COLOR, 0, CelestialConstants.Sun.NAME, CelestialConstants.Sun.ORBITAL_SPEED, null);
    CelestialBody earth = new CelestialBody(0, 0, CelestialConstants.Earth.RADIUS, CelestialConstants.Earth.COLOR, CelestialConstants.Earth.DISTANCE_FROM_PARENT, CelestialConstants.Earth.NAME, CelestialConstants.Earth.ORBITAL_SPEED, sun);//parent Sun

    public SolarSystemPanel() {
        celestialBodies = new CelestialBody[] {
                sun,
                new CelestialBody(0, 0, CelestialConstants.Mercury.RADIUS, CelestialConstants.Mercury.COLOR, CelestialConstants.Mercury.DISTANCE_FROM_PARENT, CelestialConstants.Mercury.NAME, CelestialConstants.Mercury.ORBITAL_SPEED, sun),//parent Sun
                new CelestialBody(0, 0, CelestialConstants.Venus.RADIUS, CelestialConstants.Venus.COLOR, CelestialConstants.Venus.DISTANCE_FROM_PARENT, CelestialConstants.Venus.NAME, CelestialConstants.Venus.ORBITAL_SPEED, sun),//parent Sun
                earth,
                new CelestialBody(0, 0, CelestialConstants.Mars.RADIUS, CelestialConstants.Mars.COLOR, CelestialConstants.Mars.DISTANCE_FROM_PARENT, CelestialConstants.Mars.NAME, CelestialConstants.Mars.ORBITAL_SPEED, sun),//parent Sun
                new CelestialBody(0, 0, CelestialConstants.Jupiter.RADIUS, CelestialConstants.Jupiter.COLOR, CelestialConstants.Jupiter.DISTANCE_FROM_PARENT, CelestialConstants.Jupiter.NAME, CelestialConstants.Jupiter.ORBITAL_SPEED, sun),//parent Sun
                new CelestialBody(0, 0, CelestialConstants.Saturn.RADIUS, CelestialConstants.Saturn.COLOR, CelestialConstants.Saturn.DISTANCE_FROM_PARENT, CelestialConstants.Saturn.NAME, CelestialConstants.Saturn.ORBITAL_SPEED, sun),//parent Sun
                new CelestialBody(0, 0, CelestialConstants.Uranus.RADIUS, CelestialConstants.Uranus.COLOR, CelestialConstants.Uranus.DISTANCE_FROM_PARENT, CelestialConstants.Uranus.NAME, CelestialConstants.Uranus.ORBITAL_SPEED, sun),//parent Sun
                new CelestialBody(0, 0, CelestialConstants.Neptune.RADIUS, CelestialConstants.Neptune.COLOR, CelestialConstants.Neptune.DISTANCE_FROM_PARENT, CelestialConstants.Neptune.NAME, CelestialConstants.Neptune.ORBITAL_SPEED, sun),//parent Sun
                new CelestialBody(0, 0, CelestialConstants.Moon.RADIUS, CelestialConstants.Moon.COLOR, CelestialConstants.Moon.DISTANCE_FROM_PARENT, CelestialConstants.Moon.NAME, CelestialConstants.Moon.ORBITAL_SPEED, earth)//parent Earth
        };

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

    public void updateOrbitingBodyPosition(CelestialBody bodyOrbiting, int orbitCenterX, int orbitCenterY, double xOffset, double yOffset) {
        bodyOrbiting.setX(orbitCenterX + (int) xOffset);
        bodyOrbiting.setY(orbitCenterY + (int) yOffset);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Apply zoom factor
        g2d.scale(zoomFactor, zoomFactor);

        // Apply the offset (move the user's view)
        g2d.translate(offsetX, offsetY);

        // Draw orbits and bodies
        for (CelestialBody celestialBody : celestialBodies) {
                celestialBody.drawPredictedOrbit(g2d, celestialBody);
                celestialBody.drawCelestialBody(g2d);
            }
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
        offsetX = (1700);
        offsetY = (2500);
    }
}
