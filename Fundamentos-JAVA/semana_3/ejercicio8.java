package semana_3;

import java.io.*;

public class ejercicio8 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Calcule la nota final de un estudiante para un curso de fundamentos de
        // programación. La rúbrica de evaluación del curso determina que hay solamente
        // tres exámenes y que la nota del curso se calcula por medio de un promedio
        // simple (la suma de las notas de los tres exámenes dividido entre tres).
        // El estudiante aprueba si el promedio es igual o mayor a 70.
        float primer_nota, segunda_nota, tercera_nota, promedio;

        out.println("ingrese su primer nota");
        primer_nota = Float.parseFloat(in.readLine());
        out.println("ingrese su segunda nota");
        segunda_nota = Float.parseFloat(in.readLine());
        out.println("ingrese su tercer nota");
        tercera_nota = Float.parseFloat(in.readLine());

        promedio = (primer_nota + segunda_nota + tercera_nota) / 3;

        if (promedio >= 70) {
            out.println("usted aprobo el curso: ");
        }
        out.println("su promedio final es de: " + promedio);

    }

}