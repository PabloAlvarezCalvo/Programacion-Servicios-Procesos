package UD03.Boletines.Boletin2.Ej02_LongitudUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    /* Crea un programa cliente usando sockets UDP que envíe el texto escrito desde la entrada estándar al servidor.
     * El servidor le devolverá la cadena en mayúsculas.
     * El proceso de entrada de datos finalizará cuando el cliente introduzca un asterisco.
     * Crea un programa servidor que reciba cadenas de caracteres,
     * las muestre en pantalla y se las envíe al emisor en mayúscula.
     * El proceso servidor finalizará cuando reciba un asterisco.
     * Establece un tiempo de espera de 5000ms con el método setSoTimeout para hacer que el método receive()
     * del programa cliente se bloquee.
     * Pasado ese tiempo, controlar si no se reciben datos lanzando la excepción InterruptedIOException,
     * en cuyo caso visualiza un mensaje indicando que el paquete se ha perdido.
     */
    public static void main(String[] args) {
        int serverPort = 6000;

        try(
                DatagramSocket serverSocket = new DatagramSocket(serverPort)
        ){

            String line;
            do{
                System.out.println("Esperando paquetes...");
                byte[] bufferIn = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(bufferIn, bufferIn.length);

                serverSocket.receive(incomingPacket);

                line = new String(incomingPacket.getData()).trim();

                if (!line.equals("*")){
                    System.out.println("Recibido: " + line);

                    byte[] bufferOut = Integer.toString(line.length()).getBytes();

                    InetAddress clientAddress = incomingPacket.getAddress();
                    int clientPort = incomingPacket.getPort();
                    DatagramPacket outgoingPacket = new DatagramPacket(bufferOut, bufferOut.length, clientAddress, clientPort);

                    serverSocket.send(outgoingPacket);

                }

            } while (!line.equals("*"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
