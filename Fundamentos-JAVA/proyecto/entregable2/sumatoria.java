package proyecto.entregable2;

import java.io.*;

public class sumatoria {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int num = 0, total = 0;

        for (int i = 1; i <= 7; i++) {
            out.println("Digite el numero " + i);
            num = Integer.parseInt(in.readLine());

            total += num;
            num = 0;
        }

        out.println(total);
    }

}