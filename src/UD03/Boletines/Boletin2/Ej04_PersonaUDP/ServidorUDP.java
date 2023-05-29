package UD03.Boletines.Boletin2.Ej04_PersonaUDP;

import Boletines.Boletin2.Ej04_PersonaUDP.models.Persona;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

public class ServidorUDP {
    /* Usando sockets UDP, realiza un programa servidor que espere un datagrama de un cliente.
     * El cliente le envía un objeto Persona que previamente había inicializado.
     * El servidor modifica los datos del objeto Persona y se lo envía de vuelta al cliente.
     * Visualiza los datos del objeto Persona tanto en el programa cliente cuando los envía
     * y los recibe como en el programa servidor cuando los recibe y los envía modificados.
     */

    public static void main(String[] args) {
        int port = 6000;

        try (
                DatagramSocket serverSocket = new DatagramSocket(port)
        ){
            try {
                while (true) {
                    byte[] incomingBuffer = new byte[1024];

                    serverSocket.setSoTimeout(25000);
                    DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                    serverSocket.receive(incomingPacket);

                    ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
                    ObjectInputStream ois = new ObjectInputStream(bis);

                    Persona person = (Persona) ois.readObject();

                    System.out.println("Recibido: " + person);
                    person = new Persona("John", "Doe");
                    System.out.println("Enviando: " + person);

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);

                    oos.writeObject(person);

                    byte[] outgoingBuffer = bos.toByteArray();

                    DatagramPacket outgointPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, incomingPacket.getAddress(), incomingPacket.getPort());
                    serverSocket.send(outgointPacket);

                    ois.close();
                    bis.close();

                    oos.close();
                    bos.close();

                }
            } catch (SocketTimeoutException e) {
                System.err.println("Superado el tiempo de espera.");
            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
