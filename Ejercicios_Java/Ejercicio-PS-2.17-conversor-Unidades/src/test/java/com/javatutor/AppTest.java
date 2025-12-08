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
    void testOpcion1_PulgadasAMilimetros() {
        // 10 pulgadas * 25.40 = 254.0
        provideInput("1\n10\n");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("254.0000 mm"), "10 pulgadas deben ser 254.0 mm");
    }

    @Test
    void testOpcion2_YardasAMetros() {
        // 100 yardas * 0.9144 = 91.44
        provideInput("2\n100\n");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("91.4400 m"), "100 yardas deben ser 91.44 m");
    }

    @Test
    void testOpcion3_MillasAKilometros() {
        // 10 millas * 1.6093 = 16.093
        provideInput("3\n10\n");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("16.0930 km"), "10 millas deben ser 16.093 km");
    }

    @Test
    void testOpcionInvalida() {
        provideInput("5\n");
        App.main(new String[]{});
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: La opción debe ser 1, 2 o 3"), "Debe validar opción fuera de rango");
    }
}