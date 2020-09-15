public class Main {
    public static void main (String args[]){
        Person Maria = new Person();
        Person Pasha = new Person (2);
        Person Sergey = new Person("Сергей","Бамбуров",1);
        Person Elena = new Person ("Елена","Степаненко");

        Maria.setFrstName("Masha");
        Maria.setLastName("Bamburova");
        Maria.setPassportId(2);

    }
    

}
