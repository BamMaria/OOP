package Animation2D;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Coins extends JPanel{

    private static final long serialVersionUID = 1L;
    int x , y;
    BufferedImage coinSprite;
    Image[][] coin;
    int spriteState;

    public Coins(int x,int y){
        this();
        this.x = x;
        this.y = y;
    }

    public Coins(){

        try {
            coinSprite = ImageIO.read(new File("Assets/coin.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        coin = new Image[1][10];
        int lebar = coinSprite.getWidth()/10;
        int tinggi = coinSprite.getHeight()/1;

        for(int i=0;i<10;i++){
            coin[0][i] = coinSprite.getSubimage(lebar*i, tinggi*0, lebar, tinggi).getScaledInstance(50, 50, 0);
        }

    }

    public void update(){

        spriteState++;

        if(spriteState>=10){
            spriteState = 0;
        }

    }


    public void render(Graphics g){

        g.drawImage(coin[0][spriteState], x,y ,null);

    }

}