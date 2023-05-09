import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class responsible for simulating a solar system. It sets up a graphical user interface
 * and animates the movements of celestial bodies.
 */
public class SolarSystemSimulation {

    /**
     * Main entry point of the simulation. It initializes the graphical interface and
     * sets up a timer to drive the celestial body movements.
     * @param args command-line arguments, not used in this application.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1200);

        SolarSystemPanel panel = new SolarSystemPanel();
        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            double[] angles = new double[panel.celestialBodies.length];

            /**
             * Called for each timer tick. It updates the position of each celestial body
             * and repaints the panel to reflect these changes.
             * @param e the event information, not used in this method.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < panel.celestialBodies.length; i++) {
                    angles[i] += panel.celestialBodies[i].getOrbitalSpeed();
                    double angleRadians = Math.toRadians(angles[i]);
                    panel.updateOrbitingBodyPosition(panel.celestialBodies[i], panel.celestialBodies[i].getParent(), panel.celestialBodies[i].getDistanceFromParent() * Math.cos(angleRadians), panel.celestialBodies[i].getDistanceFromParent() * Math.sin(angleRadians));
                }
                panel.repaint();
            }
        });
        timer.start();
    }
}
