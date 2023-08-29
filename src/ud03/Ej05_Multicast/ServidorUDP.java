package ud03.Ej05_Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class ServidorUDP {
    /*
     * Implementar un program que actúe como servidor multicast empleado sockets UDP.
     * Dicho servidor recogerá de teclado cadenas de texto qeu introducira el usuario por teclado y
     * las irá enviando a todos los clientes conectados al grupo multicast.
     *
     * El programa cliente solicitará al usuario su nombre y lo enviará al grupo, que indicará al resto de
     * usuarios quién se ha conectado. Cada cliente además recibirá todos los mensajes asignados al grupo.
     */
    public static void main(String[] args) {
        String groupIP = "225.0.0.1";
        int groupPort = 12345;

        System.out.println("Iniciando grupo multicast...");
        try (
                MulticastSocket serverMulticastSocket = new MulticastSocket() // No hace falta especificar puerto local en Multicast
        ){
            InetAddress multicastAddress = InetAddress.getByName(groupIP);

            byte[] outgoingBuffer = new String("Bienvenidos").getBytes();
            DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, multicastAddress, groupPort);

            serverMulticastSocket.send(outgoingPacket);

            String message;
            do {
                System.out.println("Introduce el mensaje a enviar al grupo. * para salir:");
                message = new Scanner(System.in).nextLine();

                outgoingPacket = new DatagramPacket(message.getBytes(), message.getBytes().length, multicastAddress, groupPort);
                serverMulticastSocket.send(outgoingPacket);
            } while (!message.equals("*"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
