package ud02.Ejercicios.Ej12_Clase;

public class Bienvenida {
    private boolean claseIniciada = false;

    public Bienvenida(){

    }

    public synchronized void saludar(Object obj){
        if (obj instanceof Alumno) {
            if (!claseIniciada){
                try {
                    System.out.println("Alumno" + ((Alumno) obj).getName() + " esperando por el profesor.");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Alumno " + ((Alumno) obj).getName() + " saluda a la clase.");
        } else if (obj instanceof Profesor){
            System.out.println("El profesor " + ((Profesor) obj).getName() + " saluda a la clase.");
            claseIniciada = true;
            notifyAll();
        }
    }
}
