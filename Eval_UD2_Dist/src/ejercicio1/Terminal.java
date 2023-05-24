/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 * Cada Terminal realizará un total de 200 cobros de importes aleatorios,
 * descansando durante 2 segundos entre cobro y cobro. Tras realizar los 200
 * cobros, mostrará por pantalla el importe total facturado por ese terminal de
 * venta.
 *
 * @author Iván Estévez
 */
public class Terminal extends Thread {

    private Caja caja;
    private double importeTerminal;

    public Terminal(String nombre, Caja caja) {
        super(nombre);
        this.caja = caja;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                double cobro = (Math.random() * 300);
                caja.sumarImporte(cobro);
                importeTerminal += cobro;
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Error al esperar entre cobros: " + ex.getMessage());
            }
        }
        System.out.println(getName() + " ha facturado " + String.format("%.2f", importeTerminal) + " euros.");
    }

}
