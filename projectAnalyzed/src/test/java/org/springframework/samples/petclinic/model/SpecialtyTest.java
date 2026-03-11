package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpecialtyTest {
    private Specialty specialty;

    @Before
    public void setUp() {
        specialty = new Specialty();
    }

    @After
    public void tearDown() {
        specialty = null;
    }

    @Test
    public void testGetAndSetName() {
        specialty.setName("Radiology");
        assertEquals("Radiology", specialty.getName());
    }

    @Test
    public void testToString() {
        specialty.setName("Surgery");
        String str = specialty.toString();
        assertTrue(str.contains("Surgery"));
    }

    @Test
    public void testEdgeCasesNulls() {
        specialty.setName(null);
        assertNull(specialty.getName());
    }
}
