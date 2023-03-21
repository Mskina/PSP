/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrincipal;

/**
 * ****************************************************************************
 * hilo que consume caracteres del buffer. La tarea de este hilo será consumir
 * 15 caracteres del búfer.
 *
 * @author IMCG
 */
class Consumidor extends Thread {

    private Buffer buffer;

    /**
     * ************************************************************************
     * constructor que recibe el buffer como parámetro
     *
     * @param t
     */
    public Consumidor(Buffer buf) {
        //
        buffer = buf;
    }

    /**
     * ************************************************************************
     * método que consume caracteres del buffer
     *
     */
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {

        //consume quince caracteres del buffer
        for (int i = 0; i < 15; i++) {
            buffer.recoger();

            try {
                //espera un poco antes de recoger más caracteres
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                //
            }
        }
    }
}
