/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Crea un programa Java que lea cadenas desde la entrada estándar hasta
 * escribir un *. A continuación, crea otro programa que ejecute el anterior.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        final String STOP = "*";

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String texto;
        
        do {
            System.out.print("Escribe algo:");
            texto = br.readLine();
            System.out.println("Has escrito... "+texto);
        } while (!texto.equals(STOP));
        System.out.println("Fin.");
    }

}
