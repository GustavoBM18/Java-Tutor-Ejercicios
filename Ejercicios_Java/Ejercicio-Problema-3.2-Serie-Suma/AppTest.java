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
    void testSerieSuma_1Termino() {
        assertEquals(1.0, App.calcularSerieSuma(1), 0.0001);
    }

    @Test
    void testSerieSuma_2Terminos() {
        assertEquals(0.5, App.calcularSerieSuma(2), 0.0001);
    }

    @Test
    void testSerieSuma_4Terminos() {
        assertEquals(0.5833, App.calcularSerieSuma(4), 0.0001);
    }

    @Test
    void testEntrada5Terminos() {
        provideInput("5");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0.7833"));
    }

    @Test
    void testNumeroTerminosNegativo() {
        provideInput("-1");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el número de términos debe ser positivo."));
    }
}
