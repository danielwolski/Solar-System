import java.awt.Color;

public class CelestialConstants {

    private static final int SLOWDOWN_FACTOR = 5;
    private static final int LOWER_DISTANCE_FACTOR = 5;

    public static class Sun {
        public static final int X = 1700;
        public static final int Y = 5000;
        public static final int MASS = 10000000;
        public static final int RADIUS = 4963/LOWER_DISTANCE_FACTOR ;
        public static final Color COLOR = Color.YELLOW;
        public static final String NAME = "Sun";
        public static final double ORBITAL_SPEED = 0;
    }

    public static class Mercury {
        public static final int MASS = 50000;
        public static final int RADIUS = 24;
        public static final Color COLOR = new Color(169, 169, 169); // Gray
        //public static final int SUN_MERCURY_DISTANCE = 5791000;
        public static final int SUN_MERCURY_DISTANCE = 5791/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Mercury";
        public static final double ORBITAL_SPEED = 0.14/SLOWDOWN_FACTOR;
    }

    public static class Venus {
        public static final int MASS = 50000;
        public static final int RADIUS = 60;
        public static final Color COLOR = new Color(218, 165, 32); // Goldenrod
        //public static final int SUN_VENUS_DISTANCE = 10821000;
        public static final int SUN_VENUS_DISTANCE = 10821/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Venus";
        public static final double ORBITAL_SPEED = 0.16/SLOWDOWN_FACTOR;
    }

    public static class Earth {
        public static final int MASS = 50000;
        public static final int RADIUS = 63;
        public static final Color COLOR = Color.BLUE;
        //public static final int SUN_EARTH_DISTANCE = 14960000;
        public static final int SUN_EARTH_DISTANCE = 14960/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Earth";
        public static final double ORBITAL_SPEED = 0.18/SLOWDOWN_FACTOR;
    }

    public static class Mars {
        public static final int MASS = 50000;
        public static final int RADIUS = 33;
        public static final Color COLOR = new Color(255, 99, 71); // Tomato
        //public static final int SUN_MARS_DISTANCE = 22794000;
        public static final int SUN_MARS_DISTANCE = 22794/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Mars";
        public static final double ORBITAL_SPEED = 0.2/SLOWDOWN_FACTOR;
    }

    public static class Jupiter {
        public static final int MASS = 50000;
        public static final int RADIUS = 699;
        public static final Color COLOR = new Color(205, 133, 63); // Peru
        //public static final int SUN_JUPITER_DISTANCE = 77834000;
        public static final int SUN_JUPITER_DISTANCE = 77834/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Jupiter";
        public static final double ORBITAL_SPEED = 0.22/SLOWDOWN_FACTOR;
    }

    public static class Saturn {
        public static final int MASS = 50000;
        public static final int RADIUS = 582;
        public static final Color COLOR = new Color(210, 180, 140); // Tan
        //public static final int SUN_SATURN_DISTANCE = 142701000;
        public static final int SUN_SATURN_DISTANCE = 142701/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Saturn";
        public static final double ORBITAL_SPEED = 0.24/SLOWDOWN_FACTOR;
    }

    public static class Uranus {
        public static final int MASS = 50000;
        public static final int RADIUS = 253;
        public static final Color COLOR = new Color(135, 206, 250); // Light Sky Blue
        //public static final int SUN_URANUS_DISTANCE = 28709700;
        public static final int SUN_URANUS_DISTANCE = 28709/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Uranus";
        public static final double ORBITAL_SPEED = 0.23/SLOWDOWN_FACTOR;
    }

    public static class Neptune {
        public static final int MASS = 50000;
        public static final int RADIUS = 246;
        public static final Color COLOR = new Color(65, 105, 225); // Royal Blue
        //public static final int SUN_NEPTUNE_DISTANCE = 44982600;
        public static final int SUN_NEPTUNE_DISTANCE = 44982/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Neptune";
        public static final double ORBITAL_SPEED = 0.26/SLOWDOWN_FACTOR;
    }

    public static class Moon {
        public static final int MASS = 10000;
        public static final int RADIUS = 17;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int EARTH_MOON_DISTANCE = 90;
        public static final String NAME = "Moon";
        public static final double ORBITAL_SPEED = 0.11/SLOWDOWN_FACTOR;
    }
}