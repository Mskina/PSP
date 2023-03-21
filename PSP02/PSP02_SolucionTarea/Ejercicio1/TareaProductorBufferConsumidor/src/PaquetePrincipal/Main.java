/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaquetePrincipal;

/**
 * ****************************************************************************
 * aplicación que crea un hilo productor que almacena datos en un buffer
 * compartido, de donde los recoge un hilo consumidor. La capacidad del buffer
 * es de 6 caracteres, de manera que el consumidor podrá estar cogiendo
 * caractéres del búfer siempre que éste no esté vacío. El productor sólo podrá
 * poner caracteres en el búfer, cuando esté vacio o haya espacio.
 *
 * @author IMCG
 */
public class Main {

    /**
     * ************************************************************************
     * método que inicia la aplicación
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //crea el buffer
        Buffer buffer = new Buffer();

        //crea los hilos productor y consumidor
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        //inicia los hilos
        productor.start();
        consumidor.start();
    }
}
