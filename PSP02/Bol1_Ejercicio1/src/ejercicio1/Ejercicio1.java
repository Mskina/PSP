/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crea un hilo que en su método run() muestre un “NO” hasta un máximo de 30
 * veces. En el método principal (main) tras ejecutar el start() de tu hilo,
 * mostrará “YES” hasta un máximo de 30 veces. Como salida obtendrás una serie
 * alternativa de NOes y YESes ya que, una vez iniciada la ejecución del thread, el
 * tiempo de la CPU se reparte entre todos los procesos y threads del sistema,
 * con lo cual se intercalan instrucciones del método main() con instrucciones
 * del método run().
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Hilo hilo = new Hilo();
        hilo.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("YES");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

}
