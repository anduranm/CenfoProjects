package proyecto.entregable_1;

import java.io.*;

public class entregable1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        String nombre_equipo = "";
        int numero_equipo;
        double juegosEjecutados, numOponentes, puntajeTotal, puntostodos_partidos;

        out.println("Bienvenidos a los juegos Quidditch");
        out.println("Seleccion de equipos");

        out.println("1. Marryland");
        out.println("2. Texas Hill");
        out.println("3. New York");
        out.println("4. The Warriors");
        out.println("5. The Lost Boys");
        out.println("6. Boom Train");

        out.print("Ingrese el numero su equipo: ");
        numero_equipo = Integer.parseInt(in.readLine());

        out.print("Ingrese el numero de puntos: ");
        puntostodos_partidos = Double.parseDouble(in.readLine());

        out.print("Ingrese el numero de juegos ejecutados: ");
        juegosEjecutados = Double.parseDouble(in.readLine());

        out.print("Ingrese el numero de oponentes: ");
        numOponentes = Double.parseDouble(in.readLine());

        switch (numero_equipo) {
            case 1:
                nombre_equipo = "Maryland";
                break;

            case 2:
                nombre_equipo = "Texas Hill";
                break;

            case 3:
                nombre_equipo = "New York";
                break;

            case 4:
                nombre_equipo = "The Warriors";
                break;

            case 5:
                nombre_equipo = "The Lost Boys";
                break;

            case 6:
                nombre_equipo = "Boom Train";
                break;

            default:
                out.println("Equipo no encontrado");
                break;
        }
        if (juegosEjecutados >= 5) {
            juegosEjecutados = 1;
        } else {
            juegosEjecutados = Math.sqrt(juegosEjecutados) / 2.5;
        }

        if (numOponentes == 1) {
            numOponentes = 1 / 3;
        }
        if (numOponentes == 2) {
            numOponentes = 2 / 3;
        }
        if (numOponentes >= 3) {
            numOponentes = 1;
        }

        puntajeTotal = (puntostodos_partidos + juegosEjecutados + numOponentes);

        if ((numero_equipo == 1) || (numero_equipo == 2) || (numero_equipo == 3) || (numero_equipo == 4)
                || (numero_equipo == 5) || (numero_equipo == 6)) {

            out.print("El puntaje total del equipo " + nombre_equipo + " es: " + puntajeTotal + " puntos ");

        } else {
            out.print("Equipo no encontrado");
        }
    }

}
