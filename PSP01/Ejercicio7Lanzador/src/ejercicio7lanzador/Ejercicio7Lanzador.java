/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7lanzador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio7Lanzador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\Ejercicio7\\src\\ejercicio7");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio7.java");
        pb.directory(directorio);
        Process p = pb.start();

        InputStream is = p.getInputStream();
        OutputStream os = p.getOutputStream();

        /*os.write("texto\n".getBytes());
        os.write("hola\n".getBytes());
        os.write("michi\n".getBytes());
        os.write("*\n".getBytes());
        os.close();
        
        Thread.sleep(2000);*/
        String[] cadenas = {"texto\n", "hola\n", "michi\n"};
        for (int i = 0; i < cadenas.length; i++) {
            int c;
            while ((c = is.read()) != (int) ':') {
                System.out.print((char) c);                
            }
            
            System.out.print((char) c);
            System.out.print(" "+cadenas[i]);
            
            os.write(cadenas[i].getBytes());
            os.flush();
        }

        os.write("*\n".getBytes());
        os.close();

        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }

    }

}
