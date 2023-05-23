
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int puerto = 60001;
        
        ServerSocket socket = new ServerSocket(puerto);
        
        Socket servidor = socket.accept();
        
        ObjectOutputStream flujoSalida = new ObjectOutputStream(servidor.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(servidor.getInputStream());
        
        File file = new File("salida.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter escritor = new BufferedWriter(fw);
        
        String lectura;
        while (flujoEntrada.available() > 0) {
            lectura = flujoEntrada.readUTF();
            System.out.println("Leído: " + lectura);
            fw.write(lectura+"\n");
            System.out.println("Escrito lo mismo");
            
        }
        fw.flush();
        
        flujoSalida.close();
        flujoEntrada.close();
        servidor.close();
    }
}
