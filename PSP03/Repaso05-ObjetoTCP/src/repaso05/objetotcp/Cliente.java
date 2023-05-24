package repaso05.objetotcp;

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
        // TODO code application logic here
        Socket cliente = new Socket("localhost", 60000);

        ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
        //ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

        Objeto o = new Objeto("Hola");

        salida.writeObject(o);
        salida.flush();
        salida.close();
        cliente.close();

    }
}
