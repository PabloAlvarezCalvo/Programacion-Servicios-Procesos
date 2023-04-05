package ud02.Examen.Ej02_ProductorConsumidor;

public class Recipiente {
    private String cadenas;
    private boolean disponible = false;

    public Recipiente(){

    }

    public synchronized void put(String entero){
        if (disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.cadenas = entero;
            this.disponible = false;
            notifyAll();
        }
    }

    public synchronized String get(){
        if (!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.disponible = false;
        String retorno = this.cadenas;
        this.cadenas = "";
        notifyAll();
        return retorno;
    }
}
