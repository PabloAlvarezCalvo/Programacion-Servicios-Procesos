package ud02.Ejercicios.HolaMundo;

class RunnableHolaMundo implements Runnable {
    private String cadena;

    public RunnableHolaMundo(String cadena){
        this.cadena = cadena;
    }

    public void run(){
        System.out.println("Hola mundo! " + cadena + ", id: " + Thread.currentThread().getId());
        try {
            Thread.sleep(Thread.currentThread().getId() * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class HolaMundo {
    private Thread hilo;
    public static void main(String[] args) {
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new RunnableHolaMundo("Hilo " + i));
            hilos[i].start();
        }
    }


}
