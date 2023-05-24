/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.Scanner;

/**
 *
 * @author Iván Estévez
 */
public class Productor extends Thread {

    final static String STOP = "*";
    Scanner scan = new Scanner(System.in);

    private Almacen almacen;
    private String cadena;

    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            System.out.print("Escribe una oración: ");

            cadena = scan.nextLine(); // Leo la oración

            if (cadena.equals(STOP)) { // Si se introduce el asterisco
                almacen.guardarCadena(cadena); // Lo guaardo en el almacén (para que el consumidor lo lea)
                break; // Y salgo del bucle
            }

            almacen.guardarCadena(cadena);

//            try {
//                Thread.sleep(10); // Lo duermo para que sysout no solape la respuesta del consumidor
//            } catch (InterruptedException ex) {
//                System.out.println("Error en sleep de run de Productor: " + ex.getMessage());
//            }
        }
    }
}
