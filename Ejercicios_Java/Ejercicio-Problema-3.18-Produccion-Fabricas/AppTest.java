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
    void testCalcularTotal() {
        double[] prod = {100, 200, 150};
        assertEquals(450, App.calcularTotal(prod), 0.01);
    }

    @Test
    void testContarSuperanPromedio() {
        double[] prod = {100, 200, 150, 300};
        double promedio = 187.5;
        assertEquals(2, App.contarSuperanPromedio(prod, promedio));
    }

    @Test
    void testAnalisisCompleto() {
        provideInput("4\n100\n200\n150\n300");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Producción total: 750.00"));
        assertTrue(output.contains("Promedio de producción: 187.50"));
        assertTrue(output.contains("Fábricas que superan el promedio: 2"));
    }

    @Test
    void testNumeroFabricasNegativo() {
        provideInput("-1");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el número de fábricas debe ser positivo."));
    }
}
