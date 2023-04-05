package ud01.Ejercicios.Ej5_Repetir5Veces;

import java.io.*;

public class PadreRepetir {
    public static void main(String[] args) throws IOException {
        // creamos objeto File al directorio donde esta el programa
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");

        String argumento = "Cosa";

        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej5_Repetir5Veces.HijoRepetir", argumento);

        // se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        // se ejecuta el proceso
        Process p = pb.start();
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("Error :" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // COMPROBACION DE la salida del programa
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
            switch (exitVal) {
                case (0):
                    System.out.println("Final correcto.");
                    break;
                case (1):
                    System.out.println("Final incorrecto");
                    break;
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null)
            {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception e) 	{
            e.printStackTrace();
        }
    }
}
