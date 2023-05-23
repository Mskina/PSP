
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * El programa cliente, al iniciarse, solicitará al usuario su nombre y lo
 * enviará al grupo, indicando que se ha coenctado. Cada cliente, además,
 * recibirá todos los mensajes asignados al grupo.
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando cliente --");
        
        // Pido el nombre del cliente para enviar al grupo
        Scanner scan = new Scanner(System.in);
        System.out.print("Escribe tu nombre: ");
        String nombre = scan.nextLine();
        
        // Creamos el socket multicast. En cliente SÍ lleva puerto
        int puerto = 60000;       
        MulticastSocket ms = new MulticastSocket(puerto);

        // InetAddres del grupo. SocketAddress para el grupo
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        SocketAddress sock = new InetSocketAddress(grupo, puerto);

        // Nos unimos al grupo pasándole SocketAddress
        // NetworkInterface obtenida a partir de InetAddress del grupo multicast
        ms.joinGroup(sock, NetworkInterface.getByInetAddress(grupo));
        
        // Paquete para enviar
        DatagramPacket datosCliente = new DatagramPacket(nombre.getBytes(), nombre.length(), grupo, puerto);
        ms.send(datosCliente);
        
        // Preparamos para recibir
        String msg = "";
        byte[] buf = new byte[1024];

        while (!msg.trim().equals("CERRAR")) {
            
            // Creamos paquete y recibimos desde multicast
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete);
            
            // Pasamos el paquete a string y la mostramos por pantalla
            msg = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println("Recibo: " + msg);
        }
        ms.leaveGroup(sock, NetworkInterface.getByInetAddress(grupo)); // abandonamos grupo
        ms.close();
        System.out.println("Socket cerrado.");

    }
}
