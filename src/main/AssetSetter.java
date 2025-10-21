package main;

import object.OBJ_Door;
import object.OBJ_Key;

//handle all the pacement objetcs stuff
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 37 * gp.tileSize;//x:8, y:33
        gp.obj[0].worldY = 9*gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 46 * gp.tileSize;//x:12, y:108
        gp.obj[1].worldY = 5*gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 46 * gp.tileSize;//x:12, y:108
        gp.obj[2].worldY = 5*gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 46 * gp.tileSize;//x:12, y:108
        gp.obj[2].worldY = 5*gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 46 * gp.tileSize;//x:12, y:108
        gp.obj[2].worldY = 5*gp.tileSize;
    }
}

