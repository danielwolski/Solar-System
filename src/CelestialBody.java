import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CelestialBody {
    private int x, y, distanceFromParent;
    private int radius;
    private Color color;
    private String name;
    private double orbital_speed;
    CelestialBody parentBody;

    public CelestialBody(int x, int y, int radius, Color color, int distanceFromParent, String name, double orbitalSpeed, CelestialBody parentBody) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.distanceFromParent = distanceFromParent;
        this.name = name;
        this.orbital_speed = orbital_speed;
        this.parentBody = parentBody;
    }

    public void drawCelestialBody(Graphics2D g2d) {
        g2d.setColor(this.color); // Add this line to set the color

        Ellipse2D.Double shape = new Ellipse2D.Double(this.getX() - this.getRadius(), this.getY() - this.getRadius(),
                this.getRadius() * 2, this.getRadius() * 2);
        g2d.fill(shape);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, this.getRadius()/2));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(this.getName());
        int textHeight = fm.getHeight();

        int textX = this.getX() - textWidth / 2;
        int textY = this.getY() - textHeight / 2 + fm.getAscent();

        g2d.drawString(this.getName(), textX, textY);
    }

    public void drawPredictedOrbit(Graphics2D g2d, CelestialBody celestialBody) {
        if (celestialBody.getParent() == null) {
            // Don't draw orbit for the Sun as it has no parent
            return;
        }

        g2d.setColor(Color.WHITE);
        if (celestialBody.getParent() != null) {
            int orbitCenterX = celestialBody.getParent().getX();
            int orbitCenterY = celestialBody.getParent().getY();
            g2d.drawOval(orbitCenterX - celestialBody.distanceFromParent, orbitCenterY - celestialBody.distanceFromParent, celestialBody.distanceFromParent * 2, celestialBody.distanceFromParent * 2);
        } else {
            g2d.drawOval(celestialBody.getParent().getX() - celestialBody.distanceFromParent, celestialBody.getParent().getY() - celestialBody.distanceFromParent, celestialBody.distanceFromParent * 2, celestialBody.distanceFromParent * 2);
        }
    }


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getOrbitalSpeed() {return orbital_speed;}
    public void setOrbitalSpeed() {this.orbital_speed = orbital_speed;}
    public int getDistanceFromParent() {
        return distanceFromParent;
    }
    public void setDistanceFromParent() {this.distanceFromParent = distanceFromParent;}
    public int getOrbitCenterX() {
        if (parentBody == null) {
            return 0;
        }
        return parentBody.getX();
    }

    public int getOrbitCenterY() {
        if (parentBody == null) {
            return 0;
        }
        return parentBody.getY();
    }


    public CelestialBody getParent(){
            return parentBody;
    }
}