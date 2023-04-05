package ud02.Ejercicios.Ej08_Saldo;

public class Saldo {
    private int saldo;

    public Saldo(int saldo){
        this.saldo = saldo;
    }

   public int getSaldo() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.saldo;
   }

    public void setSaldo(int saldo){
        try {
           Thread.sleep(100);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

        this.saldo = saldo;
    }

    public void ingreso(String name, int importe){
        System.out.println(name + " ingresa " + importe + "€.");
        setSaldo(getSaldo() + importe);
        System.out.println("Cantidad en cuenta: " + getSaldo() + "€.");
    }

}
