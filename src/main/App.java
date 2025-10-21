package main;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        /* 1 creer une fenetre*/
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet de pouvoir fermer la fenetre 
        window.setResizable(false);//interdire le changement de taille de la fenetre
        window.setLocationRelativeTo(null);//centrer la fenetre au milieu de lecran
        window.setTitle("Aventure 2D");//titre
        window.setVisible(true);//rendre la fenetre visible

        /*4 ajouter l'ecran du jeu a la fenetre */
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();//ajuster la fenetre a l'ecran du jeu

        gamePanel.setupGame();
        gamePanel.startGameThread();
        gamePanel.requestFocusInWindow();//permet de lire clavier

        
    }
}
