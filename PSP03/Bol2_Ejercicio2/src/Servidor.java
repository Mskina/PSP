
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

/**
 * Crea un programa servidor que reciba cadenas de caracteres, las muestre en
 * pantalla y se las envíe al emisor en mayúscula. El proceso servidor
 * finalizará cuando reciba un asterisco. * Establece un tiempo de espera de
 * 5000ms con el método setSoTimeout para hacer que el método receive() del
 * programa cliente se bloquee. Pasado ese tiempo, controlar si no se reciben
 * datos lanzando la excepción InterruptedIoException, en cuyo caso visualiza un
 * mensaje indicando que el paquete se ha perdido.
 */
public class Servidor {

    public static void main(String[] args) throws Exception {

        System.out.println("-- Iniciado Servidor UDP --");
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            socket.setSoTimeout(5000);

            byte[] recibidos = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
            socket.receive(paqueteRecibido);
            String textoRecibido = new String(paqueteRecibido.getData());
            System.out.println(">> Recibido: " + textoRecibido);

            //socket.setSoTimeout(5000);
            while (!textoRecibido.equals("*")) {
                String textoMayusculas = textoRecibido.toUpperCase();
                DatagramPacket paqueteEnviado = new DatagramPacket(textoMayusculas.getBytes(), textoMayusculas.length(), paqueteRecibido.getAddress(), paqueteRecibido.getPort());
                socket.send(paqueteEnviado);
                System.out.println(">> Enviado: " + textoMayusculas);

                paqueteRecibido = new DatagramPacket(recibidos, recibidos.length);
                socket.receive(paqueteRecibido);
                textoRecibido = new String(paqueteRecibido.getData());
                System.out.println(">> Recibido: " + textoRecibido);
            }

            socket.close();
        } catch (SocketTimeoutException soe) {
            System.out.println("Se ha perdido el paquete.");
            throw new InterruptedIOException();
        }
        System.out.println("-- Fin del servidor --");
    }
}
