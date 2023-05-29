package UD03.Boletines.Boletin2.Ej06_ServidorTCPThread;

import Boletines.Boletin2.Ej06_ServidorTCPThread.thread.ThreadServidor;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorTCP {
    /*
     * Realiza un programa servidor que escuche en el puerto 12345.
     * Cada vez que se conecte un cliente se creará un nuevo hilo para atenderlo.
     * Se mostrará en la consola del servidor la dirección IP y el puerto remoto del cliente que se conecta.
     * Se deberá notificar también cuando un cliente se desconecte.
     * En el hilo que atiende al cliente, se reciben cadenas de caracteres que, mientras sean distintas
     * de “*”, se devolverán al cliente transformadas a mayúsculas.
     */
    public static void main(String[] args) {
        int serverPort = 12345;

        try (
                ServerSocket serverSocket = new ServerSocket(serverPort);
        ){
            while(true) {
                System.out.println("Esperando conexión de cliente...");
                Thread threadServidor = new ThreadServidor(serverSocket.accept());
                threadServidor.start();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
