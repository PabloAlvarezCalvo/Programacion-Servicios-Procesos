package ud01.Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2b {
    public static void main(String[] args) throws IOException {

        //Mal escroto para que falle
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIRR");
        Process p = pb.start();

        try {
            InputStream is = p.getInputStream();
            InputStream er = p.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(er));
            int c;
            while((c = is.read()) != -1) {
                System.out.print((char)c);
            }

            String liner;
            while ((liner = br.readLine()) != null) {
                System.out.println("Error: " + liner);
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int exitVal;

        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException e) {
            e.getLocalizedMessage();
        }

    }
}