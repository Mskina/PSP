/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.io.IOException;

/**
 *
 * @author mskin
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        
        ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
        Process p = pb.start();
        
        // También se podría hacer así:
        //Process pb = new ProcessBuilder("NOTEPAD").start();
    }
    
}
