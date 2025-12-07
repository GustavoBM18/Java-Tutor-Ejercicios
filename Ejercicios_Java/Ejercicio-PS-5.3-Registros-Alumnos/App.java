package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.print("Ingrese el número de alumnos: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        if (n <= 0) {
            System.out.println("Error: el número de alumnos debe ser positivo.");
            sc.close();
            return;
        }
        
        String[] nombres = new String[n];
        double[] promedios = new double[n];
        
        System.out.println("Ingrese los datos de cada alumno:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del alumno " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.print("Promedio de " + nombres[i] + ": ");
            promedios[i] = sc.nextDouble();
            sc.nextLine();
        }
        
        System.out.println("\n=== Lista de Alumnos ===");
        for (int i = 0; i < n; i++) {
            System.out.printf(Locale.US, "%s: %.2f\n", nombres[i], promedios[i]);
        }
        
        int mejorIndice = encontrarMejorAlumno(promedios);
        System.out.printf(Locale.US, "\nMejor alumno: %s con promedio %.2f\n", 
                         nombres[mejorIndice], promedios[mejorIndice]);
        
        sc.close();
    }
    
    public static int encontrarMejorAlumno(double[] promedios) {
        int mejorIndice = 0;
        for (int i = 1; i < promedios.length; i++) {
            if (promedios[i] > promedios[mejorIndice]) {
                mejorIndice = i;
            }
        }
        return mejorIndice;
    }
}
