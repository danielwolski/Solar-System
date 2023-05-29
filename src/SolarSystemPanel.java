import images_.ImagePaths;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * SolarSystemPanel is a custom JPanel that simulates and visualizes the solar system.
 * It handles the creation of celestial bodies, and provides functionality for zooming and panning the view.
 */
public class SolarSystemPanel extends JPanel {

    // various variables needed for the simulation and visualization
    private Image backgroundImage;
    private static final long serialVersionUID = 1L;
    private Point lastDragPoint;
    private int offsetX = 0;
    private int offsetY = 0;
    private double zoomFactor = 0.0001;
    private double targetZoomFactor = zoomFactor;
    private double deltaVal = 0.005;
    CelestialBody[] celestialBodies;

    //declare objects which are parents of other objects
    CelestialBody sun = new CelestialBody(CelestialConstants.Sun.X, CelestialConstants.Sun.Y, CelestialConstants.Sun.RADIUS, 0, CelestialConstants.Sun.NAME, CelestialConstants.Sun.ORBITAL_SPEED, null,ImagePaths.sunImage);
    CelestialBody earth = new CelestialBody(0, 0, CelestialConstants.Earth.RADIUS,  CelestialConstants.Earth.DISTANCE_FROM_PARENT, CelestialConstants.Earth.NAME, CelestialConstants.Earth.ORBITAL_SPEED, sun,ImagePaths.earthImage);//parent Sun
    CelestialBody mars = new CelestialBody(0, 0, CelestialConstants.Mars.RADIUS, CelestialConstants.Mars.DISTANCE_FROM_PARENT, CelestialConstants.Mars.NAME, CelestialConstants.Mars.ORBITAL_SPEED, sun,ImagePaths.marsImage);
    CelestialBody jupiter = new CelestialBody(0, 0, CelestialConstants.Jupiter.RADIUS, CelestialConstants.Jupiter.DISTANCE_FROM_PARENT, CelestialConstants.Jupiter.NAME, CelestialConstants.Jupiter.ORBITAL_SPEED, sun,ImagePaths.jupiterImage);
    CelestialBody saturn = new CelestialBody(0, 0, CelestialConstants.Saturn.RADIUS,  CelestialConstants.Saturn.DISTANCE_FROM_PARENT, CelestialConstants.Saturn.NAME, CelestialConstants.Saturn.ORBITAL_SPEED, sun,ImagePaths.saturnImage);
    CelestialBody uranus = new CelestialBody(0, 0, CelestialConstants.Uranus.RADIUS,  CelestialConstants.Uranus.DISTANCE_FROM_PARENT, CelestialConstants.Uranus.NAME, CelestialConstants.Uranus.ORBITAL_SPEED, sun,ImagePaths.uranusImage);
    CelestialBody neptune = new CelestialBody(0, 0, CelestialConstants.Neptune.RADIUS,  CelestialConstants.Neptune.DISTANCE_FROM_PARENT, CelestialConstants.Neptune.NAME, CelestialConstants.Neptune.ORBITAL_SPEED, sun,ImagePaths.neptuneImage);

