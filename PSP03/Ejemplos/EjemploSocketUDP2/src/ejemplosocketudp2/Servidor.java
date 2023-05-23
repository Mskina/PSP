package ejemplosocketudp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Puerto por el que escucha el servidor: 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] recibidos = new byte[1024];
        byte[] enviados = new byte[1024];
        String cadena;

        while (true) {
            System.out.println("Esperando datagrama...");
            
            //Recibo datagrama
            recibidos = new byte[1024];
            DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
            serverSocket.receive(paqRecibido);
            cadena = new String(paqRecibido.getData());
            
            // Dirección de origen
            InetAddress IPOrigen = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            System.out.println("\tOrigen: " + IPOrigen + ":" + puerto);
            System.out.println("\t Mensaje recibido: " + cadena.trim());
            
            // Convertir cadena a mayúscula
            String mayuscula = cadena.trim().toUpperCase();
            enviados = mayuscula.getBytes();
            
            // Envío datagrama al cliente
            DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
            serverSocket.send(paqEnviado);
            
            // Para terminar
            if(cadena.trim().equals("*")) break;
        }
serverSocket.close();
        System.out.println("Socket cerrado.");
    }
}
