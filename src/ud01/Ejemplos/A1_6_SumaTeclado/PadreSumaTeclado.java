package ud01.Ejemplos.A1_6_SumaTeclado;

import java.io.*;

public class PadreSumaTeclado {
    public static void main(String[] args) throws IOException {
        //Creamos objeto File al directorio donde estás los archivos java
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        //El proceso a ejecutar es SumaTeclado
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejemplos.A1_6_SumaTeclado.HijoSumaTeclado");
        //Se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        //Se ejecuta el proceso
        Process p = pb.start();

        //Escritura, se envían bytes, que luego el hijo leerá, realmente no lo introducimos por teclado, pero se podría hacer
        OutputStream os = p.getOutputStream();

        os.write("10\n".getBytes());
        os.write("15\n".getBytes());
        os.flush();

        //Lectura, se muestra lo recibido del proceso hijo
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1)
            System.out.print((char) c);
        is.close();

        // COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
