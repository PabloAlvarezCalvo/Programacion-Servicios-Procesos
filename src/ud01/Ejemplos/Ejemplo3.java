package ud01.Ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejemplo3 {
    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");

        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejemplos.Ejemplo2");
        pb.directory(directorio);
        Process p = pb.start();

        InputStream is = p.getInputStream();

        int c;
        try {
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }
}
