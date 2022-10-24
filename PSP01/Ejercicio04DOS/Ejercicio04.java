/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio04;

/**
 * Enunciado: realiza un programa Java que admita argumentos desde main() y
 * devuelva con System.exit() los siguientes valores:
 *
 * - Si el número de argumentos es menor que 1 debe devolver 1. ---------------
 * - Si el argumento es una cadena debe devolver 2. ---------------------------
 * - Si el argumento es un número entero menor que 0 debe devolver 3. ---------
 * - En cualquier otra situación debe devolver 0. -----------------------------
 *
 * Realiza un segundo programa Java uqe ejecute al anterior. Este segundo
 * programa debe mostrar en pantalla lo que pasa dependiendo del valor devuelto
 * al ejecutar el programa anterior.
 *
 * Prueba los programas desde el entorno Eclipse. A continuación, crea una
 * carpeta en el disco duro y almacena los dos programas. Realiza los cambios
 * necesarios para compilarlos y ejecutarlos desde la línea de comandos del DOS.
 *
 * @author mskin
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Si el número de argumentos es menor que 1 debe devolver 1
         */
        if (args.length < 1) {
            System.out.println("Caso 1: Número de argumentos menor que 1");
            System.exit(1);
        }

        /**
         * En el try, intentamos parsear a número. Si es menor que 0, ya
         * devuelve el System.exit(). Si es positivo, no entra en el "if" pero
         * tampoco suelta una excepción, por lo que sale del "try" y llega al
         * final. Si sí hay argumentos pero no es número, entonces suelta la
         * excepción.
         */
        if (args.length == 1) {
            try {
                int numero = Integer.parseInt(args[0]);
                //Si el argumento es un número entero menor que 0 debe devolver 3
                if (numero < 0) {
                    System.out.println("Caso 3: Argumento es un entero menor que cero");
                    System.exit(3);
                }
            } catch (NumberFormatException nfe) {
                //Si el argumento es una cadena debe devolver 2
                System.out.println("Caso 2: Argumento es una cadena");
                System.exit(2);
            }
        }

        /**
         * En cualquier otra situación debe devolver 0
         */
        System.out.println("Resto de situaciones");
        System.exit(0);
    }
}
