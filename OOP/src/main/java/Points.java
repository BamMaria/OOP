
public class Points {
    public static Point sum (Point X ,Point Y){
       return new Point(X.getX()+ Y.getX(),X.getY()+ Y.getY(), X.getZ()+ Y.getZ() ) ;
    }
    public static Point subtract(Point X,Point Y) {
        return new Point (X.getX()- Y.getX(), X.getY() - Y.getY(), X.getZ()- Y.getZ());
    }
    public static Point multiply(Point X,Point Y){
        return new Point (X.getX()* Y.getX(), X.getY()* Y.getY(), X.getZ()*Y.getZ());
    }
    public static Point divide (Point X,Point Y){
        return new Point (X.getX()/Y.getX(), X.getY()/Y.getY(), X.getZ()/Y.getZ());
    }




}