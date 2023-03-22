/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso02;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class ContarThread extends Thread {

    private int maxContar;

    public ContarThread(int maxContar) {
        this.maxContar = maxContar;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxContar; i++) {
            System.out.println(getName() + "; Repetición: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                //
            }
        }
    }

}
