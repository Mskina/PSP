/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\EjemploLectura\\src\\ejemplolectura");
        ProcessBuilder pb = new ProcessBuilder ("java", "EjemploLectura.java");
        pb.directory(directorio);
        
        Process p = pb.start();
        
        // Escritura -- se envía la entrada
        OutputStream os = p.getOutputStream();
        os.write("Hola Ivan\n".getBytes());
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
