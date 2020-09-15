public class Points {
    private Points() {

    }
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
    public static Point enlarge(Point point ,double value ){
        return new Point (point.getX()*value, point.getY()*value, point.getZ()*value);
    }
}




