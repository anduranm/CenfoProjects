package tarea3;

import java.io.*;

public class AndresDuranMolina_Tarea3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int nivel = 0, team = -1, beca = -1, tipoBeca = 0, totalEstudiantes; // entradas
        int i = 0, j = 1; // contadores
        int encuesta = 1; // bucles
        int estudiantesSinEquipo = 0,
                estudiantesNivel1 = 0,
                estudiantesNivel2 = 0,
                estudiantesNivel3 = 0,
                estudiantesNivel4 = 0,
                estudiantesNivel5 = 0,
                estudiantesBasket = 0,
                estudiantesNatacion = 0,
                estudiantesAjedrez = 0,
                estudiantesBecados = 0,
                estudiantesSinBecas = 0,
                estudiantesBecaDeportiva = 0,
                estudiantesBecaAcademica = 0; // Registros
        float porcentajeBecados, porcentajeNoBecados; // para los procesos

        out.println("Por favor digite el total de estudiantes:  ");
        totalEstudiantes = Integer.parseInt(in.readLine());

        for (encuesta = 1; encuesta <= totalEstudiantes; encuesta++) {
            out.println("----------------------\nEstudiante número: " + (j) + "\n----------------------");

            while (nivel < 1 || nivel > 5) { // Repetir el ciclo nivel mientras la entrada no sea válida
                out.println("Digite el número a cual nivel pertenece: \n 1 | 2 | 3 | 4 | 5 ");
                nivel = Integer.parseInt(in.readLine());
                if (nivel < 1 || nivel > 5) {
                    System.out.println("\n Número de NIVEL inválido. Intente de nuevo. \n");
                }
            }
            switch (nivel) {
                case 1:
                    estudiantesNivel1++;
                    break;
                case 2:
                    estudiantesNivel2++;
                    break;
                case 3:
                    estudiantesNivel3++;
                    break;
                case 4:
                    estudiantesNivel4++;
                    break;
                case 5:
                    estudiantesNivel5++;
                    break;
            }
            nivel = 0; // reinicio de ciclo Nivel

            while (team < 0 || team > 3) { // Repetir el ciclo team mientras la entrada no sea válida
                out.println(
                        "Digite el numero de opción para formar parte o no de un equipo: \n 0 para Ninguno |  1 para Baloncesto | 2 para Natación | 3 para Ajedrez. ");
                team = Integer.parseInt(in.readLine());
                if (team < 0 || team > 3) {
                    System.out.println("\n Número de TEAM inválido. Intente de nuevo. \n");
                }
            }
            switch (team) {
                case 0:
                    estudiantesSinEquipo++;
                    break;
                case 1:
                    estudiantesBasket++;
                    break;
                case 2:
                    estudiantesNatacion++;
                    break;
                case 3:
                    estudiantesAjedrez++;
                    break;
            }
            team = -1; // reinicio de ciclo Team

            while (beca < 0 || beca > 1) { // Repetir el ciclo sinOconBeca mientras la entrada no sea válida
                out.println("Digite si cuenta con Beca: \n 0 para No | 1 para Si");
                beca = Integer.parseInt(in.readLine());
                if (beca == 1) {
                    while (tipoBeca < 1 || tipoBeca > 2) { // Repetir el ciclo tipoBeca mientras la entrada no sea
                                                           // válida
                        out.println("Digite con cual de las becas cuenta: \n 1 para Académica | 2 para deportiva");
                        tipoBeca = Integer.parseInt(in.readLine());

                        if (tipoBeca < 1 || tipoBeca > 2) {
                            out.println("\n Número de BECA inválido. Intente de nuevo. \n");
                        }
                    }
                    switch (tipoBeca) {
                        case 1:
                            estudiantesBecaDeportiva++;
                            break;
                        case 2:
                            estudiantesBecaAcademica++;
                            break;
                    }
                    tipoBeca = 0; // reinicio del ciclo tipo beca
                }
                if (beca < 0 || beca > 1) {
                    out.println("\n No sabemos si cuenta con Beca. Intente de nuevo. \n");
                }
                switch (beca) {
                    case 0:
                        estudiantesSinBecas++;
                        break;
                    case 1:
                        estudiantesBecados++;
                        break;
                }
            }
            beca = -1; // reinicio del ciclo sinOconBeca
            j = j + 1; // contador de alumnos se suma cada inicio de ciclo
        }
        out.println(
                "\n--------------------------------------\n      Resultados del Análisis \n--------------------------------------");

        // imprimir total becados
        out.println("\nTotal de estudiantes que contestaron la encuesta en cada nivel:\n");
        // Imprimir el numero de estudiantes por nivel
        for (i = 1; i <= 5; i++) {
            out.print("Nivel " + i + ": ");
            switch (i) {
                case 1:
                    out.print(estudiantesNivel1 + "\n");
                    break;
                case 2:
                    out.print(estudiantesNivel2 + "\n");
                    break;
                case 3:
                    out.print(estudiantesNivel3 + "\n");
                    break;
                case 4:
                    out.print(estudiantesNivel4 + "\n");
                    break;
                case 5:
                    out.print(estudiantesNivel5 + "\n");
                    break;
            }
        }

        // imprimir porcentajes de los becados
        porcentajeBecados = (estudiantesBecados * 100) / totalEstudiantes;
        // (double) eso se le llama castin para que el resultado de la división sea un
        // valor decimal o de punto flotante en lugar de un valor entero
        porcentajeNoBecados = (estudiantesSinBecas * 100) / totalEstudiantes;

        out.println("\nPorcentaje de estudiantes becados: " + porcentajeBecados + "%");
        out.println("Porcentaje de estudiantes no becados: " + porcentajeNoBecados + "%\n");

        // El monto total mensual y anual otorgado por becas deportivas, asacadémicas.
        // de 11 meses

        out.print(
                "Monto total mensual por las becas deportivas corresponde a: ¢"
                        + (estudiantesBecaDeportiva * 80000) + "\n");
        out.print("Monto total anual por las becas deportivas corresponde a: ¢"
                + (estudiantesBecaDeportiva * 80000 * 11) + "\n");

        out.print(
                "\nMonto total mensual por las becas academicas corresponde a: ¢"
                        + (estudiantesBecaAcademica * 50000) + "\n");
        out.print(
                "Monto total anual por las becas academicas corresponde a: ¢"
                        + (estudiantesBecaAcademica * 50000 * 11) + "\n");

        // imprimir la cantidad de estudiantes por equipos
        out.println("\nTotal de estudiantes por equipo: \n");
        out.print("Estudiantes que no pertenecen a ningún equipo: " + estudiantesSinEquipo + "\n");
        out.print("Estudiantes que pertenecen a Baloncesto: " + estudiantesBasket + "\n");
        out.print("Estudiantes que pertenecen a Natación: " + estudiantesNatacion + "\n");
        out.print("Estudiantes que Pertenecen a Ajedrez: " + estudiantesAjedrez + "\n");
    }
}