package semana_8.lunes;

import java.io.*;

public class numeroPar {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int numero;

        do {
            out.println("Ingrese un numero entero:");
            numero = Integer.parseInt(in.readLine());
        } while (numero % 2 == 0);
        out.println("Muchas gracias.");
    }

}