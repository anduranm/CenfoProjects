package semana_3;

import java.io.*;

public class ejercicio7 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int numA, numB;

        out.print("Digite primer valor: ");
        numA = Integer.parseInt(in.readLine());

        out.print("Digite segundo valor: ");
        numB = Integer.parseInt(in.readLine());

        if (numA < numB) {
            out.print("El numero menor es: " + numA);
        } else {
            out.print("El numero menor es:" + numB);
        }
    }

}