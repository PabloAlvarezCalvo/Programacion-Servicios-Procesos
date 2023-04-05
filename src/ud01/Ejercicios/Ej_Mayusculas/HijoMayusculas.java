package ud01.Ejercicios.Ej_Mayusculas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class HijoMayusculas {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (in);
        String cadena;

        try {
            while (!(cadena = br.readLine()).equals("*")) {
                System.out.println(cadena.toUpperCase(Locale.ROOT));
            }
            System.exit(1);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
