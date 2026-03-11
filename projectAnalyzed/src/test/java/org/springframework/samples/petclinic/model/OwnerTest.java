package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class OwnerTest {
    private Owner owner;

    @Before
    public void setUp() {
        owner = new Owner();
    }

    @After
    public void tearDown() {
        owner = null;
    }

    @Test
    public void testConstructor() {
        assertNotNull(owner);
    }

    @Test
    public void testSetAndGetFirstName() {
        owner.setFirstName("John");
        assertEquals("John", owner.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        owner.setLastName("Doe");
        assertEquals("Doe", owner.getLastName());
    }

    @Test
    public void testSetAndGetAddress() {
        owner.setAddress("123 Main St");
        assertEquals("123 Main St", owner.getAddress());
    }

    @Test
    public void testSetAndGetCity() {
        owner.setCity("Springfield");
        assertEquals("Springfield", owner.getCity());
    }

    @Test
    public void testSetAndGetTelephone() {
        owner.setTelephone("1234567890");
        assertEquals("1234567890", owner.getTelephone());
    }

    @Test
    public void testAddPetNull() {
        owner.addPet(null);
        assertTrue(owner.getPets().isEmpty());
    }

    @Test
    public void testAddPet() {
        Pet pet = new Pet();
        owner.addPet(pet);
        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    public void testGetPetsEmpty() {
        assertTrue(owner.getPets().isEmpty());
    }

    @Test
    public void testGetPetsBoundary() {
        for (int i = 0; i < 100; i++) {
            Pet pet = new Pet();
            owner.addPet(pet);
        }
        assertEquals(100, owner.getPets().size());
    }
}
