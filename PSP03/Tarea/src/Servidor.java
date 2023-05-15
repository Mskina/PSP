import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando servidor --");

        // Creo socket servidor y normal
        int puerto = 2000;
        ServerSocket serverSocket = new ServerSocket(puerto);

        // Se crea el socket cliente
        System.out.println("Esperando al cliente...");
        Socket clienteConectado = serverSocket.accept();

        // Creo el flujo de salida
        PrintWriter flujoSalida = new PrintWriter(clienteConectado.getOutputStream(), true);

        // Creo el flujo de entrada
        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));

        int numeroRecibido = -1;
        boolean acertado = false;

        // Creo un número aleatorio
        int numero = 3;

        while (!acertado) {
            numeroRecibido = Integer.parseInt(flujoEntrada.readLine());
            if (numeroRecibido == numero) {
                flujoSalida.println("Acertado");
                acertado = true;
            }

            if (numeroRecibido < numero) {
                flujoSalida.println("El número que has escrito es menor al número buscado");
            }

            if (numeroRecibido > numero) {
                flujoSalida.println("El número que has escrito es mayor al número buscado");
            }

        }

        flujoSalida.close();
        flujoEntrada.close();
        clienteConectado.close();
        serverSocket.close();
        System.out.println("-- Fin del servidor --");


    }

}
