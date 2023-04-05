package ud01.Ejercicios.Ej7_LeerCadenas;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HijoLeerCadenas {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (in);
        try {
            String lect;
            do {
                lect = br.readLine();
                if (!lect.equals("*")){
                    System.out.println("Introducido " + lect);
                }
            } while (!lect.equals("*"));
            in.close();
        }
        catch (NumberFormatException n) {
            System.out.println("Error en la entrada");
            System.exit(0);}
        catch (Exception e) {  e.printStackTrace();}
    }
}
