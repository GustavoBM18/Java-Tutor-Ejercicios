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
    void testRadio5() {
        provideInput("5.0");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("78.5398"), "El área debe ser 78.5398 para radio 5.0");
        assertTrue(output.contains("31.4159"), "La circunferencia debe ser 31.4159 para radio 5.0");
    }

    @Test
    void testRadio10() {
        provideInput("10.0");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("314.1593"), "El área debe ser 314.1593 para radio 10.0");
        assertTrue(output.contains("62.8319"), "La circunferencia debe ser 62.8319 para radio 10.0");
    }

    @Test
    void testRadioNegativo() {
        provideInput("-3.0");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el radio debe ser positivo."), 
                   "Debe mostrar mensaje de error para radio negativo");
    }

    @Test
    void testRadioCero() {
        provideInput("0");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: el radio debe ser positivo."), 
                   "Debe mostrar mensaje de error para radio cero");
    }
}
