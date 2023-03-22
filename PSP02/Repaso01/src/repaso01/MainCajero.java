/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso01;

/**
 * Diseña un programa que simule la gestión de un punto de venta con tres
 * terminales que acceden a un objeto Cajero que mantiene la cuenta de las
 * localidades vendidas.
 *
 * @author Iván Estévez Sabucedo
 */
public class MainCajero {

    /**
     * Es el programa principal desde el que creamos un cajero, 3 terminales que
     * trabajen con ese cajero, ponemos en funcionamiento los 3 terminales y
     * cuando terminen mostramos un mensaje que nos indique cuántas localidades
     * han vendido (debería mostrar 60000)
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 

        Cajero cajero = new Cajero();

        Terminal t1 = new Terminal(cajero, "Terminal 1");
        Terminal t2 = new Terminal(cajero, "Terminal 2");
        Terminal t3 = new Terminal(cajero, "Terminal 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            //
        }
        System.out.println("Localidades vendidas: "+cajero.mostrarLocalidades());

    }

}
