package com.javatutor;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Ingrese la clave de la zona (CLAVE): ");
        if (!sc.hasNextInt()) {
            System.out.println("Error: Clave debe ser un número.");
            return;
        }
        int clave = sc.nextInt();

        System.out.print("Ingrese la duración en minutos (NUMIN): ");
        if (!sc.hasNextDouble()) {
            System.out.println("Error: Duración no válida.");
            return;
        }
        double numin = sc.nextDouble();

        double p1 = 0; // Precio por minuto (1 a 3 min)
        double p2 = 0; // Precio por minuto (4 en adelante)
        boolean claveValida = true;

        // Selección de precios según la tabla
        switch (clave) {
            case 12: // América del Norte
                p1 = 2.0; p2 = 1.5; break;
            case 15: // América Central
                p1 = 2.2; p2 = 1.8; break;
            case 18: // América del Sur
                p1 = 4.5; p2 = 3.5; break;
            case 19: // Europa
                p1 = 3.5; p2 = 2.7; break;
            case 23: // Asia
                p1 = 6.0; p2 = 4.6; break;
            case 25: // África
                p1 = 6.0; p2 = 4.6; break;
            case 29: // Oceanía
                p1 = 5.0; p2 = 3.9; break;
            default:
                claveValida = false;
                break;
        }

        if (!claveValida) {
            System.out.println("ERROR EN CLAVE");
        } else {
            double costoTotal;
            if (numin > 3) {
                // Fórmula: (3 * PrecioBase) + ((Minutos - 3) * PrecioExtra)
                costoTotal = (3 * p1) + ((numin - 3) * p2);
            } else {
                // Fórmula simple: Minutos * PrecioBase
                costoTotal = numin * p1;
            }
            System.out.printf(Locale.US, "Costo total: $%.2f%n", costoTotal);
        }

        sc.close();
    }
}