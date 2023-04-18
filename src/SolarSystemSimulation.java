import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystemSimulation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1200);

        SolarSystemPanel panel = new SolarSystemPanel();
        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            double earthAngle = 0;
            double moonAngle = 0;
            double mercuryAngle = 0;
            double venusAngle = 0;
            double marsAngle = 0;
            double jupiterAngle = 0;
            double saturnAngle = 0;
            double uranusAngle = 0;
            double neptuneAngle = 0;


            @Override
            public void actionPerformed(ActionEvent e) {
                earthAngle += panel.earth.getOrbitalSpeed();
                moonAngle += panel.moon.getOrbitalSpeed();
                mercuryAngle += panel.mercury.getOrbitalSpeed();
                venusAngle += panel.venus.getOrbitalSpeed();
                marsAngle += panel.mars.getOrbitalSpeed();
                jupiterAngle += panel.jupiter.getOrbitalSpeed();
                saturnAngle += panel.saturn.getOrbitalSpeed();
                uranusAngle += panel.uranus.getOrbitalSpeed();
                neptuneAngle += panel.neptune.getOrbitalSpeed();

                double earthAngleRadians = Math.toRadians(earthAngle);
                double moonAngleRadians = Math.toRadians(moonAngle);
                double mercuryAngleRadians = Math.toRadians(mercuryAngle);
                double venusAngleRadians = Math.toRadians(venusAngle);
                double marsAngleRadians = Math.toRadians(marsAngle);
                double jupiterAngleRadians = Math.toRadians(jupiterAngle);
                double saturnAngleRadians = Math.toRadians(saturnAngle);
                double uranusAngleRadians = Math.toRadians(uranusAngle);
                double neptuneAngleRadians = Math.toRadians(neptuneAngle);

                panel.updateOrbitingBodyPosition(panel.moon, panel.earth, CelestialConstants.Moon.EARTH_MOON_DISTANCE * Math.cos(moonAngleRadians), CelestialConstants.Moon.EARTH_MOON_DISTANCE * Math.sin(moonAngleRadians));
                panel.updateOrbitingBodyPosition(panel.earth, panel.sun, CelestialConstants.Earth.SUN_EARTH_DISTANCE * Math.cos(earthAngleRadians), CelestialConstants.Earth.SUN_EARTH_DISTANCE * Math.sin(earthAngleRadians));
                panel.updateOrbitingBodyPosition(panel.mercury, panel.sun, CelestialConstants.Mercury.SUN_MERCURY_DISTANCE * Math.cos(mercuryAngleRadians), CelestialConstants.Mercury.SUN_MERCURY_DISTANCE * Math.sin(mercuryAngleRadians));
                panel.updateOrbitingBodyPosition(panel.venus, panel.sun, CelestialConstants.Venus.SUN_VENUS_DISTANCE * Math.cos(venusAngleRadians), CelestialConstants.Venus.SUN_VENUS_DISTANCE * Math.sin(venusAngleRadians));
                panel.updateOrbitingBodyPosition(panel.mars, panel.sun, CelestialConstants.Mars.SUN_MARS_DISTANCE * Math.cos(marsAngleRadians), CelestialConstants.Mars.SUN_MARS_DISTANCE * Math.sin(marsAngleRadians));
                panel.updateOrbitingBodyPosition(panel.jupiter, panel.sun, CelestialConstants.Jupiter.SUN_JUPITER_DISTANCE * Math.cos(jupiterAngleRadians), CelestialConstants.Jupiter.SUN_JUPITER_DISTANCE * Math.sin(jupiterAngleRadians));
                panel.updateOrbitingBodyPosition(panel.saturn, panel.sun, CelestialConstants.Saturn.SUN_SATURN_DISTANCE * Math.cos(saturnAngleRadians), CelestialConstants.Saturn.SUN_SATURN_DISTANCE * Math.sin(saturnAngleRadians));
                panel.updateOrbitingBodyPosition(panel.uranus, panel.sun, CelestialConstants.Uranus.SUN_URANUS_DISTANCE * Math.cos(uranusAngleRadians), CelestialConstants.Uranus.SUN_URANUS_DISTANCE * Math.sin(uranusAngleRadians));
                panel.updateOrbitingBodyPosition(panel.neptune, panel.sun, CelestialConstants.Neptune.SUN_NEPTUNE_DISTANCE * Math.cos(neptuneAngleRadians), CelestialConstants.Neptune.SUN_NEPTUNE_DISTANCE * Math.sin(neptuneAngleRadians));
                panel.repaint();
            }
        });
        timer.start();
    }
}





   
