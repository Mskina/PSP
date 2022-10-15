/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimeprocess;

import java.io.IOException;

/**
 *
 * @author mskin
 */
public class RuntimeProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length <= 0) {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }
        
        Runtime runtime = Runtime.getRuntime();
        
        try {
            Process process = runtime.exec(args);
            process.destroy();
        } catch (IOException ex) {
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }

    }
}
