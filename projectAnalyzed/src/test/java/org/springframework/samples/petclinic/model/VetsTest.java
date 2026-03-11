package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class VetsTest {
    private Vets vets;

    @Before
    public void setUp() {
        vets = new Vets();
    }

    @After
    public void tearDown() {
        vets = null;
    }

    @Test
    public void testGetVetListInitiallyEmpty() {
        assertTrue(vets.getVetList().isEmpty());
    }

    @Test
    public void testAddVetToList() {
        Vet vet = new Vet();
        List<Vet> vetList = vets.getVetList();
        vetList.add(vet);
        assertEquals(1, vets.getVetList().size());
        assertEquals(vet, vets.getVetList().get(0));
    }

    @Test
    public void testGetVetListNullHandling() {
        Vets v = new Vets();
        List<Vet> list = v.getVetList();
        assertNotNull(list);
        assertTrue(list.isEmpty());
    }
}
