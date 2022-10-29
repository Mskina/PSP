/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo6;

import java.io.*;
import java.util.*;

/**
 * El siguiente ejemplo usa varios métodos de la clase ProcessBuilder.
 *
 * - environment() que devuelve las variables de entorno del processo.
 *
 * - command() sin parámetros, que devuelve los argumentos del proceso definido
 * en el objeto ProcessBuilder.
 *
 * - command() con parámetros, donde se define un nuevo proceso y sus
 * argumentos.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejemplo6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProcessBuilder test = new ProcessBuilder();
        Map entorno = test.environment();
        System.out.println("Variables de entorno:");
        System.out.println(entorno);

        test = new ProcessBuilder("java", "LeerNombre", "Ivan");

        // Devuelve el nombre del proceso y sus argumentos
        List l = test.command();
        Iterator iter = l.iterator();
        System.out.println("\nArgumetnos del comando:");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        test = test.command("CMD", "/C", "DIR");
        try {
            Process p = test.start(); // Se ejecuta DIR
            InputStream is = p.getInputStream();

            System.out.println();
            // mostramos en pantalla caracter a caracter
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
