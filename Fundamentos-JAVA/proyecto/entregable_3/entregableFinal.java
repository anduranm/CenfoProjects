package proyecto.entregable_3;

import java.io.*;

public class entregableFinal {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void menu() throws IOException {
        int opcion, totalEquipos = 0, firstTime = 0; // Se define la variable y se asigna un valor predeterminado
        double[] numJuegos = null, numOponentes = null, resultadoPuntajeTotal = null;
        String[] equipos = null, puntajeEquiposParaImprimir = null,
                reporteDeResultadosFinal = null;
        double promedioDeOponentes = 0;
        String maxJugados, resultadoMinPts, equipos5oMasJuegos, EquiposConMasDePromedio, equipoContrario;
        boolean salir = false, case1 = false, case2 = false, case3 = false, case6 = false,
                contrarioAtrapoSnitch = false, verficarSnitch = false, atrapoSnitch = false;
        double puntajeTotalPorEquipo = 0, resultadoEquipo, resultadoEquipoContrario;

        do {

            opcion = menuOpciones(firstTime);
            firstTime++;
            switch (opcion) {
                case 1:
                    totalEquipos = inicializarEquipos();
                    numJuegos = new double[totalEquipos];
                    numOponentes = new double[totalEquipos];
                    equipos = new String[totalEquipos];
                    out.println("\n---------Establecido---------");
                    case1 = true;
                    break;
                case 2:
                    if (case1) {
                        for (int i = 0; i < totalEquipos; i++) {
                            equipos[i] = registrarNombreEquipos(totalEquipos, i);
                            numJuegos[i] = (double) registrarNumJuegos(totalEquipos, equipos, i);
                            numOponentes[i] = (double) registrarNumOponentes(totalEquipos, equipos, i);
                        }
                        case2 = true;
                        out.println("\n---------Información registrada correctamente---------");
                    } else {
                        out.println("\n---------Ingrese primero la cantidad de equipos---------");
                    }
                    break;
                case 3:
                    if (case2) {
                        reporteDeResultadosFinal = new String[totalEquipos];
                        resultadoPuntajeTotal = new double[totalEquipos];
                        puntajeEquiposParaImprimir = new String[totalEquipos];

                        for (int i = 0; i < totalEquipos; i++) { // por cada equipo
                            puntajeTotalPorEquipo = 0;
                            // declarar una variable para acumular los puntos del equipo actual
                            for (int v = 0; v < numJuegos[i]; v++) { // por cada partido
                                verficarSnitch = false;
                                contrarioAtrapoSnitch = false;
                                out.println(
                                        "\n-------------------------------------------------\nDigite los puntos del equipo "
                                                + equipos[i] + ": ");
                                resultadoEquipo = Double.parseDouble(in.readLine()); // pedir el puntaje del
                                                                                     // equipo actual
                                atrapoSnitch = false; // pedir si atrapo la snitch
                                do {
                                    out.println("Atrapó la snitch: ");
                                    String snitchCasa = in.readLine();
                                    if (snitchCasa.equalsIgnoreCase("si")) {
                                        atrapoSnitch = true;
                                        verficarSnitch = true;
                                    } else if (snitchCasa.equalsIgnoreCase("no")) {
                                        atrapoSnitch = false;
                                        verficarSnitch = true;
                                    } else {
                                        out.println("Respuesta inválida");
                                    }
                                } while (!verficarSnitch);
                                out.println("Nombre del equipo contrario: ");
                                equipoContrario = in.readLine(); // nombre del equipo contrario
                                out.println("Puntaje del equipo contrario: ");
                                resultadoEquipoContrario = Double.parseDouble(in.readLine()); // puntaje del
                                                                                              // contrario
                                if (!atrapoSnitch) {
                                    contrarioAtrapoSnitch = true;
                                }

                                if (atrapoSnitch) {
                                    puntajeTotalPorEquipo += 30;
                                }
                                puntajeTotalPorEquipo += resultadoEquipo;

                                reporteDeResultadosFinal[i] = reporteDeResultados(reporteDeResultadosFinal[i],
                                        equipos[i], resultadoEquipo, atrapoSnitch, equipoContrario,
                                        resultadoEquipoContrario, contrarioAtrapoSnitch);

                            }
                            resultadoPuntajeTotal[i] = calcularPuntajeTotal(puntajeTotalPorEquipo, numJuegos[i],
                                    numOponentes[i]);
                            puntajeEquiposParaImprimir[i] = "El equipo " + equipos[i] + " tiene un puntaje de "
                                    + resultadoPuntajeTotal[i] + ".";

                        }
                        case3 = true;

                        out.println("\n---------Reporte Generado---------");
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }
                    break;
                case 4:
                    if (case2) {
                        if (case3) {
                            for (int i = 0; i < totalEquipos; i++) {
                                out.println(equipos[i] + ":" + reporteDeResultadosFinal[i]);
                            }
                        } else {
                            out.println("\n---------Genere primero el reporte en la opcion 3---------");
                        }
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }
                    break;
                case 5:
                    if (case2) {
                        if (case3) {

                            for (int i = 0; i < totalEquipos; i++) {

                                out.println(puntajeEquiposParaImprimir[i]);
                            }

                        } else {
                            out.println("\n---------Genere primero el reporte en la opcion 3---------");
                        }
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }

                    break;
                case 6:
                    if (case2) {
                        promedioDeOponentes = calcularPromedioOponentes(numOponentes, numJuegos);
                        out.println("El promedio de los oponentes es: " + promedioDeOponentes);
                        case6 = true;
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }
                    break;
                case 7:
                    if (case3) {
                        maxJugados = encontrarEquipoConMasPuntos(equipos, numOponentes);
                        out.println(maxJugados);
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }
                    break;
                case 8:
                    if (case2) {
                        if (case3) {
                            resultadoMinPts = calcularEquipoMinPuntaje(equipos, resultadoPuntajeTotal);
                            out.println(resultadoMinPts);
                        } else {
                            out.println("\n---------Genere primero el reporte en la opcion 3---------");
                        }
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }

                    break;
                case 9:
                    if (case2) {
                        equipos5oMasJuegos = calcularMasDe5Juegos(equipos, numJuegos);
                        out.println(equipos5oMasJuegos);
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }
                    break;
                case 10:
                    if (case2) {
                        if (case6) {
                            EquiposConMasDePromedio = calcularMasDePromedio(equipos, numOponentes, promedioDeOponentes);
                            out.println(EquiposConMasDePromedio);
                        } else {
                            out.println("\n---------Genere primero el reporte de promedio---------");
                        }
                    } else {
                        if (!case1) {
                            out.println("\n---------Ingrese primero la cantidad de equipos---------");
                        }
                        if (!case2) {
                            out.println("\n---------Registre la informacion de los equipos---------");
                        }
                    }
                    break;
                case 11:
                    salir = true;
                    out.println("Adios..!");
                    break;
            }

        } while (!salir);
    }

