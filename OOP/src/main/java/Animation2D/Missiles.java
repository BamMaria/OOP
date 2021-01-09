package Animation2D;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Missiles {

    int x, y;
    int veloX;
    Image missile;

    public Missiles(int x, int y, int veloX) {
        this();
        this.x = x;
        this.y = y;
        this.veloX = veloX;
    }

    public Missiles() {

        try {
            missile = ImageIO.read(new File("Assets/missiles.gif")).getScaledInstance(100, 100, 0);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void update() {

        x += veloX;

    }

    public void render(Graphics g) {

        g.drawImage(missile, x, y, null);

    }

}
