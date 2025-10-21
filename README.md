# java rpg 2d

A small 2D RPG-style game built in Java made for fun and to learn the fundamentals of game programming.
Your goal: explore the map, move your character,  (and interact with the world not implemented yet!)

## Description

This project is a simple RPG (Role-Playing Game) made from scratch in Java.
It was created as a personal learning project to understand how games work including tile maps, collision systems, and basic rendering loops.

The game includes:

A tile-based world map

Player movement and collision detection

Basic graphics loaded from resources

Experiments with Java’s game loop, image handling, and keyboard input

## Getting Started

### Dependencies

Before running the project, make sure you have:

Java Development Kit (JDK 17 or higher)

Any IDE (IntelliJ IDEA, Eclipse, or VS Code with Java extension)

Works on Windows, macOS, and Linux

#### To view or modify the code:

Clone this repository git clone https://github.com/jeannn/rpg2d.git

Open the folder in your IDE, then build and run the project.

If you’re using IntelliJ or VS Code:

Open the project folder.

Ensure the /resources folder is correctly set as a resource root.

Run the main class (usually Main.java).


### How to play:
Use Arrow Keys / WASD to move your character

Explore the map, trees, water, and sand are generated procedurally

You can’t walk through walls, water, or trees (collision is enabled)

### Tile system
Tile System

The world is made up of tiles:

| ID | Tile  | Description     | Collision |
|----|--------|-----------------|------------|
| 0  | Grass  | Default ground  | ❌ |
| 1  | Wall   | A wall          | ✅ |
| 2  | Water  | Lake or river   | ✅ |
| 3  | Earth  | Path or road    | ❌ |
| 4  | Tree   | Forest area     | ✅ |
| 5  | Sand   | Beach or shore  | ❌ |

## Executing the Program

Run the main game file
The game window should appear, displaying the map and your player.

## Help

The game doesn’t start or shows a blank screen?

Check that your /resources folder is in the correct directory.

Ensure your image paths like( /resources/tills/grass.png) are valid.

If images fail to load, verify your classpath settings in the IDE.

## Authors

Contributors: Jean Marcel


## Version History

* Initial Release


## Acknowledgments

Inspiration, tutorials, and learning resources:

YouTube Java Game Dev Tutorials

Stack Overflow (for debugging help)

Personal experimentation & curiosity
