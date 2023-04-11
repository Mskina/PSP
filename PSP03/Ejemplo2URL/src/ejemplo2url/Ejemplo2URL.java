package ejemplo2url;

import java.net.*;
import java.io.*;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo2URL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.cientoseis.es/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//
}
