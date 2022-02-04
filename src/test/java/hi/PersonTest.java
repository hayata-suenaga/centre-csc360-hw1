package hi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person alice;
    Person bob;

    @BeforeEach
    void setUp() {
        alice = new Person("Alice", "Smith", 38);
        bob = new Person("Bob", "Smith", 40);
    }

    @Test
    void testToString() {
        String expected = "Person: Alice Smith, 38";
        assertEquals(expected, alice.toString());
    }

    @Test
    void testMakeChild() {
        final String BABY_NAME = "Chase";

        try {
            Person baby = alice.makePerson(bob, BABY_NAME);

            assertEquals(BABY_NAME, baby.getFirstName());
            assertEquals(alice.getLastName(), baby.getLastName());
            assertEquals(0, baby.getAge());
        } catch (UnderAgeException e) {
            e.printStackTrace();
            fail();
        }

        alice.setAge(13);
        assertThrows(UnderAgeException.class, () -> alice.makePerson(bob, BABY_NAME));

        alice.setAge(38);
        bob.setAge(15);
        assertThrows(UnderAgeException.class, () -> alice.makePerson(bob, BABY_NAME));
    }

}