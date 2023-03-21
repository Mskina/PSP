/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrincipal;

/**
 * ****************************************************************************
 * hilo que deposita 15 caracteres en el buffer
 *
 * @author IMCG
 */
class Productor extends Thread {

    private Buffer buffer;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * ************************************************************************
     * constructor que recibe el buffer como parámetro
     *
     * @param t
     */
    public Productor(Buffer buf) {
        //
        buffer = buf;
    }

    /**
     * ************************************************************************
     * método que deposita caracteres en el buffer
     */
    @Override
    public void run() {
        char c;

        //deposita quince caracteres aleatorios del alfabeto en el buffer
        for (int i = 0; i < 15; i++) {

            c = alfabeto.charAt((int) (26 * Math.random()));
            buffer.depositar(c);

            try {
                //espera un poco (pero menos que el consumidor) antes de 
                //depositar más caracteres en el buffer
                sleep((int) (100 * Math.random()));
            } catch (InterruptedException e) {
                //
            }
        }
    }
}
