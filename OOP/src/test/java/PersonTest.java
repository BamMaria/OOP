import static org.testng.Assert.*;
import org.testng.annotations.Test;

    public class PersonTest {
        @Test
        public void testGetSet() {

            Person FirstPerson = new Person ();


            FirstPerson.setFrstName("Bamburova");
            FirstPerson.setLastName("Maria");
            FirstPerson.setPassportId(30);
            assertEquals(FirstPerson.getFrstName(),"Bamburova") ;
            assertEquals(FirstPerson.getLastName(),"Maria");
            assertEquals(FirstPerson.getPassportId(),30);


        }


    }