/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplolectura;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class EjemploLectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String texto;
        
        try {
            System.out.println("Escribe una cadena...");
            texto = br.readLine();
            System.out.println("Has escrito: "+texto);
            isr.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
    
}
