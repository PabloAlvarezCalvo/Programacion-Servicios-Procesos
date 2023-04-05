package ud01.Ejercicios.ComunicacionBidireccional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PadreBidireccional {
    public static void main(String[] args) throws IOException {
        //Creamos objeto File al directorio donde esta Ejemplo 2
        File directorio = new File("out\\production\\ProgramacionServiciosProcesos\\");
        //System.out.println(directorio.getAbsolutePath());

        //El proceso a ejecutar es Ejercicios.ComunicacionBidireccional.Hijo
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.ComunicacionBidireccional.HijoBidireccional", "Hijo! Le dice el padre al hijo");

        //Se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        System.out.printf("Directorio de trabajo: %s%n", pb.directory());

        //Se ejecuta el proceso
        Process p = pb.start();

        //Obtener la salida devuelta por el proceso
        try {
            InputStream is = p.getInputStream();
            int c;
            while((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();

            System.out.println("Ejecucion terminada con codigo: " + p.waitFor());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
