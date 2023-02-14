package Actividades.actividad2_8;

class Saldo {
	private int saldo;

	Saldo(int saldo) {
		this.saldo = saldo;

	}

	public int getSaldo() {
		try {
			Thread.sleep((long) (Math.random() * 40 + 1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
		try {
			Thread.sleep((long) (Math.random() * 40 + 1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized void insertaSaldo(int cantidad, String nombre) {
		int actual = getSaldo();
		System.out.printf("%s Deposita %d, El saldo actual es: %d %n", nombre, cantidad, actual);
		setSaldo(actual + cantidad);
		System.out.printf("%s El nuevo saldo es: %d  %n", nombre, getSaldo());
	}

}// Saldo

// hilo
class HiloDepositarSaldo extends Thread {
	Saldo saldo;
	int cantidaddeDeposito;
	String nombre;

	HiloDepositarSaldo(Saldo saldo, int cantidad, String nombre) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.cantidaddeDeposito = cantidad;
	}

	public void run() {
		saldo.insertaSaldo(cantidaddeDeposito, nombre);

	}
}// hilo

public class Ejercicio3_Saldo {
	public static void main(String[] args) {
		Saldo saldo = new Saldo(1000);
		System.out.println("***** Saldo Inicial: " + saldo.getSaldo());

		HiloDepositarSaldo UNO, DOS, TRES, CUATRO;
		UNO = new HiloDepositarSaldo(saldo, 1000, "#1");
		DOS = new HiloDepositarSaldo(saldo, 1000, "\t#2");
		TRES = new HiloDepositarSaldo(saldo, 1000, "\t\t#3");
		CUATRO = new HiloDepositarSaldo(saldo, 1000, "\t\t\t#4");

		UNO.start();
		DOS.start();
		TRES.start();
		CUATRO.start();
		try {
			UNO.join();
			DOS.join();
			TRES.join();
			CUATRO.join();

		} catch (InterruptedException e) {
		}

		System.out.println("***** Saldo Final: " + saldo.getSaldo());

	}// main

}

