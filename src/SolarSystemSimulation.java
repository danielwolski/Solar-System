import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystemSimulation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);

        SolarSystemPanel panel = new SolarSystemPanel();
        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(20, new ActionListener() {
            double angle = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 1;
                double angleRadians = Math.toRadians(angle);
                panel.updateMoonPosition(150 * Math.cos(angleRadians), 150 * Math.sin(angleRadians));
                panel.repaint();
            }
        });
        timer.start();
    }
}





   
