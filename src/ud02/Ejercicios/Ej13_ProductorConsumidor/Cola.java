package ud02.Ejercicios.Ej13_ProductorConsumidor;

public class Cola {
    private Integer numero;

    public Cola(){

    }

    public synchronized void put(int numero){
        if (this.numero != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Depositado el número: " + numero + ".");
        this.numero = numero;
        notify();
    }

    public synchronized void get(){
        if (this.numero == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Retirado el número: " + numero + ".");
        this.numero = null;
        notify();

    }
}
