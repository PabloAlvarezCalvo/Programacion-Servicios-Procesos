package ud02.Ejercicios.Ej00_Actividad2_1;

class HiloTicTac extends Thread {
    private int timer;
    public HiloTicTac(String nombre, int timer){
        super(nombre);
        this.timer = timer;
    }

    public void run(){

        while(true){
            System.out.println(getName());
            try {
                sleep(timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MainActividadTicTac {
    public static void main(String[] args) {
        Thread tic = new HiloTicTac("Tic", 1000);
        Thread tac = new HiloTicTac("Tac", 1000);

        tic.start();
        tac.start();
    }
}
