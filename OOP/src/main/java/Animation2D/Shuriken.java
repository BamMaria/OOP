package Animation2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shuriken {

    int x , y;
    int veloX;
    BufferedImage shuriken;
    Image[][] shurikenSprite;
    int spriteState , lebar , tinggi;

    public Shuriken(int x,int y,int veloX){
        this();
        this.x = x;
        this.y = y;
        this.veloX = veloX;
    }

    public Shuriken() {

        try {
            shuriken = ImageIO.read(new File("Assets/shuriken.png"));
        } catch (IOException e) {

            e.printStackTrace();
        }

        shurikenSprite = new Image[1][10];
        lebar = shuriken.getWidth()/10;
        tinggi = shuriken.getHeight()/1;

        for(int i=0;i<2;i++){
            shurikenSprite[0][i] = shuriken.getSubimage(lebar*i, tinggi*0, lebar, tinggi).getScaledInstance(50, 50, 0);
        }

    }

    public void update(){

        x += veloX;

        spriteState++;

        if(spriteState >= 2){
            spriteState = 0;
        }

    }

    public void render(Graphics g){

        g.drawImage(shuriken, x,y ,null);

    }

}