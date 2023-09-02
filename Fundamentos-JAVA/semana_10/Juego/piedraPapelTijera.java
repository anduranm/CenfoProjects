package semana_10.Juego;

import java.io.*;
import java.util.Random;

public class piedraPapelTijera {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Random r = new Random();
    static String nombreJugador;

    public static String asignarNombre() throws IOException {
        String nombrejugador = "empty";
        out.print("Jugador por favor ingrese su nombre: ");
        nombrejugador = in.readLine();

        nombreJugador = nombrejugador;

        return nombrejugador;
    }

    public static String entradaJugador() throws IOException {
        int opcionJugador = 0;
        String opcionFinalJugador = "empty";
        do {
            out.println("Jugador " + nombreJugador
                    + ":\n  1 Piedra || 2 Papel || 3 Tijera \nSeleccione una de las tres opciones:");
            opcionJugador = Integer.parseInt(in.readLine());
            if (opcionJugador < 1 || opcionJugador > 3) {
                out.println("Opcion invalida.");
            }
        } while (opcionJugador < 1 || opcionJugador > 3);

        switch (opcionJugador) {
            case 1:
                opcionFinalJugador = "Piedra";
                break;
            case 2:
                opcionFinalJugador = "Papel";
                break;
            case 3:
                opcionFinalJugador = "Tijera";
                break;
        }

        return opcionFinalJugador;
    }

    public static String opcionComputadora() {
        int computadora = (r.nextInt(3)) + 1;
        String opcionFinalJugador2 = "";

        switch (computadora) {
            case 1:
                opcionFinalJugador2 = "Piedra";
                break;
            case 2:
                opcionFinalJugador2 = "Papel";
                break;
            case 3:
                opcionFinalJugador2 = "Tijera";
                break;
        }

        return opcionFinalJugador2;
    }

    public static String comparacion(String opcionJugador, String opcionComputadora) {
        String comparacionDeOpciones = opcionJugador + " vs " + opcionComputadora;
        String resultados = "";

        if (comparacionDeOpciones.equals("Piedra vs Piedra")) {
            resultados = "Empate";
        }
        if (comparacionDeOpciones.equals("Tijera vs Tijera")) {
            resultados = "Empate";
        }
        if (comparacionDeOpciones.equals("Papel vs Papel")) {
            resultados = "empate";
        }
        if (comparacionDeOpciones.equals("Piedra vs Tijera")) {
            resultados = "¡Jugador 1 " + nombreJugador + " gana!";
        }
        if (comparacionDeOpciones.equals("Tijera vs Papel")) {
            resultados = "¡Jugador 1 " + nombreJugador + " gana!";
        }
        if (comparacionDeOpciones.equals("Papel vs Piedra")) {
            resultados = "¡Jugador 1 " + nombreJugador + " gana!";
        }
        if (comparacionDeOpciones.equals("Tijera vs Piedra")) {
            resultados = "¡Jugador 2 gana!";
        }
        if (comparacionDeOpciones.equals("Papel vs Tijera")) {
            resultados = "¡Jugador 2 gana!";
        }
        if (comparacionDeOpciones.equals("Piedra vs Papel")) {
            resultados = "¡Jugador 2 gana!";
        }

        return resultados;
    }

    public static void entradaDatos() throws IOException {
        String resultado, entradaJugador, salidaComputadora;
        asignarNombre();
        entradaJugador = entradaJugador();
        salidaComputadora = opcionComputadora();
        resultado = comparacion(entradaJugador, salidaComputadora);

        out.println("Jugador 1 " + nombreJugador + ": " + entradaJugador + "\nJugador 2: " + salidaComputadora
                + "\nResultado: " + resultado);
    }

    public static void main(String[] args) throws IOException {
        entradaDatos();

    }

}