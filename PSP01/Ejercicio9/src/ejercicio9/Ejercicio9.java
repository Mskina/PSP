/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Modifica el ejercicio 7 para que, al ejecutar el programa, la entrada al
 * proceso se obtenga a partir de un fichero de texto.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\Ejercicio7\\src\\ejercicio7");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio7.java");
        pb.directory(directorio);

        // De dónde lee
        File fEntrada = new File("texto.txt");

        pb.redirectInput(ProcessBuilder.Redirect.from(fEntrada));
        Process p = pb.start();

        // Leemos la respuesta por pantalla
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
    }

}
