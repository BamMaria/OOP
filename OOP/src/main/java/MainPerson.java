public class MainPerson {
    private static Person person1 = new Person();
    private static Person person2 = new Person();
    private static Person person3 = new Person();


    public static void main(String[] args) {
        person1.setFirstName("Алексей");
        person1.setLastName("Иванов");
        person1.setPassportId(44454);
        person2.setFirstName("Наташа");
        person2.setLastName("Степанова");
        person2.setPassportId(45434);
        person3.setFirstName("Михаил");
        person3.setLastName("Булгаков");
        person3.setPassportId(1917624);
        System.out.println(person1.getFirstName() + " " + person1.getLastName() + ", passport ID: " + person1.getPassportId());
        System.out.println(person2.getFirstName() + " " + person2.getLastName() + ", passport ID: " + person2.getPassportId());
        System.out.println(person3.getFirstName() + " " + person3.getLastName() + ", passport ID: " + person3.getPassportId());
    }
}

