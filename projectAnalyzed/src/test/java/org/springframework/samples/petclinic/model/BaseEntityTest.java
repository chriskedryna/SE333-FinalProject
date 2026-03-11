package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BaseEntityTest {
    private BaseEntity entity;

    @Before
    public void setUp() {
        entity = new BaseEntity();
    }

    @After
    public void tearDown() {
        entity = null;
    }

    @Test
    public void testConstructor() {
        assertNotNull(entity);
    }

    @Test
    public void testSetId() {
        entity.setId(123);
        assertEquals(Integer.valueOf(123), entity.getId());
    }

    @Test
    public void testIsNewTrue() {
        entity.setId(null);
        assertTrue(entity.isNew());
    }

    @Test
    public void testIsNewFalse() {
        entity.setId(1);
        assertFalse(entity.isNew());
    }
}
