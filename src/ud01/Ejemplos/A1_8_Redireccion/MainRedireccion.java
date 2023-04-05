package ud01.Ejemplos.A1_8_Redireccion;

import java.io.*;

public class MainRedireccion {
    public static void main(String[] args) throws IOException {
        // creamos objeto File al directorio donde esta el programa
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");

        String argumento = "Cosa";

        ProcessBuilder pb = new ProcessBuilder("java", "Ejemplos.A1_8_Redireccion.HijoRedireccion", argumento);
        File fIn = new File(".\\src\\ud01\\Ejemplos.A1_8_Redireccion\\entrada.txt");
        File fOut = new File(".\\src\\ud01\\Ejemplos.A1_8_Redireccion\\salida.txt");
        pb.redirectInput(fIn);
        pb.redirectOutput(fOut);


        // se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        // se ejecuta el proceso
        Process p = pb.start();
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("ERROR >" + liner);
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
                    System.out.println("FINAL CORRECTO...");
                    break;
                case (1):
                    System.out.println("FINAL INCORRECTO...");
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
        } catch (Exception ee) 	{
            ee.printStackTrace();
        }
    }
}
