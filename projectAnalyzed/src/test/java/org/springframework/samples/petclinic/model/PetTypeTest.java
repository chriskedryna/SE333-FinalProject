package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PetTypeTest {
    private PetType petType;

    @Before
    public void setUp() {
        petType = new PetType();
    }

    @After
    public void tearDown() {
        petType = null;
    }

    @Test
    public void testGetAndSetName() {
        petType.setName("Cat");
        assertEquals("Cat", petType.getName());
    }

    @Test
    public void testToString() {
        petType.setName("Dog");
        String str = petType.toString();
        assertTrue(str.contains("Dog"));
    }

    @Test
    public void testEdgeCasesNulls() {
        petType.setName(null);
        assertNull(petType.getName());
    }
}
