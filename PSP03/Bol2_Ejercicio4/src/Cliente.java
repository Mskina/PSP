
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
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
        System.out.println("-- Iniciando cliente --");

        Persona persona = new Persona("Nombre", 71);
        System.out.println("Creada la persona: " + persona);

        System.out.println("Creando socket...");
        DatagramSocket socket = new DatagramSocket();

        System.out.println("Convirtiendo persona a bytes...");
        ByteArrayOutputStream flujoSalida = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(flujoSalida);
        oos.writeObject(persona);
        oos.close();

        byte[] enviados = flujoSalida.toByteArray();

        System.out.println("Creando el paquete...");
        int puerto = 6000;
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket paqueteEnviado = new DatagramPacket(enviados, enviados.length, ip, puerto);
        socket.send(paqueteEnviado);

        System.out.println("Recibiendo paquete...");
        byte[] recibidos = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
        socket.receive(paqueteRecibido);

        System.out.println("Convirtiendo bytes a persona...");
        ByteArrayInputStream flujoEntrada = new ByteArrayInputStream(paqueteRecibido.getData());
        ObjectInputStream ois = new ObjectInputStream(flujoEntrada);
        Persona personaRecibida = (Persona) (ois.readObject());
        ois.close();

        System.out.println("Datos de la persona: " + personaRecibida);
        socket.close();
    }
}
