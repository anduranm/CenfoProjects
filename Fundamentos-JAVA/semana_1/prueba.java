package semana_1;

import java.io.*;

public class prueba {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        // declaracion de variables
        int N, sumatoria;

        // entrada de datos
        out.print("Ingrese un numero entero positivo: ");
        N = Integer.parseInt(in.readLine());

        // proceso
        sumatoria = (N * (N + 1)) / 2;

        // salida"
        out.println("La sumatoria de 1 hasta " + N + " es: " + sumatoria);
    }
}