package com.example.efarmoghgiaodontiatrous.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * The type Client test.
 */
public class ClientTest {
    /**
     * The Client.
     */
    Client client;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        client = new Client("Panagiotis", "Ntymenos", "6948554284", "panagiwths.nty@gmail.com", "17099800037");
    }

    /**
     * checks clients to have the same hashcode and are equal
     */
    @Test
    public void equals() {
        Client otherClient = new Client("George", "Patrikis", "6986888788", "geopatg4@gmail.com", "17099800037");
        assertTrue(otherClient.equals(client));
        assertEquals(otherClient.hashCode(), client.hashCode());
    }

    /**
     * Same object.
     */
    @Test
    public void sameObject() {
        Client otherClient = new Client(client);
        assertTrue(otherClient.equals(client));
        assertEquals(otherClient.hashCode(), client.hashCode());
    }

    /**
     * Different customers.
     */
    @Test
    public void differentCustomers() {
        Client otherClient = new Client("George", "Patrikis", "6986888788", "geopatg4@gmail.com", "16019800037");
        assertFalse(otherClient.equals(client));
        assertNotEquals(otherClient.hashCode(), client.hashCode());
    }

    /**
     * Test getters setters.
     */
    @Test
    public void testGettersSetters() {
        Client otherClient = new Client();
        otherClient.setFirstName("George");
        otherClient.setLastName("Fotopoulos");
        otherClient.setTelephoneNo("6980793051");
        otherClient.setEmail("giorgos.fotopoulos7@gmail.com");
        otherClient.setAMKA("18059500037");
        assertNotEquals("Panagiotis", otherClient.getFirstName());
        assertNotEquals("Ntymenos", otherClient.getLastName());
        assertNotEquals("6948554284", otherClient.getTelephoneNo());
        assertNotEquals("panagiwths.nty@gmail.com", otherClient.getEmail());
        assertNotEquals("17099800037", otherClient.getAMKA());
    }
}