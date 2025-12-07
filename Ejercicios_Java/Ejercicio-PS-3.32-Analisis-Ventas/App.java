package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.print("Ingrese el número de sucursales: ");
        int N = sc.nextInt();
        
        if (N <= 0) {
            System.out.println("Error: el número de sucursales debe ser positivo.");
            sc.close();
            return;
        }
        
        double[][] ventas = new double[14][N];
        
        System.out.println("Ingrese las ventas de cada sucursal por año:");
        for (int anio = 0; anio < 14; anio++) {
            System.out.println("Año " + (anio + 1) + ":");
            for (int suc = 0; suc < N; suc++) {
                System.out.print("  Sucursal " + (suc + 1) + ": ");
                ventas[anio][suc] = sc.nextDouble();
            }
        }
        
        System.out.println("\n=== Análisis de Ventas ===");
        
        double[] totalesPorAnio = calcularTotalesPorAnio(ventas, N);
        System.out.println("\nTotal de ventas por año:");
        for (int i = 0; i < 14; i++) {
            System.out.printf(Locale.US, "Año %d: $%.2f\n", i + 1, totalesPorAnio[i]);
        }
        
        double[] totalesPorSucursal = calcularTotalesPorSucursal(ventas, N);
        System.out.println("\nTotal de ventas por sucursal:");
        for (int i = 0; i < N; i++) {
            System.out.printf(Locale.US, "Sucursal %d: $%.2f\n", i + 1, totalesPorSucursal[i]);
        }
        
        double totalGeneral = calcularTotalGeneral(totalesPorAnio);
        System.out.printf(Locale.US, "\nTotal general en 14 años: $%.2f\n", totalGeneral);
        
        sc.close();
    }
    
    public static double[] calcularTotalesPorAnio(double[][] ventas, int N) {
        double[] totales = new double[14];
        for (int anio = 0; anio < 14; anio++) {
            for (int suc = 0; suc < N; suc++) {
                totales[anio] += ventas[anio][suc];
            }
        }
        return totales;
    }
    
    public static double[] calcularTotalesPorSucursal(double[][] ventas, int N) {
        double[] totales = new double[N];
        for (int suc = 0; suc < N; suc++) {
            for (int anio = 0; anio < 14; anio++) {
                totales[suc] += ventas[anio][suc];
            }
        }
        return totales;
    }
    
    public static double calcularTotalGeneral(double[] totalesPorAnio) {
        double total = 0;
        for (double t : totalesPorAnio) {
            total += t;
        }
        return total;
    }
}
