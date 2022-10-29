/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Modifica el Ejemplo5 para que la salida del proceso y la salida de error se
 * almacenen en un fichero de texto, y la entrada la tome desde otro fichero de
 * texto.
 *
 * @author Iván Estévez Sabucedo
 */
public class Actividad7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\EjemploLectura\\src\\ejemplolectura");
        ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura.java");
        pb.directory(directorio);

        // Escritura -- se envía la entrada
//        OutputStream os = p.getOutputStream();
//        os.write("Hola Ivan\n".getBytes());
//        os.flush(); // Vacía el buffer de salida

        // Reemplazamos por redirectInput
        File fFuente = new File("fichero.txt");
        pb.redirectInput(fFuente);
        
        // Creamos las salidas a fichero
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);

        Process p = pb.start();

        // Lectura -- obtiene la salida de DATE
//        InputStream is = p.getInputStream();
//        int c;
//        while ((c = is.read()) != -1) {
//            System.out.print((char) c);
//        }
//        is.close();

        // Comprobación de error - 0 bien, 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
