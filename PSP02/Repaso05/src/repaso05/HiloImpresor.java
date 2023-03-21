/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso05;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloImpresor extends Thread {

    private Impresora impresora;
    
    public HiloImpresor(Impresora impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {
        impresora.imprimir(getName());
    }
    
    
}
