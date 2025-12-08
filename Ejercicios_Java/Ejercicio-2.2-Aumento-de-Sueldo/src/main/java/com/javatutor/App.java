package com.javatutor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Leer el sueldo (SUE)
        System.out.print("Introduce el sueldo (SUE): ");
        double SUE = teclado.nextDouble();

        // Inicializar variables
        double AUM = 0;
        double NSUE = SUE;

        // Aplicar aumento del 15% si SUE < 1000
        if (SUE < 1000) {
            AUM = SUE * 0.15;
            NSUE = SUE + AUM;
        }
        
        // Imprimir el resultado
        System.out.println("El nuevo sueldo (NSUE) es: " + NSUE);

        teclado.close();
    }
}
