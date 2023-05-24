
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        DatagramSocket servidor = new DatagramSocket(60000);

        byte[] buf = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(buf, buf.length);

        servidor.receive(paqueteRecibido);

        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Objeto objeto = (Objeto) ois.readObject();

        System.out.println(objeto.user);
        System.out.println(objeto.pass);

        String cadena = "Acceso concedido";
        DatagramPacket paqueteEnviado = new DatagramPacket(cadena.getBytes(), cadena.length(), paqueteRecibido.getAddress(), paqueteRecibido.getPort());
        servidor.send(paqueteEnviado);
    }
}
