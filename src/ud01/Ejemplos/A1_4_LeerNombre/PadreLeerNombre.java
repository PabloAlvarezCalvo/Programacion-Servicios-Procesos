package ud01.Ejemplos.A1_4_LeerNombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PadreLeerNombre {
    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejemplos.A1_4_LeerNombre.HijoLeerNombre", "Pepe");
        pb.directory(directorio);
        Process p = pb.start();

        InputStream is = p.getInputStream();

        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char)c);
        }

        try {
            int exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (Exception e) {
            e.getLocalizedMessage();
        }

    }
}
