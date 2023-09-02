package semana_3;

import java.io.*;

public class ejercicio5 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Definir si una persona debe pagar impuesto al valor agregado por su consumo
        // mensual de
        // electricidad. El programa recibe el consumo mensual de la persona. Se deduce
        // un
        // impuesto del 13% si el consumo es mayor a 200 kWh.
        int consumo_mensual;

        out.print("Ingrese su consumo mensual ");
        consumo_mensual = Integer.parseInt(in.readLine());

        if (consumo_mensual > 200) {

            out.println("Usted debe de pagar impuesto");

        }

    }

}