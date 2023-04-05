package ud01.Ejemplos.A1_6_SumaTeclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HijoSumaTeclado {
    public static void main (String [] args) {

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (in);
        try {
            System.out.println("Introduce número1: ");
            int numero1 = Integer.parseInt (br.readLine());
            System.out.println("Número escrito: "+numero1);

            System.out.println("Introduce número2: ");
            int numero2 = Integer.parseInt (br.readLine());
            System.out.println("Número escrito: "+numero2);

            int suma=numero1 + numero2;
            System.out.println("La suma es: "+suma);
            in.close();
        }
        catch (NumberFormatException n) {
            System.out.println("ERROR EN LOS NÚMEROS TECLEADOS...");
            System.exit(0);}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
