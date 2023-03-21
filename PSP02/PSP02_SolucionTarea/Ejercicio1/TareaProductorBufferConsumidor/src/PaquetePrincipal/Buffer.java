/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrincipal;

/**
 * ****************************************************************************
 * clase que monitoriza el acceso a un buffer de caracteres
 *
 * @author IMCG
 */
class Buffer {

    private boolean bolLLeno = false;
    private boolean bolVacio = true;
    private int intSiguiente = 0;
    //varibale para indicar la posición del buffer
    private char chrBuffer[] = new char[6];
    //buffer de seis caracteres

    /**
     * ************************************************************************
     * método que devuelve el carácter consumido. Se consumen de derecha a
     * izquierda (el último carácter en producirse es el primero en consumirse).
     *
     * @return
     */
    public synchronized void recoger() {

        // mientras el buffer está vacío
        while (bolVacio == true) {
            try {
                //espera
                wait();
            } catch (InterruptedException e) {
                //
            }
        }

        //se decrementa la posición del buffer en 1 para simular que se va a
        //consumir un carácter
        intSiguiente--;

        //si la posición es la 0, es el último que queda por consumir y justo se
        //va a consumir ahora, por lo que el búfer quedará vacío
        if (intSiguiente == 0) {
            //anota buffer vacío
            bolVacio = true;
        }

        //como vamos a consumir un carácter, anotamos no lleno
        bolLLeno = false;

        System.out.println("Recogido el carácter "
                + chrBuffer[intSiguiente] + " del buffer");
        //muestra en consola el carácter consumido. Para comprobar funcionamiento

        notify();
        //notifica que ya ha consumido un carácter

    }

    /**
     * ************************************************************************
     * desposita un carácter en el buffer. El búfer se va llenando de izquierda
     * a derecha. El carácter se deposita en la primera posición libre, que será
     * la última consumida.
     *
     * @param c
     */
    public synchronized void depositar(char c) {

        //mientras el buffer está lleno
        while (bolLLeno == true) {
            try {
                //espera
                wait();
            } catch (InterruptedException e) {
                //
            }
        }

        //deposita el carácter en la última posición consumida
        chrBuffer[intSiguiente] = c;

        //incrementa posición del buffer
        intSiguiente++;

        //si se completó el buffer (la posición ya es la 6)
        if (intSiguiente == 6) {
            //anota buffer lleno
            bolLLeno = true;
        }

        //como hay un nuevo carácter sin consumir, anota buffer no vacío
        bolVacio = false;
        System.out.println("Depositado el carácter "
                + c + " en el buffer");
        //muestra en consola el carácter depositado. Para comprobar funcionamiento

        notify();
        //notifica que se ha depositado un carácter
    }
}
