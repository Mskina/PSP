/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Iván Estévez
 */
public class Consumidor extends Thread {

    final static String STOP = "*";
    private Almacen almacen;

    public Consumidor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            String cadenaRecibida = almacen.entregarCadena();
            
            if (cadenaRecibida.equals(STOP)) {
                break;
            }
            String cadenaRecibidaMayus = cadenaRecibida.toUpperCase();

            int caracteres = cadenaRecibida.length();

            System.out.println(">> Oración convertida a mayúsculas: " + cadenaRecibidaMayus);
            System.out.println(">> Número de caracteres en tu oración: " + caracteres + " caracteres.");
        }
    }
}
