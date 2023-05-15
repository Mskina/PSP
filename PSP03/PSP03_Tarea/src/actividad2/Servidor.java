package actividad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * El cliente se conectará al servidor y le solicitará el nombre de un fichero.
 * Si el fichero existe, el servidor le enviará el contenido del fichero al
 * cliente y éste lo mostrará por pantalla. Si el fichero no existe, el servidor
 * le enviará al cliente un mensaje de error. Una vez que el cliente ha mostrdo
 * el fichero se finalizará la conexión.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    private static final int PUERTO = 1500;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("-- Servidor iniciado -- ");

        try (
                ServerSocket servidor = new ServerSocket(PUERTO); // Creo el socket servidor
                 Socket cliente = servidor.accept(); // Creo el socket cliente y acepto su conexión
                 ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream()); // Flujo de salida para objetos
                 BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Creo el flujo de entrada para texto
                ) {

            Fichero[] ficheros = new Fichero[2];
            ficheros[0] = new Fichero("Nombre", "Soy el fichero de prueba 1. Si me lees, ha funcionado.");
            ficheros[1] = new Fichero("Archivo", "Soy el fichero de prueba 2. Si me lees, ha funcionado.");

            boolean encontrado = false;
            String nombreRecibido;

            /**
             * Leemos el nombre recibido. Recorremos los ficheros en busca de
             * coincidencia. Si la hay, enviamos un true indicándola y
             * posteriormente el fichero. En caso contrario, enviamos un false y
             * seguimos esperando por nuevos intentos.
             *
             */
            while (!encontrado) {
                nombreRecibido = flujoEntrada.readLine();
                System.out.println("He recibido: " + nombreRecibido);

                for (Fichero f : ficheros) {
                    if (nombreRecibido.equals(f.getNombre())) { // Compruebo si coincide
                        flujoSalida.writeBoolean(true); // Primero envío si lo ha encontrado
                        flujoSalida.writeObject(f); // Después envío el fichero
                        System.out.println("Fichero enviado al cliente.");
                        encontrado = true;
                    } else {
                        flujoSalida.writeBoolean(false);
                    }
                    flujoSalida.flush();
                }

            }
        } catch (IOException ioe) {
            System.out.println("Excepción: " + ioe.getMessage());
        }
        System.out.println("-- Fin del programa cliente --");
    }
}
