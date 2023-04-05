package ud02.Ejercicios.Ej08_Saldo;

public class ThreadIngreso extends Thread {
    private Saldo saldo;

    public ThreadIngreso(String name, Saldo saldo){
        super(name);
        this.saldo = saldo;
    }

    public void run(){
        for (int i = 0; i < 4; i++) {
            saldo.ingreso(getName(), 30);
        }
    }
}
