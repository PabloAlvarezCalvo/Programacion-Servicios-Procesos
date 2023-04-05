package ud01.Ejercicios.Ej8_Palindromo;

import java.io.*;
import java.util.Scanner;

public class PadrePalindromo {
    public static void main(String[] args) throws IOException {
        // creamos objeto File al directorio donde esta el programa
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        //El proceso hijo a ejecutar
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej8_Palindromo.HijoPalindromo");

        pb.directory(directorio);

        Process p = pb.start();

        InputStream is = p.getInputStream();

        OutputStream os = p.getOutputStream();

        System.out.println("Introduzca una cadena para comprobar si es palindromo");
        Scanner sc = new Scanner(System.in);
        os.write(sc.nextLine().getBytes());
        os.write("\n".getBytes());
        os.flush();

        try {
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        is.close();

        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
            switch (exitVal){
                case 0 -> System.out.println("Proceso finalizado correctamente.");
                case 1 -> System.out.println("Proceso finalizado con errores.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            InputStream err = p.getErrorStream();
            BufferedReader berr = new BufferedReader(new InputStreamReader(err));
            String liner = null;
            while ((liner = berr.readLine()) != null)
                System.out.println("ERROR >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
