package ud01.Ejercicios.Ej_Aleatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HijoAleatorio {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        String in;
        try {
            while ((in = bis.readLine()) != null) {
                if (!in.equals("fin")) {
                    System.out.println((int)(Math.random() * 11));
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