    public static String reporteDeResultados(String reporteDeResultadosFinal, String nombreEquipo,
            double resultadoEquipo,
            boolean atrapoSnitch, String equipoContrario, double resultadoEquipoContrario,
            boolean contrarioAtrapoSnitch) {
        String reporte = "";
        String valorAnterior = "";
        String snitchCasa = "", snitchOponente = "";
        if (atrapoSnitch) {
            snitchCasa = "*";
            snitchOponente = "";
        } else {
            snitchCasa = "";
            snitchOponente = "*";
        }
        if (reporteDeResultadosFinal != null) {
            valorAnterior = reporteDeResultadosFinal;
        }

        reporte = valorAnterior + "\n" + nombreEquipo + " vs " + equipoContrario + ": " + resultadoEquipo
                + snitchCasa
                + "-"
                + resultadoEquipoContrario + snitchOponente + "\n";

        return reporte;
    }

    public static double calcularPuntajeTotal(double puntajeTotalPorEquipo, double numJuegos,
            double numOponentes)
            throws IOException {
        double puntajeMAx = 0;
        puntajeMAx = puntajeTotalPorEquipo;
        if (numJuegos >= 5) {
            numJuegos = 1;
        } else {
            numJuegos = Math.sqrt(numJuegos) / 2.5;
        }

        if (numOponentes == 0) {
            numOponentes = 0.33;
        } else if (numOponentes == 1) {
            numOponentes = 0.33;
        } else if (numOponentes == 2) {
            numOponentes = 0.67;
        } else {
            numOponentes = 1;
        }

        puntajeMAx = (puntajeTotalPorEquipo + numJuegos + numOponentes);

        return puntajeMAx;
    }

    public static String calcularMasDePromedio(String[] equipos, double[] numOponentes, double promedioDeOponentes) {
        String equiposConMasOponentesQuePromedio = "";
        int count = 0;
        for (int i = 0; i < equipos.length; i++) {
            if (numOponentes[i] > promedioDeOponentes) {
                equiposConMasOponentesQuePromedio += equipos[i] + ", ";
                count++;
            }
        }
        if (count == 0) {
            return "No hubo equipos que tuvieron más oponentes que el promedio";
        } else {
            equiposConMasOponentesQuePromedio = equiposConMasOponentesQuePromedio.substring(0,
                    equiposConMasOponentesQuePromedio.length() - 2);
            return "Los equipos que tuvieron más oponentes que el promedio fueron: "
                    + equiposConMasOponentesQuePromedio;
        }
    }

