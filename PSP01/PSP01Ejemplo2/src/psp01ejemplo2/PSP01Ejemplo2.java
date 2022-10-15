/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp01ejemplo2;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author mskin
 */
public class PSP01Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /**
         * CMD inicia una nueva instancia del intérprete de comandos de Windows.
         * Para ver la sintaxis del comando, escribimos desde el indicador del
         * DOS: HELP CMD. Para ejecutar un comando escribimos:
         * - CMD /C comando: Ejecuta el comando especificado y luego finaliza
         * - CMD /K comando: Ejecuta el comando especificado, pero sigue activo.
         */

        /**
         * El siguient ejemplo ejecuta el comando DIR. Usaremos el método
         * getInputStream() de la clase Process para leer el stream de salida
         * del proceso, es decir, para leer lo que el comando DIR envía a la
         * consola. Definiremos así el stream: InputStream is =
         * p.getInputStream();
         */
        // Ejecutamos el proceso DIR
        Process p = new ProcessBuilder("CMD", "/C", "DIR").start();

        // Mostramos caracter a caracter la salida generada por DIR
        try {
            InputStream is = p.getInputStream();
            int c;

            c = is.read();
            while (c != -1) {
                System.out.print((char) c);
                c = is.read();
            }
            is.close();

            //while ((c = is.read()) != -1) // sigue mientras sea -1
            //    System.out.print((char) c);
            //is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // COMPROBACIÓN DE ERROR
        // 0 = bien
        // 1 = mal
        int exitVal;
        try {
            exitVal = p.waitFor(); // recoge la salida de System.exit()
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * El método waitFor() hace que el proceso actual espere hasta que el
         * subproceso representado por el objeto Process finalice. Este método
         * recoge lo que System.exit() devuelve. Por defecto, un programa Java
         * que no incluye esta orden devuelve valor 0, que normalmente responde
         * a una finalización correcta del proceso.
         */
    }

}
