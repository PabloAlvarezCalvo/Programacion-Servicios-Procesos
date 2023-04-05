package ud02.Ejercicios.Ej10_Factorial2;

public class ThreadFactorial extends Thread {
    private int numero = 1;

    public ThreadFactorial(String name, int numero){
        super(name);
        this.numero = numero;
    }

    public void run() {
        System.out.printf("Empieza el proceso. Cálculo del factorial de: %d.\n", numero);
        long factorial = 1;
        for (int i = numero; i > 1; i--) {
            factorial *= i;
        }

        System.out.printf("Acabó el proceso. El factorial de: %d es %d.\n", numero, factorial);
    }
}
