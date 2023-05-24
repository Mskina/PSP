package repaso05.objetotcp;

import java.io.ObjectInputStream;
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
        ServerSocket socket = new ServerSocket(60000);
        Socket servidor = socket.accept();
        
        //ObjectOutputStream salida = new ObjectOutputStream(servidor.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(servidor.getInputStream());
        
        Objeto o = (Objeto) entrada.readObject();
        System.out.println(o.nombre);
       
    }
}