    /**
     * Constructor for the SolarSystemPanel.
     * Initializes celestial bodies and sets up necessary listeners for user interaction.
     */
    public SolarSystemPanel() {
        celestialBodies = new CelestialBody[] {
                sun,
                new CelestialBody(0, 0, CelestialConstants.Mercury.RADIUS, CelestialConstants.Mercury.DISTANCE_FROM_PARENT, CelestialConstants.Mercury.NAME, CelestialConstants.Mercury.ORBITAL_SPEED, sun,ImagePaths.mercuryImage),
                new CelestialBody(0, 0, CelestialConstants.Venus.RADIUS,  CelestialConstants.Venus.DISTANCE_FROM_PARENT, CelestialConstants.Venus.NAME, CelestialConstants.Venus.ORBITAL_SPEED, sun,ImagePaths.venusImage),
                earth,
                mars,
                jupiter,
                saturn,
                uranus,
                neptune,
                new CelestialBody(0, 0, CelestialConstants.Moon.RADIUS,  CelestialConstants.Moon.DISTANCE_FROM_PARENT, CelestialConstants.Moon.NAME, CelestialConstants.Moon.ORBITAL_SPEED, earth,ImagePaths.moonImage),
                new CelestialBody(0, 0, CelestialConstants.Phobos.RADIUS,  CelestialConstants.Phobos.DISTANCE_FROM_PARENT, CelestialConstants.Phobos.NAME, CelestialConstants.Phobos.ORBITAL_SPEED, mars,ImagePaths.phobosImage),
                new CelestialBody(0, 0, CelestialConstants.Deimos.RADIUS,  CelestialConstants.Deimos.DISTANCE_FROM_PARENT, CelestialConstants.Deimos.NAME, CelestialConstants.Deimos.ORBITAL_SPEED, mars,ImagePaths.deimosImage),
                new CelestialBody(0, 0, CelestialConstants.Io.RADIUS, CelestialConstants.Io.DISTANCE_FROM_PARENT, CelestialConstants.Io.NAME, CelestialConstants.Io.ORBITAL_SPEED, jupiter,ImagePaths.ioImage),
                new CelestialBody(0, 0, CelestialConstants.Europa.RADIUS,  CelestialConstants.Europa.DISTANCE_FROM_PARENT, CelestialConstants.Europa.NAME, CelestialConstants.Europa.ORBITAL_SPEED, jupiter,ImagePaths.europaImage),
                new CelestialBody(0, 0, CelestialConstants.Ganymede.RADIUS,  CelestialConstants.Ganymede.DISTANCE_FROM_PARENT, CelestialConstants.Ganymede.NAME, CelestialConstants.Ganymede.ORBITAL_SPEED, jupiter,ImagePaths.ganymedeImage),
                new CelestialBody(0, 0, CelestialConstants.Callisto.RADIUS,  CelestialConstants.Callisto.DISTANCE_FROM_PARENT, CelestialConstants.Callisto.NAME, CelestialConstants.Callisto.ORBITAL_SPEED, jupiter,""),
                new CelestialBody(0, 0, CelestialConstants.Titan.RADIUS,  CelestialConstants.Titan.DISTANCE_FROM_PARENT, CelestialConstants.Titan.NAME, CelestialConstants.Titan.ORBITAL_SPEED, saturn,""),
                new CelestialBody(0, 0, CelestialConstants.Rhea.RADIUS,  CelestialConstants.Rhea.DISTANCE_FROM_PARENT, CelestialConstants.Rhea.NAME, CelestialConstants.Rhea.ORBITAL_SPEED, saturn,""),
                new CelestialBody(0, 0, CelestialConstants.Iapetus.RADIUS,  CelestialConstants.Iapetus.DISTANCE_FROM_PARENT, CelestialConstants.Iapetus.NAME, CelestialConstants.Iapetus.ORBITAL_SPEED, saturn,""),
                new CelestialBody(0, 0, CelestialConstants.Dione.RADIUS, CelestialConstants.Dione.DISTANCE_FROM_PARENT, CelestialConstants.Dione.NAME, CelestialConstants.Dione.ORBITAL_SPEED, saturn,""),
                new CelestialBody(0, 0, CelestialConstants.Titania.RADIUS,  CelestialConstants.Titania.DISTANCE_FROM_PARENT, CelestialConstants.Titania.NAME, CelestialConstants.Titania.ORBITAL_SPEED, uranus,""),
                new CelestialBody(0, 0, CelestialConstants.Oberon.RADIUS,  CelestialConstants.Oberon.DISTANCE_FROM_PARENT, CelestialConstants.Oberon.NAME, CelestialConstants.Oberon.ORBITAL_SPEED, uranus,""),
                new CelestialBody(0, 0, CelestialConstants.Umbriel.RADIUS,  CelestialConstants.Umbriel.DISTANCE_FROM_PARENT, CelestialConstants.Umbriel.NAME, CelestialConstants.Umbriel.ORBITAL_SPEED, uranus,""),
                new CelestialBody(0, 0, CelestialConstants.Ariel.RADIUS,  CelestialConstants.Ariel.DISTANCE_FROM_PARENT, CelestialConstants.Ariel.NAME, CelestialConstants.Ariel.ORBITAL_SPEED, uranus,""),
                new CelestialBody(0, 0, CelestialConstants.Miranda.RADIUS,  CelestialConstants.Miranda.DISTANCE_FROM_PARENT, CelestialConstants.Miranda.NAME, CelestialConstants.Miranda.ORBITAL_SPEED, uranus,""),
                new CelestialBody(0, 0, CelestialConstants.Triton.RADIUS,  CelestialConstants.Triton.DISTANCE_FROM_PARENT, CelestialConstants.Triton.NAME, CelestialConstants.Triton.ORBITAL_SPEED, neptune,"")
        };

        try {
            backgroundImage = ImageIO.read(new File(ImagePaths.background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /**
        * Adds a mouse wheel listener to enable zooming in and out.
        * The zoom factor is adjusted based on the precise wheel rotation of the mouse.
        * @param deltaVal the amount of change in zoom factor per wheel rotation
        */
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                double delta = deltaVal * e.getPreciseWheelRotation();
                targetZoomFactor -= delta;

                if (targetZoomFactor > 0.0001) {
                    zoomFactor = targetZoomFactor;
                    repaint();
                }
                else
                    targetZoomFactor += delta;
            }
        });

        /**
        * Adds a mouse listener to enable dragging of the view.
        * The starting point of the drag is stored for reference.
        * @param e the mouse event indicating the button press
        */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastDragPoint = e.getPoint();
            }
        });
        
        /**
        * Adds a mouse motion listener to handle dragging of the view.
        * The offset values are adjusted based on the movement of the mouse
        * and the current zoom factor. The view is repainted to reflect the new position.
        * @param e the mouse event indicating the mouse movement
        */
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

    /**
     * Update the position of a body orbiting another body in the solar system.
     * @param bodyOrbiting the celestial body that is orbiting.
     * @param bodyOrbited the celestial body that is being orbited.
     * @param xOffset the x offset for the orbiting body.
     * @param yOffset the y offset for the orbiting body.
     */
    public void updateOrbitingBodyPosition(CelestialBody bodyOrbiting, CelestialBody bodyOrbited, double xOffset, double yOffset) {
        bodyOrbiting.setX(bodyOrbited.getX() + (int) xOffset);
        bodyOrbiting.setY(bodyOrbited.getY() + (int) yOffset);
    }

    /**
     * Overridden method for painting components. Draws the celestial bodies and applies transformations for zooming and panning.
     * @param g the Graphics object to protect.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw image
        g2d.drawImage(backgroundImage, 0, 0, getRawWidth(), getRawHeight(), this);

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


    /**
     * Get methods and private method to initialize the offset.
     */
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
