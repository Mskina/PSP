/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo9;

import java.io.File;
import java.io.IOException;

/**
 * Para llevar a cabo el redireccionamiento tanto de entrada como de salida del
 * proceso que se ejecuta, también podemos usar la clase
 * ProcessBuilder.Redirect. El redireccionamiento puede ser uno de los
 * siguientes:
 *
 * - El valor especial Redirect.INHERIT, indica que la fuente de entrada y
 * salida del proceso será la misma que la del proceso actual.
 *
 * - Redirect.from(File) indica redirección para leer de un fichero; la entrada
 * al proceso se encuentra en el objeto File.
 *
 * - Redirect.to(File) indica redirección para escribir en un fichero; el
 * proceso escribirá en el objeto File especificado.
 *
 * - Redirect.appendTo(File) indica redirección para añadir a un fichero; la
 * salida del proceso se añadirá al objeto File especificado.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // El ejemplo 8 empleando Redirect
        
        ProcessBuilder pb = new ProcessBuilder("CMD");
        
        File fBat = new File("fichero.bat");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        
        pb.redirectInput(ProcessBuilder.Redirect.from(fBat));
        pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
        pb.redirectError(ProcessBuilder.Redirect.to(fErr));
        pb.start();
        
        // El siguiente ejemplo muestra en la consola la salida del comando DIR
        ProcessBuilder pb2 = new ProcessBuilder("CMD", "/C", "DIR");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
    }

}
