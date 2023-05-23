package bol1_ejercicio6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    private static final String FIN = "*";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Se establecen host y puerto
        String host = "localhost";
        int puerto = 6000;//puerto remoto	

        // Se inicia el cliente
        System.out.println(" == PROGRAMA CLIENTE INICIADO == ");
        Socket cliente = new Socket(host, puerto);

        // Se crea un flujo de salida hacia el servidor
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

        // Se lee el teclado
        Scanner scan = new Scanner(System.in);
        System.out.print("Escribe algo: ");
        String entrada = scan.nextLine();

        while (!entrada.equals(FIN)) {
            flujoSalida.writeUTF(entrada);

            // Se crea un flujo de entrada desde el servidor
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            // El servidor envía un mensaje
            System.out.println("Recibiendo del SERVIDOR: \n\t"
                    + "'" + entrada + "'" + " tiene " + flujoEntrada.readInt() + " caracteres.");

            System.out.print("Escribe algo: ");
            entrada = scan.nextLine();
        }
        // El cliente envía la última entrada (FIN)
        flujoSalida.writeUTF(entrada);
        
        // Se cierra
        flujoSalida.close();
        cliente.close();
        System.out.println(" == PROGRAMA CLIENTE FINALIZADO == ");
    }
}
