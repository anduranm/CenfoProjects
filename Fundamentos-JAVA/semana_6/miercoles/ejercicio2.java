package semana_6.miercoles;

import java.io.*;

public class ejercicio2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        // Se quiere calcular el factorialde un número entero N, que se define de la
        // siguiente manera: n ! = 1 * 2 * 3* 4 * 5 … * n. n ! : se lee n factorial.
        // •Ejemplo: si N = 5, se calcula: 5 ! = 1 * 2 * 3 * 4 * 5 = 120
        int N, i = 1, factorial = 1;
        out.println("Ingrese un valor para determinar el factorial: ");
        N = Integer.parseInt(in.readLine());

        while (i <= N) {
            factorial = factorial * i;
            i = i + 1;
        }
        out.println("El factorial de " + N + " es: " + factorial);

    }
}
