import java.awt.Color;

public class CelestialConstants {

    private static final int SLOWDOWN_FACTOR = 5;
    private static final int LOWER_DISTANCE_FACTOR = 5;

    public static class Sun {
        public static final int X = 1700;
        public static final int Y = 5000;
        public static final int RADIUS = 4963/LOWER_DISTANCE_FACTOR ;
        public static final Color COLOR = Color.YELLOW;
        public static final String NAME = "Sun";
        public static final double ORBITAL_SPEED = 0;
    }

    public static class Mercury {
        public static final int RADIUS = 24;
        public static final Color COLOR = new Color(169, 169, 169); // Gray
        public static final int DISTANCE_FROM_PARENT = 5791/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Mercury";
        public static final double ORBITAL_SPEED = 1.24/SLOWDOWN_FACTOR;
    }

    public static class Venus {
        public static final int RADIUS = 60;
        public static final Color COLOR = new Color(218, 165, 32); // Goldenrod
        public static final int DISTANCE_FROM_PARENT = 10821/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Venus";
        public static final double ORBITAL_SPEED = 0.36/SLOWDOWN_FACTOR;
    }

    public static class Earth {
        public static final int DISTANCE_FROM_PARENT = 14960/LOWER_DISTANCE_FACTOR ;
        public static final int X = Sun.X + DISTANCE_FROM_PARENT;
        public static final int Y = Sun.Y;
        public static final int RADIUS = 63;
        public static final Color COLOR = Color.BLUE;
        public static final String NAME = "Earth";
        public static final double ORBITAL_SPEED = 0.48/SLOWDOWN_FACTOR;
    }

    public static class Mars {
        public static final int RADIUS = 33;
        public static final Color COLOR = new Color(255, 99, 71); // Tomato
        public static final int DISTANCE_FROM_PARENT= 22794/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Mars";
        public static final double ORBITAL_SPEED = 0.25/SLOWDOWN_FACTOR;
        public static final int X = Sun.X + DISTANCE_FROM_PARENT;
        public static final int Y = Sun.Y;
     }

    public static class Jupiter {
        public static final int RADIUS = 699;
        public static final Color COLOR = new Color(205, 133, 63); // Peru
        public static final int DISTANCE_FROM_PARENT = 77834/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Jupiter";
        public static final double ORBITAL_SPEED = 0.32/SLOWDOWN_FACTOR;
        public static final int X = Sun.X + DISTANCE_FROM_PARENT;
        public static final int Y = Sun.Y;
      }

    public static class Saturn {
        public static final int RADIUS = 582;
        public static final Color COLOR = new Color(210, 180, 140); // Tan
        public static final int DISTANCE_FROM_PARENT = 142701/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Saturn";
        public static final double ORBITAL_SPEED = 0.34/SLOWDOWN_FACTOR;
        public static final int X = Sun.X + DISTANCE_FROM_PARENT;
        public static final int Y = Sun.Y;
     }

    public static class Uranus {
        public static final int RADIUS = 253;
        public static final Color COLOR = new Color(135, 206, 250); // Light Sky Blue
        public static final int DISTANCE_FROM_PARENT = 28709/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Uranus";
        public static final double ORBITAL_SPEED = 0.5/SLOWDOWN_FACTOR;
        public static final int X = Sun.X + DISTANCE_FROM_PARENT;
        public static final int Y = Sun.Y;
    }

    public static class Neptune {
        public static final int RADIUS = 246;
        public static final Color COLOR = new Color(65, 105, 225); // Royal Blue
        public static final int DISTANCE_FROM_PARENT = 44982/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Neptune";
        public static final double ORBITAL_SPEED = 0.46/SLOWDOWN_FACTOR;
        public static final int X = Sun.X + DISTANCE_FROM_PARENT;
        public static final int Y = Sun.Y;
     }

    public static class Moon {
        public static final int RADIUS = 17;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 90;
        public static final String NAME = "Moon";
        public static final double ORBITAL_SPEED = 0.81/SLOWDOWN_FACTOR;
        public static final int X = Earth.X + DISTANCE_FROM_PARENT;
        public static final int Y = Earth.Y;
    }
}
