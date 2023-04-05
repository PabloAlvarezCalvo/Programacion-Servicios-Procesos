package ud01.Examen.Ejercicio2;

import java.io.*;
import java.util.ArrayList;

public class PadreEvaluarArgumentos {
    public static void main(String[] args) {

        ArrayList<String> argumentos = new ArrayList<>();
        argumentos.add("java");
        argumentos.add("Ejercicio2.EvaluarArgumentos");

        //Resultado 0
        //??
        //Resultado 1
        argumentos.add("Asd");
        argumentos.add("1");
        argumentos.add("2");
        argumentos.add("3");
        //Resultado 2
        //argumentos.add("-5");
        //argumentos.add("1");
        //argumentos.add("2");
        //argumentos.add("3");
        //Resultado 3
        //rgumentos.add("0");
        //rgumentos.add("1");
        //rgumentos.add("2");
        //rgumentos.add("99");


        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        ProcessBuilder pb = new ProcessBuilder();
        pb.command(argumentos);
        pb.directory(directorio);

        try {
            Process p = pb.start();

            InputStream is = p.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));

            try {
                int exitVal = p.waitFor();
                System.out.println("Ejecucion finalizada con valor: " + exitVal);

                switch (exitVal){
                    case -1 -> System.out.println("-1: No se han enviado argumentos");
                    case 0 -> System.out.println("0: Caso no especificado");
                    case 1 -> System.out.println("1: Alguno de los argumentos es una cadena");
                    case 2 -> System.out.println("2: La mitad de los argumentos es superior a la media");
                    case 3 -> System.out.println("3: Menos de la mitad de los argumentos es superior a la media");
                }

            } catch (InterruptedException e) {
                e.getStackTrace();
            }

            try {
                String liner;
                while ((liner = bis.readLine()) != null) {
                    System.out.println(liner);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
            is.close();

        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
