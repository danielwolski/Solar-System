import java.awt.Color;

public class CelestialConstants {

    public static class Earth {
        public static final int MASS = 50000;
        public static final int RADIUS = 200;
        public static final Color COLOR = Color.BLUE;
        public static final int SUN_EARTH_DISTANCE = 6000;
        public static final String NAME = "Earth";
        public static final double ROTATION_SPEED = 0.1;
    }

    public static class Moon {
        public static final int MASS = 10000;
        public static final int RADIUS = 50;
        public static final Color COLOR = new Color(200, 200, 200);
        public static final int EARTH_MOON_DISTANCE = 400;
        public static final String NAME = "Moon";
        public static final double ROTATION_SPEED = 0.6;
    }

    public static class Sun {
        public static final int X = 1700;
        public static final int Y = 5000;
        public static final int MASS = 10000000;
        public static final int RADIUS = 3000;
        public static final Color COLOR = Color.YELLOW;
        public static final String NAME = "Sun";
        public static final double ROTATION_SPEED = 0;
    }

    // Add more celestial bodies' constants here
}
