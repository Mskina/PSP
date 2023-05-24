
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        int puerto = 60000;
        InetAddress ip = InetAddress.getLocalHost();

        DatagramSocket cliente = new DatagramSocket();

        Objeto objeto = new Objeto("user", "1234");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(objeto);
        oos.close();

        byte[] bytes = baos.toByteArray();

        DatagramPacket paqueteEnviado = new DatagramPacket(bytes, bytes.length, ip, puerto);
        cliente.send(paqueteEnviado);
        
        byte[] buf = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(buf, buf.length);
        cliente.receive(paqueteRecibido);
        
        String cadenaRecibida = new String(paqueteRecibido.getData());
        System.out.println(cadenaRecibida);
    }
}
