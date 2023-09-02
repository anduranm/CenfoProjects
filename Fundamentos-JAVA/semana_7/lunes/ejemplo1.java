package semana_7.lunes;

import java.io.*;

public class ejemplo1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        // Haga un programa que lea uno o varios números enteros, mientras el número
        // dado por el usuario sea un número par. Ejemplos: si los números dados por el
        // usuario son los siguientes, el programa se comporta de esta manera:

        int num = 2;

        while (num % 2 == 0) {
            out.print("Por favor escriba un número entero: ");
            num = Integer.parseInt(in.readLine());
        }
        out.print("Muchas Gracias.");
    }
}