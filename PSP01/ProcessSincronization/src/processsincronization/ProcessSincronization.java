/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processsincronization;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author mskin
 */
public class ProcessSincronization {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here

        try {
            Process process = new ProcessBuilder(args).start();
            int retorno = process.waitFor();

            System.out.println("Comando " + Arrays.toString(args) + " devolvió: " + retorno);
        } catch (IOException e) {
            System.out.println("Error ocurrió ejecutando el comando:" + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El comando fue interrumpido. Descripción del error:" + e.getMessage());
        }
    }

}
