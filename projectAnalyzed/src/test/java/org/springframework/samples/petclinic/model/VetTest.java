package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class VetTest {
    private Vet vet;

    @Before
    public void setUp() {
        vet = new Vet();
    }

    @After
    public void tearDown() {
        vet = null;
    }

    @Test
    public void testConstructor() {
        assertNotNull(vet);
    }

    @Test
    public void testSetAndGetFirstName() {
        vet.setFirstName("Alice");
        assertEquals("Alice", vet.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        vet.setLastName("Smith");
        assertEquals("Smith", vet.getLastName());
    }

    @Test
    public void testAddSpecialtyNull() {
        vet.addSpecialty(null);
        assertTrue(vet.getSpecialties().isEmpty());
    }

    @Test
    public void testAddSpecialty() {
        Specialty specialty = new Specialty();
        vet.addSpecialty(specialty);
        assertTrue(vet.getSpecialties().contains(specialty));
    }

    @Test
    public void testGetSpecialtiesEmpty() {
        assertTrue(vet.getSpecialties().isEmpty());
    }

    @Test
    public void testGetSpecialtiesBoundary() {
        for (int i = 0; i < 50; i++) {
            Specialty specialty = new Specialty();
            vet.addSpecialty(specialty);
        }
        assertEquals(50, vet.getSpecialties().size());
    }
}
