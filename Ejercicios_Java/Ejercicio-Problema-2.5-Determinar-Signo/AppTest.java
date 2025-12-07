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
    void testNumeroPositivo() {
        assertEquals("El número es positivo.", App.determinarSigno(5.0));
    }

    @Test
    void testNumeroNegativo() {
        assertEquals("El número es negativo.", App.determinarSigno(-3.0));
    }

    @Test
    void testNumeroCero() {
        assertEquals("El número es cero.", App.determinarSigno(0.0));
    }

    @Test
    void testEntradaPositiva() {
        provideInput("10");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El número es positivo."));
    }

    @Test
    void testEntradaNegativa() {
        provideInput("-7.5");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El número es negativo."));
    }
}
