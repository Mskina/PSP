/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Process p = new ProcessBuilder("CMD", "/C", "DATE").start();
        
        // Escritura -- envía entrada a DATE
        OutputStream os = p.getOutputStream();
        os.write("15-06-18".getBytes());
        os.flush(); // Vacía el buffer de salida
        
        // Lectura -- obtiene la salida de DATE
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1)
            System.out.print((char) c);
        is.close();
        
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
