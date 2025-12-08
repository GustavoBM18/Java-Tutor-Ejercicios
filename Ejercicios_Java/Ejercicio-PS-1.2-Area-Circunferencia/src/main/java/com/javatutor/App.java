package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el radio (RADIO): ");
        double RADIO = sc.nextDouble();

        // Validar que el radio sea positivo
        if (RADIO <= 0) {
            System.out.println("Error: el radio debe ser positivo.");
            sc.close();
            return;
        }

        // Calcular área y circunferencia
        double AREA = Math.PI * Math.pow(RADIO, 2);
        double CIRC = 2 * Math.PI * RADIO;

        // Imprimir resultados con 4 decimales en formato US
        System.out.printf(Locale.US, "Area = %.4f%n", AREA);
        System.out.printf(Locale.US, "Circunferencia = %.4f%n", CIRC);

        sc.close();
    }
}
