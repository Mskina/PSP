/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso05;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Repaso05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        
        HiloImpresor h1 = new HiloImpresor(impresora);
        HiloImpresor h2 = new HiloImpresor(impresora);
        HiloImpresor h3 = new HiloImpresor(impresora);
        HiloImpresor h4 = new HiloImpresor(impresora);
        HiloImpresor h5 = new HiloImpresor(impresora);
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
    
}
