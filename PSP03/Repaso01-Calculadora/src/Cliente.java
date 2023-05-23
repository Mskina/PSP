
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido a Calculator3000");

        int puerto = 60000;
        String host = "localhost";

        try (
                Socket cliente = new Socket(host, puerto); //
                 ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream()); //
                 ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream()); //
                ) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Puedes realizar SUMA, RESTA, MULTIPLICACION o DIVISION entre dos números");
            System.out.print("Escribe tu operacion: ");
            String operacion = scan.nextLine();

            System.out.print("Escribe el primer número: ");
            float numero1 = scan.nextFloat();

            System.out.print("Escribe el segundo número: ");
            float numero2 = scan.nextFloat();

            flujoSalida.writeUTF(operacion);
            flujoSalida.writeFloat(numero1);
            flujoSalida.writeFloat(numero2);
            flujoSalida.flush();

            double resultado = flujoEntrada.readDouble();
            
            

            System.out.println("El resultado es: " + resultado);
        } catch (Exception e) {
            System.out.println("Oh no");
        }
    }
}
