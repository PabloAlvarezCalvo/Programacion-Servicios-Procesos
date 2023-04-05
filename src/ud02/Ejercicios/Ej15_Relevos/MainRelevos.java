package ud02.Ejercicios.Ej15_Relevos;

public class MainRelevos {
    public static void main(String[] args) {
        /**
         *  Escribe una clase llamada Relevos que simule una carrera de relevos de la siguiente forma:
         * * Cree 4 threads, que se quedarán a la espera de recibir alguna señal para comenzar a correr. Una vez creados los threads,
         * se indicará que comience la carrera, con lo que uno de los threads deberá empezar a correr.
         * * Cuando un thread termina de correr, pone algún mensaje en pantalla y espera un par de segundos, pasando el testigo a
         * otro de los hilos para que comience a correr, y terminando su ejecución (la suya propia).
         * * Cuando el último thread termine de correr, el padre mostrará un mensaje indicando que todos los hijos han terminado.
         *
         El relevo se transfiere a través del objeto compartido. Existirá un atributo entero con el número del hilo que se ejecuta.
         Hilo termina ejecución, incrementa turno y notifica el cambio.
         Antes de ejecutarse cada hilo, comprueba si es su turno. Si no lo es, espera.
         * */

        int numeroCorredores = 4;
        Testigo testigo = new Testigo(numeroCorredores);

        Thread[] corredores = new Thread[numeroCorredores];
        for (int i = 0; i < corredores.length; i++){
            corredores[i] = new Corredor(i+1, testigo);
        }

        for(Thread t : corredores){
            t.start();

        }

        testigo.iniciarCarrera();

        try {
            corredores[0].join();
            corredores[1].join();
            corredores[2].join();
            corredores[3].join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin de carrera.");
    }
}
