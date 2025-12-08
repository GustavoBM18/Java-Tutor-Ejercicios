package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // Para usar punto decimal

        // Mostrar menú
        System.out.println("--- MENÚ DE CONVERSIONES ---");
        System.out.println("1. Pulgadas a Milímetros");
        System.out.println("2. Yardas a Metros");
        System.out.println("3. Millas a Kilómetros");
        System.out.print("Ingrese opción (OPCION): ");

        // Validar entrada de entero
        if (!sc.hasNextInt()) {
            System.out.println("Error: Entrada no válida.");
            sc.close();
            return;
        }
        int opcion = sc.nextInt();

        // Validar rango de opción
        if (opcion < 1 || opcion > 3) {
            System.out.println("Error: La opción debe ser 1, 2 o 3.");
            sc.close();
            return;
        }

        System.out.print("Ingrese medida (MED): ");
        if (!sc.hasNextDouble()) {
            System.out.println("Error: Medida no válida.");
            sc.close();
            return;
        }
        double med = sc.nextDouble();
        double res = 0;
        String unidad = "";

        // Proceso según diagrama de flujo
        switch (opcion) {
            case 1:
                res = med * 25.40;
                unidad = "mm";
                break;
            case 2:
                res = med * 0.9144;
                unidad = "m";
                break;
            case 3:
                res = med * 1.6093;
                unidad = "km";
                break;
        }

        // Salida formateada a 2 o 4 decimales según prefieras, usaremos 4 para precisión
        // o 2 como es estándar en ejercicios simples. Usaré %.4f para ser precisos con los factores.
        System.out.printf(Locale.US, "Resultado: %.4f %s%n", res, unidad);

        sc.close();
    }
}