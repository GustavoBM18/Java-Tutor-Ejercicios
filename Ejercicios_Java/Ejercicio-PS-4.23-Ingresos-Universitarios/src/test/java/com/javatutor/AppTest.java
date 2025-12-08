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
    void testContarAprobados() {
        double[] notas = {8.5, 6.0, 7.0, 5.5, 9.0};
        assertEquals(3, App.contarAprobados(notas));
    }

    @Test
    void testCalcularPromedio() {
        double[] notas = {8.0, 6.0, 7.0};
        assertEquals(7.0, App.calcularPromedio(notas), 0.01);
    }

    @Test
    void testAnalisisCompleto() {
        // Notas: 8.5 + 6.0 + 7.0 + 9.0 = 30.5 / 4 = 7.625
        // Java redondea 7.625 a 7.63
        provideInput("4\n8.5\n6.0\n7.0\n9.0");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Aprobados (nota >= 7.0): 3"), "Debe contar 3 aprobados");
        assertTrue(output.contains("Reprobados (nota < 7.0): 1"), "Debe contar 1 reprobado");
        // CORREGIDO: Esperamos 7.63 en lugar de 7.62
        assertTrue(output.contains("Promedio general: 7.63"), "El promedio debe ser 7.63 (redondeado)");
    }

    @Test
    void testNumeroPostulantesNegativo() {
        provideInput("-5");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el número de postulantes debe ser positivo."));
    }
}