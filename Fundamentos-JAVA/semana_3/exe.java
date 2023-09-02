package semana_3;

import java.io.*;

public class exe {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int num;

        out.print("Ingrese un numero entero: ");
        num = Integer.parseInt(in.readLine());

        if (num < 0) {
            num = -1 * num;
        }

        out.print("El valor absoluto es de: " + num);
    }

}
