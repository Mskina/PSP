/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Partiendo del ejercicio anterior, realiza los cambios necesarios para que la
 * cadena introducida por teclado se almacene en un fichero de texto, no
 * mostrándola en pantalla.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio06B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        // Onde está o arquivo
        String rutaDirectorio = "D:\\GitHub\\PSP\\PSP01\\PSP01Ejercicio06A\\src\\psp01ejercicio06a";
        File directorio = new File(rutaDirectorio);

        // Solicitamos por teclado
        System.out.print("Por favor, escribe algo: ");
        Scanner scan = new Scanner(System.in);
        String texto = scan.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "PSP01Ejercicio06A.java", texto);
        pb.directory(directorio);

        // Cos argumentos engadidos, iniciamos o proceso
        Process p = pb.start();
    }

}
