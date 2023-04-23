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
            double[] angles = new double[panel.celestialBodies.length];

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < panel.celestialBodies.length; i++) {
                    angles[i] += panel.celestialBodies[i].getOrbitalSpeed();
                    double angleRadians = Math.toRadians(angles[i]);
                    panel.updateOrbitingBodyPosition(panel.celestialBodies[i], panel.celestialBodies[i].getOrbitCenterX(), panel.celestialBodies[i].getOrbitCenterY(), panel.celestialBodies[i].getDistanceFromParent() * Math.cos(angleRadians), panel.celestialBodies[i].getDistanceFromParent() * Math.sin(angleRadians));
                }
                panel.repaint();
            }
                });
        timer.start();
    }
}
