/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp01ejercicio04lanzador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Realiza un segundo programa Java uqe ejecute al anterior. Este segundo
 * programa debe mostrar en pantalla lo que pasa dependiendo del valor devuelto
 * al ejecutar el programa anterior.
 *
 * @author mskin
 */
public class Lanzador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        // Añadimos la ruta donde está el Ejercicio 4
        File directorio = new File(".");

        // Creamos el proceso
        List<String> argList = new LinkedList<String>();
        argList.add("java");
        argList.add("Ejercicio04.java");
        for (String arg : args) {
            argList.add(arg);
        }
        
        ProcessBuilder pb = new ProcessBuilder(argList);

        // Se establece el directorio donde se encuentra el .java
        pb.directory(directorio);
        System.out.printf(">> Directorio de trabajo: %s%n", pb.directory());

        // Se ejecuta PSP01Ejercicio04
        Process p = pb.start();

        // Comprobamos el valor devuelto por System.exit()
        int valorExit;
        try {
            valorExit = p.waitFor(); // recoge la salida de System.exit()
            System.out.println("Valor de salida de PSP01Ejercicio04: " + valorExit);
            switch (valorExit) {
                case 1:
                    System.out.println(">>> Número de argumentos < 1");
                    break;
                case 2:
                    System.out.println(">>> Argumento es 1 String");
                    break;
                case 3:
                    System.out.println(">>> Argumento es 1 Int < 0");
                    break;
                default:
                    System.out.println(">>> Resto de situaciones");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
