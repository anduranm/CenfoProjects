package semana_10.Juego;

import java.io.*;
import java.util.Random;

public class random {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Random r = new Random();

    public static void numeroAleatorio() {
        int numero;

        numero = (r.nextInt(3)) + 1;

        out.println(numero);
    }

    public static void main(String[] args) throws IOException {
        numeroAleatorio();
    }

}