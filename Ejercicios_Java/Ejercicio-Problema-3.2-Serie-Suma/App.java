package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.print("Ingrese el número de términos: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Error: el número de términos debe ser positivo.");
            sc.close();
            return;
        }
        
        double suma = calcularSerieSuma(n);
        System.out.printf(Locale.US, "La suma de la serie es: %.4f\n", suma);
        
        sc.close();
    }
    
    public static double calcularSerieSuma(int n) {
        double suma = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                suma += 1.0 / i;
            } else {
                suma -= 1.0 / i;
            }
        }
        return suma;
    }
}
