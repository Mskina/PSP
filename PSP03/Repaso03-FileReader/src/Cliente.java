
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int puerto = 60001;

        Socket cliente = new Socket(host, puerto);

        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

        //Archivo
        File file = new File("archivo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            flujoSalida.writeUTF(line);
            System.out.println(line);
            flujoSalida.flush();
        }
        
        br.close();
        flujoSalida.close();
        flujoEntrada.close();
        cliente.close();

    }
}
