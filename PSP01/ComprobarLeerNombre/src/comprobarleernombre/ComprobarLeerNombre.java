/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprobarleernombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author mskin
 */
public class ComprobarLeerNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Creamos objeto File al directorio donde está LeerNombre
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\LeerNombre\\src\\leernombre");

        // El proceso a ejecutar es LeerNombre.java
        // Se le pasa el nombre como tercer argumento
        ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre.java", "Testeando");

        // Se establece el directorio donde se encuentra el ejecutable
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());

        // Se ejecuta LeerNombre
        Process p = pb.start();

        // Comprobamos la salida (1 = Bien; -1 = Mal)
        int exitVal;
        try {
            exitVal = p.waitFor(); // recoge la salida de System.exit()
            System.out.println("Valor de salida: " + exitVal);
            switch (exitVal) {
                case -1:
                    System.out.println("¡OH, NO! :(");                    
                    break;
                case 1:
                    System.out.println("¡BRAVO!");                    
                    break;
            }
            leerTexto(p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void leerTexto(Process p) {
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
