package ud01.Ejemplos;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {
    public static void main(String[] args) throws IOException {

        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        Process p = pb.start();

        try {
            InputStream is = p.getInputStream();
            int c;
            while((c = is.read()) != -1) {
                System.out.print((char)c);
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