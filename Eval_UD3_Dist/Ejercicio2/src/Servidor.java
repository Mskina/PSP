
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Diseña una aplicación donde, empleando Datagram Sockets, un proceso (que
 * actúa como cliente) le envía a otro (que actúa como servidor) el nombre del
 * usuario y el cargo que ocupa en una empresa. El servidor le devolverá un
 * resumen en el que figuren los datos del usuario y el salario que le
 * corresponde según su cargo.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * Una vez que tiene todos los datos, mostrará por su consola una entrada:
     * EMPLEADO: Juan Gómez \\ CARGO: Operario \\ SALARIO: 1500€
     *
     * Los salarios que le corresponden a cada cargo son los siguientes:
     *
     * - Operario: 1500€
     *
     * - Comercial: 1600€
     *
     * - Técnico: 1800€
     *
     * - Especialista: 2200€
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-- Servidor iniciado --");
        int puerto = 60000;
        try (DatagramSocket servidor = new DatagramSocket(puerto);) {

            byte[] buf = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(buf, buf.length);
            servidor.receive(paqueteRecibido);

            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            ObjectInputStream in = new ObjectInputStream(bais);
            Cargo cargo = (Cargo) in.readObject();
            in.close();

            switch (cargo.getTipo()) {
                case 1: // Operario
                    cargo.setSalario(1500);
                    break;
                case 2: // Comercial
                    cargo.setSalario(1600);
                    break;
                case 3: // Técnico
                    cargo.setSalario(1800);
                    break;
                case 4: // Especialista
                    cargo.setSalario(2200);
                    break;
            }
            System.out.println("Se ha recibido la siguiente información: ");
            System.out.println(cargo);
            System.out.println("\nLa información ha sido almacenada. Un saludo.");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Excepción al recuperar el cargo: " + cnfex.getMessage());
        } catch (SocketException sex) {
            System.out.println("Excepción en el servidor: " + sex.getMessage());
        } catch (IOException ioex) {
            System.out.println("Excepción lectura/escritura: " + ioex.getMessage());
        }
    }

}
