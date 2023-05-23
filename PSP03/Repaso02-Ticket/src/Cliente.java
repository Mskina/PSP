
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        InetAddress ip = InetAddress.getLocalHost();
        int puerto = 60000;

        DatagramSocket cliente = new DatagramSocket();

        Scanner scan = new Scanner(System.in);
        System.out.print("Escribe tu nombre: ");
        String nombre = scan.nextLine();
        System.out.println("Tenemos 4 tipos de entradas: ");
        System.out.println("1. Normal: 10 euros");
        System.out.println("2. Niños: 3 euros");
        System.out.println("3. Carnet joven: 5 euros");
        System.out.println("4. Pensionista: 4 euros");
        
        System.out.print("Escribe el número de la opción elegida: ");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Escribe el número de la opción elegida: ");
        }
        int tipo = scan.nextInt();

        Ticket ticket = new Ticket(nombre, tipo);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(ticket);
        out.close();
        byte[] bytes = bs.toByteArray();

        DatagramPacket paquete = new DatagramPacket(bytes, bytes.length, ip, puerto);

        cliente.send(paquete);

    }
}
