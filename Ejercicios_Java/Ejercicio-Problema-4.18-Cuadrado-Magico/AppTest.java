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
    void testGenerarCuadradoMagico3x3() {
        int[][] cuadrado = App.generarCuadradoMagico(3);
        assertEquals(3, cuadrado.length);
        assertEquals(3, cuadrado[0].length);
        assertTrue(cuadrado[0][1] == 1);
    }

    @Test
    void testSumaFilasCuadradoMagico3x3() {
        int[][] cuadrado = App.generarCuadradoMagico(3);
        int sumaEsperada = 15;
        
        for (int i = 0; i < 3; i++) {
            int suma = 0;
            for (int j = 0; j < 3; j++) {
                suma += cuadrado[i][j];
            }
            assertEquals(sumaEsperada, suma);
        }
    }

    @Test
    void testEntradaTamano3() {
        provideInput("3");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Cuadrado Mágico de orden 3"));
    }

    @Test
    void testTamanoParInvalido() {
        provideInput("4");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el tamaño debe ser un número impar positivo."));
    }

    @Test
    void testTamanoNegativo() {
        provideInput("-3");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el tamaño debe ser un número impar positivo."));
    }
}
