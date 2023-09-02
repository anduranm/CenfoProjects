package semana_7.miercoles;

import java.io.*;

public class capitulos {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int cap = 0, dias = 0, cantidadCap = 0;
        char pregunta = 'N';

        while (pregunta == 'N' || pregunta == 'n') {
            out.println("¿Cuántos capítulos leyó hoy?");
            cap = Integer.parseInt(in.readLine());
            out.println("¿Terminó el libro?");
            pregunta = in.readLine().charAt(0);
            dias++;
            cantidadCap = cantidadCap + cap;
        }
        out.println("Felicidades, usted leyó un libro de " + cantidadCap + " capítulos en" + dias + " días.");
    }

}