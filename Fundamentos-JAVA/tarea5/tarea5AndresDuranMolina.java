package tarea5;

import java.io.*;
import java.util.Random;

public class tarea5AndresDuranMolina {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    // DECLARAMOS VARIABLES ESTATICAS PARA TENER EL ACCESO EN CADA MOMENTO
    static int[] playerShips = new int[20], computerShips = new int[20];
    static boolean[] usedPlayerPositions = new boolean[20], usedComputerPositions = new boolean[20],
            shootPlayer = new boolean[20], shootComputer = new boolean[20]; // Indicará si una
    static int[] shotPlayerPositions = new int[20];
    static int[] shotComputerPositions = new int[20];

    static boolean battleShipsPlaced = false, reposition = true, loopMenu = true;
    static String choiseReposition = "";

    static int firstTime = 0, computerPoints = 0, playerPoints = 0;

    // juego
    public static void playGame() throws IOException {
        // Disparamos los barcos hasta que alguno de los dos jugadores alcance los 10
        // disparos
        for (int i = 1; i <= 10; i++) {
            out.println("Ronda " + i);

            // Turno del jugador
            out.println("Tu turno de disparar:");
            hacerDisparo();

            // Turno del ordenador
            out.println("Turno del ordenador:");
            computerShoot();
        }

        imprimirGanador();

        resetGame();
        imprimirMenu();
    }

    public static void imprimirGanador() {
        String resultadosDePartida = "";
        // Imprimimos los resultados finales
        out.println("¡Fin del juego!");
        out.println("Puntos del jugador: " + playerPoints);
        out.println("Puntos del Computador: " + computerPoints);

        if (playerPoints > computerPoints) {
            resultadosDePartida = "¡Ganaste!";
        } else if (playerPoints < computerPoints) {
            resultadosDePartida = "¡Perdiste!";
        } else {
            resultadosDePartida = ("¡Empate!");
        }
        out.println(resultadosDePartida);
    }

    // fin de implementario
    public static void hacerDisparo() throws IOException {
        int position;
        boolean validPosition;
        do {
            out.print("(1-20) Seleccione la posicion a disparar: ");
            position = Integer.parseInt(in.readLine()) - 1;
            if (position < 0 || position >= 20) {
                out.println("Posicion invalida. Intente de nuevo.");
                validPosition = false;
            } else if (shootPlayer[position]) {
                out.println("Ya has disparado en esta posicion. Intente de nuevo.");
                validPosition = false;
            } else {
                validPosition = true;
                shootPlayer[position] = true;
                shotPlayerPositions[playerPoints] = position;
                playerPoints += computerShips[position];
                if (computerShips[position] != 0) {
                    out.println("¡Acertaste!");
                } else {
                    out.println("¡Agua!");
                }
            }
        } while (!validPosition);
    }

    public static void computerShoot() {
        Random random = new Random();
        int position;
        boolean validPosition;
        do {
            position = random.nextInt(20);
            if (shootComputer[position]) {
                validPosition = false;
            } else {
                validPosition = true;
                shootComputer[position] = true;
                shotComputerPositions[computerPoints] = position;
                computerPoints += playerShips[position];
                if (playerShips[position] != 0) {
                    out.println("El ordenador ha disparado en la posicion " + (position + 1) + " y ha acertado.");
                } else {
                    out.println("El ordenador ha disparado en la posicion " + (position + 1) + " y ha fallado.");
                }
            }
        } while (!validPosition);
    }

    // llenamos posicion de barcos para jugador y para computadora
    public static void inicializarBarcosJugador() throws IOException {
        int numShips = 5;
        int position;
        boolean validPosition;
        for (int i = 0; i < numShips; i++) {
            do {
                out.print("(1-20) Seleccione la posicion de su barco " + (i + 1) + ": ");
                position = Integer.parseInt(in.readLine()) - 1; // se resta 1 para que la posición sea del 0 al 19
                if (position < 0 || position >= 20) {
                    out.println("Posicion invalida. Intente de nuevo.");
                    validPosition = false;
                } else if (usedPlayerPositions[position]) {
                    out.println("Esta posicion ya esta ocupada. Intente de nuevo.");
                    validPosition = false;
                } else {// si llega aqui es porque se lleno
                    validPosition = true;
                    usedPlayerPositions[position] = true;
                    playerShips[position] = i + 1;
                }
            } while (!validPosition);
        }
    }

