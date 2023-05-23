
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";

        while (!cadena.trim().equals("CERRAR")) {
            System.out.print("Datos a enviar al grupo: ");
            cadena = in.readLine();            
            
            // Y lo envío a todos
            DatagramPacket paqueteEnviado = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
            ms.send(paqueteEnviado);
            System.out.println("Enviado el siguiente mensaje al grupo: " + cadena);
        }
        ms.close(); // Cierro socket
        System.out.println("Socket cerrado.");

    }
}
