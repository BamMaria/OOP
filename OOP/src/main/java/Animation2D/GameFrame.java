package Animation2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;


public class GameFrame extends JFrame implements KeyListener, Runnable {


    private static final long serialVersionUID = 1L;
    CanvasPanel canvas;
    int count=0;
    Thread thread;
    Hero player;

    public GameFrame(){

        canvas = new CanvasPanel();

        add(canvas);

        addKeyListener(this);

        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        music();

        thread = new Thread(this);
        thread.start();

        Random rand = new Random();



        while(count<=1000){


            int coorX = rand.nextInt(1000) + 100;

            if(canvas.coinStat == false){
                canvas.coins.add(new Coins(coorX,600));
                canvas.coinStat = true;
            }

            int veloX = rand.nextInt(5)+10;
            int  coorY = rand.nextInt(550) + 100;
            int  coorYLeft = rand.nextInt(550) + 100;
            int  coorY2 = rand.nextInt(550) + 100;
            int  coorYLeft2 = rand.nextInt(550) + 100;

            canvas.missiles.add(new Missiles(1100,coorY,-veloX));
            veloX = rand.nextInt(5)+10;
            canvas.missilesLeft.add(new MissilesLeft(0,coorYLeft,veloX));
            veloX = rand.nextInt(5)+10;
            canvas.missiles.add(new Missiles(1100,coorY2,-veloX));
            veloX = rand.nextInt(5)+10;
            canvas.missilesLeft.add(new MissilesLeft(0,coorYLeft2,veloX));

            try {

                Thread.sleep(3000);
                count++;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
    }


    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch(arg0.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if(canvas.player.y<600){
                    canvas.player.veloX = 10;
                }
                else{
                    canvas.player.veloX =10;
                    canvas.player.direction =0;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(canvas.player.y<600){
                    canvas.player.veloX = -10;
                }
                else{
                    canvas.player.veloX = -10;
                    canvas.player.direction =1;
                }
                break;
            case KeyEvent.VK_UP:
                if(canvas.player.y==600 && canvas.player.direction == 0){
                    canvas.player.veloY = -120;
                    canvas.player.direction =2;
                    musicJump();
                }
                else if(canvas.player.y==600 && canvas.player.direction == 1){
                    canvas.player.veloY = -120;
                    canvas.player.direction =3;
                    musicJump();
                }
                break;
            case KeyEvent.VK_SPACE:
//			if(canvas.player.direction == 0){
//				canvas.shurikens.add(new Shuriken(canvas.player.x , canvas.player.y,10));
//			}
//			if(canvas.player.direction == 1){
//				canvas.shurikens.add(new Shuriken(canvas.player.x , canvas.player.y,-10));
//			}
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch(arg0.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                canvas.player.veloX =0;
                break;
            case KeyEvent.VK_LEFT:
                canvas.player.veloX =0;
                break;
            case KeyEvent.VK_UP:
                if(canvas.player.y==480)
                    canvas.player.veloY =6;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    public static void music()
    {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Backsound.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(100);
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

    public static void musicJump()
    {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Jump.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }


}