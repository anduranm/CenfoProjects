package semana_3;

import java.io.*;

public class curso {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        double nota;

        out.print("ingrese la nota: ");
        nota = Double.parseDouble(in.readLine());

        if (nota >= 70) {
            out.print("El estudiante logro aprobar");
        } else {
            out.print("El estudiante reprobo");
        }

    }

}