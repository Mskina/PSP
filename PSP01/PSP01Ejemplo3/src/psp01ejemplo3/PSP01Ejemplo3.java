/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp01ejemplo3;

import java.io.*;

/**
 *
 * @author mskin
 */
public class PSP01Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        // Creamos objeto File al directorio donde está Ejemplo 2
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\PSP01Ejemplo2\\src\\psp01ejemplo2");

        // El proceso a ejecutar es Ejemplo2
        ProcessBuilder pb = new ProcessBuilder("java", "PSP01Ejemplo2.java");

        // Se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());

        // Se ejecuta el proceso
        Process p = pb.start();

        // Obtenemos la salida devuelta por el proceso
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
