package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.joda.time.DateTime;

public class VisitTest {
    private Visit visit;

    @Before
    public void setUp() {
        visit = new Visit();
    }

    @After
    public void tearDown() {
        visit = null;
    }

    @Test
    public void testGetAndSetDate() {
        DateTime date = new DateTime(2022, 5, 10, 0, 0);
        visit.setDate(date);
        assertEquals(date, visit.getDate());
    }

    @Test
    public void testGetAndSetDescription() {
        visit.setDescription("Annual checkup");
        assertEquals("Annual checkup", visit.getDescription());
    }

    @Test
    public void testEdgeCasesNulls() {
        visit.setDate(null);
        visit.setDescription(null);
        assertNull(visit.getDate());
        assertNull(visit.getDescription());
    }
}
