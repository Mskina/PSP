
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Implementar un programa que actúe como servidor multicast. Dicho servidor
 * recogerá de teclado cadenas de texto que introducirá el usuario y las irá
 * enviando a todos los clientes conectados al grupo multicast.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando servidor --");

        int puerto = 60000; // Necesito el puerto para el datagrama

        // Creo el socket multicast. No lleva puerto
        MulticastSocket ms = new MulticastSocket();

        // Creo el grupo
        InetAddress grupo = InetAddress.getByName("225.0.0.1"); // Grupo

        String msgRecibido = "";
        byte[] buf = new byte[1024];
        
        String mensajeEnviado = "test";

        while (!msgRecibido.trim().equals("CERRAR")) {

            // Recibo un paquete
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete);
            msgRecibido = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println("En el servidor se ha conectado " + msgRecibido);
            
            
            // Y lo envío a todos
            DatagramPacket paqueteEnviado = new DatagramPacket(mensajeEnviado.getBytes(), mensajeEnviado.length(), grupo, puerto);
            ms.send(paqueteEnviado);
            System.out.println("Enviado el sigueinte mensaje al grupo: " + mensajeEnviado);
        }
        ms.close(); // Cierro socket
        System.out.println("Socket cerrado.");

    }
}
