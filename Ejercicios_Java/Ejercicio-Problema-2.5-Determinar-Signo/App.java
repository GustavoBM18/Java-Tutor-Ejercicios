package com.javatutor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un número: ");
        double numero = sc.nextDouble();
        
        String resultado = determinarSigno(numero);
        System.out.println(resultado);
        
        sc.close();
    }
    
    public static String determinarSigno(double numero) {
        if (numero > 0) {
            return "El número es positivo.";
        } else if (numero < 0) {
            return "El número es negativo.";
        } else {
            return "El número es cero.";
        }
    }
}
