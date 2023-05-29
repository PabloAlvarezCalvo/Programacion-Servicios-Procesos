package UD03.Boletines.Boletin2.Ej02_LongitudUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int serverPort = 6000;
        int clientPort = 1234;

        try (
                DatagramSocket clientSocket = new DatagramSocket(clientPort)
        ){
            String line;
            do {
                System.out.println("Introduzca una cadena de texto. * para salir:");
                line = sc.nextLine();

                byte[] bufferOut = line.getBytes();
                DatagramPacket outgoingPacket = new DatagramPacket(bufferOut, bufferOut.length, InetAddress.getByName(host), serverPort);
                clientSocket.send(outgoingPacket);

                if (!line.equals("*")) {
                    byte[] bufferIn = new byte[1024];
                    DatagramPacket incomingPacket = new DatagramPacket(bufferIn, bufferIn.length);
                    System.out.println("BufferIn.length: " + bufferIn.length);
                    clientSocket.receive(incomingPacket);

                    String length = new String(incomingPacket.getData()).trim();
                    System.out.println("La longitud de la cadena enviada es: " + length);
                }


            } while (!line.equals("*"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
