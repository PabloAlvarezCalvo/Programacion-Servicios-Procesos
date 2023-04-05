package ud02.Ejercicios.Ej09_Factorial;

class RunnableFactorial implements Runnable {
    private final int numero;
    public RunnableFactorial(int numero){
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
