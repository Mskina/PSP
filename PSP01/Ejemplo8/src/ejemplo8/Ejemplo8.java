/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo8;

import java.io.File;
import java.io.IOException;

/**
 * También podemos ejecutar varios comandos del sistema operativo dentro de un
 * fichero BAT. El siguiente ejemplo ejecuta los comandos MS-DOS que se
 * encuentran en el fichero fichero.bat. Se utiliza el método redirectInput()
 * para indicar que la entrada al proceso se encuentra en un fichero, es decir,
 * la entrada para el comando CMD será el fichero fichero.bat. La salida del
 * proceso se envía al fichero salida.txt y la salida de error, al fichero
 * error.txt.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo8 {

//    Suponemos que los comandos MS-DOS del fichero.bat son:
//
//    MKDIR NUEVO
//    CD NUEVO
//    ECHO CREO FICHERO > Mifichero.txt
//    DIR
//    DIRR
//    ECHO FIN COMANDOS
//
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD");
        
        File fBat = new File("fichero.bat");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        
        pb.redirectInput(fBat);
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        pb.start();
    }

}
