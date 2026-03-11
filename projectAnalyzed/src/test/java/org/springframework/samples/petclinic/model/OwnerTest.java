package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

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
    public void testGetAndSetAddress() {
        owner.setAddress("123 Main St");
        assertEquals("123 Main St", owner.getAddress());
    }

    @Test
    public void testGetAndSetCity() {
        owner.setCity("Springfield");
        assertEquals("Springfield", owner.getCity());
    }

    @Test
    public void testGetAndSetTelephone() {
        owner.setTelephone("555-1234");
        assertEquals("555-1234", owner.getTelephone());
    }

    @Test
    public void testGetPetsInitiallyEmpty() {
        assertTrue(owner.getPets().isEmpty());
    }

    @Test
    public void testAddPet() {
        Pet pet = new Pet();
        pet.setName("Fido");
        owner.addPet(pet);
        assertEquals(1, owner.getPets().size());
        assertEquals("Fido", owner.getPets().get(0).getName());
    }

    @Test
    public void testGetPetByName() {
        Pet pet = new Pet();
        pet.setName("Fido");
        owner.addPet(pet);
        assertEquals(pet, owner.getPet("Fido"));
    }

    @Test
    public void testGetPetByNameNotFound() {
        assertNull(owner.getPet("Unknown"));
    }

    @Test
    public void testGetPetByNameIgnoreNew() {
        Pet pet = new Pet();
        pet.setName("Fido");
        owner.addPet(pet);
        pet.setId(null); // simulate new pet
        assertNull(owner.getPet("Fido", true));
    }

    @Test
    public void testToString() {
        owner.setAddress("123 Main St");
        owner.setCity("Springfield");
        owner.setTelephone("555-1234");
        String str = owner.toString();
        assertTrue(str.contains("123 Main St"));
        assertTrue(str.contains("Springfield"));
        assertTrue(str.contains("555-1234"));
    }

    @Test
    public void testEdgeCasesNulls() {
        owner.setAddress(null);
        owner.setCity(null);
        owner.setTelephone(null);
        assertNull(owner.getAddress());
        assertNull(owner.getCity());
        assertNull(owner.getTelephone());
    }

    @Test
    public void testEdgeCasesEmptyCollections() {
        assertTrue(owner.getPets().isEmpty());
    }
}
