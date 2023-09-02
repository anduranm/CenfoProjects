package semana_3;

import java.io.*;

public class ejercicio12 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Hugo, Paco y Luis son tres hermanos a los que les gusta jugar al fútbol. Como
        // Hugo es el mayor, él debe jugar contra Paco y Luis. Haga un programa que
        // reciba la cantidad de goles que anotó Hugo, la cantidad de goles que anotó
        // Paco y la cantidad que anotó Luis, e indique cuál equipo de los dos equipos
        // ganó.
        int cantidad_goles_hugo, cantidad_goles_paco, cantidad_goles_luis, equipo_luis_paco;

        out.println("Cantidad de goles anotados por Hugo: ");
        cantidad_goles_hugo = Integer.parseInt(in.readLine());
        out.println("Cantidad de goles anotados por Paco: ");
        cantidad_goles_paco = Integer.parseInt(in.readLine());
        out.println("Cantidad de goles anotados por luis: ");
        cantidad_goles_luis = Integer.parseInt(in.readLine());

        // proceso
        equipo_luis_paco = cantidad_goles_luis + cantidad_goles_paco;

        if (equipo_luis_paco > cantidad_goles_hugo) {
            out.print("El equipo ganador es el equipo luis y paco");

        } else {
            out.println("El equipo ganador es el de Hugo: ");
        }

    }

}