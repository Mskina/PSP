/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso08;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Repaso08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (int i = 0; i < 30; i++) {

            char A = 'A';
            char B = 'B';
            char C = 'C';

            StringBuilder sb = new StringBuilder();

            Escribir escribir1 = new Escribir(sb, A);
            Escribir escribir2 = new Escribir(sb, B);
            Escribir escribir3 = new Escribir(sb, C);

            escribir1.start();
            escribir2.start();
            escribir3.start();

            try {
                escribir1.join();
                escribir2.join();
                escribir3.join();
            } catch (InterruptedException ex) {
                //
            }

            System.out.println(sb.length() + ": " + sb.toString());
        }
    }
    
}
