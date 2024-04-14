package org.marylin;

public class Binarios
{
    public static boolean validarDecimal(int decimal) {
        // Decimal pasa la validación con el hecho de que sea entero
        return false;
    }

    public static boolean validarBinario(int binario) {
        // Comprobar si solo se compone de unos y ceros
        String binarioComoCadena = String.valueOf(binario);
        for (int i = 0; i < binarioComoCadena.length(); i++) {
            char caracter = binarioComoCadena.charAt(i);
            if (caracter != '0' && caracter != '1') {
                return true;
            }
        }
        return false;
    }

    public static boolean validarOctal(int octal) {
        // comprobar si solo tiene números del 0 al 7
        String octalComoCadena = String.valueOf(octal);
        String caracteresOctales = "01234567";
        for (int i = 0; i < octalComoCadena.length(); i++) {
            char caracter = octalComoCadena.charAt(i);
            // Si no se encuentra dentro de los caracteres válidos, regresamos false
            if (caracteresOctales.indexOf(caracter) == -1) {
                return true;
            }
        }
        return false;
    }

    // Nota: se debe enviar la cadena hexadecimal convertida a mayúsculas
    public static boolean validarHexadecimal(String hexadecimal) {
        // Comprobar si solo tiene números del 0 al 9 y letras de la A a la F
        String caracteresHexadecimales = "0123456789ABCDEF";
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            // Si no se encuentra dentro de los caracteres válidos, regresamos false
            if (caracteresHexadecimales.indexOf(caracter) == -1) {
                return true;
            }
        }
        return false;
    }

    //De Decimal a otras bases
    public static String decimalABinario(int decimal) {
        StringBuilder binario = new StringBuilder ();
        while (decimal > 0) {
            binario.insert (0, decimal % 2);
            decimal = decimal / 2;
        }
        return binario.toString ();
    }

    public static String decimalAOctal(int decimal) {
        int residuo;
        StringBuilder octal = new StringBuilder ();
        char[] caracteresOctales = {'0', '1', '2', '3', '4', '5', '6', '7'};
        while (decimal > 0) {
            residuo = decimal % 8;
            char caracter = caracteresOctales[residuo];
            octal.insert (0, caracter);
            decimal = decimal / 8;
        }
        return octal.toString ();
    }

    public static String decimalAHexadecimal(int decimal) {
        int residuo;
        StringBuilder hexadecimal = new StringBuilder ();
        char[] caracteresHexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            residuo = decimal % 16;
            char caracterHexadecimal = caracteresHexadecimales[residuo];
            hexadecimal.insert (0, caracterHexadecimal);
            decimal = decimal / 16;
        }
        return hexadecimal.toString ();
    }

    // Conversiones de otras bases a decimal
    public static int binarioADecimal(int binario) {
        int decimal = 0;
        int potencia = 0;
        // Ciclo infinito hasta que binario sea 0
        while (true) {
            if (binario == 0) {
                break;
            } else {
                int temp = binario % 10;
                decimal += (int) (temp * Math.pow(2, potencia));
                binario = binario / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public static int octalADecimal(int octal) {
        int decimal = 0;
        int potencia = 0;
        // Ciclo infinito que se rompe cuando octal es 0
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += (int) (temp * Math.pow(8, potencia));
                octal = octal / 10;
                potencia++;
            }
        }
        return decimal;
    }

    public static int hexadecimalADecimal(String hexadecimal) {
        String caracteresHexadecimales = "0123456789ABCDEF";
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char caracter = hexadecimal.charAt(i);
            int posicionEnCaracteres = caracteresHexadecimales.indexOf(caracter);
            decimal = 16 * decimal + posicionEnCaracteres;
        }
        return decimal;
    }

}







