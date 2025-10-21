package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*8 pour avoir les retour clavier pour fair bouger le carrer */
public class KeyHandler implements KeyListener{

    public boolean haut, bas, gauche, droite;

    @Override
    public void keyTyped(KeyEvent e) {
       
        
    }

    //9 lire le clavier et set les boolean variable si une touche est appuiyée
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if((code == KeyEvent.VK_W) || (code == KeyEvent.VK_UP)){
            haut = true;

        }
        if((code == KeyEvent.VK_S) || (code == KeyEvent.VK_DOWN)){
            bas = true;
        }
        if((code == KeyEvent.VK_A) || (code == KeyEvent.VK_LEFT)){
            gauche = true;
        }
        if((code == KeyEvent.VK_D) || (code == KeyEvent.VK_RIGHT)){
            droite = true;
        }
        
    }

    //9 lire le clavier et set les boolean variable si une touche est relachée
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if((code == KeyEvent.VK_W) || (code == KeyEvent.VK_UP)){
            haut = false;
        }
        if((code == KeyEvent.VK_S) || (code == KeyEvent.VK_DOWN)){
            bas = false;
        }
        if((code == KeyEvent.VK_A) || (code == KeyEvent.VK_LEFT)){
            gauche = false;
        }
        if((code == KeyEvent.VK_D) || (code == KeyEvent.VK_RIGHT)){
            droite = false;
        }
    }

}
