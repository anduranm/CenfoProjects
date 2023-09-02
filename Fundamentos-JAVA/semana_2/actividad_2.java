package semana_2;

import java.io.*;

public class actividad_2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        /*
         * Encontrar la edad de Ana dentro de diez años, si la edad de Ana es dos veces
         * la edad de Elena. El programa recibe como entrada la edad actual de Elena, y
         * debe imprimir la edad de Ana dentro de diez años.
         */

        // declaracion de variables
        int edadAna;
        int edadElena;

        // entrada de datos
        out.print("ingrese la edad de Elena: ");
        edadElena = Integer.parseInt(in.readLine());

        // proceso
        edadAna = (edadElena * 2) + 10;

        // salida
        out.print("La edad de Ana es " + edadAna);
    }
}
