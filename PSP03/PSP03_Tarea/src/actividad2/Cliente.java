package actividad2;

import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * El cliente se conectará al servidor y le solicitará el nombre de un fichero.
 * Si el fichero existe, el servidor le enviará el contenido del fichero al
 * cliente y éste lo mostrará por pantalla. Si el fichero no existe, el servidor
 * le enviará al cliente un mensaje de error. Una vez que el cliente ha mostrado
 * el fichero se finalizará la conexión.
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 1500;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("-- Cliente iniciado -- ");

        try (
                Socket socket = new Socket(HOST, PUERTO); // Creo el socket
                 PrintWriter flujoSalida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true); // Creo el flujo de salida de texto
                 ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream()); // Creo el flujo de entrada para objetos
                ) {

            boolean encontrado = false;
            Scanner scan = new Scanner(System.in);
            String teclado;

            /**
             * Leemos por teclado un nombre de fichero. Se lo enviamos al
             * servidor y esperamos un true si el fichero existe y false en caso
             * contrario. De existir, recibiremos también el fichero y
             * mostraremos su descripción.
             */
            while (!encontrado) {
                System.out.print("Escribe el nombre del fichero: ");
                teclado = scan.nextLine();
                flujoSalida.println(teclado);

                encontrado = flujoEntrada.readBoolean(); // Recibo únicamente si se ha encontrado

                if (encontrado) { // Si lo encuentra, leo el objeto
                    Fichero fichero = (Fichero) flujoEntrada.readObject();
                    System.out.println(fichero.getDescri());
                } else { // En caso contrario, muestro error y sigo intentando encontrar el objeto
                    System.out.println("No se ha encontrado el fichero.");
                }

            }
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        System.out.println("-- Fin del programa cliente --");
    }
}
