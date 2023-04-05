package ud01.Examen.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OrdenarNumeros {
    public static void main(String[] args) {
        //Recibe de entrada estándar números
        //Fin con -999
        //Ordena los números y los muestra en su salida estándar
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        String entrada;
        ArrayList<Integer> numerosRecibidos = new ArrayList<>();
        try {
            while (((entrada = bis.readLine()) != null) && (Integer.parseInt(entrada) != -999)) {
                numerosRecibidos.add(Integer.parseInt(entrada));
            }

            numerosRecibidos.sort(null);

            System.out.println(numerosRecibidos.toString());

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
