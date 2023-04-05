package ud02.Ejercicios.Ej07_Cuenta;

public class Cuenta {
    private double saldo = 0.0d;

    public Cuenta(){
    }

    public Cuenta(double saldo){
        this.saldo = saldo;
    }

    public synchronized double obtenerSaldo() {
       return this.saldo;
    }

    public synchronized void retirarSaldo(double importe) throws Exception {
        if(comprobarMovimiento(importe)) {
            this.saldo -= importe;
        } else {
            throw new Exception("Cantidad a retirar superior a saldo disponible en cuenta.");
        }

        Thread.sleep(100);
    }

    public Boolean comprobarMovimiento(double importe){
        return (saldo > importe);
    }
}
