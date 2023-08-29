package ud03.Ejercicios.Ej_MostrarPuertos;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /*
     * Realiza un programa servidor TCP que acepte 3 clientes
     * Para cada cliente, mostrar los puertos local y remotos.
     *
     * Se deberá implementar el programa cliente que se conecea dicho servidor.
     * Mostrar los puertos locales y remotos a los que está conectado su socket,
     * y la dirección IP de la máquina remota a la que se conecta.
     */

    public static void main(String[] args) {
        int puerto = 6000;// Puerto
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("[Servidor] Escuchando en " + servidor.getLocalPort());
            Socket cliente1 = servidor.accept(); //esperando a un cliente
            //realizar acciones con cliente1
            System.out.println("-----Cliente 1-----");
            InetAddress inetAddress = cliente1.getInetAddress();
            System.out.println("[Servidor] Puerto local: " + servidor.getLocalPort());
            System.out.println("[Servidor] Puerto Remoto: " + cliente1.getPort());
            System.out.println("[Servidor] Host Remoto: " + inetAddress.getHostName());
            System.out.println("[Servidor] IP Host Remoto: " + inetAddress.getHostAddress());


            Socket cliente2 = servidor.accept(); //esperando a otro cliente
            //realizar acciones con cliente2
            System.out.println("-----Cliente 2-----");
            inetAddress = cliente2.getInetAddress();
            System.out.println("[Servidor] Puerto local: " + servidor.getLocalPort());
            System.out.println("[Servidor] Puerto Remoto: " + cliente2.getPort());
            System.out.println("[Servidor] Host Remoto: " + inetAddress.getHostName());
            System.out.println("[Servidor] IP Host Remoto: " + inetAddress.getHostAddress());

            Socket cliente3 = servidor.accept(); //esperando a otro cliente
            //realizar acciones con cliente3
            System.out.println("-----Cliente 3-----");
            inetAddress = cliente3.getInetAddress();
            System.out.println("[Servidor] Puerto local: " + servidor.getLocalPort());
            System.out.println("[Servidor] Puerto Remoto: " + cliente3.getPort());
            System.out.println("[Servidor] Host Remoto: " + inetAddress.getHostName());
            System.out.println("[Servidor] IP Host Remoto: " + inetAddress.getHostAddress());

            servidor.close(); //cierro socket servidor

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
