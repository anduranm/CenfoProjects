package semana_3;

import java.io.*;

public class voto {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int anios;

        out.print("Ingrese su edad: ");
        anios = Integer.parseInt(in.readLine());

        if (anios >= 18) {
            out.print("Usted puede votar");
        }
    }

}