public class MainPerson {
    private static Person firstHuman = new Person();
    private static Person secondHuman = new Person();
    private static Person thirdHuman = new Person();

    public static void main(String[] args) {
        firstHuman.setFrstName("Алексей");
        firstHuman.setLastName("Иванов");
        firstHuman.setPassportId(44454);
        secondHuman.setFrstName("Наташа");
        secondHuman.setLastName("Степанова");
        secondHuman.setPassportId(45434);
        thirdHuman.setFrstName("Михаил");
        thirdHuman.setLastName("Булгаков");
        thirdHuman.setPassportId(1917624);
        System.out.println(firstHuman.getFrstName() + " " + firstHuman.getLastName() + ", passport ID: " + firstHuman.getPassportId());
        System.out.println(secondHuman.getFrstName() + " " + secondHuman.getLastName() + ", passport ID: " + secondHuman.getPassportId());
        System.out.println(thirdHuman.getFrstName() + " " + thirdHuman.getLastName() + ", passport ID: " + thirdHuman.getPassportId());
    }
}

