package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.print("Ingrese el número de fábricas: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Error: el número de fábricas debe ser positivo.");
            sc.close();
            return;
        }
        
        double[] produccion = new double[n];
        System.out.println("Ingrese la producción de cada fábrica:");
        for (int i = 0; i < n; i++) {
            System.out.print("Fábrica " + (i + 1) + ": ");
            produccion[i] = sc.nextDouble();
        }
        
        double total = calcularTotal(produccion);
        double promedio = total / n;
        int superanPromedio = contarSuperanPromedio(produccion, promedio);
        
        System.out.println("\n=== Análisis de Producción ===");
        System.out.printf(Locale.US, "Producción total: %.2f\n", total);
        System.out.printf(Locale.US, "Promedio de producción: %.2f\n", promedio);
        System.out.println("Fábricas que superan el promedio: " + superanPromedio);
        
        sc.close();
    }
    
    public static double calcularTotal(double[] produccion) {
        double total = 0;
        for (double p : produccion) {
            total += p;
        }
        return total;
    }
    
    public static int contarSuperanPromedio(double[] produccion, double promedio) {
        int count = 0;
        for (double p : produccion) {
            if (p > promedio) {
                count++;
            }
        }
        return count;
    }
}
