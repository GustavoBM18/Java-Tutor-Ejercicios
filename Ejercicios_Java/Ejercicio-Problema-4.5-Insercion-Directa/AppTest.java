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
    void testInsercionDirecta_ArrayDesordenado() {
        int[] arr = {5, 2, 8, 1, 9};
        App.insercionDirecta(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    void testInsercionDirecta_ArrayOrdenado() {
        int[] arr = {1, 2, 3, 4, 5};
        App.insercionDirecta(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testInsercionDirecta_ArrayInverso() {
        int[] arr = {5, 4, 3, 2, 1};
        App.insercionDirecta(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testOrdenamientoCompleto() {
        provideInput("5\n64\n34\n25\n12\n22");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("12 22 25 34 64"));
    }

    @Test
    void testTamanoNegativo() {
        provideInput("-1");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el tamaño debe ser positivo."));
    }
}
