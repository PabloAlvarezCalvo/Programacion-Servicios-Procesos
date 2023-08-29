package ud03.Ej03_CuadradoNumeroTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP {
    /*
     */

    public static void main(String[] args) {
        int puerto = 6000;// Puerto
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("[Servidor] Escuchando en " + servidor.getLocalPort());
            Socket cliente = servidor.accept(); //esperando a un cliente

            //realizar acciones con cliente
            System.out.println("Introduzca un número por teclado para recibir su cuadrado:");
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            Scanner sc = new Scanner(System.in);
            dos.writeUTF(Integer.toString(sc.nextInt()));

            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            System.out.println("ECHO => " + dis.readUTF());

            //cerrar recursos
            sc.close();
            dis.close();
            dos.close();
            servidor.close(); //cierro socket servidor

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
