package UD03.Boletines.Boletin2.Ej05_AlumnoUDP;

import Boletines.Boletin2.Ej05_AlumnoUDP.models.Alumno;
import Boletines.Boletin2.Ej05_AlumnoUDP.models.Curso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class ServidorUDP {
    /* Utilizando sockets UDP crea un programa servidor que inicialice un array de 5 objetos de tipo Alumno.
     * El servidor, en un bucle infinito, solicitará al cliente un idAlumno y le devolverá el objeto Alumno que corresponda.
     * Crea un programa cliente en el que se introduzca por teclado el idAlumno que se desea consultar.
     * Dicho programa recogerá datos hasta recibir un * por parte del usuario.
     * Si el idAlumno no se encuentra registrado, el servidor le devolverá un objeto Alumno con datos vacíos.
     */
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = generarAlumnos();
        int serverPort = 6000;


        try (
                DatagramSocket serverSocket = new DatagramSocket(serverPort)
        ){

            String line;
            do {
                byte[] incomingBuffer = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                serverSocket.receive(incomingPacket);

                line = new String(incomingPacket.getData()).trim();
                int id = Integer.parseInt(line);

                if (id >= 0) {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);

                    System.out.println("Recibido id: " + id);

                    Alumno alumno = new Alumno();

                    for (Alumno a : alumnos) {
                        if (a.getId() == id) {
                            alumno = a;
                        }
                    }

                    oos.writeObject(alumno);
                    System.out.println("Enviado alumno: " + alumno);

                    byte[] outgoingBuffer = bos.toByteArray();
                    DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, incomingPacket.getAddress(), incomingPacket.getPort());
                    serverSocket.send(outgoingPacket);
                    oos.flush();

                    oos.close();
                    bos.close();
                }
            } while (!line.equals("*"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Alumno> generarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();

        Curso curso1 = new Curso(0, "Curso 1");
        Curso curso2 = new Curso(1, "Curso 2");
        Curso curso3 = new Curso(2, "Curso 3");

        Alumno alumno1 = new Alumno(0);
        alumno1.setNombre("Alumno 1");
        alumno1.setCurso(curso1);
        alumno1.setNota(6);

        Alumno alumno2 = new Alumno(1);
        alumno2.setNombre("Alumno 2");
        alumno2.setCurso(curso1);
        alumno1.setNota(7);

        Alumno alumno3 = new Alumno(2);
        alumno3.setNombre("Alumno 3");
        alumno3.setCurso(curso2);
        alumno1.setNota(3);

        Alumno alumno4 = new Alumno(3);
        alumno4.setNombre("Alumno 4");
        alumno4.setCurso(curso3);
        alumno1.setNota(5);

        Alumno alumno5 = new Alumno(4);
        alumno5.setNombre("Alumno 5");
        alumno5.setCurso(curso2);
        alumno1.setNota(9);

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);

        return alumnos;
    }
}
