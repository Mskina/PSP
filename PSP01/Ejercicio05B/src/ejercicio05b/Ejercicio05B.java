/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio05b;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Crea un segundo programa Java que introduzca por teclado una cadena y ejecute
 * el programa anterior para visualizar 5 veces esa cadena.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio05B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here

        // Onde está o arquivo
        File directorio = new File("D:\\GitHub\\PSP\\PSP01\\PSP01Ejercicio05A\\src\\psp01ejercicio05a");

        // Creamos unha lista de argumentos para pasarlla o construtor
        List<String> listaArgs = new LinkedList<String>();
        listaArgs.add("java");
        listaArgs.add("PSP01Ejercicio05A.java");

        // Solicitamos por teclado
        System.out.print("Por favor, escribe algo: ");
        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();

        // Engadimos os argumentos
        listaArgs.add(texto);

        ProcessBuilder pb = new ProcessBuilder(listaArgs);
        pb.directory(directorio);

        // Cos argumentos engadidos, iniciamos o proceso
        Process p = pb.start();
        
        // Neste caso non capturamos excepcións
        int valorExit = p.waitFor(); // recolle System.exit()

        System.out.println("Escribiches: ");
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        is.close(); // Pechamos o stream

    }

}
