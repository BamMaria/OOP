import static java.lang.Math.sqrt;

public class Point {
    private final double X;
    private final double Y;
    private final double Z;
    public Point(double x, double y, double z) {
        this.X =x;
        this.Y=y;
        this.Z=z;

    }

    public  double length(){
        return sqrt(X*X+Y*Y+Z*Z);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }
    public double setX() {
        return this.X;
    }

    public double setY() {
        return this.Y;
    }

    public double setZ() {
        return this.Z;
    }



}

