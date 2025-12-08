package com.javatutor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el límite inferior: ");
        int limInf = sc.nextInt();
        System.out.print("Ingrese el límite superior: ");
        int limSup = sc.nextInt();
        
        if (limInf >= limSup || limInf < 2) {
            System.out.println("Error: rango inválido.");
            sc.close();
            return;
        }
        
        System.out.println("Primos gemelos en el rango [" + limInf + ", " + limSup + "]:");
        
        int contador = 0;
        for (int i = limInf; i <= limSup - 2; i++) {
            if (esPrimo(i) && esPrimo(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
                contador++;
            }
        }
        
        if (contador == 0) {
            System.out.println("No se encontraron primos gemelos.");
        } else {
            System.out.println("Total de parejas: " + contador);
        }
        
        sc.close();
    }
    
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
