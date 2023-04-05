package ud01.Ejercicios.Ej4_EvaluarArgumento;

import java.io.*;

public class PadreEvaluar {
    public static void main(String[] args) throws IOException {
        // creamos objeto File al directorio donde esta el programa
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");

        //Valor de salida 1, argumentos < 1
        //ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej4_EvaluarArgumento.HijoEvaluar", "-1");

        //Valor de salida 2, el argumento es una cadena
        //ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej4_EvaluarArgumento.HijoEvaluar", "-1");

        //Valor de salida 3, el argumento es un entero menor que 0
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej4_EvaluarArgumento.HijoEvaluar", "-1");

        // Cuando trabajamos con paquetes, el nombre de dicho paquete debe ir
        // en el comando Java (Ejercicio4.Ejercicio4_sub) en lugar de en la ruta del File
        // se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);

        // se ejecuta el proceso
        Process p = pb.start();

        // obtener la salida devuelta por el proceso
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("Error: " + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //Comprobación salida de programa
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
            switch (exitVal){
                case 0:
                    System.out.println("Situación no especificada.");
                    break;
                case 1:
                    System.out.println("Cantidad de argumentos menor que 1.");
                    break;
                case 2:
                    System.out.println("El argumento es una cadena.");
                    break;
                case 3:
                    System.out.println("El argumento es un número negativo.");
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
