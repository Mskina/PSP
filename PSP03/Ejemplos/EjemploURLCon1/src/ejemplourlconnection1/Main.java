package ejemplourlconnection1;

import java.net.*;
import java.io.*;

/**
 * El ejemplo crea un objeto URL a la dirección https://www.iessanclemente.net,
 * se invoca al método openConnection() del objeto para crear una conexión y se
 * obtiene un URLConnection. Después, se abre un stream de entrada sobre esa
 * conexión mediante el método getInputStream(). Al ejecutar el programa, se
 * muestra la misma salida que en Ejemplo2URL; sin embargo, este programa crea
 * una conexión con la URL y el anterior abre directamente un stream desde la
 * URL.
 *
 * @author Iván Estévez Sabucedo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        try {
            url = new URL("https://www.iessanclemente.net");
            urlCon = url.openConnection();

            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
