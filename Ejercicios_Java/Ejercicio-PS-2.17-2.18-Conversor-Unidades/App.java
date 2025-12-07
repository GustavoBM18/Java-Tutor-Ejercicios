package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        System.out.println("=== Conversor de Unidades ===");
        System.out.println("1. Metros a Pies");
        System.out.println("2. Pies a Metros");
        System.out.println("3. Kilogramos a Libras");
        System.out.println("4. Libras a Kilogramos");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        
        System.out.print("Ingrese el valor: ");
        double valor = sc.nextDouble();
        
        double resultado = convertir(opcion, valor);
        
        System.out.printf(Locale.US, "Resultado: %.2f\n", resultado);
        
        sc.close();
    }
    
    public static double convertir(int opcion, double valor) {
        switch (opcion) {
            case 1:
                return valor * 3.28084;
            case 2:
                return valor / 3.28084;
            case 3:
                return valor * 2.20462;
            case 4:
                return valor / 2.20462;
            default:
                return 0;
        }
    }
}
