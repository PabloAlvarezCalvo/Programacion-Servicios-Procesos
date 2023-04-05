package ud02.Ejercicios.Ej06_ContadorSincro;

public class Contador {
    private int contador =0;

    public Contador(int contador){
        this.contador = contador;
    }

    public synchronized void incrementar(){
        contador++;
    }

    public synchronized void decrementar(){
        contador--;
    }

    public synchronized int getContador() {
        return contador;
    }
}
