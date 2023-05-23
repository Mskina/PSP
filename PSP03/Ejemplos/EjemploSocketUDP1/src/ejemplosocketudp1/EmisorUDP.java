package ejemplosocketudp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class EmisorUDP {

    /**
     * Red Parte 2, página 15.
     *
     *
     * Constructor: DatagramPacket(byte[] buf, int offset, int length,
     * InetAddress addrss, int port).
     *
     * El siguiente ejemplo utiliza el constructor para enviar un datagrama por
     * el puerto 12345. El mensaje está formado por la cadena "Enviando Saludos
     * !!", que es necesario codificar en una secuencia de bytes y almacenar el
     * resultado en una matriz de bytes. Después será necesario calcular la
     * longitud del mensaje a enviar. Con InetAddress.getLocalHost() obtengo la
     * dirección IP del host al que enviaré el mensaje, en este caso el host
     * local.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Puerto a donde envío el paquete
        int port = 12345;

        // IP a la que envío
        InetAddress destino = InetAddress.getLocalHost();

        // Matriz de bytes
        byte[] mensaje = new byte[1024];

        String Saludo = "Enviando Saludos! !";

        // Se codidifica a bytes para enviarlo
        mensaje = Saludo.getBytes();

        //Se construye el datagrama a enviar
        /**
         * Constructor para el envío de datagramas. Se especifica la cadena de
         * bytes a enviar (buf), la longitud (length), el número de puerto de
         * destino (port) y el host especificado en la dirección addrss
         */
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

        //construyo datagrama a enviar indicando el host destino y puerto
        /**
         * Con el paquete ya listo, lo envío usando un DatagramSocket. En este
         * caso, empleamos como puerto de envío el puerto local 34567. Mediante
         * el método send(), se envía el datagrama.
         */
        DatagramSocket socket = new DatagramSocket(34567);
        socket.send(envio);//envio datagrama a destino y port
    }
}
