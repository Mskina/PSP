
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Crea un programa cliente que introduzca por teclado un número e inicialice un
 * objeto Numeros. El atributo numero debe contener el número introducido por
 * teclado. Debe enviar ese objeto al programa servidor. El proceso se repetirá
 * mientras el número introducido por teclado sea mayor que 0.
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-- Cliente iniciado --");

        int puerto = 60001;
        String host = "localhost";
        Socket cliente = new Socket(host, puerto);

        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

        Scanner scan = new Scanner(System.in);
        System.out.print("Escribe un numero: ");
        int num = scan.nextInt();

        while (num > 0) {
            Numeros numeroEnviado = new Numeros();
            numeroEnviado.setNumero(num);

            flujoSalida.writeObject(numeroEnviado);
            System.out.println(">> Número enviado.");

            System.out.println("<< Recibiendo datos...");
            Numeros numeroRecibido = (Numeros) flujoEntrada.readObject();

            System.out.println(numeroRecibido);

            System.out.print("Escribe un numero: ");
            num = scan.nextInt();
        }
        Numeros numeroEnviado = new Numeros();
        numeroEnviado.setNumero(num);
        flujoSalida.writeObject(numeroEnviado);

        cliente.close();
        System.out.println("Fin del cliente.");

    }
}
