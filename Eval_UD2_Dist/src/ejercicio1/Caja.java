/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 * La clase Caja deberá contar con los métodos necesarios para incrementar el
 * importe cobrado y para mostrarlo por pantalla.
 *
 * @author Iván Estévez
 */
public class Caja {

    private double importeTotalFacturado;

    public Caja() {
    }

    public synchronized void sumarImporte(double importe) {
        importeTotalFacturado += importe;
    }

    @Override
    public String toString() {
        String s = "El importe total facturado ha sido: " + String.format("%.2f", importeTotalFacturado) + " euros.";
        return s;
    }

}
