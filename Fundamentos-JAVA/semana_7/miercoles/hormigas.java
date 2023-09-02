package semana_7.miercoles;

import java.io.*;

public class hormigas {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int numeroMeses;
        double cantidadHormigas;

        out.println("Ingrese el numero de hormigas");
        cantidadHormigas = Double.parseDouble(in.readLine());

        out.println("Ingrese la cantidad de meses");
        numeroMeses = Integer.parseInt(in.readLine());

        for (int i = 1; i <= numeroMeses; i++) {
            if (cantidadHormigas > 28000) {
                cantidadHormigas = cantidadHormigas * 1.31;
            } else {
                cantidadHormigas = cantidadHormigas * 1.40;
            }
            if (cantidadHormigas <= 7000) {
                cantidadHormigas = 0;
            } else {
                cantidadHormigas = cantidadHormigas - 7000;
            }

        }
        out.println(
                "La cantidad de hormigas que quedan al pasar  " + numeroMeses + " meses es " + cantidadHormigas
                        + ".");
    }

}
