package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
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
    public void testGetPetsEmpty() {
        List<Pet> pets = owner.getPets();
        assertNotNull(pets);
        assertTrue(pets.isEmpty());
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
        assertEquals(1, owner.getPets().size());
        assertTrue(owner.getPets().contains(pet));
    }

    // No removePet method exists; test omitted.

    @Test
    public void testGetAddressNull() {
        owner.setAddress(null);
        assertNull(owner.getAddress());
    }

    @Test
    public void testGetAddress() {
        owner.setAddress("123 Main St");
        assertEquals("123 Main St", owner.getAddress());
    }

    @Test
    public void testGetCityNull() {
        owner.setCity(null);
        assertNull(owner.getCity());
    }

    @Test
    public void testGetCity() {
        owner.setCity("Springfield");
        assertEquals("Springfield", owner.getCity());
    }

    @Test
    public void testGetTelephoneNull() {
        owner.setTelephone(null);
        assertNull(owner.getTelephone());
    }

    @Test
    public void testGetTelephone() {
        owner.setTelephone("555-1234");
        assertEquals("555-1234", owner.getTelephone());
    }
}
