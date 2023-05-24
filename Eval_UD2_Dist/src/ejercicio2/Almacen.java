/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Iván Estévez
 */
public class Almacen {

    private boolean hayTexto = false;
    private String cadena;

    public Almacen() {
    }

    public synchronized void guardarCadena(String cadena) {
        while (hayTexto) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en wait de guardarCadena: " + ex.getMessage());
            }
        }
        this.cadena = cadena; // Guardo la cadena
        hayTexto = true; // Cambio el valor para que el consumidor consuma
        notifyAll(); // Notifico
    }

    public synchronized String entregarCadena() {
        while (!hayTexto) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en wait de entregarCadena: " + ex.getMessage());
            }
        }
        String texto = this.cadena; // Guardo la variable por si se escribiese muy rápido
        hayTexto = false; // Cambio el valor para que el productor entre en acción
        notifyAll(); // Notifico
        return texto;
    }

}
