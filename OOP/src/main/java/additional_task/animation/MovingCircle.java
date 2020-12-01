package additional_task.animation;
import java.awt.*;

    public class MovingCircle extends MovingShape {
        /**
         * Конструктор для создания овала со значениями по умолчанию
         */
        public MovingCircle() {
            super();
        }

        /**
         * Конструктор для создания овальной формы
         */
        public MovingCircle(int x, int y, int w, int h, int mw, int mh, Color f, Color b, int pathType) {
            super(x ,y ,w, h ,mw ,mh, f, b, pathType);
        }

        /**
         * Рисует овал с цветом заливки
         * Если он выбран, нарисуйте маркеры
         * @param g графический элемент управления
         */
        public void draw(Graphics g) {
            g.setColor(this.fill);
            g.fillOval(p.x, p.y, width, height);
            g.setColor(this.border);
            g.drawOval(p.x, p.y, width, height);
            drawHandles(g);
        }

        /**
         * Возвращает, находится ли точка в овале или нет
         * @return  true тогда и только тогда, когда точка находится в овале, false-в противном случае.
         **/
        public boolean contains(Point mousePt) {
            double dx, dy;
            Point EndPt = new Point(p.x + width, p.y + height);
            dx = (2 * mousePt.x - p.x - EndPt.x) / (double) width;
            dy = (2 * mousePt.y - p.y - EndPt.y) / (double) height;
            return dx * dx + dy * dy < 1.0;
        }
    }


