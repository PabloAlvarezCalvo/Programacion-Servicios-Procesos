package ud02.Ejercicios.Ej11_ContarApp;

public class ContarThread extends Thread {
    private int maxContar;

    public ContarThread(String name, int maxContar){
        super(name);
        this.maxContar = maxContar;
    }

    public void run(){
        for (int i = 1; i <= this.maxContar; i++){
            System.out.println("[" + getName() + "]" + " Repetición: " + i);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
