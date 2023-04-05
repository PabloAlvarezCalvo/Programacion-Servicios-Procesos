package ud02.Ejercicios.Ej15_Relevos;

public class Testigo {
    private int corredor;
    protected int participantes;

    public Testigo(int participantes){
        this.participantes = participantes;
    }

    public void setCorredor(int corredor){
        this.corredor = corredor;
    }

    public synchronized void iniciarCarrera(){
        System.out.println("Se va a iniciar la carrera.");
        setCorredor(1);
        notifyAll();
    }

    public synchronized void tomarTestigo(int corredor){
        while (corredor != this.corredor){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void pasarTestigo(int corredor){
        if (corredor < participantes) {
            System.out.println("Corredor " + corredor + " pasa el testigo a " + ++this.corredor + ".");
        }
        notifyAll();
    }
}
