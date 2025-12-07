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
    void testCuadradoYCubo_7() {
        provideInput("7");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El cuadrado (CUA) es: 49"), 
                   "Debe calcular correctamente el cuadrado de 7 (49)");
        assertTrue(output.contains("El cubo (CUB) es: 343"), 
                   "Debe calcular correctamente el cubo de 7 (343)");
    }

    @Test
    void testCuadradoYCubo_15() {
        provideInput("15");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El cuadrado (CUA) es: 225"), 
                   "Debe calcular correctamente el cuadrado de 15 (225)");
        assertTrue(output.contains("El cubo (CUB) es: 3375"), 
                   "Debe calcular correctamente el cubo de 15 (3375)");
    }

    @Test
    void testCuadradoYCubo_8() {
        provideInput("8");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El cuadrado (CUA) es: 64"), 
                   "Debe calcular correctamente el cuadrado de 8 (64)");
        assertTrue(output.contains("El cubo (CUB) es: 512"), 
                   "Debe calcular correctamente el cubo de 8 (512)");
    }

    @Test
    void testCuadradoYCubo_12() {
        provideInput("12");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El cuadrado (CUA) es: 144"), 
                   "Debe calcular correctamente el cuadrado de 12 (144)");
        assertTrue(output.contains("El cubo (CUB) es: 1728"), 
                   "Debe calcular correctamente el cubo de 12 (1728)");
    }

    @Test
    void testCuadradoYCubo_30() {
        provideInput("30");
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El cuadrado (CUA) es: 900"), 
                   "Debe calcular correctamente el cuadrado de 30 (900)");
        assertTrue(output.contains("El cubo (CUB) es: 27000"), 
                   "Debe calcular correctamente el cubo de 30 (27000)");
    }
}
