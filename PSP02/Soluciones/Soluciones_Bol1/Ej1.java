package Ejercicios_Sonia.Bol1;

public class Ej1 extends Thread{
    public void run() {
        System.out.println();
        for (int i = 1; i <= 30; i++)
            System.out.println("NO");
    }
}
class Principal {
    public static void main(String[] args) {
        Ej1 hilo1 = new Ej1();
        hilo1.start();
        System.out.println();
        for (int i = 1; i <= 30; i++)
            System.out.println("YES");

    }
}