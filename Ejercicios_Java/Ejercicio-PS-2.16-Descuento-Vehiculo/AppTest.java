package com.javatutor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

class AppTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testPorcentajePorModelo_BlazerTrail() {
        assertEquals(0.08, App.porcentajePorModelo("Blazer-Trail"), 0.0001);
    }

    @Test
    void testPorcentajePorModelo_Cavalier() {
        assertEquals(0.05, App.porcentajePorModelo("Cavalier"), 0.0001);
    }

    @Test
    void testCavalier_150000() {
        provideInput("Cavalier\n150000");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Porcentaje: 5%"));
        assertTrue(output.contains("Total a pagar: $142500.00"));
    }

    @Test
    void testPrecioNegativo() {
        provideInput("Cavalier\n-5000");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el precio debe ser positivo."));
    }
}
