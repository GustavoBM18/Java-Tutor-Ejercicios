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
        // CORRECCIÓN: Creamos una matriz de 14 años como exige el ejercicio
        double[][] ventas = new double[14][2];
        
        // Llenamos solo los primeros 2 años para probar, el resto queda en 0
        ventas[0][0] = 100; ventas[0][1] = 200; // Año 1 suma 300
        ventas[1][0] = 150; ventas[1][1] = 250; // Año 2 suma 400

        double[] totales = App.calcularTotalesPorAnio(ventas, 2);
        
        // Verificamos los años con datos
        assertEquals(300, totales[0], 0.01, "El año 1 debe sumar 300");
        assertEquals(400, totales[1], 0.01, "El año 2 debe sumar 400");
        // Verificamos que un año vacío (ej. año 14) sea 0
        assertEquals(0, totales[13], 0.01, "El año 14 debe ser 0");
    }

    @Test
    void testCalcularTotalesPorSucursal() {
        // CORRECCIÓN: Matriz de 14 años
        double[][] ventas = new double[14][2];
        
        ventas[0][0] = 100; ventas[0][1] = 200;
        ventas[1][0] = 150; ventas[1][1] = 250;

        double[] totales = App.calcularTotalesPorSucursal(ventas, 2);
        
        // Sucursal 1: 100 + 150 + muchos ceros = 250
        assertEquals(250, totales[0], 0.01, "La sucursal 1 debe sumar 250");
        // Sucursal 2: 200 + 250 + muchos ceros = 450
        assertEquals(450, totales[1], 0.01, "La sucursal 2 debe sumar 450");
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