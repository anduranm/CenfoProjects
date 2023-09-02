package semana_8.lunes;

import java.io.*;

public class validacion_do_while {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int cap = 0, dias = 0, cantidadCap = 0;
        char pregunta;

        do {
            out.println("¿Cuántos capítulos leyó hoy?");
            cap = Integer.parseInt(in.readLine());
            out.println("¿Terminó el libro?");
            pregunta = in.readLine().charAt(0);
            dias++;
            cantidadCap = cantidadCap + cap;
        } while (pregunta == 'N' || pregunta == 'n');

        out.println("Felicidades, usted leyó un libro de " + cantidadCap + " capítulos en" + dias + " días.");
    }

}