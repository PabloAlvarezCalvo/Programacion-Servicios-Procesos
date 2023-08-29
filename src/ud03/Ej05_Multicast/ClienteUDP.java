package ud03.Ej05_Multicast;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String groupIP = "225.0.0.1";
        int groupPort = 12345;

        try (
                MulticastSocket clientMulticastSocket = new MulticastSocket(groupPort)
        ){

            InetAddress groupAddress = InetAddress.getByName(groupIP);
            SocketAddress groupSocketAddress = new InetSocketAddress(groupAddress, groupPort);
            clientMulticastSocket.joinGroup(groupSocketAddress, NetworkInterface.getByInetAddress(groupAddress)); //Unirse al grupo

            System.out.println("Bienvenido. Cuál es tu nombre?");
            String name = "Se ha conectado: " + sc.nextLine();

            DatagramPacket outgoingPacket = new DatagramPacket(name.getBytes(), name.getBytes().length, groupAddress, groupPort);

            clientMulticastSocket.send(outgoingPacket);

            String message;
            do {
                byte[] incomingBuffer = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                clientMulticastSocket.receive(incomingPacket);

                message = new String(incomingPacket.getData()).trim();

                System.out.println("Recibido: " + message);

            } while (!message.equals("*"));

            clientMulticastSocket.leaveGroup(groupAddress);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
