
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Iván Estévez Sabucedo
 */
public class CalculatorThread extends Thread {

    private Socket socket;

    public CalculatorThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream()); //
                 ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream());//
                ) {
            String operacion = flujoEntrada.readUTF().toUpperCase().trim();
            float numero1 = flujoEntrada.readFloat();
            float numero2 = flujoEntrada.readFloat();

            switch (operacion) {
                case "SUMA":
                    flujoSalida.writeDouble(numero1 + numero2);
                    break;
                case "RESTA":
                    flujoSalida.writeDouble(numero1 - numero2);
                    break;
                case "MULTIPLICACION":
                    flujoSalida.writeDouble(numero1 * numero2);
                    break;
                case "DIVISION":
                    if (numero2 == 0) {
                        flujoSalida.writeDouble(Double.NaN);
                    } else {
                        flujoSalida.writeDouble(numero1 / numero2);
                    }
                    break;
                default:
                    flujoSalida.writeDouble(Double.NaN);
                    break;
            }
            
            flujoSalida.flush();

        } catch (IOException ex) {
            System.out.println("Excepción en hilo");
            ex.printStackTrace();
        }

    }

}
