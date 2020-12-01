package additional_task.animation;
import java.awt.*;

public abstract class MovingShape {
    public int marginWidth, marginHeight;  // поле области анимационной панели
    protected Point p; 					 // верхний левый угол фигур
    protected int width,					 // ширина фигур
            height;								 // высота фигур
    protected MovingPath path;			 // движущийся путь фигур
    protected boolean selected = false;    // нарисовать  маркеры, если они выбраны
    protected Color fill, 				//  цвет заливки фигуры
            border;								//  цвет границы фигуры
    /**
     * Constuctor для создания фигуры со значениями по умолчанию
     */
    public MovingShape() {
        this(0, 0, 20, 20, 500, 500, Color.blue, Color.black, 0);
    }
    /**
     * Конструктор для создания фигуры
     * @param x-координата x новой фигуры
     * @param y-координата y новой фигуры
     * @param w ширина новой фигуры
     * @param h высота новой фигуры
     * @param mw ширина поля панели анимации
     * @param mh высота поля анимационной панели
     * @param f цвет для установки середины фигуры
     * @param b цвет для установки границы фигуры

     **/

    public MovingShape(int x, int y, int w, int h, int mw, int mh, Color f, Color b, int pathType) {
        p = new Point(x,y);
        marginWidth = mw;
        marginHeight = mh;
        width = w;
        height = h;
        fill = f;
        border = b;
        setPath (pathType);
    }


    public int getX() { return p.x; }


    public int getY() { return p.y;}
    /**
     * Возвращает выбранное свойство фигуры.
     * @return  выбранного свойства
     */
    public boolean isSelected() { return selected; }

    /**
     * Установите выбранное свойство фигуры.
     * Когда фигура выбрана, отображаются ее маркеры.
     * @param s выбранное значение
     */
    public void setSelected(boolean s) { selected = s; }

    /**
     * Установите ширину фигуры.
     * @param w значение ширины
     */
    public void setWidth(int w) { width = w; }

    /**
     * Устанавливает высоту фигуры.
     * @param h значение высоты
     */
    public void setHeight(int h){
        height = h;
    }

    /**
     * Устанавливает цвет заливки фигуры
     * @param f новое значение цвета заливки фигуры
     */
    public void setFillColor(Color f){
        fill = f;
    }

    /**
     * Устанавливает цвет границы фигуры
     * @param b новый цвет границы фигуры
     */
    public void setBorderColor(Color b){
        border = b;
    }

    /**
     * Возвращает строковое представление фигуры, содержащее
     * строковое представление каждого элемента.
     */
    public String toString() {
        return "[" + this.getClass().getName() + "," + p.x + "," + p.y + "]";
    }

    /**
     * Нарисуйте ручки фигуры
     * @param g графический элемент управления
     */
    public void drawHandles(Graphics g) {
        // if the shape is selected, then draw the handles
        if (isSelected()) {
            g.setColor(Color.black);
            g.fillRect(p.x -2, p.y-2, 4, 4);
            g.fillRect(p.x + width -2, p.y + height -2, 4, 4);
            g.fillRect(p.x -2, p.y + height -2, 4, 4);
            g.fillRect(p.x + width -2, p.y-2, 4, 4);
        }
    }
    /**
     * Сброс поля для фигуры
     * @param w ширина поля
     * @param h высота поля
     */
    public void setMarginSize(int w, int h) {
        marginWidth = w;
        marginHeight = h;
    }

    /**

     * возвращает, находится ли точка p внутри фигуры или нет.
     * @param p точка мыши
     */
    public abstract boolean contains(Point p);

    /**
     * Абстрактный метод рисования
     * @param g графический элемент управления
     */
    public abstract void draw(Graphics g);


