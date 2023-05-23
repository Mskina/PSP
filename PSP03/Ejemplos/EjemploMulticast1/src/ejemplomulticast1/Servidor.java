package ejemplomulticast1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * Servidor multicast que lee datos por teclado y los envía a todos los
     * clientes que pertenezcan al grupo multicast. El proceso terminará cuando
     * se introduzca un asterisco.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Flujo para entrada estándar
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Se crea el socket multicast (sin puerto)
        MulticastSocket ms = new MulticastSocket();
        int puerto = 12345; // puerto multicast
        InetAddress grupo = InetAddress.getByName("224.0.0.1"); // Grupo
        String cadena = "";

        while (!cadena.trim().equals("*")) {
            System.out.print("Datos a enviar al grupo: ");
            cadena = in.readLine();

            // Enviando al grupo
            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
            ms.send(paquete);
            String msg = new String(paquete.getData());
            System.out.println("Envío: " + msg.trim());
        }
        ms.close(); // Cierro socket
        System.out.println("Socket cerrado.");
    }
}
