/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayusculashijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Obtiene una línea de texto, la transforma a mayúsculas y lo imprime.
 *
 * @author Iván Estévez Sabucedo
 */
public class MayusculasHijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException { 
        // Abrimos el canal para recibir texto por la entrada estándar.
        InputStreamReader isr = new InputStreamReader(System.in);

        // Almacenamos lo que recibimos en un buffer
        BufferedReader br = new BufferedReader(isr);

        String texto; // Variable que emplearemos para almacenar lo recibido

        // Bucle infinito en el que se genera un número aleatorio cada vez que se recibe una nueva línea.
        do {
            texto = br.readLine(); // Leemos lo recibido
            System.out.println(texto.toUpperCase()); // Generamos un número aleatorio
        } while (true);

    }
}
