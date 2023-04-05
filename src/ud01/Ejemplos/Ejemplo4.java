package ud01.Ejemplos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejemplo4 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "date");
        Process p = pb.start();

        InputStream is = p.getInputStream();
        OutputStream os = p.getOutputStream();
        os.write("06-12-2022".getBytes());
        os.flush();

        int c;
        while ((c = is.read()) != -1){
            System.out.print((char)c);
        }
        is.close();

        try {
            int exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (Exception e) {
            e.getLocalizedMessage();
        }

    }
}
