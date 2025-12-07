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
    void testAumento_875() {
        provideInput("875.0");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1006.25"), "Para sueldo 875.0, el nuevo sueldo debe ser 1006.25");
    }

    @Test
    void testAumento_785() {
        provideInput("785.0");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("902.75"), "Para sueldo 785.0, el nuevo sueldo debe ser 902.75");
    }

    @Test
    void testSinAumento_1300() {
        provideInput("1300.0");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1300.0"), "Para sueldo 1300.0, no debe haber aumento");
    }

    @Test
    void testSinAumento_2150() {
        provideInput("2150.0");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("2150.0"), "Para sueldo 2150.0, no debe haber aumento");
    }
}
