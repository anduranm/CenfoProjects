package semana_2;

import java.io.*;

public class actividad_3 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        /*
         * Encontrar la edad de la abuela de Ana a hoy, si es 7 años menor que el abuelo
         * de Ana, y en
         * el año del matrimonio, el abuelo tenía 25 años. El programa recibe como
         * entrada el año del matrimonio.
         */
        // declaracion de variantes
        int anio_matrimonio, edad_abuela;
        // datos de entrada
        out.println("ingrese anio matrimonio");
        anio_matrimonio = Integer.parseInt(in.readLine());
        // proceso
        edad_abuela = (2023 - anio_matrimonio) + (25 - 7);
        // salida
        out.println("la edad de la abuela de ana es: " + edad_abuela);
    }
}
