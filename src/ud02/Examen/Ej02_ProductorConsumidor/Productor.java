package ud02.Examen.Ej02_ProductorConsumidor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Productor extends Thread {
    private Recipiente recipiente;

    public Productor(String name, Recipiente recipiente){
        super(name);
        this.recipiente = recipiente;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        String cadena;
        System.out.println("Introduzca una cadena, o * para finalizar.");
        int contador = 0;
        do {
            cadena = sc.nextLine();
            contador++;
            recipiente.put(cadena);
        } while (contador < 10 && !cadena.equals("*"));

        System.out.println("Fin de hilo productor.");
    }
}
