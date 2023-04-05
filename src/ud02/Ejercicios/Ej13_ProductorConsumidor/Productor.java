package ud02.Ejercicios.Ej13_ProductorConsumidor;

public class Productor extends Thread {
    private Cola cola;

    public Productor(String name, Cola cola){
        this.cola = cola;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            cola.put((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
