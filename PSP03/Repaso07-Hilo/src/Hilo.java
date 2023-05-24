
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Hilo extends Thread {

    private Socket socket;

    public Hilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectOutputStream flujoSalida;
        ObjectInputStream flujoEntrada;

    }

}
