package ud02.Ejercicios.Ej13_ProductorConsumidor;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(String name, Cola cola){
        this.cola = cola;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            cola.get();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
