

import java.util.concurrent.Semaphore;

public class Saludo extends Thread {
    private Semaphore sem;
    private int id;

    Saludo(int orden, Semaphore s) {
        this.id = orden;
        this.sem = s;
    }

    public void run() {
        if (id == 1) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hola, soy el thread " + id);
        if (id == 2) {
            sem.release();
        }
    }
}