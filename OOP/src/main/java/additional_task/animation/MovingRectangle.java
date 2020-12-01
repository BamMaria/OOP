package additional_task.animation;

import java.awt.*;
public class MovingRectangle extends MovingShape{
    /**
     * Конструктор для создания прямоугольника со значениями по умолчанию
     */
    public MovingRectangle() {
        super();
    }
    /**
     * Конструктор для создания прямоугольной формы
     */

    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color f, Color b, int pathType) {
        super(x ,y ,w, h, mw ,mh, f, b ,pathType);
    }
    /**
     * Нарисуйте прямоугольник с цветом заливки
     * Если он выбран, нарисуйте маркеры
     * @param g графический элемент управления
     */

    public void draw(Graphics g) {
        g.setColor(this.fill);
        g.fillRect(p.x, p.y, width, height);
        g.setColor(this.border);
        g.drawRect(p.x, p.y, width, height);
        drawHandles(g);
    }
    /**
     * Возвращает, находится ли точка в прямоугольнике или нет
     * @return  true тогда и только тогда, когда точка находится в прямоугольнике, false-в противном случае.
     */

    public boolean contains(Point mousePt) {
        return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)  &&  p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
    }
}
