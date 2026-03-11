package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.util.*;

public class OwnerTest {
    private Owner owner;

    @Before
    public void setUp() {
        owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @After
    public void tearDown() {
        owner = null;
    }

    @Test
    public void testConstructor() {
        Owner o = new Owner();
        Assert.assertNotNull(o);
    }

    @Test
    public void testSetAndGetFirstName() {
        owner.setFirstName("Jane");
        Assert.assertEquals("Jane", owner.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        owner.setLastName("Smith");
        Assert.assertEquals("Smith", owner.getLastName());
    }

    @Test
    public void testAddPet() {
        Pet pet = new Pet();
        pet.setName("Fido");
        owner.addPet(pet);
        Assert.assertTrue(owner.getPets().contains(pet));
    }

    @Test
    public void testGetPetByName() {
        Pet pet = new Pet();
        pet.setName("Fido");
        owner.addPet(pet);
        Assert.assertEquals(pet, owner.getPet("Fido"));
    }

    @Test
    public void testGetPetByNameNotFound() {
        Assert.assertNull(owner.getPet("Unknown"));
    }

    @Test
    public void testGetPetWithIgnoreNew() {
        Pet pet = new Pet();
        pet.setName("Fido");
        owner.addPet(pet);
        Assert.assertEquals(pet, owner.getPet("Fido", false));
        Assert.assertNull(owner.getPet("Fido", true));
    }

    @Test
    public void testGetPetsEmpty() {
        Owner emptyOwner = new Owner();
        Assert.assertTrue(emptyOwner.getPets().isEmpty());
    }

    @Test
    public void testEdgeCasesNullPetName() {
        Assert.assertNull(owner.getPet(null));
    }

    @Test
    public void testEdgeCasesEmptyPetName() {
        Assert.assertNull(owner.getPet(""));
    }
}
