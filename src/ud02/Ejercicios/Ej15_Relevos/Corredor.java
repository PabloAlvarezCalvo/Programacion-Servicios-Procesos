package ud02.Ejercicios.Ej15_Relevos;

public class Corredor extends Thread {
    private Testigo testigo;
    private int posicion;

    public Corredor(int posicion, Testigo testigo){
        super("Corredor " + posicion);
        this.posicion = posicion;
        this.testigo = testigo;
    }

    public void run() {
        testigo.tomarTestigo(posicion);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Corredor " + posicion + " terminó de correr.");
        testigo.pasarTestigo(posicion);
    }

    public int getPosicion(){
        return this.posicion;
    }
}
