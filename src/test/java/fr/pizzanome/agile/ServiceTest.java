package fr.pizzanome.agile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

    @Test
    void testGetMessage() {
        Service service = new Service();
        assertEquals("Hello world !", service.getMessage());
    }
}