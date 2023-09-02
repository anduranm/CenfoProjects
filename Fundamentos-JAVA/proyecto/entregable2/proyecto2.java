package proyecto.entregable2;

import java.io.*;

public class proyecto2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int numJuegos, puntajeTotal = 0, puntajeEquipoCasa, puntajeOponente;
        String nombreEquipoCasa, nombreEquipoOponente, snitchCasa = "", snitchOponente = "", partidos = "";

        out.print("Equipo: ");
        nombreEquipoCasa = in.readLine();

        do {
            out.print("Número de juegos: ");
            numJuegos = Integer.parseInt(in.readLine());
            if (numJuegos < 0) {
                out.println("Número inválido");
            }
        } while (numJuegos <= 0);

        for (int i = 1; i <= numJuegos; i++) {

            out.print("\nJuego " + i + " contra: ");
            nombreEquipoOponente = in.readLine();

            do {
                out.print("Marcador de " + nombreEquipoCasa + ": ");
                puntajeEquipoCasa = Integer.parseInt(in.readLine());
                if (puntajeEquipoCasa < 0) {
                    out.println("Número inválido");
                }
            } while (puntajeEquipoCasa < 0);

            out.print("Atrapó la snitch: ");
            snitchCasa = in.readLine();
            if (snitchCasa.equalsIgnoreCase("si")) {
                snitchCasa = "*";
            } else if (snitchCasa.equalsIgnoreCase("no")) {
                snitchCasa = "";
            } else {
                out.println("Respuesta inválida");
            }

            do {
                out.print("Marcador de " + nombreEquipoOponente + ": ");
                puntajeOponente = Integer.parseInt(in.readLine());
                if (puntajeOponente < 0) {
                    out.println("Número inválido");
                }
            } while (puntajeOponente < 0);

            out.print("Atrapó la snitch: ");
            snitchOponente = in.readLine();
            if (snitchOponente.equalsIgnoreCase("si")) {
                snitchOponente = "*";
            } else if (snitchOponente.equalsIgnoreCase("no")) {
                snitchOponente = "";
            } else {
                out.println("Respuesta inválida");
            }

            puntajeTotal += puntajeEquipoCasa;

            partidos += "\n" + nombreEquipoCasa + " vs " + nombreEquipoOponente + ": " + puntajeEquipoCasa + snitchCasa
                    + "-"
                    + puntajeOponente + snitchOponente + "\n";
        }

        out.println(partidos);
        out.println("Puntaje total: " + puntajeTotal);
    }

}