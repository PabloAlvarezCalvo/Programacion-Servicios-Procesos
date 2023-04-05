package ud01.Examen.Ejercicio1;

import java.io.*;
import java.util.Scanner;

public class PadreOrdernarNumeros {
    public static void main(String[] args) {
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Examen.Ejercicio1.OrdenarNumeros");
        pb.directory(directorio);

        File flujoSalida = new File(".\\src\\ud01\\Examen\\Ejercicio1\\salida.txt");
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(flujoSalida));

        try {
            Process p = pb.start();

            InputStream is = p.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));

            PrintStream ps = new PrintStream(p.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String entrada;
            do {
                System.out.println("Introduzca números enteros. Escriba -999 para salir");
                entrada = sc.nextLine();
                ps.println(entrada);
            } while (!entrada.equals("-999"));

            System.out.println("Fin");

            ps.flush();

            String liner;
            while ((liner = bis.readLine()) != null) {
                System.out.println(liner);
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
