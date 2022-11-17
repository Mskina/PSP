/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorioshijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Obtiene una línea de texto y devuelve un número aleatorio de 0 a 10 en bucle.
 *
 * @author Iván Estévez Sabucedo
 */
public class AleatoriosHijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Abrimos el canal para recibir texto por la entrada estándar.
        InputStreamReader isr = new InputStreamReader(System.in);

        // Almacenamos lo que recibimos en un buffer
        BufferedReader br = new BufferedReader(isr);

        // Clase que genera número aleatorio
        Random r = new Random();

        // Bucle infinito en el que se genera un número aleatorio cada vez que se recibe una nueva línea.
        do {
            br.readLine(); // Leemos lo recibido. No lo almacenamos ya que no es necesario.
            System.out.println(r.nextInt(11)); // Generamos un número aleatorio
        } while (true);
    }

}
