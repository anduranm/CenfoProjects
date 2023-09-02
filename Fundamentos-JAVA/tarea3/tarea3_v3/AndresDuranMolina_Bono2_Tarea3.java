package tarea3.tarea3_v3;

import java.io.*;

public class AndresDuranMolina_Bono2_Tarea3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int nivel = 0, team = -1, beca = -1, tipoBeca = 0, totalEstudiantes = 0; // entradas
        int i = 0, a = 1; // contadores
        int encuesta = 1; // bucles
        int estudiantesSinEquipo = 0, estudiantesNivel1 = 0, estudiantesNivel2 = 0, estudiantesNivel3 = 0,
                estudiantesNivel4 = 0, estudiantesNivel5 = 0, estudiantesBasket = 0, estudiantesNatacion = 0,
                estudiantesAjedrez = 0, estudiantesBecados = 0, estudiantesSinBecas = 0, estudiantesBecaDeportiva = 0,
                estudiantesBecaAcademica = 0; // Registros
        float porcentajeBecados, porcentajeNoBecados;
        // año 1
        int estudiantesNivel1Annio1 = 0, estudiantesNivel2Annio1 = 0, estudiantesNivel3Annio1 = 0,
                estudiantesNivel4Annio1 = 0, estudiantesNivel5Annio1 = 0,
                estudiantesBecaDeportivaAnnio1 = 0, estudiantesBecaAcademicaAnnio1 = 0, estudiantesAjedrezAnnio1 = 0,
                estudiantesNatacionAnnio1 = 0,
                estudiantesBasketAnnio1 = 0, estudiantesBecadosAnnio1 = 0, estudiantesSinBecasAnnio1 = 0,
                estudiantesSinEquipoAnnio1 = 0;
        // año 2
        int estudiantesNivel1Annio2 = 0, estudiantesNivel2Annio2 = 0, estudiantesNivel3Annio2 = 0,
                estudiantesNivel4Annio2 = 0,
                estudiantesNivel5Annio2 = 0,
                estudiantesBecaDeportivaAnnio2 = 0, estudiantesBecaAcademicaAnnio2 = 0, estudiantesAjedrezAnnio2 = 0,
                estudiantesNatacionAnnio2 = 0,
                estudiantesBasketAnnio2 = 0, estudiantesBecadosAnnio2 = 0, estudiantesSinBecasAnnio2 = 0,
                estudiantesSinEquipoAnnio2 = 0;
        // año 3
        int estudiantesNivel1Annio3 = 0, estudiantesNivel2Annio3 = 0, estudiantesNivel3Annio3 = 0,
                estudiantesNivel4Annio3 = 0, estudiantesNivel5Annio3 = 0,
                estudiantesBecaDeportivaAnnio3 = 0, estudiantesBecaAcademicaAnnio3 = 0, estudiantesAjedrezAnnio3 = 0,
                estudiantesNatacionAnnio3 = 0,
                estudiantesBasketAnnio3 = 0, estudiantesBecadosAnnio3 = 0, estudiantesSinBecasAnnio3 = 0,
                estudiantesSinEquipoAnnio3 = 0;
        int totalEstudiantesAnnio1 = 0, totalEstudiantesAnnio2 = 0, totalEstudiantesAnnio3 = 0;

        for (a = 1; a <= 3; a++) { // ciclo años

            while (totalEstudiantes <= 0) { // repetir ciclo si el dato no es valido
                out.println(
                        "\n-------------------------------------------------------- \n Por favor digite el total de estudiantes del año "
                                + a + ": \n--------------------------------------------------------\n");
                totalEstudiantes = Integer.parseInt(in.readLine());
                if (totalEstudiantes <= 0) {
                    out.println("Dígito un número de estudiantes inválido. \n");
                }
            }

            for (encuesta = 1; encuesta <= totalEstudiantes; encuesta++) {

                out.println(
                        "--------------------------------------------\nEstudiante de año" + a + "número: " + encuesta
                                + "\n--------------------------------------------");

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

            }

            switch (a) {
                case 1:
                    totalEstudiantesAnnio1 = totalEstudiantes;
                    estudiantesSinEquipoAnnio1 = estudiantesSinEquipo;
                    estudiantesNivel1Annio1 = estudiantesNivel1;
                    estudiantesNivel2Annio1 = estudiantesNivel2;
                    estudiantesNivel3Annio1 = estudiantesNivel3;
                    estudiantesNivel4Annio1 = estudiantesNivel4;
                    estudiantesNivel5Annio1 = estudiantesNivel5;
                    estudiantesBasketAnnio1 = estudiantesBasket;
                    estudiantesNatacionAnnio1 = estudiantesNatacion;
                    estudiantesAjedrezAnnio1 = estudiantesAjedrez;
                    estudiantesBecadosAnnio1 = estudiantesBecados;
                    estudiantesSinBecasAnnio1 = estudiantesSinBecas;
                    estudiantesBecaDeportivaAnnio1 = estudiantesBecaDeportiva;
                    estudiantesBecaAcademicaAnnio1 = estudiantesBecaAcademica;
                    break;
                case 2:
                    totalEstudiantesAnnio2 = totalEstudiantes;
                    estudiantesSinEquipoAnnio2 = estudiantesSinEquipo;
                    estudiantesNivel1Annio2 = estudiantesNivel1;
                    estudiantesNivel2Annio2 = estudiantesNivel2;
                    estudiantesNivel3Annio2 = estudiantesNivel3;
                    estudiantesNivel4Annio2 = estudiantesNivel4;
                    estudiantesNivel5Annio2 = estudiantesNivel5;
                    estudiantesBasketAnnio2 = estudiantesBasket;
                    estudiantesNatacionAnnio2 = estudiantesNatacion;
                    estudiantesAjedrezAnnio2 = estudiantesAjedrez;
                    estudiantesBecadosAnnio2 = estudiantesBecados;
                    estudiantesSinBecas = estudiantesSinBecasAnnio2;
                    estudiantesBecaDeportivaAnnio2 = estudiantesBecaDeportiva;
                    estudiantesBecaAcademicaAnnio2 = estudiantesBecaAcademica;
                    break;
                case 3:
                    estudiantesSinEquipoAnnio3 = totalEstudiantes;
                    estudiantesNivel1Annio3 = estudiantesNivel1;
                    estudiantesNivel2Annio3 = estudiantesNivel2;
                    estudiantesNivel3Annio3 = estudiantesNivel3;
                    estudiantesNivel4Annio3 = estudiantesNivel4;
                    estudiantesNivel5Annio3 = estudiantesNivel5;
                    estudiantesBasketAnnio3 = estudiantesBasket;
                    estudiantesNatacionAnnio3 = estudiantesNatacion;
                    estudiantesAjedrezAnnio3 = estudiantesAjedrez;
                    estudiantesBecadosAnnio3 = estudiantesBecados;
                    estudiantesSinBecasAnnio3 = estudiantesSinBecas;
                    estudiantesBecaDeportivaAnnio3 = estudiantesBecaDeportiva;
                    estudiantesBecaAcademicaAnnio3 = estudiantesBecaAcademica;
                    break;

            }
            totalEstudiantes = 0;
            estudiantesSinEquipo = 0;
            estudiantesNivel1 = 0;
            estudiantesNivel2 = 0;
            estudiantesNivel3 = 0;
            estudiantesNivel4 = 0;
            estudiantesNivel5 = 0;
            estudiantesBasket = 0;
            estudiantesNatacion = 0;
            estudiantesAjedrez = 0;
            estudiantesBecados = 0;
            estudiantesSinBecas = 0;
            estudiantesBecaDeportiva = 0;
            estudiantesBecaAcademica = 0;

        }

        ///// termina ciclo por año
        // salida
        for (a = 1; a <= 3; a++) {
            switch (a) {
                case 1:
                    estudiantesSinEquipo = estudiantesSinEquipoAnnio1;
                    estudiantesNivel1 = estudiantesNivel1Annio1;
                    estudiantesNivel2 = estudiantesNivel2Annio1;
                    estudiantesNivel3 = estudiantesNivel3Annio1;
                    estudiantesNivel4 = estudiantesNivel4Annio1;
                    estudiantesNivel5 = estudiantesNivel5Annio1;
                    estudiantesBasket = estudiantesBasketAnnio1;
                    estudiantesNatacion = estudiantesNatacionAnnio1;
                    estudiantesAjedrez = estudiantesAjedrezAnnio1;
                    estudiantesBecados = estudiantesBecadosAnnio1;
                    estudiantesSinBecas = estudiantesSinBecasAnnio1;
                    estudiantesBecaDeportiva = estudiantesBecaDeportivaAnnio1;
                    estudiantesBecaAcademica = estudiantesBecaAcademicaAnnio1;
                    totalEstudiantes = totalEstudiantesAnnio1;
                    break;
                case 2:
                    estudiantesSinEquipo = estudiantesSinEquipoAnnio2;
                    estudiantesNivel1 = estudiantesNivel1Annio2;
                    estudiantesNivel2 = estudiantesNivel2Annio2;
                    estudiantesNivel3 = estudiantesNivel3Annio2;
                    estudiantesNivel4 = estudiantesNivel4Annio2;
                    estudiantesNivel5 = estudiantesNivel5Annio2;
                    estudiantesBasket = estudiantesBasketAnnio2;
                    estudiantesNatacion = estudiantesNatacionAnnio2;
                    estudiantesAjedrez = estudiantesAjedrezAnnio2;
                    estudiantesBecados = estudiantesBecadosAnnio2;
                    estudiantesSinBecasAnnio2 = estudiantesSinBecas;
                    estudiantesBecaDeportiva = estudiantesBecaDeportivaAnnio2;
                    estudiantesBecaAcademica = estudiantesBecaAcademicaAnnio2;
                    totalEstudiantes = totalEstudiantesAnnio2;
                    break;
                case 3:
                    estudiantesSinEquipo = estudiantesSinEquipoAnnio3;
                    estudiantesNivel1 = estudiantesNivel1Annio3;
                    estudiantesNivel2 = estudiantesNivel2Annio3;
                    estudiantesNivel3 = estudiantesNivel3Annio3;
                    estudiantesNivel4 = estudiantesNivel4Annio3;
                    estudiantesNivel5 = estudiantesNivel5Annio3;
                    estudiantesBasket = estudiantesBasketAnnio3;
                    estudiantesNatacion = estudiantesNatacionAnnio3;
                    estudiantesAjedrez = estudiantesAjedrezAnnio3;
                    estudiantesBecados = estudiantesBecadosAnnio3;
                    estudiantesSinBecas = estudiantesSinBecasAnnio3;
                    estudiantesBecaDeportiva = estudiantesBecaDeportivaAnnio3;
                    estudiantesBecaAcademica = estudiantesBecaAcademicaAnnio3;
                    totalEstudiantes = totalEstudiantesAnnio3;

                    break;
            }

            out.println(
                    "\n--------------------------------------------\n      Resultados del Análisis del año " + a
                            + "\n-------------------------------------------");

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
            // (double) eso se le llama castin para que el resultado de la división sea
            // un
            // valor decimal o de punto flotante en lugar de un valor entero
            porcentajeNoBecados = (estudiantesSinBecas * 100) / totalEstudiantes;

            out.println("\nPorcentaje de estudiantes becados: " + porcentajeBecados +
                    "%");
            out.println("Porcentaje de estudiantes no becados: " + porcentajeNoBecados +
                    "%\n");

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
            out.print("Estudiantes que no pertenecen a ningún equipo: " +
                    estudiantesSinEquipo + "\n");
            out.print("Estudiantes que pertenecen a Baloncesto: " + estudiantesBasket +
                    "\n");
            out.print("Estudiantes que pertenecen a Natación: " + estudiantesNatacion +
                    "\n");
            out.print("Estudiantes que Pertenecen a Ajedrez: " + estudiantesAjedrez +
                    "\n");
        }

    }
}