/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso03;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Semaforo semaforo = new Semaforo();
        
        HiloEscritor escritor1 = new HiloEscritor("Escritor 1", semaforo);
        HiloEscritor escritor2 = new HiloEscritor("Escritor 2", semaforo);
        
        HiloLector lector1 = new HiloLector("Lector 1", semaforo);
        HiloLector lector2 = new HiloLector("Lector 2", semaforo);
        HiloLector lector3 = new HiloLector("Lector 3", semaforo);
        
        escritor1.start();
        escritor2.start();
        lector1.start();
        lector2.start();
        lector3.start();
    }
    
}
