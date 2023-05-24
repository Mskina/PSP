
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Hilo extends Thread {

    private static final String FIN = "FIN";
    private static final String NOMBRE_PREGUNTA = "¿Cómo te llamas?";
    private static final String NOMBRE_RESPUESTA = "Me llamo Servidor del Ejercicio 1";
    private static final String LINEAS_PREGUNTA = "¿Cuántas líneas de código tienes?";
    private static final String LINEAS_RESPUESTA = "59";
    private static final String RESPUESTA_DEFAULT = "No he entendido la pregunta";

    private Socket socket;

    public Hilo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream());//
                 ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());//
                ) {

            String recibido = flujoEntrada.readUTF();

            while (!recibido.equals(FIN)) {
                switch (recibido) {
                    case NOMBRE_PREGUNTA:
                        flujoSalida.writeUTF(NOMBRE_RESPUESTA);
                        flujoSalida.flush();
                        break;
                    case LINEAS_PREGUNTA:
                        flujoSalida.writeUTF(LINEAS_RESPUESTA);
                        flujoSalida.flush();
                        break;
                    default:
                        flujoSalida.writeUTF(RESPUESTA_DEFAULT);
                        flujoSalida.flush();
                }
                recibido = flujoEntrada.readUTF();
            }
            this.socket.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido una excepción en el hilo " + this.getName() + ". Motivo: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Hilo " + this.getName() + " cerrado.");
    }

}
