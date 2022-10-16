/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp01ejercicio05a;

/**
 * Crea un programa Java que visualice 5 veces la cadena que se le envía desde
 * los argumentos de main(). Si no se le envía ninguna cadena, que muestre un
 * mensaje indicándolo y que finalice el programa con System.exit(1).
 *
 * @author mskin
 */
public class PSP01Ejercicio05A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if (args.length != 1) {
            System.out.println("Non escribiches nada.");
            System.exit(1);
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.println(args[0]);
            }
            
        }
    }

}
