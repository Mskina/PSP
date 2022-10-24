/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad6;

import java.util.Scanner;

/**
 * Escribe un programa Java que lea dos números desde la entrada estándar y
 * visualice su suma. COntrolar que lo introducido por teclado sean dos números.
 * Haz otro programa Java para ejecutar el anterior.
 *
 * @author Iván Estévez Sabucedo
 */
public class Actividad6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        

        int num1 = 0;
        int num2 = 0;
        boolean esNumero1 = false;
        boolean esNumero2 = false;

        Scanner scan = new Scanner(System.in);
        
        do {
            try {
                System.out.print("Escribe el número 1: ");
                num1 = Integer.parseInt(scan.nextLine());
                esNumero1 = true;
            } catch (Exception e) {
                System.out.println("Debes escribir un número.");
            }
        } while (!esNumero1);
        
        do {
            try {
                System.out.print("Escribe el número 2: ");
                num2 = Integer.parseInt(scan.nextLine());
                esNumero2 = true;
            } catch (Exception e) {
                System.out.println("Debes escribir un número.");
            }
        } while (!esNumero2);
        
        int resultado = num1+num2;
        
        System.out.println("La suma es: " +resultado);
    }

}
