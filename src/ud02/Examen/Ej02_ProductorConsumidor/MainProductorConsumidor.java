package ud02.Examen.Ej02_ProductorConsumidor;

public class MainProductorConsumidor {
    public static void main(String[] args) {

        Recipiente recipiente = new Recipiente();
        Thread productor = new Productor("Productor", recipiente);
        Thread consumidor = new Consumidor("Consumidor", recipiente);

        consumidor.start();
        productor.start();

        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finalización de programa principal.");
    }
}
