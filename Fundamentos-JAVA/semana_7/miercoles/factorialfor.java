package semana_7.miercoles;

import java.io.*;

public class factorialfor {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int N, factorial = 1;

        out.println("Ingrese un valor para determinar el factorial: ");
        N = Integer.parseInt(in.readLine());

        for (int i = 1; i <= N; i++) {
            factorial = factorial * i;
        }
        out.println("El factorial de " + N + " es: " + factorial);
    }

}