package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
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
    public void testGetSpecialtiesEmpty() {
        List<Specialty> specialties = vet.getSpecialties();
        assertNotNull(specialties);
        assertTrue(specialties.isEmpty());
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
        assertEquals(1, vet.getSpecialties().size());
        assertTrue(vet.getSpecialties().contains(specialty));
    }
}
