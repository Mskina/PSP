import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Crea un programa cliente en el que se introduzca por teclado el idProfesor que se desea consultar. Dicho programa
 * recogerá datos hasta recibir un * por parte del usuario. Si el idProfesor no se encuentra registrado, el servidor
 * le devolverá un objeto Profesor con datos vacíos.
 */
public class Cliente {

    final static String FIN = "*";
    public static void main(String[] args) {
        try {
            String host = "localhost";
            int puerto = 6000;

            System.out.println("-- Cliente iniciado --");

            Socket cliente = new Socket(host, puerto);

            // Preparamos un flujo de entrada de objetos
            ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

            // Preparamos un flujo de salida hacia el servidor
            PrintWriter flujoSalida = new PrintWriter(cliente.getOutputStream(), true);

            // Creo un flujo de entrada por teclado
            Scanner scan = new Scanner(System.in);

            // Creo un profesor
            Profesor personaRecibida = null;

            // Se solicita cadena al usuario
            System.out.print("Introduce id del Profesor: ");
            String texto = scan.nextLine();

            while (!texto.equals(FIN)) {
                // Se envía la cadena al servidor
                flujoSalida.println(texto);

                // Recibimos la respuesta del servidor
                personaRecibida = (Profesor) flujoEntrada.readObject();

                System.out.println("Recibido: " + personaRecibida);

                // Volvemos a solicitar un profesor
                System.out.print("Introduce id del Profesor: ");
                texto = scan.nextLine();
            }

            if (texto.equals(FIN)) {
                System.out.println("Enviando mensaje de cierre.");
                flujoSalida.println(FIN);
            }

            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();





        } catch (Exception e) {
            System.out.println("Se murió.");
        }


    }





}
