package semana_6.miercoles;

import java.io.*;

public class ejercicio1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Haga un programa que dado un número entero N, imprima todos los números desde
        // N hasta 1

        int N;

        out.println("Numero que desea mostrar en cuenta regresiva: ");
        N = Integer.parseInt(in.readLine());

        while (N >= 1) {
            out.println(N);

            N = N - 1;
        }

    }

}