import java.awt.Color;

public class CelestialConstants {

    private static final int SLOWDOWN_FACTOR = 150;
    private static final int LOWER_DISTANCE_FACTOR = 2;


    public static class Sun {
        public static final int X = 1700;
        public static final int Y = 5000;
        public static final int RADIUS = 68780;
        public static final Color COLOR = Color.YELLOW;
        public static final String NAME = "Sun";
        public static final double ORBITAL_SPEED = 0;
    }

    public static class Mercury {
        public static final int RADIUS = 240;
        public static final Color COLOR = new Color(169, 169, 169); // Gray
        public static final int DISTANCE_FROM_PARENT = 57910*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Mercury";
        public static final double ORBITAL_SPEED = 1.24/SLOWDOWN_FACTOR;
    }

    public static class Venus {
        public static final int RADIUS = 600;
        public static final Color COLOR = new Color(218, 165, 32); // Goldenrod
        public static final int DISTANCE_FROM_PARENT = 108210*LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Venus";
        public static final double ORBITAL_SPEED = 0.36/SLOWDOWN_FACTOR;
    }

    public static class Earth {
        public static final int DISTANCE_FROM_PARENT = 149600*LOWER_DISTANCE_FACTOR ;
        public static final int RADIUS = 630;
        public static final Color COLOR = Color.BLUE;
        public static final String NAME = "Earth";
        public static final double ORBITAL_SPEED = 0.48/SLOWDOWN_FACTOR;
    }

    public static class Mars {
        public static final int RADIUS = 340;
        public static final Color COLOR = new Color(255, 99, 71); // Tomato
        public static final int DISTANCE_FROM_PARENT= 227940*LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Mars";
        public static final double ORBITAL_SPEED = 0.25/SLOWDOWN_FACTOR;
    }

    public static class Jupiter {
        public static final int RADIUS = 6930;
        public static final Color COLOR = new Color(205, 133, 63); // Peru
        public static final int DISTANCE_FROM_PARENT = 778340*LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Jupiter";
        public static final double ORBITAL_SPEED = 0.32/SLOWDOWN_FACTOR;
    }

    public static class Saturn {
        public static final int RADIUS = 5760;
        public static final Color COLOR = new Color(210, 180, 140); // Tan
        public static final int DISTANCE_FROM_PARENT = 1427010*LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Saturn";
        public static final double ORBITAL_SPEED = 0.34/SLOWDOWN_FACTOR;
    }

    public static class Uranus {
        public static final int RADIUS = 2510;
        public static final Color COLOR = new Color(135, 206, 250); // Light Sky Blue
        public static final int DISTANCE_FROM_PARENT = 2870980*LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Uranus";
        public static final double ORBITAL_SPEED = 0.5/SLOWDOWN_FACTOR;
    }

    public static class Neptune {
        public static final int RADIUS = 2440;
        public static final Color COLOR = new Color(65, 105, 225); // Royal Blue
        public static final int DISTANCE_FROM_PARENT = 4498450*LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Neptune";
        public static final double ORBITAL_SPEED = 0.46/SLOWDOWN_FACTOR;
    }

    public static class Moon {
        public static final int RADIUS = 170;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 2000*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Moon";
        public static final double ORBITAL_SPEED = 0.81/SLOWDOWN_FACTOR;
    }

    public static class Phobos {
        public static final int RADIUS = 10;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 1480*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Phobos";
        public static final double ORBITAL_SPEED = 2.14/SLOWDOWN_FACTOR;
    }

    public static class Deimos {
        public static final int RADIUS = 10;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 1820*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Deimos";
        public static final double ORBITAL_SPEED = 1.35/SLOWDOWN_FACTOR;
    }

    public static class Io {
        public static final int RADIUS = 180;
        public static final Color COLOR = new Color(255, 165, 0); // Orange
        public static final int DISTANCE_FROM_PARENT = 17210*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Io";
        public static final double ORBITAL_SPEED = 17.3/SLOWDOWN_FACTOR;
    }

