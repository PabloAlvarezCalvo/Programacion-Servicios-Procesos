package ud02.Examen.Ej01_Restaurante;

public class Sede extends Thread{
    private Fondo fondo;
    private double facturado;

    public Sede(String name, Fondo fondo){
        super(name);
        this.fondo = fondo;
    }

    public void run(){
        for (int i = 0; i < 30; i++){
            double cobro = Math.random() * 100 + 1;
            this.fondo.sumarRecaudacion(cobro);
            this.facturado += cobro;
            System.out.printf("[%d] " + getName() + " ha cobrado %.2f€\n", i, cobro);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf(getName() + " ha registrado una recaudación de %.2f€.\n", facturado);
    }
}
