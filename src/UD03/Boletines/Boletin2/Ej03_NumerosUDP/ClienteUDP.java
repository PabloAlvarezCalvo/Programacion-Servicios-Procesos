package UD03.Boletines.Boletin2.Ej03_NumerosUDP;

import Boletines.Boletin2.Ej03_NumerosUDP.model.Numero;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int clientPort = 1234;
        int serverPort = 6000;

        try (
                DatagramSocket clientSocket = new DatagramSocket(clientPort)
        ) {

            Numero number;
            do {
                System.out.println("Introduzca un entero positivo para obtener sus potencias. 0 para salir:");
                number = new Numero(Integer.parseInt(sc.nextLine()));

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(number);
                oos.flush();

                byte[] outgoingBuffer = bos.toByteArray();

                DatagramPacket outgointPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, InetAddress.getByName(host), serverPort);
                clientSocket.send(outgointPacket);

                if (number.getNumero() > 0) {
                    byte[] incomingBuffer = new byte[1024];
                    DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                    clientSocket.receive(incomingPacket);

                    ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
                    ObjectInputStream ois = new ObjectInputStream(bis);

                    number = (Numero) ois.readObject();

                    System.out.printf("Cuadrado: %d, Cubo: %d.\n", number.getCuadrado(), number.getCubo());

                    ois.close();
                    bis.close();
                }

                oos.close();
                bos.close();

            } while (number.getNumero() > 0);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
