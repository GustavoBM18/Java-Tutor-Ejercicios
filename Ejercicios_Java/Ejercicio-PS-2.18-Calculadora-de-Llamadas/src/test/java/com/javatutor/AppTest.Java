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
    void testAmericaNorte_Corta() {
        // Clave 12, 3 min. Precio Base = 2.0
        // Costo = 3 * 2.0 = 6.0
        provideInput("12\n3\n");
        App.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().contains("$6.00"), "3 min a Norteamérica debe ser $6.00");
    }

    @Test
    void testAmericaNorte_Larga() {
        // Clave 12, 5 min. Base=2.0, Extra=1.5
        // (3 * 2.0) + (2 * 1.5) = 6 + 3 = 9.0
        provideInput("12\n5\n");
        App.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().contains("$9.00"), "5 min a Norteamérica debe ser $9.00");
    }

    @Test
    void testEuropa_Decimal() {
        // Clave 19, 2.5 min. Base=3.5
        // 2.5 * 3.5 = 8.75
        provideInput("19\n2.5\n");
        App.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().contains("$8.75"), "2.5 min a Europa debe ser $8.75");
    }

    @Test
    void testAsia_Larga() {
        // Clave 23, 4 min. Base=6.0, Extra=4.6
        // (3 * 6.0) + (1 * 4.6) = 18 + 4.6 = 22.6
        provideInput("23\n4\n");
        App.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().contains("$22.60"), "4 min a Asia debe ser $22.60");
    }

    @Test
    void testClaveInvalida() {
        provideInput("99\n5\n");
        App.main(new String[]{});
        assertTrue(outputStreamCaptor.toString().contains("ERROR EN CLAVE"), "Debe detectar clave inválida");
    }
}