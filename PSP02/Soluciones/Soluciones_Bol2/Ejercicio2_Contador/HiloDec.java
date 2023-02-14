

public class HiloDec extends Thread{
    private Contador contador;

    HiloDec(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        for (int j = 0; j < 300; j++) {
            contador.decrementa();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getName() + " contador: " + contador.getValor());
    }
}
