package ud01.Ejercicios.Ej7_LeerCadenas;

import java.io.*;
import java.util.Scanner;

public class PadreLeercadenas {
    public static void main(String[] args) throws IOException {
        // creamos objeto File al directorio donde esta el programa
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej7_LeerCadenas.HijoLeerCadenas");
        // se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        // se ejecuta el proceso
        Process p = pb.start();
        //Escritura, se envían bytes, que luego el hijo leerá, realmente no lo introducimos por teclado, pero se podría hacer
        //OutputStream os = p.getOutputStream();

        //os.write("ASD\n".getBytes());
        //os.write("Cosa\n".getBytes());
        //os.write("Equisde\n".getBytes());
        //os.write("*\n".getBytes());
        //os.flush();

        //Múltiples elementos desde teclado
        Scanner sc = new Scanner(System.in);
        String lectura = "";
        OutputStream os = p.getOutputStream();
        do {
            System.out.println("Introduzca cadena");
            lectura = sc.nextLine();
            os.write(lectura.getBytes());
            os.write("\n".getBytes());
            os.flush(); // vacía el buffer de salida
        } while (!lectura.equals("*"));
        os.close();

        //Lectura, se muestra lo recibido del proceso hijo
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1)
            System.out.print((char) c);
        is.close();

        //Comprobación de errores: 0 OK, 1 NOK
        int exitValue;
        try {
            exitValue = p.waitFor();
            System.out.println("Valor de salida: " + exitValue);
            switch (exitValue) {
                case 0 -> System.out.println("Finalizado correctamente.");
                case 1 -> System.out.println("Finalizado con errores.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        //Capturar stream de error
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("ERROR >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
