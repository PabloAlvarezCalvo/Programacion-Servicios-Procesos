package UD03.Boletines.Boletin2.Ej04_PersonaUDP;

import Boletines.Boletin2.Ej04_PersonaUDP.models.Persona;

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
        ){
            while(true) {
                System.out.println("Introduzca el nombre de la persona:");
                String personName = sc.nextLine();
                System.out.println("Introduzca los apellidos de la persona:");
                String personSurname = sc.nextLine();
                Persona person = new Persona(personName, personSurname);

                byte[] outgoingBuffer;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(person);
                outgoingBuffer = bos.toByteArray();
                bos.flush();

                InetAddress serverAddress = InetAddress.getByName(host);
                DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, serverAddress, serverPort);
                clientSocket.send(outgoingPacket);

                System.out.println("Enviando: " + person);

                byte[] incomingBuffer = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                clientSocket.receive(incomingPacket);

                ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bis);

                person = (Persona) ois.readObject();
                System.out.println("Recibido: " + person);

                oos.close();
                ois.close();
                bos.close();
                bis.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
