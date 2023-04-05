package ud01.Ejercicios.Ej_Mayusculas;

import java.io.*;

public class PadreMayusculas {
    public static void main(String[] args) {
        /*Escribir una clase llamada mayúsculas que cree un proceso hijo
         * el proceso padre y el hijo se comunican bidireccional con streams
         * el padre leerá líneas de su entrada estandar y las envía a la entrada estandra del hijo
         * (usando el outputstream del hijo) el proceso hijo leera el texto
         * por su entrada estandar, lo transforma a mayus y lo imprime a salida estandar
         * el padre imprime en pantalla lo recibido del hijo
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            // creamos objeto File al directorio donde esta el programa
            File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
            //El proceso hijo a ejecutar
            ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej_Mayusculas.HijoMayusculas");

            // se establece el directorio donde se encuentra el ejecutable
            pb.directory(directorio);

            // se ejecuta el proceso
            Process p = pb.start();

            BufferedReader brHijo = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintStream ps = new PrintStream(p.getOutputStream());

            System.out.println("Introduzca una palabra en minuscula. * para salir.");

            String lectura, respuesta;
            while(!(lectura = br.readLine()).equals("*")){
                ps.println(lectura);
                ps.flush();
                if ((respuesta = brHijo.readLine()) != null) {
                    System.out.println(respuesta);
                }
            }
            System.out.println("Fin");
        }

        catch (IOException e){

        }
    }
}
