package semana_3;

import java.io.*;

public class ejercicio14 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // *Felipe es un programador que debe marcar todos lo días la hora de entrada y
        // la hora de salida. Si Felipe trabajó más de ocho horas, hay que pagarle un
        // costo por hora extra que es igual a 1.5 el monto de la tarifa por hora. Haga
        // un programa que, recibiendo la tarifa por hora, la hora de entrada y la hora
        // de salida, imprima el total de dinero que Felipe recibió en ese día. */

        // Entradas
        double horaEntrada, horaSalida, tarifa, horasExtra, horasTrabajadas, totalDinero;

        out.print("Ingrese la tarifa por hora: ");
        tarifa = Double.parseDouble(in.readLine());

        out.print("Ingrese la hora de entrada: ");
        horaEntrada = Double.parseDouble(in.readLine());

        out.print("Ingrese la hora de salida: ");
        horaSalida = Double.parseDouble(in.readLine());

        // proceso
        horasTrabajadas = horaSalida - horaEntrada;
        horasExtra = horasTrabajadas - 8;
        totalDinero = (tarifa * 8);

        if (horasTrabajadas > 8) {
            totalDinero = (tarifa * 8) + ((horasExtra * tarifa) * 1.5);
        }
        out.print("Su dinero total es de: " + totalDinero);
    }
}