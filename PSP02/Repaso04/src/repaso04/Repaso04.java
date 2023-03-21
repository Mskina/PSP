/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso04;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Repaso04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Caja caja = new Caja();
        
        Productor p = new Productor(caja, "fichero.txt");
        Consumidor c = new Consumidor(caja);
        
        p.start();
        c.start();
    }
    
}
