package ejemplourlconnection2;

import java.io.*;
import java.net.*;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.cientoseis.es/index.php?action=search2");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);

            String cadena = "search=spoiler&search_selection=all&search2=Buscar&advanced=0";

            //ESCRIBIR EN LA URL stream de salida
            PrintWriter output = new PrintWriter(conexion.getOutputStream());
            output.write(cadena);
            output.close(); //cerrar flujo

            //LEER DE LA URL � stream de entrada
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();//cerrar flujo

        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
        }
    }

}
