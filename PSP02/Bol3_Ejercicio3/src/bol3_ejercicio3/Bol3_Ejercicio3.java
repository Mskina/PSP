/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol3_ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Usando el modelo productor-consumidor, crea un productor que lea caracteres
 * de un fichero de texto cuyo nombre recibirá a través de su constructor. El
 * consumidor obtendrá los datos que produzca el productor y los mostrará por
 * pantalla.
 *
 * Muestra al final del proceso del productor y del consumidor un mensaje
 * indicando que el proceso ha finalizado.
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol3_Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String nombreFichero = "documento.txt";
            Caracteres caracteres = new Caracteres();

            Productor productor = new Productor(caracteres, nombreFichero);
            Consumidor consumidor = new Consumidor(caracteres);

            productor.start();
            consumidor.start();

            productor.join();
            consumidor.join();

            System.out.println(">> Fin de la lectura");
        } catch (InterruptedException ex) {
            Logger.getLogger(Bol3_Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
