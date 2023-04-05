package ud01.Ejemplos.A1_8_Redireccion;

public class HijoRedireccion {
    public static void main(String[] args) {
        //Valor de salida 1, argumentos < 1
        if (args.length < 1){
            System.out.println("No se han enviado argumentos");
            System.exit(1);
        } else {
            for (int i = 0; i < 5; i++){
                System.out.println(args[0]);
            }
        }
    }
}
