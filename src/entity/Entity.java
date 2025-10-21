package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    //public int x,y;//not using the player x and y to move the player on the map instead we will move the map and the player stays in the middle
    public int worldX, worldY; //remplace x et y la position du joueur sur la world map
    public int speed;//new

    public BufferedImage haut1, haut2, bas1, bas2, gauche1, gauche2, droite1, droite2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    //invisible abstract rectangle and store data x,y etc
    public Rectangle solidArea;

    public boolean collisionOn = false; 
}
