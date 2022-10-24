/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.Scanner;

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
    public static void main(String[] args) {
        // TODO code application logic here
        
        final String STOP = "*";

        Scanner scan = new Scanner(System.in);
        String texto = "";
        
        do {
            System.out.print("Escribe algo: ");
            texto = scan.nextLine();
        } while (!texto.equals(STOP));
        System.out.println("Se acabó.");
    }

}
