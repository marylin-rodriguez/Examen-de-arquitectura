package org.marylin;

import java.util.Scanner;

import static org.marylin.Binarios.*;


public class App
{
    private static int octal;

    public static void main(String[] args)
    {

        System.out.println ("""
                Menú principal
                1.Convertir
                2.Operaciones aritméticas
                                
                Escoja una opción:
                1. Binaria\s
                2. Decimal
                3. Octal
                4. Hexadecimal\s
                5. Salir
                ""\");
                Seleccione:\s""");
        Scanner sc = new Scanner (System.in);
        int eleccion = sc.nextInt ();
        if (eleccion < 1 || eleccion > 12) {
            System.out.println ("Elección no válida");
            return;
        }
        Scanner scanner = new Scanner (System.in);
        switch (eleccion) {
            case 1:
                System.out.println ("Ingrese número binario:");
                int binario = scanner.nextInt ();

                if (Binarios.validarBinario (binario)) {
                    System.out.println ("Número binario no válido");
                    return;
                }
                int decimal = binarioADecimal (binario);
                System.out.println ("El decimal es: " + decimal);
                break;
            case 2:
                System.out.print ("Ingrese número decimal: ");
                int numeroDecimal = scanner.nextInt ();
                if (numeroDecimal < 0) {
                    System.out.println ("Número decimal no válido. Debe ser positivo.");
                    return;
                }

                String binarioResultante = decimalABinario (numeroDecimal);
                System.out.println ("El binario es: " + binarioResultante);
                break;


            case 3:


                System.out.println ("Ingrese numero octal:");
                int octal = scanner.nextInt ();
                if (Binarios.validarBinario (octal)) {
                    System.out.println ("Numero binario no valido");
                    return;
                }
                decimal = Binarios.octalADecimal (octal);
                String hexadecimalResultante = decimalAHexadecimal (decimal);
                System.out.println ("El hexadecimal es " + hexadecimalResultante);
                break;

            case 4:
                System.out.println ("Ingrese número hexadecimal:");
                String hexadecimal = scanner.next ().toUpperCase ();
                binario = scanner.nextInt ();
                if (!validarHexadecimal (hexadecimal)) {
                    System.out.println ("Número no válido");
                    return;
                }
                decimal = hexadecimalADecimal (hexadecimal);
                System.out.println ("El hexadecimal es " + hexadecimal);
                break;

            case 5:

                System.out.println ("Saliendo del programa. ");
                break;

            default:
                System.out.println ("Opción no válida. Por favor, seleccione una opción válida.");

        }

    }
    public static void convertirMenu(Scanner scanner)
    {
        System.out.println("Ingrese número:");
        int numero = scanner.nextInt();
        System.out.println("El número en notación hexadecimal es: " + Integer.toHexString(numero));
    }

    public static void operacionesAritmeticas(Scanner scanner)
    {
        System.out.println("""
                Elige una opción:
                1. Suma
                2. Resta
                3. Multiplicación
                4. División 
                5. Salir
                """);

        int opcion = scanner.nextInt();
        switch (opcion)
        {
            case 1:
                System.out.println("Ingrese el primer número binario:");
                int binario1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número binario:");
                int binario2 = scanner.nextInt();
                int suma = binario1 + binario2;
                System.out.println("La suma es: " + suma);
                break;

            case 2:
                System.out.println("Ingrese el primer número:");
                int num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                int num2 = scanner.nextInt();
                int resta = num1 - num2;
                System.out.println("La resta es: " + resta);
                break;

            case 3:
                System.out.println("Ingrese el primer número:");
                num1 = scanner.nextInt ();
                System.out.println("Ingrese el segundo número:");
                num2 = scanner.nextInt ();
                int multiplicacion = num1 * num2;
                System.out.println("La multiplicación es: " + multiplicacion);
                break;

            case 4:
                System.out.println("Ingrese el dividendo:");
                int dividendo = scanner.nextInt();
                System.out.println("Ingrese el divisor:");
                int divisor = scanner.nextInt();

                if (divisor == 0)
                {
                    System.out.println("No se puede dividir por cero.");
                }

                else {
                    int division = dividendo / divisor;
                    int residuo = dividendo % divisor;
                    System.out.println("La división es: " + division + " con un residuo de: " + residuo);
                }
                break;

            case 5:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void setOctal(int octal)
    {
        App.octal = octal;
    }
}


