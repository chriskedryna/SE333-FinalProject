package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelTest {
    private Person person;
    private Pet pet;
    private PetType petType;
    private Specialty specialty;
    private Visit visit;

    @Before
    public void setUp() {
        person = new Person();
        pet = new Pet();
        petType = new PetType();
        specialty = new Specialty();
        visit = new Visit();
    }

    @After
    public void tearDown() {
        person = null;
        pet = null;
        petType = null;
        specialty = null;
        visit = null;
    }

    @Test
    public void testPersonConstructor() {
        assertNotNull(person);
    }

    @Test
    public void testPetConstructor() {
        assertNotNull(pet);
    }

    @Test
    public void testPetTypeConstructor() {
        assertNotNull(petType);
    }

    @Test
    public void testSpecialtyConstructor() {
        assertNotNull(specialty);
    }

    @Test
    public void testVisitConstructor() {
        assertNotNull(visit);
    }

    @Test
    public void testPersonSetAndGetFirstName() {
        person.setFirstName("Bob");
        assertEquals("Bob", person.getFirstName());
    }

    @Test
    public void testPetSetAndGetName() {
        pet.setName("Fluffy");
        assertEquals("Fluffy", pet.getName());
    }

    @Test
    public void testPetTypeSetAndGetName() {
        petType.setName("Dog");
        assertEquals("Dog", petType.getName());
    }

    @Test
    public void testSpecialtySetAndGetName() {
        specialty.setName("Surgery");
        assertEquals("Surgery", specialty.getName());
    }

    @Test
    public void testVisitSetAndGetDescription() {
        visit.setDescription("Annual checkup");
        assertEquals("Annual checkup", visit.getDescription());
    }
}