    public static String calcularMasDe5Juegos(String[] equipos, double[] numJuegos) {
        String equiposConMasDe5Juegos = "Los equipos con 5 o más juegos fueron: ";
        boolean hayEquiposConMasDe5Juegos = false;
        for (int i = 0; i < equipos.length; i++) {
            if (numJuegos[i] >= 5) {
                equiposConMasDe5Juegos += equipos[i] + ", ";
                hayEquiposConMasDe5Juegos = true;
            }
        }
        if (!hayEquiposConMasDe5Juegos) {
            equiposConMasDe5Juegos = "No hay equipos con 5 o más juegos.";
        } else {
            // Eliminar la última coma y espacio en la cadena resultante
            equiposConMasDe5Juegos = equiposConMasDe5Juegos.substring(0, equiposConMasDe5Juegos.length() - 2);
        }
        return equiposConMasDe5Juegos;
    }

    public static String encontrarEquipoConMasPuntos(String[] equipos, double[] resultadoPuntajeTotal) {
        double maxPuntos = Double.NEGATIVE_INFINITY;
        String equipoMaxPuntos = "";

        for (int i = 0; i < resultadoPuntajeTotal.length; i++) {
            if (resultadoPuntajeTotal[i] > maxPuntos) {
                maxPuntos = resultadoPuntajeTotal[i];
                equipoMaxPuntos = equipos[i];
            }
        }

        String resultado = "El equipo con más puntos fue " + equipoMaxPuntos + " con un total de " + maxPuntos
                + " Puntos.";
        return resultado;
    }

    public static double calcularPromedioOponentes(double[] numOponentes, double[] numJuegos) {
        int suma = 0;
        for (int i = 0; i < numOponentes.length; i++) {
            suma += numOponentes[i];
        }
        double promedio = (double) suma / numOponentes.length;
        return promedio;
    }

    public static String calcularEquipoMinPuntaje(String[] equipos, double[] resultadoPuntajeTotal) {
        String elEquipoConMenorPuntaje = equipos[0];
        double menorPuntaje = resultadoPuntajeTotal[0];
        for (int i = 1; i < equipos.length; i++) {
            if (resultadoPuntajeTotal[i] < menorPuntaje) {
                menorPuntaje = resultadoPuntajeTotal[i];
                elEquipoConMenorPuntaje = equipos[i];
            }
        }
        return "El equipo con menor puntaje fue " + elEquipoConMenorPuntaje + " con un total de " + menorPuntaje;
    }

    public static int inicializarEquipos() throws IOException {
        int totalEquipos;
        out.print("Ingrese el número de equipos del torneo: ");
        totalEquipos = Integer.parseInt(in.readLine());
        return totalEquipos;
    }

    public static String registrarNombreEquipos(int totalEquipos, int i)
            throws IOException {
        String equipo = "";
        out.println("\nIngrese el nombre del equipo #" + (i + 1) + ":");
        equipo = in.readLine();
        return equipo;
    }

    public static int registrarNumJuegos(int totalEquipos, String[] equipos, int i)
            throws IOException {
        int numJuegos = 0;
        out.println("Ingrese el número de juegos jugados por " + equipos[i] + ":");
        numJuegos = Integer.parseInt(in.readLine());
        return numJuegos;
    }

    public static int registrarNumOponentes(int totalEquipos, String[] equipos, int i) throws IOException {
        int numOponentes = 0;
        boolean cantidadValida = false;
        do {
            out.println("Ingrese el número de oponentes diferentes que ha enfrentado " + equipos[i] + ":");
            numOponentes = Integer.parseInt(in.readLine());
            if (numOponentes > totalEquipos - 1) { // se resta uno para excluir el equipo mismo
                out.println("Error: la cantidad de oponentes no puede ser mayor que el total de equipos.");
            } else {
                cantidadValida = true;
            }
        } while (!cantidadValida);
        return numOponentes;
    }

    public static int menuOpciones(int firstTime) throws IOException {
        int opcion;

        do {
            if (firstTime == 0) {
                out.println("\nBienvenido a el generador de reportes de Quiditch champions game");
            }
            out.println("\n---- MENU DE OPCIONES ----\n");
            out.println("1.Ingresar cantidad de equipos");
            out.println("2.Registrar la información");
            out.println("3.Hacer reporte de resultados");
            out.println("4.Imprimir el reporte");
            out.println("5.Imprimir el puntaje total de cada uno de los equipos");
            out.println("6.Calcular el promedio de oponentes");
            out.println("7.Imprimir el nombre del equipo que ha jugado más partidos");
            out.println("8.Imprimir el nombre del equipo que con menor puntaje");
            out.println("9.Imprimir los nombres de los equipos que han jugado 5 partidos o más");
            out.println("10.Imprimir el nombre de los equipos que tengan más oponentes");
            out.println("11. Salir");
            out.println("Ingrese una opcion: ");
            opcion = Integer.parseInt(in.readLine());
            if (opcion <= 0 || opcion >= 12) {
                out.println("\n---------Opción inválida---------");
            }
        } while (opcion <= 0 || opcion >= 12);

        return opcion;
    }

    public static void main(String[] args) throws IOException {
        menu();
    }
}