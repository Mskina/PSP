package ejemploobjetotcp1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        
        // Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        
        // Se prepara un objeto y se envía
        Persona p1 = new Persona("Juan", 20);
        outObjeto.writeObject(p1); // Enviando objeto
        System.out.println("Envio: " + p1.getNombre() + "*" + p1.getEdad());
        
        // Se obtiene un stream para leer objetos
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        Persona dato = (Persona) inObjeto.readObject();
        System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
        
        // Se cierran streams y sockets
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        servidor.close();
    }
}
