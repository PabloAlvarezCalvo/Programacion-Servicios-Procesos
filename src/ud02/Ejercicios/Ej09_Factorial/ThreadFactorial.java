package ud02.Ejercicios.Ej09_Factorial;

class ThreadFactorial extends Thread {
    private int numero;

    public ThreadFactorial(String name, int numero){
        super(name);
        this.numero = numero;
    }

    public void run(){
        long factorial = 1;
        for (int i = numero; i > 1; i--) {
            factorial *= i;
        }

        System.out.println(numero + "! = " + factorial);
    }
}
