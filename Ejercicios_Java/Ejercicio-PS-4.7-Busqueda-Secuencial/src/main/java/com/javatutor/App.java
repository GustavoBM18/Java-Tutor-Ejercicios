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
        
        System.out.print("Ingrese el valor a buscar: ");
        int valor = sc.nextInt();
        
        int posicion = busquedaSecuencial(arreglo, valor);
        
        if (posicion != -1) {
            System.out.println("Valor encontrado en la posición: " + posicion);
        } else {
            System.out.println("Valor no encontrado.");
        }
        
        sc.close();
    }
    
    public static int busquedaSecuencial(int[] arreglo, int valor) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}
