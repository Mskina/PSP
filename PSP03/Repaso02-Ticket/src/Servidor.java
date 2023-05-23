
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        int puerto = 60000; // Por dónde está escuchando
        DatagramSocket servidor = new DatagramSocket(puerto);

        byte[] buf = new byte[1024];
        DatagramPacket paquete = new DatagramPacket(buf, buf.length);
        servidor.receive(paquete);

        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Ticket ticket = (Ticket) ois.readObject();
        ois.close();

        // Si quisiese responder
//        paquete.getAddress();
//        paquete.getPort();
        
        switch (ticket.getTipo()) {
            case 1 -> ticket.setPrecio(10);
            case 2 -> ticket.setPrecio(3);
            case 3 -> ticket.setPrecio(5);
            case 4 -> ticket.setPrecio(4);
            default -> ticket.setPrecio(Integer.MIN_VALUE);
        }
        
        System.out.println(ticket);

    }
}
