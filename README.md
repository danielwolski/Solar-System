# Solar-System


## Project description
2D Solar System visualization in JAVA using Swing. The main goal is to create a educational tool that will allow to visualize in an interesting way how does the Solar system work.


## How to install and run
- variable "pathBeg" located in ImagePaths.java should point to the images_folder as in this example: "C:\\Users\\Username\\Desktop\\Solar-System-WIP-\\src\\images_"

## Manual
- Move the view - user needs to click and hold the mouse button, and then move the mouse cursor.
 - Zoom in/out - user needs to use mouse scroll. Currently, the zooming functionality is focused on the upper left corner of the window

## Update notes:

v1.0*

- displayed circles - each circle represents one celestial body
- added name of each celestial body inside its circle representation
- implement basic Moon rotation around Earth
- implement line presenting the orbit of the Moon
- Java
- zooming in and out

v1.1
- added Sun
- Earth now rotates around Sun

v1.2*
- Added all lacking planets of solar system
- Changes in zoom in/out functionality
- Sizes of planets are now scaled according to reality
- standardization of constant describing distance from parent planet,
it is a preparatory step to implement cleaner management of declaring
celestial bodies and drawing them/their orbits.

v1.3
- code restructurization - now less code, it's easier to add new bodies
- improved zoom in/out - fixed bug caused by zooming out too far

v1.4*
- add most important moons of planets in solar system: "Phobos, Deimos, Io, Europa, Ganymede, Calisto, Titan, Rhea, Iapetus, Dione, Titania, Oberon, Umbriel, Ariel, Miranda, Triton"
- add background image of Milky Way from Wikimedia Commons
- add Sun, Jupiter, Earth, Moon, Mars, Uranus and Neptun images from Wikimedia Commons
- adjusted zooming properties and celestial bodies constants
