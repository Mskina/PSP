package bol1_ejercicio6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Usando Sockets TCP realiza un programa cliente que introduzca cadenas por
 * teclado hasta introducir un asterisco. Las cadenas se enviarán a un programa
 * servidor. El programa servidor aceptará la conexión de un único cliente y por
 * cada cadena recibida le devolverá al cliente el número de caracteres de la
 * misma. El programa servidor finalizará cuando reciba un asterisco como
 * cadena.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    private static final String FIN = "*";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Se establece el puerto
        int puerto = 6000;

        // Se crea el socket servidor
        System.out.println(" == PROGRAMA SERVIDOR INICIADO == ");
        ServerSocket servidor = new ServerSocket(puerto);

        // Se crea el socket cliente
        Socket clienteConectado = null;

        // Se espera al cliente
        System.out.println("Esperando al cliente...");
        clienteConectado = servidor.accept();

        // Se crea el flujo de entrada del cliente
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        String textoRecibido = flujoEntrada.readUTF();        

        while (!textoRecibido.equals(FIN)) {            

            // Mostramos el mensaje enviado por el cliente
            System.out.println("Recibiendo del CLIENTE: \n\t"
                    + textoRecibido);

            // Se crea el flujo de salida hacia el cliente
            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            // Se devuelve el número de caracteres
            int numCaracteres = textoRecibido.length();
            flujoSalida.writeInt(numCaracteres);
            
            // Vuelvo a leer
            textoRecibido = flujoEntrada.readUTF();
        }

        // Cierre de streams y sockets
        entrada.close();
        flujoEntrada.close();
        clienteConectado.close();
        servidor.close();
        System.out.println(" == PROGRAMA SERVIDOR FINALIZADO == ");
    }
}
