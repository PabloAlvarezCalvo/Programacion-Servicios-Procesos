package ud01.Ejercicios.ComunicacionBidireccional;

public class HijoBidireccional {
    public static void main(String[] args) {
        if (args != null){
            System.out.print("    Recibido mensaje del padre: ");
            System.out.println(args[0]);
            System.out.println("Padre! Le dice el hijo, al padre.");
        }

    }
}
