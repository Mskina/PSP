/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio06a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Partiendo del ejercicio anterior, realiza los cambios necesarios para que la
 * cadena introducida por teclado se almacene en un fichero de texto, no
 * mostrándola en pantalla.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio06A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length < 1) {
            System.exit(-1);
        }

        String rutaSalida = "D:\\GitHub\\PSP\\PSP01\\PSP01Ejercicio06A\\salida.txt";

        // Uso try-with-resources, que non necesita que se pechen os recursos manualmente
        try (FileWriter fw = new FileWriter(rutaSalida);
                BufferedWriter br = new BufferedWriter(fw);) {
            for (int i = 0; i < 5; i++) {
                br.write(args[0]);
                br.write("\n"); // Salto de liña
            }
            //br.close(); // Con try-with-resources xaa non é necesario (chamaría a flush y pecharía o fluxo)
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
