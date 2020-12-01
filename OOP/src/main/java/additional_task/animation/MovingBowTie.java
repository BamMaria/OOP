package additional_task.animation;
import java.awt.*;
public class MovingBowTie extends MovingShape {
    /**
     *  Конструктор для создания галстука-бабочки со значениями по умолчанию
     */
    public MovingBowTie() {
        super();
    }

    /**
     *  Конструктор для создания формы галстука-бабочки
     */
    public MovingBowTie(int x, int y, int w, int h, int mw, int mh, Color f, Color b, int pathType) {
        super(x ,y ,w, h, mw ,mh, f, b ,pathType);
    }

    /**
     *  Рисует галстук-бабочку с цветом заливки
     *  Если он выбран, нарисуйте маркеры
     *g графический элемент управления**/

    public void draw(Graphics g) {
        Polygon bowtie = bowtieOuter();
        Polygon centre = bowtieCentre();

        g.setColor(this.fill);
        g.fillPolygon(bowtie);

        g.setColor(this.border);
        g.fillPolygon(centre);

        drawHandles(g);
    }

    private Polygon bowtieOuter(){
        int offSet = this.height / 3;
        int halfWidth = this.width / 2;

        int[] tieX = {p.x, p.x + halfWidth, p.x + this.width, p.x + this.width, p.x + halfWidth, p.x};
        int[] tieY = {p.y, p.y + offSet, p.y, p.y + this.height, p.y + this.height - offSet, p.y + this.height};

        return new Polygon(tieX, tieY, 6);
    }

    /**
     *  Создает центральную ромбовидную форму галстука-бабочки
     * @return центральный бриллиант галстука-бабочки
     */
    private Polygon bowtieCentre(){
        int offSet = this.width / 4;
        int heightOffSet = this.height / 3;
        int halfHeight = this.height / 2;
        int halfWidth = this.width / 2;

        int[] tieX = {p.x + offSet, p.x + halfWidth, p.x + halfWidth + offSet, p.x + halfWidth};
        int[] tieY = {p.y + halfHeight, p.y + heightOffSet, p.y + halfHeight, p.y + this.height - heightOffSet};

        return new Polygon(tieX, tieY, 4);
    }
    /**
     * Возвращает, находится ли точка в галстуке-бабочке или нет
     * @return true тогда и только тогда, когда точка находится в галстуке-бабочке, false в противном случае.
     */

    public boolean contains(Point mousePt) {
        return bowtieOuter().contains(mousePt.x, mousePt.y);
    }
}

