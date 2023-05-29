package UD03.Examen.Ej02;

import Ej02.model.Cargo;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP {
    public static void main(String[] args) throws SocketException {
        int serverPort = 6000;

        try (
                DatagramSocket serverSocket = new DatagramSocket(serverPort)
        ){
            System.out.println("Esperando conexión...");

            byte[] incomingBuffer = new byte[1024];
            DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
            serverSocket.receive(incomingPacket);

            System.out.println("Conectado con: " + incomingPacket.getAddress() + ", puerto: " + incomingPacket.getPort());

            ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);

            try {
                System.out.println("Recibido:");
                Cargo cargo = (Cargo) ois.readObject();

                System.out.println(cargo + "\n");

                cargo.setSalario(calcularSalario(cargo.getCargo()));

                System.out.println("Enviar: ");
                System.out.println(cargo + "\n");

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(cargo);

                byte[] outgoingBuffer = bos.toByteArray();
                oos.flush();

                DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, incomingPacket.getAddress(), incomingPacket.getPort());
                serverSocket.send(outgoingPacket);

                // Liberar recursos
                oos.close();
                bos.close();

            } catch (ClassNotFoundException e){
                System.err.println("Ha ocurrido un error: " + e.getMessage());
            }

            // Liberar recursos
            ois.close();
            bis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin ejecución servidor");
    }

    private static double calcularSalario(String cargo){
        double salario;

        switch (cargo) {
            case "Operario" -> salario = 1500;
            case "Comercial" -> salario = 1600;
            case "Técnico" -> salario = 1800;
            case "Especialista" -> salario = 2200;
            default -> salario = -1;
        }

        return salario;
    }
}
