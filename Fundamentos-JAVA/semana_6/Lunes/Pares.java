package semana_6.Lunes;

import java.io.*;

public class Pares {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int N, i = 1;
        out.println("Ingrese un número mayor a 1: ");
        N = Integer.parseInt(in.readLine());
        out.println("Los numeros pares entre 1 y " + N + " Son: ");
        while (i <= N) {
            if (i % 2 == 0) {
                out.println(i);
            }
            i += 1;
        }
    }

}