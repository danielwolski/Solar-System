import java.awt.Color;

public class CelestialConstants {

    private static final int SLOWDOWN_FACTOR = 15;
    private static final int LOWER_DISTANCE_FACTOR = 2;


    public static class Sun {
        public static final int X = 1700;
        public static final int Y = 5000;
        public static final int RADIUS = 4963/LOWER_DISTANCE_FACTOR;
        public static final Color COLOR = Color.YELLOW;
        public static final String NAME = "Sun";
        public static final double ORBITAL_SPEED = 0;
    }

    public static class Mercury {
        public static final int RADIUS = 24;
        public static final Color COLOR = new Color(169, 169, 169); // Gray
        public static final int DISTANCE_FROM_PARENT = 5791/LOWER_DISTANCE_FACTOR;
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
     }

    public static class Jupiter {
        public static final int RADIUS = 699;
        public static final Color COLOR = new Color(205, 133, 63); // Peru
        public static final int DISTANCE_FROM_PARENT = 77834/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Jupiter";
        public static final double ORBITAL_SPEED = 0.32/SLOWDOWN_FACTOR;
      }

    public static class Saturn {
        public static final int RADIUS = 582;
        public static final Color COLOR = new Color(210, 180, 140); // Tan
        public static final int DISTANCE_FROM_PARENT = 142701/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Saturn";
        public static final double ORBITAL_SPEED = 0.34/SLOWDOWN_FACTOR;
     }

    public static class Uranus {
        public static final int RADIUS = 253;
        public static final Color COLOR = new Color(135, 206, 250); // Light Sky Blue
        public static final int DISTANCE_FROM_PARENT = 28709/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Uranus";
        public static final double ORBITAL_SPEED = 0.5/SLOWDOWN_FACTOR;
    }

    public static class Neptune {
        public static final int RADIUS = 246;
        public static final Color COLOR = new Color(65, 105, 225); // Royal Blue
        public static final int DISTANCE_FROM_PARENT = 44982/LOWER_DISTANCE_FACTOR ;
        public static final String NAME = "Neptune";
        public static final double ORBITAL_SPEED = 0.46/SLOWDOWN_FACTOR;
     }

    public static class Moon {
        public static final int RADIUS = 17;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 200/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Moon";
        public static final double ORBITAL_SPEED = 0.81/SLOWDOWN_FACTOR;
    }

    public static class Phobos {
        public static final int RADIUS = 7;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 148/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Phobos";
        public static final double ORBITAL_SPEED = 2.14/SLOWDOWN_FACTOR;
    }

    public static class Deimos {
        public static final int RADIUS = 5;
        public static final Color COLOR = new Color(200, 200, 200); // Light Gray
        public static final int DISTANCE_FROM_PARENT = 182/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Deimos";
        public static final double ORBITAL_SPEED = 1.35/SLOWDOWN_FACTOR;
    }

    public static class Io {
        public static final int RADIUS = 22;
        public static final Color COLOR = new Color(255, 165, 0); // Orange
        public static final int DISTANCE_FROM_PARENT = 1721/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Io";
        public static final double ORBITAL_SPEED = 17.3/SLOWDOWN_FACTOR;
    }

    public static class Europa {
        public static final int RADIUS = 18;
        public static final Color COLOR = new Color(175, 238, 238); // Pale Turquoise
        public static final int DISTANCE_FROM_PARENT = 2571/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Europa";
        public static final double ORBITAL_SPEED = 13.7/SLOWDOWN_FACTOR;
    }

    public static class Ganymede {
        public static final int RADIUS = 41;
        public static final Color COLOR = new Color(255, 127, 80); // Coral
        public static final int DISTANCE_FROM_PARENT = 4370/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Ganymede";
        public static final double ORBITAL_SPEED = 10.9/SLOWDOWN_FACTOR;
    }

    public static class Callisto {
        public static final int RADIUS = 38;
        public static final Color COLOR = new Color(112, 128, 144); // Slate Gray
        public static final int DISTANCE_FROM_PARENT = 4882/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Callisto";
        public static final double ORBITAL_SPEED = 8.2/SLOWDOWN_FACTOR;
    }

    public static class Titan {
        public static final int RADIUS = 47;
        public static final Color COLOR = new Color(160, 82, 45); // Sienna
        public static final int DISTANCE_FROM_PARENT = 4232/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Titan";
        public static final double ORBITAL_SPEED = 3.2/SLOWDOWN_FACTOR;
    }

    public static class Rhea {
        public static final int RADIUS = 25;
        public static final Color COLOR = new Color(255, 192, 203); // Pink
        public static final int DISTANCE_FROM_PARENT = 5699/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Rhea";
        public static final double ORBITAL_SPEED = 1.7/SLOWDOWN_FACTOR;
    }

    public static class Iapetus {
        public static final int RADIUS = 23;
        public static final Color COLOR = new Color(139, 69, 19); // Saddle Brown
        public static final int DISTANCE_FROM_PARENT = 6048/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Iapetus";
        public static final double ORBITAL_SPEED = 1.1/SLOWDOWN_FACTOR;
    }

    public static class Dione {
        public static final int RADIUS = 28;
        public static final Color COLOR = new Color(176, 224, 230); // Powder Blue
        public static final int DISTANCE_FROM_PARENT = 3670/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Dione";
        public static final double ORBITAL_SPEED = 2.7/SLOWDOWN_FACTOR;
    }

    public static class Titania {
        public static final int RADIUS = 39;
        public static final Color COLOR = new Color(221, 160, 221); // Plum
        public static final int DISTANCE_FROM_PARENT = 4363/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Titania";
        public static final double ORBITAL_SPEED = 1.5/SLOWDOWN_FACTOR;
    }

    public static class Oberon {
        public static final int RADIUS = 38;
        public static final Color COLOR = new Color(255, 222, 173); // Navajo White
        public static final int DISTANCE_FROM_PARENT = 4835/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Oberon";
        public static final double ORBITAL_SPEED = 1.4/SLOWDOWN_FACTOR;
    }

    public static class Umbriel {
        public static final int RADIUS = 29;
        public static final Color COLOR = new Color(128, 128, 128); // Gray
        public static final int DISTANCE_FROM_PARENT = 2360/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Umbriel";
        public static final double ORBITAL_SPEED = 4.1/SLOWDOWN_FACTOR;
    }

    public static class Ariel {
        public static final int RADIUS = 36;
        public static final Color COLOR = new Color(152, 251, 152); // Pale Green
        public static final int DISTANCE_FROM_PARENT = 1612/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Ariel";
        public static final double ORBITAL_SPEED = 5.5/SLOWDOWN_FACTOR;
    }

    public static class Miranda {
        public static final int RADIUS = 20;
        public static final Color COLOR = new Color(245, 245, 220); // Beige
        public static final int DISTANCE_FROM_PARENT = 1299/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Miranda";
        public static final double ORBITAL_SPEED = 6.7/SLOWDOWN_FACTOR;
    }

    public static class Triton {
        public static final int RADIUS = 40;
        public static final Color COLOR = new Color(255, 248, 220); // Cornsilk
        public static final int DISTANCE_FROM_PARENT = 2847/LOWER_DISTANCE_FACTOR;
        public static final String NAME = "Triton";
        public static final double ORBITAL_SPEED = 5.8/SLOWDOWN_FACTOR;
    }

}
