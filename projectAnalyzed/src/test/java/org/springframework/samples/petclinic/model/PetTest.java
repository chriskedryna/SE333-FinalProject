package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PetTest {
    private Pet pet;

    @Before
    public void setUp() {
        pet = new Pet();
    }

    @After
    public void tearDown() {
        pet = null;
    }

    @Test
    public void testConstructor() {
        assertNotNull(pet);
    }

    @Test
    public void testSetNameNull() {
        pet.setName(null);
        assertNull(pet.getName());
    }

    @Test
    public void testSetName() {
        pet.setName("Fido");
        assertEquals("Fido", pet.getName());
    }

    @Test
    public void testSetBirthDateNull() {
        pet.setBirthDate(null);
        assertNull(pet.getBirthDate());
    }
}
