package UD03.Examen.Ej02;

import Ej02.model.Cargo;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteUDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int clientPort = 1234;
        int serverPort  = 6000;

        try (
                DatagramSocket clientSocket = new DatagramSocket(clientPort);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
        ){
            System.out.println("Introduzca el nombre completo del empleado");
            String name = sc.nextLine().trim();
            String stringcargo = menu();

            Cargo cargo = new Cargo(name, stringcargo);

            System.out.println("Enviando datos a servidor:");
            System.out.println(cargo + "\n");
            oos.writeObject(cargo);
            byte[] outgoingBuffer = bos.toByteArray();
            oos.flush();

            DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, InetAddress.getByName(host), serverPort);
            clientSocket.send(outgoingPacket);

            // Recibir object
            byte[] incomingBuffer = new byte[1024];
            DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
            clientSocket.receive(incomingPacket);

            ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);
            cargo = (Cargo) ois.readObject();

            System.out.println("Datos recibidos:");
            System.out.println(cargo + "\n");

            // Cerrar recursos
            ois.close();
            bis.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin ejecución cliente.");
    }

    private static String menu(){
        System.out.println("""
                Seleccione un cargo:
                Operario
                Comercial
                Técnico
                Especialista
                """);
        return sc.nextLine().trim();
    }
}
