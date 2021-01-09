package Animation2D;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Hero extends JPanel{


    private static final long serialVersionUID = 1L;
    int x , y , lebar , tinggi;
    int veloX , veloY;
    BufferedImage runSprite , jumpSprite , run2Sprite , jump2Sprite ;
    Image[][] spritesRun , spritesJump;
    int direction , spriteState;
    int health;


    public Hero(){

        health = 200;
        x = 300;
        y = 600;
        veloX = 0;
        veloY = 0;
        direction = 0;
        spriteState = 0;


        try {
            runSprite = ImageIO.read(new File("Assets/run.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            run2Sprite = ImageIO.read(new File("Assets/runLeft.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            jumpSprite = ImageIO.read(new File("Assets/jump.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            jump2Sprite = ImageIO.read(new File("Assets/jumpLeft.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        spritesRun = new Image[4][5];
        lebar = runSprite.getWidth() / 5;
        tinggi = runSprite.getHeight() / 2;

        for(int i=0;i<5;i++){
            spritesRun[0][i]= runSprite.getSubimage(lebar*i,tinggi*0,lebar,tinggi).getScaledInstance(100, 100, 0);
        }

        for(int i=0;i<5;i++){
            spritesRun[1][i]= run2Sprite.getSubimage(lebar*i,tinggi*0,lebar,tinggi).getScaledInstance(100, 100, 0);
        }


        int lebarJump = jumpSprite.getWidth() / 4;
        int tinggiJump = jumpSprite.getHeight() / 2;

        for(int i=0 ;i<4;i++){
            spritesRun[2][i] = jumpSprite.getSubimage(lebarJump*i, tinggiJump*0, lebarJump, tinggiJump).getScaledInstance(100, 100, 0);
        }

        for(int i=0 ;i<4;i++){
            spritesRun[3][i] = jump2Sprite.getSubimage(lebarJump*i, tinggiJump*0, lebarJump, tinggiJump).getScaledInstance(100, 100, 0);
        }

    }


    public void update(){

        x += veloX;
        y += veloY;

        if(veloX != 0 || veloY != 0){


            if(x<=0){
                x=0;
            }
            else if(x>=1100){
                x=1100;
            }

            if(y == 480 && veloY != 0){
                veloY = 6;
            }

            if(y == 600 && veloY !=0){
                if(direction ==2){
                    direction =0;
                }
                else if(direction ==3){
                    direction =1;
                }
                veloY = 0;
                y = 600;
            }

            spriteState++;

            if(direction == 0){
                if(spriteState>=5){
                    spriteState = 0;
                }
            }
            else if(direction ==1){
                if(spriteState>=5){
                    spriteState=0;
                }
            }
            else if(direction == 2){
                if(spriteState>=4){
                    spriteState=0;
                    if(y==600){
                        veloY=0;
                        y=600;
                        direction =0;
                    }
                }
            }
            else if(direction == 3){
                if(spriteState>=4){
                    spriteState=0;
                    if(y==600){
                        veloY=0;
                        y=600;
                        direction =1;
                    }
                }
            }

        }

    }

    public void render(Graphics g){

        g.drawImage(spritesRun[direction][spriteState], x , y , null);

        //g.drawImage(spritesJump[directionJump][spriteState], x, y, null);


    }

}
