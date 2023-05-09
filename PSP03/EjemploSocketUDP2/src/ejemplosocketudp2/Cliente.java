package ejemplosocketudp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Flujo para entrada estándar
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] enviados  = new byte[1024];
        byte[] recibidos  = new byte[1024];
        
        // Datos del SERVIDOR al que ENVIAR el mensaje
        InetAddress IPServidor = InetAddress.getLocalHost(); // localhost
        int puerto = 9876; // puerto por el que escucha
        
        // Introducir datos por teclado
        System.out.print("Introduce mensaje: ");
        String cadena = in.readLine();
        enviados = cadena.getBytes();
        
        // Enviando datagram al servidor
        System.out.println("Enviando " + enviados.length + " bytes al servidor.");
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clientSocket.send(envio);
        
        // Recibiendo datagrama del servidor
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando datagrama...");
        clientSocket.receive(recibo);
        String mayuscula = new String(recibo.getData());
        
        // Obteniendo información del datagrama
        InetAddress IPOrigen = recibo.getAddress();
        int puertoOrigen = recibo.getPort();
        System.out.println("\tProcedente de: " + IPOrigen + ":" + puertoOrigen);
        System.out.println("\tDatos: " + mayuscula.trim());
        clientSocket.close(); // cerrar socket
        
    }
}
