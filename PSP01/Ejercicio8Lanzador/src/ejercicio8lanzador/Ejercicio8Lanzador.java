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

        File fEntrada = new File("origen.txt");
        File fErr = new File("error.txt");

        pb.redirectInput(ProcessBuilder.Redirect.from(fEntrada));
        pb.redirectError(ProcessBuilder.Redirect.to(fErr));

        // Salida por pantalla
        Process p = pb.start();        
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
