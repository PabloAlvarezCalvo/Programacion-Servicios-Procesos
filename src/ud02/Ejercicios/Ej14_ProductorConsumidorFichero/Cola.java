package ud02.Ejercicios.Ej14_ProductorConsumidorFichero;

public class Cola {
    private int caracter;
    private boolean disponible = false;

    public Cola(){

    }

    public synchronized void put(int caracter){
        if (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.caracter = caracter;
        disponible = true;
        notify();
    }

    public synchronized int get(){
        if (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int c = this.caracter;
        disponible = false;
        notify();

        return c;
    }
}
