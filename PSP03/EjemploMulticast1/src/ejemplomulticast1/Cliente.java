package ejemplomulticast1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * El programa cliente visualiza el paquete que recibe del servidor. Su
     * proceso finaliza cuando recibe un asterisco.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        System.out.println("-- Iniciando cliente --");
        

        // Se crea el socket multicast
        int puerto = 12345; // puerto multicast
        MulticastSocket ms = new MulticastSocket(puerto);
        InetAddress grupo = InetAddress.getByName("224.0.0.1"); // Grupo

        // Nos unimos al grupo
        ms.joinGroup(grupo);

        String msg = "";
        byte[] buf = new byte[1024];

        while (!msg.trim().equals("*")) {
            // Recibe el paquete del servidor multicast
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete);
            // msg = new String(paquete.getData());
            // En lugar de hacerlo como en la línea superior, lo hago
            // como se ve a continuación para admitir únicamente los bytes
            // de la longitud correspondiente, para no leer bytes que
            // están por debajo.
            msg = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println("Recibo: " + msg.trim());
        }
        ms.leaveGroup(grupo); // abandonamos grupo
        ms.close();
        System.out.println("Socket cerrado.");
    }
}
