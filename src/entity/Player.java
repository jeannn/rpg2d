package entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;



public class Player extends Entity{
     GamePanel gp;
     KeyHandler keyH;

     public final int screenX,screenY;
     
    
     int counter2= 0;
     

     public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        //x,y,width, heigh
        solidArea = new Rectangle(8,16,32,32);

        //ou le joueur se situ sur lecran
        //ca ne change pas, on bouge la map
        screenX = gp.screenWidth/2 - (gp.tileSize/2);//on veut ce soit au milieu mis ca nest pas
        screenY = gp.screenHeight/2 - (gp.tileSize/2);//soustraire ca place le personnage au milieu

        setDefaultValue();
        getPlayerImage();
     }

     public void setDefaultValue(){
        worldX = gp.tileSize * 30;
        worldY = gp.tileSize * 30 ;
        speed = 4;
        direction = "down";
     }

     //charger les images du joueur du dossier res
     public void getPlayerImage(){
        try {
        
            haut1 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_up_1.png"));
            haut2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_up_2.png"));
            bas1 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_down_1.png"));
            bas2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_down_2.png"));
            gauche1 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_left_1.png"));
            gauche2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_left_2.png"));
            droite1 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_right_1.png"));
            droite2 = ImageIO.read(getClass().getResourceAsStream("/resources/player/jean_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

     public void update(){
        //cette fonction update se fait appeler 60 foie par second
        //11 vu que le point 0,0 est en haut a gauche, x augmente vas a droite et y diminu va en haut 
        //if sexecute si une touche est appuiyee
        if(keyH.haut == true|| keyH.bas == true ||keyH.gauche == true || keyH.droite == true){
            if(keyH.haut == true){
                direction="up";
                 
            }
            else if(keyH.bas == true){
                direction="down";
                
            }
            else if(keyH.gauche == true){
                direction="left";
                
            }
            else if(keyH.droite == true){
                direction = "right";
                
            }
            //check tile colision 
            collisionOn = false;
            gp.cChecker.checkTitle(this);

            //if colision is false, player can move
            if(collisionOn == false){
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;

                    case "down":
                        worldY += speed;
                        break;

                    case "left":
                        worldX -= speed;
                        break;

                    case "right":
                    worldX += speed;
                    break;
                
                }
            }

            //se fait appeler a chaque itteration et augmente le counter
            //counter calcule le nombre dimage, chaque 10 image, on change pour la deuxieme
            spriteCounter++;
            if(spriteCounter>11){
                if(spriteNum == 1){
                    spriteNum=2;
                }
                else if(spriteNum==2){
                    spriteNum = 1;
                }
                spriteCounter=0;
            }
        }
     }

     public void draw(Graphics2D g2){
        
        BufferedImage image = null;
        //adapt limage qui apparait selon la touche pressed dans update
        switch (direction) {
            //on veut alterner entre deux images pour donner limpression que le personnage se deplace
            //la clause if sert a ca
            case "up":
            if(spriteNum == 1){
                image = haut1;
            }
            if(spriteNum == 2){
                image = haut2;
            }      
                break;

            case "down":
            if(spriteNum == 1){
                image = bas1;
            }
            if(spriteNum == 2){
                image = bas2;
            }  
                break;
            case "left":
            if(spriteNum == 1){
                image = gauche1;
            }
            if(spriteNum == 2){
                image = gauche2;
            }  
                break;
            case "right":
            if(spriteNum == 1){
                image = droite1;
            }
            if(spriteNum == 2){
                image = droite2;
            }  
                break;
            default:
                break;
        }

        //dessine l'image sur lecran
        g2.drawImage(image, screenX,screenY, gp.tileSize, gp.tileSize, null);


     }
}
