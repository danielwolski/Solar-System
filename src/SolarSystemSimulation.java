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

            @Override
            public void actionPerformed(ActionEvent e) {
                earthAngle += panel.earth.getRotationSpeed();
                moonAngle += panel.moon.getRotationSpeed();
                double earthAngleRadians = Math.toRadians(earthAngle);
                double moonAngleRadians = Math.toRadians(moonAngle);
                panel.updateOrbitingBodyPosition(panel.moon, panel.earth, CelestialConstants.Moon.EARTH_MOON_DISTANCE * Math.cos(moonAngleRadians), CelestialConstants.Moon.EARTH_MOON_DISTANCE * Math.sin(moonAngleRadians));
                panel.updateOrbitingBodyPosition(panel.earth, panel.sun, CelestialConstants.Earth.SUN_EARTH_DISTANCE * Math.cos(earthAngleRadians), CelestialConstants.Earth.SUN_EARTH_DISTANCE * Math.sin(earthAngleRadians));
                panel.repaint();
            }
        });
        timer.start();
    }
}





   
