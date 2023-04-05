package ud02.Ejercicios.Ej12_Clase;

public class MainClase {
    public static void main(String[] args) {
        /**
         * Se trata de simular el comienzo de una clase.
         *
         * Los alumnos llegarán y esperarán hasta que llegue el profesor y salude para que comience la clase.
         *
         * Los alumnos y el profesor compartirán un objeto de la clase Bienvenida, con dos métodos sincronizados:
         *
         * * Uno donde los alumnos llegan y saludan al profesor (se quedan esperando mientras el profesor no llegue)
         *
         * * Otro donde el profesor llega e indica que la clase puede comenzar, notificándoselo a los alumnos.
         *
         */
        Bienvenida bienvenida = new Bienvenida();
        Thread[] hiloAlumnos = new Thread[5];
        for (int i = 0; i < hiloAlumnos.length; i++){
            hiloAlumnos[i] = new Alumno("Alumno " + (i+1), bienvenida);
        }
        Thread profesor = new Profesor("Carlos", bienvenida);

        for (Thread t : hiloAlumnos){
            t.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        profesor.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread alumnoTardio = new Alumno("Alumno tardío", bienvenida);
        alumnoTardio.start();
    }
}
