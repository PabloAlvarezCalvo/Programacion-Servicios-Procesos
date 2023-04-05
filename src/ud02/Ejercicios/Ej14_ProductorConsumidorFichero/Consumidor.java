package ud02.Ejercicios.Ej14_ProductorConsumidorFichero;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(String name, Cola cola){
        super(name);
        this.cola = cola;
    }

    public void run() {
        int c;
        while ((c = cola.get()) != -1){
            System.out.print((char)c);
        }
    }
}
