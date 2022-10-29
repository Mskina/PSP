/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo7;

import java.io.File;
import java.io.IOException;

/**
 * Los métodos redirectOutput() y redirectError() nos permiten redirigir la
 * salida estándar y de error a un fichero. El siguien teejemplo ejecuta el
 * comando DIR y envía la salida al fichero salida.txt; si ocurre algún error,
 * se envía a error.txt.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        pb.start();
    }

}
