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
    void testEncontrarMejorAlumno() {
        double[] promedios = {8.5, 9.2, 7.8, 9.0};
        assertEquals(1, App.encontrarMejorAlumno(promedios));
    }

    @Test
    void testEncontrarMejorAlumno_PrimerElemento() {
        double[] promedios = {10.0, 9.0, 8.0};
        assertEquals(0, App.encontrarMejorAlumno(promedios));
    }

    @Test
    void testRegistrosCompletos() {
        provideInput("3\nJuan\n8.5\nMaria\n9.2\nPedro\n7.8");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Juan: 8.50"));
        assertTrue(output.contains("Maria: 9.20"));
        assertTrue(output.contains("Pedro: 7.80"));
        assertTrue(output.contains("Mejor alumno: Maria con promedio 9.20"));
    }

    @Test
    void testNumeroAlumnosNegativo() {
        provideInput("-1");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el número de alumnos debe ser positivo."));
    }
}