    public static class Europa {
        public static final int RADIUS = 150;
        public static final Color COLOR = new Color(175, 238, 238); // Pale Turquoise
        public static final int DISTANCE_FROM_PARENT = 25710*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Europa";
        public static final double ORBITAL_SPEED = 13.7/SLOWDOWN_FACTOR;
    }

    public static class Ganymede {
        public static final int RADIUS = 260;
        public static final Color COLOR = new Color(255, 127, 80); // Coral
        public static final int DISTANCE_FROM_PARENT = 43700*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Ganymede";
        public static final double ORBITAL_SPEED = 10.9/SLOWDOWN_FACTOR;
    }

    public static class Callisto {
        public static final int RADIUS = 240;
        public static final Color COLOR = new Color(112, 128, 144); // Slate Gray
        public static final int DISTANCE_FROM_PARENT = 48820*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Callisto";
        public static final double ORBITAL_SPEED = 8.2/SLOWDOWN_FACTOR;
    }

    public static class Titan {
        public static final int RADIUS = 260;
        public static final Color COLOR = new Color(160, 82, 45); // Sienna
        public static final int DISTANCE_FROM_PARENT = 42320*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Titan";
        public static final double ORBITAL_SPEED = 3.2/SLOWDOWN_FACTOR;
    }

    public static class Rhea {
        public static final int RADIUS = 80;
        public static final Color COLOR = new Color(255, 192, 203); // Pink
        public static final int DISTANCE_FROM_PARENT = 56990*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Rhea";
        public static final double ORBITAL_SPEED = 1.7/SLOWDOWN_FACTOR;
    }

    public static class Iapetus {
        public static final int RADIUS = 70;
        public static final Color COLOR = new Color(139, 69, 19); // Saddle Brown
        public static final int DISTANCE_FROM_PARENT = 60480*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Iapetus";
        public static final double ORBITAL_SPEED = 1.1/SLOWDOWN_FACTOR;
    }

    public static class Dione {
        public static final int RADIUS = 60;
        public static final Color COLOR = new Color(176, 224, 230); // Powder Blue
        public static final int DISTANCE_FROM_PARENT = 36700*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Dione";
        public static final double ORBITAL_SPEED = 2.7/SLOWDOWN_FACTOR;
    }

    public static class Titania {
        public static final int RADIUS = 80;
        public static final Color COLOR = new Color(221, 160, 221); // Plum
        public static final int DISTANCE_FROM_PARENT = 43630*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Titania";
        public static final double ORBITAL_SPEED = 1.5/SLOWDOWN_FACTOR;
    }

    public static class Oberon {
        public static final int RADIUS = 80;
        public static final Color COLOR = new Color(255, 222, 173); // Navajo White
        public static final int DISTANCE_FROM_PARENT = 48350*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Oberon";
        public static final double ORBITAL_SPEED = 1.4/SLOWDOWN_FACTOR;
    }

    public static class Umbriel {
        public static final int RADIUS = 60;
        public static final Color COLOR = new Color(128, 128, 128); // Gray
        public static final int DISTANCE_FROM_PARENT = 23600*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Umbriel";
        public static final double ORBITAL_SPEED = 4.1/SLOWDOWN_FACTOR;
    }

    public static class Ariel {
        public static final int RADIUS = 60;
        public static final Color COLOR = new Color(152, 251, 152); // Pale Green
        public static final int DISTANCE_FROM_PARENT = 16120*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Ariel";
        public static final double ORBITAL_SPEED = 5.5/SLOWDOWN_FACTOR;
    }

    public static class Miranda {
        public static final int RADIUS = 20;
        public static final Color COLOR = new Color(245, 245, 220); // Beige
        public static final int DISTANCE_FROM_PARENT = 12990*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Miranda";
        public static final double ORBITAL_SPEED = 6.7/SLOWDOWN_FACTOR;
    }

    public static class Triton {
        public static final int RADIUS = 130;
        public static final Color COLOR = new Color(255, 248, 220); // Cornsilk
        public static final int DISTANCE_FROM_PARENT = 28470*LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Triton";
        public static final double ORBITAL_SPEED = 5.8/SLOWDOWN_FACTOR;
    }

}
