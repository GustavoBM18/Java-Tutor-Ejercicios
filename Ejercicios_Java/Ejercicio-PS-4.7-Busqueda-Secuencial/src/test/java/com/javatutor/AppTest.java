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
    void testBusquedaSecuencial_Encontrado() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(2, App.busquedaSecuencial(arr, 30));
    }

    @Test
    void testBusquedaSecuencial_NoEncontrado() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(-1, App.busquedaSecuencial(arr, 99));
    }

    @Test
    void testBusquedaSecuencial_PrimerElemento() {
        int[] arr = {10, 20, 30};
        assertEquals(0, App.busquedaSecuencial(arr, 10));
    }

    @Test
    void testBuscarEnArreglo() {
        provideInput("5\n10\n20\n30\n40\n50\n30");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Valor encontrado en la posición: 2"));
    }

    @Test
    void testValorNoEncontrado() {
        provideInput("3\n5\n10\n15\n99");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Valor no encontrado."));
    }
}
