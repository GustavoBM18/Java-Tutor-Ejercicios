package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        // Configurar locale para formato numérico
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        // Leer el número entero positivo
        System.out.print("Introduce un número entero positivo (NUM): ");
        int NUM = teclado.nextInt();

        // Calcular el cuadrado (CUA) y el cubo (CUB)
        int CUA = NUM * NUM;
        int CUB = NUM * NUM * NUM;
        
        // Imprimir los resultados en el formato requerido
        System.out.println("El cuadrado (CUA) es: " + CUA);
        System.out.println("El cubo (CUB) es: " + CUB);
        
        teclado.close();
    }
}
