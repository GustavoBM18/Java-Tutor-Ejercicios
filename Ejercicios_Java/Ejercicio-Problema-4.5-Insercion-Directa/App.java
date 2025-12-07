package com.javatutor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Error: el tamaño debe ser positivo.");
            sc.close();
            return;
        }
        
        int[] arreglo = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }
        
        insercionDirecta(arreglo);
        
        System.out.println("\nArreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
        
        sc.close();
    }
    
    public static void insercionDirecta(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int aux = arreglo[i];
            int j = i - 1;
            
            while (j >= 0 && arreglo[j] > aux) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            
            arreglo[j + 1] = aux;
        }
    }
}
