/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Realiza un programa Java que lea una cadena desde la entrada estándar y
 * visualice en pantalla si la cadena es o no palíndromo o si la cadena está
 * vacía (la longitud es 0).
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String texto;

        System.out.println("Escribe algo: ");
        texto = br.readLine();
        
        // https://parzibyte.me/blog/2019/02/22/palindromo-java-saber-si-cadena-palindroma/
        texto = texto.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
        String invertida = new StringBuilder(texto).reverse().toString();

        // Cadena vacía
        
        if (texto.length() == 0) {
            System.err.println("No has escrito nada (?)");
        } else if (invertida.equals(texto)) {
            System.out.println(texto + " --> Palindromía");            
        } else {
            System.err.println(texto + " --> No es palíndromo");
        }

    }

}
