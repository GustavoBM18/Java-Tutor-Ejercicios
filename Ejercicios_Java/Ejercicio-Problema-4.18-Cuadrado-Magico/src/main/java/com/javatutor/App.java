package com.javatutor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del cuadrado mágico (impar): ");
        int n = sc.nextInt();
        
        if (n <= 0 || n % 2 == 0) {
            System.out.println("Error: el tamaño debe ser un número impar positivo.");
            sc.close();
            return;
        }
        
        int[][] cuadrado = generarCuadradoMagico(n);
        
        System.out.println("\nCuadrado Mágico de orden " + n + ":");
        imprimirCuadrado(cuadrado);
        
        sc.close();
    }
    
    public static int[][] generarCuadradoMagico(int n) {
        int[][] cuadrado = new int[n][n];
        int fila = 0;
        int col = n / 2;
        
        for (int num = 1; num <= n * n; num++) {
            cuadrado[fila][col] = num;
            
            int nuevaFila = (fila - 1 + n) % n;
            int nuevaCol = (col + 1) % n;
            
            if (cuadrado[nuevaFila][nuevaCol] != 0) {
                fila = (fila + 1) % n;
            } else {
                fila = nuevaFila;
                col = nuevaCol;
            }
        }
        
        return cuadrado;
    }
    
    public static void imprimirCuadrado(int[][] cuadrado) {
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                System.out.printf("%4d", cuadrado[i][j]);
            }
            System.out.println();
        }
    }
}
