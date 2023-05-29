package UD03.Boletines.Boletin2.Ej05_AlumnoUDP;

import Boletines.Boletin2.Ej05_AlumnoUDP.models.Alumno;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        ){

            String line;

            do {
                System.out.println("Introduzca el id del alumno a consultar. * para salir:");
                line = sc.nextLine();

                byte[] outgoingBuffer = line.getBytes();
                DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, InetAddress.getByName(host), serverPort);
                clientSocket.send(outgoingPacket);

                if (!line.equals("*")) {
                    byte[] incomingBuffer = new byte[1024];
                    DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                    clientSocket.receive(incomingPacket);

                    ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
                    ObjectInputStream ois = new ObjectInputStream(bis);

                    try {
                        Alumno alumn = (Alumno) ois.readObject();
                        System.out.println("Recibido: " + alumn);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    ois.close();
                    bis.close();
                }

            } while (!line.equals("*"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
