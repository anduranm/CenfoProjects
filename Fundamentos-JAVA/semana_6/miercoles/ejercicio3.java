package semana_6.miercoles;

import java.io.*;

public class ejercicio3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Haga un programa que dado un número entero N, imprima todos los números que
        // son múltiplos entre 1 y N. Ejemplo: si N = 10.

        int N, i = 1;
        out.println("Digite un numero que desee conocer los multiplos: ");
        N = Integer.parseInt(in.readLine());

        out.println("Los multiplos de " + N + ", entre 1 y " + N + " Son: ");

        while (i <= N) {
            if (N % i == 0) {
                out.println(i);
            }
            i++;
        }
    }

}