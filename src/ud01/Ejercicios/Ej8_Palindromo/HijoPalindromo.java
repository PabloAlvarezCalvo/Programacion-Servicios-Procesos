package ud01.Ejercicios.Ej8_Palindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HijoPalindromo {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        try {
            String cadena = bis.readLine();
            if (cadena.length() > 0) {
                String inversa = new StringBuilder(cadena).reverse().toString();
                String salida = cadena.equals(inversa) ? cadena + " es un palindromo." : cadena + " no es un palindromo.";
                System.out.println(salida);
            } else {
                System.out.println("No se ha introducido una palabra.");
            }
        } catch (IOException e) {
            e.getStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}
