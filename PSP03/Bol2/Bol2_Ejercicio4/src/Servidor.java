
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Usando sockets UDP, realiza un programa servidor que espere un datagrama de
 * un cliente. El cliente le envía un objeto Persona que previamente había
 * inicializado. El servidor modifica los datos del objeto Persona y se lo envia
 * de vuelta al cliente. Visualiza los datos del objeto Persona tanto en el
 * programa cliente cuando los envía y los recibe como en el programa servidor
 * cuando los recibe y los envía modificados.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando servidor --");

        DatagramSocket socket = new DatagramSocket(6000);

        byte[] recibidos = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
        socket.receive(paqueteRecibido);
        int puerto = paqueteRecibido.getPort();
        InetAddress ip = paqueteRecibido.getAddress();

        // Convertimos bytes a objeto
        
        ByteArrayInputStream flujoEntrada = new ByteArrayInputStream(recibidos);
        ObjectInputStream ois = new ObjectInputStream(flujoEntrada);
        Persona persona = (Persona) ois.readObject();

        System.out.println("Recibido objeto persona.");
        System.out.println(persona);

        persona.setNombre("Nombre cambiado");
        persona.setEdad(17);

        System.out.println("Persona modificada. Ahora es: " + persona);

        ByteArrayOutputStream flujoSalida = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(flujoSalida);
        oos.writeObject(persona);
        oos.close();

        byte[] enviados = flujoSalida.toByteArray();

        DatagramPacket paqueteEnviado = new DatagramPacket(enviados, enviados.length, ip, puerto);
        socket.send(paqueteEnviado);
        System.out.println("Persona enviada.");

        socket.close();
    }
}
