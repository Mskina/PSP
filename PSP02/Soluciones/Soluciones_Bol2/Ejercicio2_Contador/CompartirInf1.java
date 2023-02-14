
/**
 *
 * Implementa una clase contador, con un atributo entero y 3 métodos
 * (incrementa, decrementa, y getValor)
 *
 * Definir 2 tipos de hilo (hiloInc, hiloDec), uno para decrementar
 * y otro para incrementar dicho contador (ejecutarán un bucle de X
 * iteraciones, en las que se modifique el valor del contador según
 * corresponda, y a continuación un Thread.sleep), que cuenten con un
 * atributo interno de tipo Contador.
 *
 * En el main, crear 2 hilos, uno de cada clase, que trabajen sobre un
 * mismo objeto Contador.
 *
 * */


public class CompartirInf1 {
    public static void main(String[] args) {
        Contador cont = new Contador(500);
        HiloInc inc = new HiloInc("Incremental", cont);
        HiloDec dec = new HiloDec("Decremental", cont);
        inc.start();
        dec.start();

        try {
            inc.join();
            dec.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(cont.getValor());
    }
}