    public void setPath(int pathID) {
        switch (pathID) {
            case MovingPath.BOUNDARY : {
                path = new BoundaryPath(10, 10);
                break;
            }
            case MovingPath.FALLING : {
                path = new FallingPath();
                break;
            }
            case MovingPath.FLOATINGSIDEWAYS : {
                path = new FloatingSideWaysPath();
                break;
            }
            case MovingPath.FLOATINGSIDEWAYSOPP : {
                path = new FloatingSideWaysPathOpp();
                break;
            }
            case MovingPath.FLYINGPATH : {
                path = new FlyingPath();
                break;
            }
        }
    }


    public void move() {
        path.move();
    }



    public abstract class MovingPath {
        public static final int BOUNDARY = 0;
        public static final int FALLING = 1;
        public static final int FLOATINGSIDEWAYS = 2;
        public static final int FLOATINGSIDEWAYSOPP = 3;
        public static final int FLYINGPATH = 4;
        protected int deltaX, deltaY;

        public MovingPath() { }


        public abstract void move();
    }

    public class FallingPath extends MovingPath {
        private double am = 0, stx = 0, sinDeltax = 0;


        public FallingPath() {
            am = Math.random() * 20;
            stx = 0.5;
            deltaY = 5;
            sinDeltax = 0;
        }


        public void move() {
            sinDeltax = sinDeltax + stx;
            p.x = (int) Math.round(p.x + am * Math.sin(sinDeltax));
            p.y = p.y + deltaY;
            if (p.y > marginHeight)
                p.y = 0;
        }
    }

    public class BoundaryPath extends MovingPath {
        private int direction;

        public BoundaryPath(int speedx, int speedy) {
            deltaX = (int) (Math.random() * speedx) + 1;
            deltaY = (int) (Math.random() * speedy) + 1;
            direction = 0;
        }


        public void move() {
            int h = marginHeight - height;
            int w = marginWidth - width;
            switch  (direction) {
                case 0 : {
                    p.y += deltaY;
                    if (p.y > h) {
                        p.y = h - 1;
                        direction = 90;
                    }
                    break;
                }
                case 90 : {
                    p.x += deltaX;
                    if (p.x > w) {
                        p.x = w - 1;
                        direction = 180;
                    }
                    break;
                }
                case 180 : {
                    p.y -= deltaY;
                    if (p.y < 0) {
                        direction = 270;
                        p.y = 0;
                    }
                    break;
                }
                case 270 : {
                    p.x -= deltaX;
                    if (p.x < 0) {
                        direction = 0;
                        p.x = 0;
                    }
                    break;
                }
            }
        }
    }


    public class FloatingSideWaysPath extends MovingPath {
        private double am = 0, sty = 0, sinDeltay = 0;


        public FloatingSideWaysPath() {
            am = Math.random() * 20;
            sty = 0.5;
            deltaX = 5;
            sinDeltay = 0;
        }


        public void move() {
            sinDeltay = sinDeltay + sty;
            p.y = (int) Math.round(p.y + am * Math.sin(sinDeltay));
            p.x = p.x + deltaX;
            if (p.x > marginWidth)
                p.x = 0 - width;
        }
    }


    public class FloatingSideWaysPathOpp extends MovingPath {
        private double am = 0, sty = 0, sinDeltay = 0;

        public FloatingSideWaysPathOpp() {
            am = Math.random() * 20;
            sty = 0.5;
            deltaX = -5;
            sinDeltay = 0;
        }

        public void move() {
            sinDeltay = sinDeltay + sty;
            p.y = (int) Math.round(p.y + am * Math.sin(sinDeltay));
            p.x = p.x + deltaX;
            if (p.x < 0 - width )
                p.x = marginWidth;
        }
    }


    public class FlyingPath extends MovingPath {
        private double am = 0, stx = 0, sinDeltax = 0;


        public FlyingPath() {
            am = Math.random() * 20;
            stx = 0.5;
            deltaY = 5;
            sinDeltax = 0;
        }


        public void move() {
            sinDeltax = sinDeltax + stx;
            p.x = (int) Math.round(p.x + am * Math.sin(sinDeltax));
            p.y = p.y - deltaY;
            if (p.y < 0 - height)
                p.y = marginHeight;
        }
    }


}
