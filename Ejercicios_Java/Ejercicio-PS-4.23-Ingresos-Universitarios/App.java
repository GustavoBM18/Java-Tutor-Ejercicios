package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.print("Ingrese el número de postulantes: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Error: el número de postulantes debe ser positivo.");
            sc.close();
            return;
        }
        
        double[] notas = new double[n];
        System.out.println("Ingrese las notas de los postulantes:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nota del postulante " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }
        
        int aprobados = contarAprobados(notas);
        int reprobados = n - aprobados;
        double promedio = calcularPromedio(notas);
        
        System.out.println("\n=== Resultados ===");
        System.out.println("Total de postulantes: " + n);
        System.out.println("Aprobados (nota >= 7.0): " + aprobados);
        System.out.println("Reprobados (nota < 7.0): " + reprobados);
        System.out.printf(Locale.US, "Promedio general: %.2f\n", promedio);
        
        sc.close();
    }
    
    public static int contarAprobados(double[] notas) {
        int count = 0;
        for (double nota : notas) {
            if (nota >= 7.0) {
                count++;
            }
        }
        return count;
    }
    
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }
}
