package additional_task.stars.file_render;
import java.util.ArrayList;

public class Model {
    static float MOTION_SPEED = 0.001f;// скорость точки

    public static float INITIAL_Z_COORD = -3;//по оси z , движение вглубь экрана , то есть выбрали
                                             //коодинтаную систему

    ArrayList<Point> points = new ArrayList<>();

    public void update(long elapsedTime) {
        for (int i = 0; i < 3; i++) {
            points.add(new Point(random(-1, 1), random(-1, 1), INITIAL_Z_COORD,
                    0xff000000 | (int)random(180, 255) << 16 | (int)random(180, 255) << 8 | (int)random(180, 255)));
        }

        for (Point point: points) {
            point.z += elapsedTime * MOTION_SPEED;// умножаем прошедшее время на скорость
                                                  // таким образом продвигаем точки впред
                                                  //соответсвенно прошедшему времени
        }

        points.removeIf(point -> point.z >= 0);// удаление точки , так как она уходит за пределы видимости

    }

    private float random(float from, float to) {
        return (float)(from + (to - from) * Math.random());
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

}
