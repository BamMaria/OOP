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
    public static Point opposite(Point point ) {

        return new Point(point.getX()*(-1), point.getY()*(-1), point.getZ()*(-1));
    }
    public static Point inverse(Point point ) {
        return new Point (1/ point.getX() ,1/point.getY(),1/point.getZ());

    }
}




