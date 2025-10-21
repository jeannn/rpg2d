package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
// ici on cree lecran de jeu

import entity.Player;
import object.SuperObject;
import tile.TileManager;

//extends jpanel qui est un ecran de jeu dans la class main on cree la fenetre
//implements runnable est necessaire pour le thread
public class GamePanel extends JPanel implements Runnable{

     /* 2  screen settings 
      * on doit calculer la largeur et hauteur de lecran en pixel pour injecter dans constructeur
      * une tile est de 16 pixel de base mais on peut agrandire a laide dune echelle (scale)
      * on multiplie 16 par le nombre de tiles quon veut dans le jeu
      * 
     */
    public final int originalTileSize = 16; //16*16 tile is a default size of player character
    public final int scale = 3;//echelle
    public final int tileSize = originalTileSize * scale; //48x48 parce que 16 sera trop petit sur lecran
    public final int maxScreenCol = 16;//ecran a 16 tiles horizonlale --
    public final int maxScreenRow = 12;//ecran contient 12 tiles vertical |
    public final int screenWidth = tileSize * maxScreenCol;//largeur de l'ecran 768 pixel
    public final int screenHeight = tileSize * maxScreenRow; // hauteur de l'ecran 576 pixel

    //world settings
    public final int maxWorldCol = 60;
    public final int maxWorldrow = 60;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldrow;

    Thread gameThread;// 5

    //10 
    KeyHandler keyH = new KeyHandler();

    //11 set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //FPS image par second
    int fps = 60;

    //instancier Player
    public Player player = new Player(this, keyH);

    //instancier tile manager pour dessiner les tiles
    TileManager tileM = new TileManager(this);


    public CollisionChecker cChecker = new CollisionChecker(this);
    
    public AssetSetter aSetter = new AssetSetter(this);

    public SuperObject obj [] = new SuperObject[10];


    /*constructeur */
    public GamePanel(){

        /*3 */
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));//setPreferredsize class de jpanel, on y ajoute la largeur et la hauteur en pixel
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);//default for better rendering performance

        //10
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.requestFocusInWindow();//permet de lire le clavier
    }

    public void setupGame(){
        aSetter.setObject();
    }



    /* 5 rendre le jeu existant dns le temps, 
     * ceci est necessaire pour le mouvement dimage
     * on va faire un thread qui run en meme temps. 
     * quand on commence le thread, methode run se lance automatiquement
     */
    //run generé automatiquement apres avoir add implement runnable
     @Override
     public void run() {

        //we draw the screen every drawInterval, ici 0,01666 second
        double drawInterval = 1000000000 / fps; //1000 000 000 nano =1 second 
        double nextDrawTime = System.nanoTime() + drawInterval ;

        /*as long as the game continues, it keeps calling update and repaint */
        while(gameThread != null){
            //permet dutiliser le temps pour controller le mouvement

            // update: update information such as character positions
            update();
            // draw: draw the screen with updated informations (paintComponent)          
            repaint();// this is how we call paintComponent
            
            //on va empecher le jeu de update/repaint pendant quelque temps
            try {
                double remainingTime = (nextDrawTime - System.nanoTime());
                remainingTime = remainingTime/1000000;//on converti en milisec

                //if update and repaint took more than remaining time, no need to sleep
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    public void startGameThread (){
        gameThread = new Thread(this);//creer un thread et donner la class gamePanel en argument
        gameThread.start();
    }

    /*6 
     * update 
     * paintComponent est une methode standar utilisé par game panel
    */
    public void update(){
        player.update();

    }
    public void paintComponent (Graphics g){
        //System.out.println("paint  est en marche");

        // on appelle juste la methode de la class mere game panel
        super.paintComponent(g); 
        
        Graphics2D g2 = (Graphics2D) g;//convertir le graphic en graph2d

        //dessine les tiles, doit etre fait avant de dessiner le player pour pas cacher
        tileM.draw(g2);//tile
        //objet
        for (int i =0; i<obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        player.draw(g2);//player





        g2.dispose();//release the system ressource it is using after done to save memory
        
    }

}
