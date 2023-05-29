package UD03.Boletines.Boletin1.Ej02_VerHTML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class VerHTML {
    /* Implementa un programa que recoja de teclado una URL (con el formato http://www.sitioweb.dom)
     * y abra una conexión a dicho sitio Web, mostrando por pantalla el código HTML de su página inicial.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una url para visualizar su código HTML:");
        URL url;

        try {
            url = new URL(sc.nextLine());
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;

            while ((inputLine = br.readLine()) != null){
                System.out.println(inputLine);
            }

            br.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
