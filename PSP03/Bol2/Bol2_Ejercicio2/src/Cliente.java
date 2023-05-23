
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Crea un programa cliente usando sockets UDP que envíe el texto escrito desde
 * la entrada estándar al servidor. El servidor le devolverá la cadena en
 * mayúsculas. El proceso de entrada de datos finalizará cuando el cliente
 * introduzca un asterisco
 */
public class Cliente {

    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando cliente UDP --");

        // Creo el socket
        DatagramSocket socket = new DatagramSocket();
        int puerto = 9876;
        InetAddress ip = InetAddress.getLocalHost();

        // Creo el escaner de entrada
        Scanner scan = new Scanner(System.in);
        System.out.print("Escribe algo: ");
        String texto = scan.nextLine();

        while (!texto.equals("*")) {
            System.out.println(">> Enviando: " + texto);
            DatagramPacket paqueteSaliente = new DatagramPacket(texto.getBytes(), texto.length(), ip, puerto);
            socket.send(paqueteSaliente);
            System.out.println(">> Texto enviado");

            byte[] recibidos = new byte[1024];
            DatagramPacket paqueteEntrante = new DatagramPacket(recibidos, recibidos.length);
            System.out.println("<< Recibiendo paquete.");
            socket.receive(paqueteEntrante);
            String textoEntrante = new String(paqueteEntrante.getData());
            System.out.println("<< Recibido " + textoEntrante);

            System.out.print("Escribe algo: ");
            texto = scan.nextLine();
        }
        DatagramPacket paqueteSaliente = new DatagramPacket(texto.getBytes(), texto.length(), ip, puerto);
        socket.send(paqueteSaliente);

        System.out.println("Finalizando cliente...");
        socket.close();
        System.out.println("Cliente finalizado");

    }
}
