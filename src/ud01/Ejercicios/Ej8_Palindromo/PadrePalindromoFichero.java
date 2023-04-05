package ud01.Ejercicios.Ej8_Palindromo;

import java.io.*;

public class PadrePalindromoFichero {
    public static void main(String[] args) throws IOException {
        // creamos objeto File al directorio donde esta el programa
        File directorio = new File(".\\out\\production\\ProgramacionServiciosProcesos");
        //El proceso hijo a ejecutar
        ProcessBuilder pb = new ProcessBuilder("java", "ud01.Ejercicios.Ej8_Palindromo.HijoPalindromo");

        pb.directory(directorio);

        File fIn = new File(".\\src\\ud01\\Ejercicios\\Ej8_Palindromo\\entrada.txt");
        File fOut = new File(".\\src\\ud01\\Ejercicios\\Ej8_Palindromo\\salida.txt");

        pb.redirectInput(fIn);
        pb.redirectOutput(fOut);

        Process p = pb.start();

        InputStream is = p.getInputStream();

        OutputStream os = p.getOutputStream();

        try {
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
        is.close();

        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
            switch (exitVal){
                case 0 -> System.out.println("Proceso finalizado correctamente.");
                case 1 -> System.out.println("Proceso finalizado con errores.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            InputStream err = p.getErrorStream();
            BufferedReader berr = new BufferedReader(new InputStreamReader(err));
            String liner;
            while ((liner = berr.readLine()) != null)
                System.out.println("ERROR >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
