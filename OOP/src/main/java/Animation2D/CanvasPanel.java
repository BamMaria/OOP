package Animation2D;


import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


public class CanvasPanel extends JPanel implements Runnable {


    private static final long serialVersionUID = 1L;
    Hero player;
    Thread thread;
    Image bg;
    Coins coin;
    Missiles missile;
    MissilesLeft missileLeft;
    Shuriken shuriken;
    Vector<Missiles> missiles = new Vector<>();
    Vector<MissilesLeft> missilesLeft = new Vector<>();
    Vector<Coins> coins = new Vector<>();
    Vector<Shuriken> shurikens = new Vector<>();
    char[] text = new char[]{'H', 'H', 'e', 'a', 'l', 't', 'h'};
    char[] endText = new char[]{'G', 'G', 'A', 'M', 'E'};
    char[] endText2 = new char[]{'G', 'O', 'V', 'E', 'R'};
    char[] scoreText = new char[]{'S', 'S', 'C', 'O', 'R', 'E', ':'};
    int score = 0;
    String scorePoint = String.valueOf(score);
    boolean coinStat = false;

    public CanvasPanel() {

        player = new Hero();

        thread = new Thread(this);
        thread.start();

        try {
            bg = ImageIO.read(new File("Assets/background.gif")).getScaledInstance(1200, 800, 0);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void run() {

        while (true) {
            scorePoint = String.valueOf(score);
            repaint();
            player.update();

            for (Shuriken shuriken : shurikens) {
                shuriken.update();
            }

            for (Coins coin : coins) {
                coin.update();
            }

            for (Missiles missile : missiles) {
                missile.update();
            }

            for (MissilesLeft missileLeft : missilesLeft) {
                missileLeft.update();
            }

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            for (int i = 0; i < missiles.size(); i++) {
                if (player.x - 30 <= missiles.get(i).x && player.x + player.lebar - 220 >= missiles.get(i).x && player.y - 35 <= missiles.get(i).y && player.y + player.tinggi - 350 >= missiles.get(i).y) {
                    if (player.health > 0) {
                        Boom();

                        missiles.remove(i);
                        player.health -= 20;
                    }

                }
            }


            for (int i = 0; i < missilesLeft.size(); i++) {
                if (player.x - 30 <= missilesLeft.get(i).x && player.x + player.lebar - 220 >= missilesLeft.get(i).x && player.y - 35 <= missilesLeft.get(i).y && player.y + player.tinggi - 350 >= missilesLeft.get(i).y) {
                    if (player.health > 0) {
                        Boom();

                        missilesLeft.remove(i);
                        player.health -= 20;

                    }
                }
            }

            for (int i = 0; i < shurikens.size(); i++) {
                if (shuriken.x - 30 <= missilesLeft.get(i).x && shuriken.x + shuriken.lebar - 220 >= missilesLeft.get(i).x && shuriken.y - 35 <= missilesLeft.get(i).y && shuriken.y + shuriken.tinggi - 350 >= missilesLeft.get(i).y) {
                    if (player.health > 0) {
                        Boom();

                        shurikens.remove(i);
                        missilesLeft.remove(i);

                    }
                }
            }

            for (int i = 0; i < coins.size(); i++) {
                if (player.x - 30 <= coins.get(i).x && player.x + player.lebar - 220 >= coins.get(i).x) {
                    if (player.y <= coins.get(i).y && player.y + player.tinggi >= coins.get(i).y) {
                        if (player.health > 0) {
                            Coin();

                            coins.remove(i);
                            coinStat = false;
                            score += 100;
                        }
                    }
                }
            }

            if (player.health == 0) {
                gameOver();
                player.health -= 20;
            }


        }

    }

    public static void Boom() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Boom.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

    public static void Coin() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Coin.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

    public static void gameOver() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/GameOver.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

    public void paint(Graphics g) {


        super.paint(g);
        g.drawImage(bg, 0, 0, null);

        g.setFont(new Font("Arial", Font.BOLD, 70));
        g.setColor(Color.BLUE);
        g.drawChars(endText, 1, 1, 500, 300);
        g.drawChars(endText, 1, 2, 500, 300);
        g.drawChars(endText, 1, 3, 500, 300);
        g.drawChars(endText, 1, 4, 500, 300);

        g.drawChars(endText2, 1, 1, 500, 400);
        g.drawChars(endText2, 1, 2, 500, 400);
        g.drawChars(endText2, 1, 3, 500, 400);
        g.drawChars(endText2, 1, 4, 500, 400);

        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.GREEN);
        g.drawChars(scoreText, 1, 1, 460, 500);
        g.drawChars(scoreText, 1, 2, 460, 500);
        g.drawChars(scoreText, 1, 3, 460, 500);
        g.drawChars(scoreText, 1, 4, 460, 500);
        g.drawChars(scoreText, 1, 5, 460, 500);
        g.drawChars(scoreText, 1, 6, 460, 500);
        g.drawString(scorePoint, 660, 500);

        if (player.health > 0) {
            g.drawImage(bg, 0, 0, null);

            for (Shuriken shuriken : shurikens) {
                shuriken.update();
            }

            for (Coins coin : coins) {
                coin.render(g);
            }

            for (Missiles missile : missiles) {
                missile.render(g);
            }

            for (MissilesLeft missileLeft : missilesLeft) {
                missileLeft.render(g);
            }

            g.setColor(Color.GREEN);

            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawChars(text, 1, 1, 30, 25);
            g.drawChars(text, 1, 2, 30, 25);
            g.drawChars(text, 1, 3, 30, 25);
            g.drawChars(text, 1, 4, 30, 25);
            g.drawChars(text, 1, 5, 30, 25);
            g.drawChars(text, 1, 6, 30, 25);

            g.setColor(Color.red);

            g.fillRect(30, 30, 200, 40);

            g.setColor(Color.GREEN);
            g.fillRect(30, 30, player.health, 40);

            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawChars(scoreText, 1, 1, 980, 25);
            g.drawChars(scoreText, 1, 2, 980, 25);
            g.drawChars(scoreText, 1, 3, 980, 25);
            g.drawChars(scoreText, 1, 4, 980, 25);
            g.drawChars(scoreText, 1, 5, 980, 25);
            g.drawChars(scoreText, 1, 6, 980, 25);
            g.drawString(scorePoint, 1100, 25);
            player.render(g);


        }

    }


}