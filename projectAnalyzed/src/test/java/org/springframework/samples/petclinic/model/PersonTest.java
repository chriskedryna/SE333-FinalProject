package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        person = new Person();
    }

    @After
    public void tearDown() {
        person = null;
    }

    @Test
    public void testGetAndSetFirstName() {
        person.setFirstName("Alice");
        assertEquals("Alice", person.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }

    @Test
    public void testEdgeCasesNulls() {
        person.setFirstName(null);
        person.setLastName(null);
        assertNull(person.getFirstName());
        assertNull(person.getLastName());
    }
}
