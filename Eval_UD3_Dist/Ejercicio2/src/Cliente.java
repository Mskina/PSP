
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * Cliente:
     *
     * - Se pide al usuario el nombre completo.
     *
     * - Se muestran los posibles cargos, para que indique el que corresponda:
     * Operario, Comercial, Técnico, Especialista.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (
                DatagramSocket cliente = new DatagramSocket();//
                 Scanner scan = new Scanner(System.in);//
                ) {
            System.out.println("-- Bienvenido a RRHH --");

            InetAddress ip = InetAddress.getLocalHost();
            int puerto = 60000;

            System.out.print("Escribe el nombre completo: ");
            String nombre = scan.nextLine();

            System.out.println("Existen cuatro cargos:");
            System.out.println("1. Operario");
            System.out.println("2. Comercial");
            System.out.println("3. Técnico");
            System.out.println("4. Especialista");

            int tipo = 0;
            while (!(tipo >= 1 && tipo < 5)) {
                System.out.println("Escribe el número que corresponde al cargo elegido: ");
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("Escribe el número que corresponde al cargo elegido: ");
                }
                tipo = scan.nextInt();
            }
            Cargo cargo = new Cargo(nombre, tipo);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(cargo);
            out.close();
            byte[] bytes = baos.toByteArray();

            DatagramPacket paqueteEnviado = new DatagramPacket(bytes, bytes.length, ip, puerto);
            cliente.send(paqueteEnviado);

            System.out.println("\nLa información ha sido guardada correctamente.\nMuchas gracias por usar nuestros servicios.\nUn saludo.");
        } catch (SocketException sex) {
            System.out.println("Excepción en el cliente: " + sex.getMessage());
        } catch (IOException ioex) {
            System.out.println("Excepción lectura/escritura: " + ioex.getMessage());
        }
    }

}
