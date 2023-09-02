package semana_3;

import java.io.*;

public class fronteras {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Costa Rica tiene las fronteras cerradas para todas personas que provienen del
        // exterior
        // debido a la pandemia, salvo aquellas cuya nacionalidad es costarricense. El
        // programa
        // recibe como entrada la nacionalidad de la persona.
        String nacionalidad;

        out.print("Cual es su nacionalidad?");
        nacionalidad = in.readLine();

        // if (nacionalidad.equals("costarricense") ||
        // nacionalidad.equals("Costarricense")) {
        // out.print("si puede entrar al pais");
        // } else {
        // out.print("no puede entrar al pais");
        // }
        if (nacionalidad.equalsIgnoreCase("costarricense")) {
            out.print("si puede entrar al pais");
        } else {
            out.print("no puede entrar al pais");
        }

    }

}