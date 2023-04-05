package ud01.Ejercicios.Ej_Aleatorio;

import java.io.*;
import java.util.Scanner;

public class PadreAleatorio {
    public static void main(String[] args) {
        try {
            File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
            ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej_Aleatorio.HijoAleatorio");
            pb.directory(directorio);
            Process p = pb.start();

            InputStream is = p.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            PrintStream ps = new PrintStream(p.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String lineRec;
            while ((lineRec = sc.nextLine()).compareTo("fin") != 0) {
                if (!lineRec.equals("fin")) {
                    ps.println("");
                    ps.flush();
                }

                String lineBis;
                if ((lineBis = bis.readLine()) != null) {
                    System.out.println(lineBis);
                }
            }

            p.destroy();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
