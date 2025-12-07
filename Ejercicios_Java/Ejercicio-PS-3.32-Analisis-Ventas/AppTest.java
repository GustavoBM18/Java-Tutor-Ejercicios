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
    void testCalcularTotalesPorAnio() {
        double[][] ventas = {
            {100, 200},
            {150, 250}
        };
        double[] totales = App.calcularTotalesPorAnio(ventas, 2);
        assertEquals(300, totales[0], 0.01);
        assertEquals(400, totales[1], 0.01);
    }

    @Test
    void testCalcularTotalesPorSucursal() {
        double[][] ventas = {
            {100, 200},
            {150, 250}
        };
        double[] totales = App.calcularTotalesPorSucursal(ventas, 2);
        assertEquals(250, totales[0], 0.01);
        assertEquals(450, totales[1], 0.01);
    }

    @Test
    void testCalcularTotalGeneral() {
        double[] totales = {100, 200, 300};
        assertEquals(600, App.calcularTotalGeneral(totales), 0.01);
    }

    @Test
    void testNumeroSucursalesNegativo() {
        provideInput("-1");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el número de sucursales debe ser positivo."));
    }
}
