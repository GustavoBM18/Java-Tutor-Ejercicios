package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    
    /** Devuelve el porcentaje de descuento según el modelo */
    public static double porcentajePorModelo(String modelo) {
        String m = modelo.trim().toLowerCase(Locale.ROOT);
        if (m.equals("blazer-trail")) return 0.08;
        if (m.equals("cavalier")) return 0.05;
        if (m.equals("chevy")) return 0.06;
        if (m.equals("opel-astra")) return 0.09;
        return 0.0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Modelo: ");
        String MODELO = sc.nextLine();
        System.out.print("Precio: ");
        double PRECIO = sc.nextDouble();

        if (PRECIO <= 0) {
            System.out.println("Error: el precio debe ser positivo.");
            sc.close();
            return;
        }

        double PORC = porcentajePorModelo(MODELO);
        double DESCUENTO = PRECIO * PORC;
        double TOTAL = PRECIO - DESCUENTO;

        System.out.printf(Locale.US, "Modelo: %s%n", MODELO);
        System.out.printf(Locale.US, "Porcentaje: %.0f%%%n", PORC * 100);
        System.out.printf(Locale.US, "Descuento: $%.2f%n", DESCUENTO);
        System.out.printf(Locale.US, "Total a pagar: $%.2f%n", TOTAL);
        sc.close();
    }
}
