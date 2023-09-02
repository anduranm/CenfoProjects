package semana_2;

import java.io.*;

public class actividad {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        float kilometroInical, kilometroFinal, resultado;

        out.print("Ingrese el kilometro inical: ");
        kilometroInical = Float.parseFloat(in.readLine());

        out.print("Ingrese el kilometro final: ");
        kilometroFinal = Float.parseFloat(in.readLine());

        resultado = kilometroFinal - kilometroInical;

        out.println("Kilometro recorrido: " + resultado);

    }
}
