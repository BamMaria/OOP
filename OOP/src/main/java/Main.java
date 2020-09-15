
public class Main {
    public static void main (String args[]){
        /*Person Maria = new Person();
        Person Pasha = new Person (2);
        Person Sergey = new Person("Сергей","Бамбуров",1);
        Person Elena = new Person ("Елена","Степаненко");

        Maria.setFrstName("Masha");
        Maria.setLastName("Bamburova");
        Maria.setPassportId(2);*/
        Point tochka = new Point (4,5,2);
        Point tochka2=new Point (10,5,20);
        Point tochka3=new Point (15,20,17);
        Point result = new Point(0,0,0);
        result = Points.sum(tochka,tochka2);
        result=Points. subtract(tochka,tochka2);
        result=Points.multiply (tochka,tochka2);
        result=Points.divide(tochka,tochka2);
        System.out.println(1);



    }


}
