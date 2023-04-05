package ud01.Ejercicios.Ej6_RepetirFichero;

import java.io.*;

public class PadreRepetirFichero {
    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        String argumento = "cinco veces";
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej6_RepetirFichero.HijoRepetirFichero", argumento);
        pb.directory(directorio);

        //El directorio del fichero será en la carpeta donde se encuentra este programa, para mejor revisión
        File fileOut = new File(".\\src\\ud01\\Ejercicios\\Ej6_RepetirFichero\\salida.txt");
        pb.redirectOutput(fileOut);

        Process p = pb.start();

        //Primero se capta el stream de errores
        InputStream err = p.getErrorStream();
        BufferedReader berr = new BufferedReader(new InputStreamReader(err));

        String error;
        while ((error = berr.readLine()) != null) {
            System.out.println("Error: " + error);
        }

        //Luego se comprueba el resutado de la ejecución del programa
        int exitVal;
        try {
            exitVal = p.waitFor();
            switch (exitVal) {
                case 0:
                    System.out.println("Ejecución finalizada correctamente.");
                    break;
                case 1:
                    System.out.println("Ejecución finalizada con errores.");
                    break;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        //El stream que se haya podido recibir se procesa
        //Como está redirigido, en vez de por terminal el sout lo sacará a fichero
        InputStream is = p.getInputStream();
        BufferedReader bis = new BufferedReader(new InputStreamReader(is));
        String liner;
        while ((liner = bis.readLine()) != null) {
            System.out.println(liner);
        }
    }
}
