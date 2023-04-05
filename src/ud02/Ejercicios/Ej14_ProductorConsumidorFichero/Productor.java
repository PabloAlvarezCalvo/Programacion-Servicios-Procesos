package ud02.Ejercicios.Ej14_ProductorConsumidorFichero;

import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {
    private Cola cola;
    private final File file;

    public Productor (String name, Cola cola, File file) {
        super(name);
        this.cola = cola;
        this.file = file;
    }

    public void run(){
        int c;

        try (FileReader fr = new FileReader(file);){
            while (((c = fr.read()) != -1)) {
                cola.put(c);
            }
        } catch (EOFException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
