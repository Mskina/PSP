

/**
 * Crear una clase Cuenta, con un atributo saldo y 3 métodos:
 * * Uno que devuelva el importe del saldo
 * * Otro resta al saldo el importe a retirar de la cuenta (modifica el saldo)
 * * Otro que realice las comprobaciones para verificar que se puede efectuar la retirada (el importe final debe ser 0 o superior), enviando en caso contrario el aviso correspondiente.
 *
 * Posteriormente, crear otra clase denominada RetiradaDeCajero, que extienda de Thread. Cada hilo que se cree de esta clase, recibirá un nombre concreto al ser creado, y trabajará
 * sobre un objeto Cuenta. Dentro de su método run(), se intentará realizar un número X de retiradas.
 *
 * En el main, crear 2 hilos, uno para cada titular de la cuenta (Pepe, María).
 *
 * Observaciones: el objeto Cuenta, será compartido por varios hilos.
 *
 * */

public class Principal {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(100);
        RetiradaDeCajero ana = new RetiradaDeCajero("Maria", c);
        RetiradaDeCajero pepe = new RetiradaDeCajero("Pepe", c);

        pepe.start();
        ana.start();
    }
}
