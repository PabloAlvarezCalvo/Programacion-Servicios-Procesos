package ud02.Ejercicios.Ej07_Cuenta;

public class RetiradaDeCajero extends Thread {
    private final Cuenta cuenta;

    public RetiradaDeCajero(String name, Cuenta cuenta) {
        super(name);
        this.cuenta = cuenta;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            double retirada = Math.floor(Math.random() * 200);
            System.out.println(Thread.currentThread().getName() + " intentando retirar " + retirada + ". Disponible en cuenta: " + cuenta.obtenerSaldo());
            try {
                cuenta.retirarSaldo(retirada);
            } catch (Exception e) {
                System.err.println(Thread.currentThread().getName() + ", retirada " + retirada + ", disponible " + cuenta.obtenerSaldo() + ". " + e.getLocalizedMessage());
                break;
            }
        }
    }
}