    public static void inicializarBarcosComputadora() {
        int numShips = 5;
        int position;
        boolean validPosition;
        Random random = new Random();

        for (int i = 0; i < numShips; i++) {
            do {
                position = random.nextInt(20); // genera una posición aleatoria del 0 al 19
                if (usedComputerPositions[position]) {
                    validPosition = false;
                } else {
                    validPosition = true;
                    usedComputerPositions[position] = true;
                    computerShips[position] = i + 1;
                }
            } while (!validPosition);
        }
    }

    // fin de llenado de posicion

    // imprime la posicion de los barcos
    public static void imprimirBarcos() {
        out.println("Barcos del Jugador:");
        for (int i = 0; i < playerShips.length; i++) {
            out.print(playerShips[i] + " ");
        }
        out.println("\nBarcos del computador:");
        for (int i = 0; i < computerShips.length; i++) {
            out.print(computerShips[i] + " ");
        }
        out.println();
    }

    // DECLARAMOS MENU
    public static void imprimirMenu() throws IOException {
        int selecction;
        while (loopMenu) {
            if (firstTime == 0) {
                out.println("BIENVENIDO A BATTLESHIP");
                out.println("Preparate para la batalla, posiciona tus barcos.");
            }
            do {
                out.println("MENU");

                out.println("1. Posiciona los barcos");
                out.println("2. Imprime la posicion de los barcos");
                out.println("3. Jugar");
                out.println("4. Salir \n Seleccione la opcion");

                selecction = Integer.parseInt(in.readLine());
                if (selecction < 1 || selecction > 4) {
                    out.println("Opción invalida");
                }
            } while (selecction < 1 || selecction > 4);

            switch (selecction) {
                case 1:
                    if (reposition == false) {
                        out.println("(Si o No)\nQuieres volver a posicionar los barcos?");
                        choiseReposition = in.readLine();
                        if (choiseReposition.equalsIgnoreCase("si")) {
                            resetShips();
                            reposition = true;
                            inicializarBarcosJugador();
                            inicializarBarcosComputadora();
                            out.println("Posicionados");
                            battleShipsPlaced = true;
                            reposition = false;
                            imprimirMenu();
                        } else if (choiseReposition.equalsIgnoreCase("no")) {
                            imprimirMenu();
                        } else {
                            System.out.println("Respuesta inválida");
                        }
                    }
                    if (reposition == true) {
                        inicializarBarcosJugador();
                        inicializarBarcosComputadora();
                        out.println("Posicionados");
                        battleShipsPlaced = true;
                        firstTime = firstTime + 1;
                        reposition = false;
                        imprimirMenu();
                    }
                    break;

                case 2:
                    if (battleShipsPlaced == false) {
                        out.println("Primero posiciona tus barcos.");
                        firstTime = firstTime + 1;
                        imprimirMenu();
                    } else {
                        imprimirBarcos();
                    }
                    break;
                case 3:
                    if (battleShipsPlaced == false) {
                        out.println("Primero posiciona tus barcos.");
                        firstTime = firstTime + 1;
                        imprimirMenu();
                    } else {
                        playGame();
                    }
                    break;
                case 4:
                    // referencia al mario sunshine porque lo amo
                    out.println("\nAdioos..!");
                    loopMenu = false;
                    break;
            }
        }
    }

    // reset arrays
    public static void resetShips() {
        playerShips = new int[20];
        computerShips = new int[20];
        usedPlayerPositions = new boolean[20];
        usedComputerPositions = new boolean[20];
        shootPlayer = new boolean[20];
        shootComputer = new boolean[20];
    }

    public static void resetGame() {
        // reiniciamos los arreglos de los barcos y las posiciones utilizadas
        playerShips = new int[20];
        computerShips = new int[20];
        usedPlayerPositions = new boolean[20];
        usedComputerPositions = new boolean[20];
        shootPlayer = new boolean[20];
        shootComputer = new boolean[20];
        shotPlayerPositions = new int[20];
        shotComputerPositions = new int[20];

        // reiniciamos las variables booleanas y numéricas
        battleShipsPlaced = false;
        reposition = true;
        choiseReposition = "";
        firstTime = 0;
        computerPoints = 0;
        playerPoints = 0;
    }

    public static void startExe() throws IOException {
        imprimirMenu();
    }

    public static void main(String[] args) throws IOException {
        startExe();
    }
}
