package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

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
    public void testSpecialtiesInitiallyEmpty() {
        assertTrue(vet.getSpecialties().isEmpty());
    }

    @Test
    public void testAddSpecialty() {
        Specialty specialty = new Specialty();
        specialty.setName("Surgery");
        Set<Specialty> specialties = new HashSet<>();
        specialties.add(specialty);
        vet.setSpecialtiesInternal(specialties);
        List<Specialty> result = vet.getSpecialties();
        assertEquals(1, result.size());
        assertEquals("Surgery", result.get(0).getName());
    }

    @Test
    public void testGetSpecialtiesInternalNull() {
        Vet v = new Vet();
        Set<Specialty> s = v.getSpecialtiesInternal();
        assertNotNull(s);
        assertTrue(s.isEmpty());
    }

    @Test
    public void testSetSpecialtiesInternalNull() {
        vet.setSpecialtiesInternal(null);
        assertNotNull(vet.getSpecialtiesInternal());
        assertTrue(vet.getSpecialtiesInternal().isEmpty());
    }

    @Test
    public void testSpecialtiesSorting() {
        Specialty s1 = new Specialty();
        s1.setName("Dentistry");
        Specialty s2 = new Specialty();
        s2.setName("Surgery");
        Set<Specialty> specialties = new HashSet<>();
        specialties.add(s2);
        specialties.add(s1);
        vet.setSpecialtiesInternal(specialties);
        List<Specialty> sorted = vet.getSpecialties();
        assertEquals("Dentistry", sorted.get(0).getName());
        assertEquals("Surgery", sorted.get(1).getName());
    }
}
