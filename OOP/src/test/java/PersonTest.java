import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PersonTest {
    Person person1 = new Person();
    Person person2 = new Person("Maria", "Bamburova", 2222228, Gender.MALE);
    Person person3 = new Person(Gender.FEMALE);

    @Test
    public void testGetAndSet() {
        person1.setFirstName("Maria");
        person1.setLastName("Bamburova");
        person1.setPassportId(15163);
        person1.setGender(Gender.MALE);
        assertEquals(person1.getFirstName(), "Maria");
        assertEquals(person1.getLastName(), "Bamburova");
        assertEquals(person1.getPassportId(), 15163, 0.000000001);
        assertEquals(person1.getGender(), Gender.MALE);
    }

    @Test
    public void testFirstName() {
        person1.setFirstName("Maria");
        assertEquals(person1.getFirstName(), "Maria");
    }

    @Test
    public void testLastName() {
        person1.setLastName("Bamburova");
        assertEquals(person1.getLastName(), "Bamburova");
    }

    @Test
    public void testPassportId() {
        person1.setPassportId(12345);
        assertEquals(person1.getPassportId(), 12345, 0.000001);
    }

    @Test
    public void testGender() {
        assertEquals(person3.getGender(), Gender.FEMALE);
    }

    @Test
    public void testToString() {
        Person person = new Person("Mary", "Pary");
        assertEquals(person2.toString(), "Mary Paa");
        assertEquals(person.toString(), "Mary Pary");
    }

    @Test
    public void testException() {
        Person person = new Person("Mary", "Paary");
        assertEquals(person2.exceptionPerson(person2), "Mary Paa");
        assertEquals(person.exceptionPerson(person), "Mary Pary");

        Assert.assertThrows(NullPointerException.class, () -> {
            person.exceptionPerson(null);
        });
    }

    @Test
    public void testPersonConstr() {
        assertEquals(person2.getFirstName(), "Maria");
        assertEquals(person2.getLastName(), "Bamburova");
        assertEquals(person2.getPassportId(), 2222228);
        assertEquals(person2.getGender(), Gender.MALE);
    }

}

