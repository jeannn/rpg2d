package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;

    //variable pour stocker matrix, numero de tiles provenant du fichier texte map
    public int mapTileNum[][];

    //constructeur qui cree les tils et appele les fonctions pour getimage et draw image 
    public TileManager (GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldrow]; //pour stocket tiles cree un tableau 2d de 16*12 (screen size)


        getTileImage();
        loadMap ("/resources/maps/map01.txt");
    }

    //recupere les 
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0]. image = ImageIO.read(getClass().getResourceAsStream("/resources/tills/grass.png"));

            tile[1] = new Tile();
            tile[1]. image = ImageIO.read(getClass().getResourceAsStream("/resources/tills/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2]. image = ImageIO.read(getClass().getResourceAsStream("/resources/tills/water.png"));
            tile[2].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/resources/tills/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/resources/tills/tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/resources/tills/sand.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap (String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);//import le fichier text
            BufferedReader br = new BufferedReader(new InputStreamReader(is));//lit le contenu du fichier

            int col = 0;
            int row = 0;

            //lire le fichier text
            while (col < gp.maxWorldCol && row < gp.maxWorldrow ) {
                String line = br.readLine();//read a single line and put it in the string (get the numbers one by one)
                while (col < gp.maxWorldCol){
                    String numbers [] = line.split(" "); //here we get the numbers received one by one and put it in the array 
                    int num = Integer.parseInt(numbers[col]);//change the string to integer
                    mapTileNum [col][row] = num;//stock
                    col++;
                }

                //mets a jour lindex colonne et rangee
                if (col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }

            br.close();//ferme le bufferreader

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void draw(Graphics2D g2){

        //dessine une tile, argument: position x,y, largeur, hauteur, null (au cas ou rien est trouver)
        /*
        g2.drawImage(tile[0].image,0, 0,gp.tileSize,gp.tileSize, null);
        g2.drawImage(tile[1].image,48, 0,gp.tileSize,gp.tileSize, null);
        g2.drawImage(tile[2].image,96, 0,gp.tileSize,gp.tileSize, null);*/

        int worldCol = 0;//variable colonne ---
        int worldRow = 0;//variable rangee |


        //dessine les tiles
        // create a note document to draw tiles, each number in the notepad is a tile number
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldrow){
            int tileNum = mapTileNum[worldCol][worldRow];//recupere le numero a la ligne col et rangee row pour lutiliser comme index et afficher limage associer en dessous

            /* world x is the position on the map and screenx is where on the screen we draw a tile*/
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;//tile screen position
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //dessine les tiles seulement autour du joueur
            //create a boundary a gauche (world x - screen x) a droite en haut et en bas
            //as long as a tile is in this boundary we draw it
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                    
                    g2.drawImage(tile[tileNum].image,screenX, screenY,gp.tileSize,gp.tileSize, null);
            }

                                


            worldCol++;//tient en compte le nombre de colonnes dans la fenetre

            //si la collone est a la fin, reinitialise col et x, agment la rangee et y, donc dessine sur la ligne du bas 
            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }



    }

}
