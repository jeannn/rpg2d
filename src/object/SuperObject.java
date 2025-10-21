package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;//tile screen position
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //dessine les tiles seulement autour du joueur
            //create a boundary a gauche (world x - screen x) a droite en haut et en bas
            //as long as a tile is in this boundary we draw it
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                    
                    g2.drawImage(image,screenX, screenY,gp.tileSize,gp.tileSize, null);
            }
    }
    
}
