import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private int passportId;
    private Gender gender;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int passportId) {
        this.passportId = passportId;
    }

    public Person(String firstName, String lastName, int passportId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
    }

    public Person(Gender gender) {
        this.gender = gender;
    }

    public Person(String firstName, String lastName, int passportId, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName = firstName;
    }

    public String getLastName() {
        return lastName = lastName;
    }

    public int getPassportId() {
        return passportId = passportId;
    }

    public Gender getGender() {
        return gender = gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String exceptionPerson(Person person) {
        return person.toString();
    }


}

