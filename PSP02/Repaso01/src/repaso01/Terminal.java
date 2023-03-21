/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso01;

/**
 * En su constructor se le pasará un objeto Cajero, que será al que accederá, y
 * su nombre. El número máximo de localidades que puede vender cada terminal es
 * de 20000
 *
 * @author Iván Estévez Sabucedo
 */
public class Terminal extends Thread {

    private Cajero cajero;
    private String nombreTerminal;
    private int localidadesVendidas = 0;
    private final int localidadesMaximas = 20000;

    public Terminal(Cajero cajero, String nombreTerminal) {
        this.cajero = cajero;
        this.nombreTerminal = nombreTerminal;
    }

    @Override
    public void run() {
        for (int i = 0; i < localidadesMaximas; i++) {
            cajero.sumarLocalidades();
            localidadesVendidas++;
            //System.out.println(nombreTerminal + " lleva " + localidadesVendidas + " entradas vendidas.");
        }
        System.out.println(nombreTerminal + " ha vendido todas sus entradas.");
    }

}
