package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

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
    public void testGetAndSetName() {
        pet.setName("Buddy");
        assertEquals("Buddy", pet.getName());
    }

    @Test
    public void testGetAndSetBirthDate() {
        org.joda.time.DateTime date = new org.joda.time.DateTime(2020, 1, 1, 0, 0);
        pet.setBirthDate(date);
        assertEquals(date, pet.getBirthDate());
    }

    @Test
    public void testGetAndSetType() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
        assertEquals(type, pet.getType());
    }

    @Test
    public void testGetAndSetOwner() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        pet.setOwner(owner);
        assertEquals(owner, pet.getOwner());
    }

    @Test
    public void testGetVisitsInitiallyEmpty() {
        assertTrue(pet.getVisits().isEmpty());
    }

    @Test
    public void testAddVisit() {
        Visit visit = new Visit();
        visit.setDescription("Checkup");
        pet.addVisit(visit);
        assertEquals(1, pet.getVisits().size());
        assertEquals("Checkup", pet.getVisits().iterator().next().getDescription());
    }

    @Test
    public void testEdgeCasesNulls() {
        pet.setName(null);
        pet.setBirthDate(null);
        pet.setType(null);
        pet.setOwner(null);
        assertNull(pet.getName());
        assertNull(pet.getBirthDate());
        assertNull(pet.getType());
        assertNull(pet.getOwner());
    }

    @Test
    public void testEdgeCasesEmptyCollections() {
        assertTrue(pet.getVisits().isEmpty());
    }
}
