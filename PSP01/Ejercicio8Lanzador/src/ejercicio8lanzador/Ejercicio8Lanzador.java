/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8lanzador;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Realiza un segundo programa Java que ejecute el anterior. Debe leer la cadena
 * desde teclado y mostrar la salida por pantalla. Transforma este ejercicio
 * para que la cadena se obtenga de un fichero de texto y se envíe la salida de
 * error a un fichero.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio8Lanzador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\Ejercicio8\\src\\ejercicio8");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio8.java");
        pb.directory(directorio);
        Process p = pb.start();

        InputStream is = p.getInputStream();
        OutputStream os = p.getOutputStream();
        InputStream err = p.getErrorStream();

        FileReader fr = new FileReader("origen.txt");

        int c;
        while ((c = fr.read()) != -1) {
            os.write(c);
        }
        os.close();

        FileWriter fw = new FileWriter("error.txt", true);

        int d;
        while ((d = err.read()) != -1) {
            fw.append((char) d);
        }
        fw.close();
        err.close();

        // Comprobación de palíndromos
        int e;
        while ((e = is.read()) != -1) {
            System.out.print((char) e);
        }

    }
}
