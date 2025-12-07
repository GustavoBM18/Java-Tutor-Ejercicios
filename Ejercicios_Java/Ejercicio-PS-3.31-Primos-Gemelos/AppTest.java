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
    void testEsPrimo_2() {
        assertTrue(App.esPrimo(2));
    }

    @Test
    void testEsPrimo_17() {
        assertTrue(App.esPrimo(17));
    }

    @Test
    void testNoEsPrimo_4() {
        assertFalse(App.esPrimo(4));
    }

    @Test
    void testRango_3_20() {
        provideInput("3\n20");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("(3, 5)"));
        assertTrue(output.contains("(5, 7)"));
        assertTrue(output.contains("(11, 13)"));
        assertTrue(output.contains("(17, 19)"));
    }

    @Test
    void testRangoInvalido() {
        provideInput("10\n5");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: rango inválido."));
    }
}
