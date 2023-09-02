package semana_7.miercoles;

import java.io.*;

public class multiplosfor {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int n;

        out.println("Digite un numero:");
        n = Integer.parseInt(in.readLine());

        out.println("Multipos de " + n + " entre 1 y " + n + " son:");

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                out.println(i);
            }
        }

    }
}