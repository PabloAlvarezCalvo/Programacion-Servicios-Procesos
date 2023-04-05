package ud01.Ejercicios.Ej4_EvaluarArgumento;

public class HijoEvaluar {
    public static void main(String[] args) {
        //Valor de salida 1, argumentos < 1
        if (args.length < 1){
            System.exit(1);
        } else {
            try {
                //Valor de salida 0
                //Valor de salida 3, el argumento es un entero menor que 0
                if (Integer.parseInt(args[0]) < 0) {
                    System.exit(3);
                }
                System.exit(0);
            } catch (Exception e) {
                //Valor de salida 2, el argumento es una cadena
                System.exit(2);
            }
        }
    }
}
