/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leernombre;

/**
 *
 * @author mskin
 */
public class LeerNombre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length != 1) {
            System.out.println("Tienes que darme un (1) nombre");
            System.exit(-1);
        } else {
            System.out.println("Hola " + args[0]);
            System.exit(1);
            /**
             * En el enunciado solicita -1 y 1, pero si no le indicamos que
             * devuelva 0 cuando todo fue OK, devuelve un error
             */
        }
    }

}
