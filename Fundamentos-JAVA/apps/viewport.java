package apps;

import java.io.*;

public class viewport {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int tamañoMaximoPantalla, contador = 0, ciclo = 1, exit = -1;
        double pixel, totalmulti, total;

        while (ciclo == 1) {
            out.println("\nOperacion numero " + (contador + 1) + "\n" + "\nDigite la cantidad de pixeles:");
            pixel = Integer.parseInt(in.readLine());

            totalmulti = pixel * 100;

            out.println("\nDigite la proporcion maxima de diseño de pantalla\n");
            tamañoMaximoPantalla = Integer.parseInt(in.readLine());

            total = totalmulti / tamañoMaximoPantalla;

            out.println("\n Es   " + total + "vw\n");

            while (exit < 0 || exit > 1) { // Repetir el ciclo nivel mientras la entrada no sea válida
                out.println("\n¿Terminó? | No = 0  Si = 1 ?\n");
                exit = Integer.parseInt(in.readLine());
                if (exit < 0 || exit > 1) {
                    System.out.println("\n Número de NIVEL inválido. Intente de nuevo. \n");
                }
                if (exit == 1) {
                    ciclo--;
                }
                if (exit == 0) {
                    exit++;
                }
            }
            exit = -1;
        }
    }
}