package ejemploobjetotcp1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int puerto = 6000; // puerto remoto
        System.out.println("-- Programa cliente iniciado --");
        Socket cliente = new Socket(host, puerto);

        // Flujo de entrada para objetos
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

        // Se recibe un objeto
        Persona dato = (Persona) perEnt.readObject();
        System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());

        // Modifico el objeto
        dato.setNombre("Juan Ramos");
        dato.setEdad(22);

        // Flujo de salida para objetos
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
        
        // Se envía el objeto
        perSal.writeObject(dato);
        System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());
        
        // Se cierran streams y sockets
        perEnt.close();
        perSal.close();
        cliente.close();
    }
}