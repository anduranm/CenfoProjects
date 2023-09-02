package semana_6.miercoles;

import java.io.*;

public class ejercicio4 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Haga un programa que reciba como entrada la cantidad de exámenes realizados
        // por un estudiante en un curso, y debe calcular la nota del curso que se
        // obtiene del promedio de todos los exámenes. El programa deberá determinar
        // además, si el estudiante aprobó, debe ir a ampliación o reprobó el curso. Un
        // estudiante aprueba el curso si su nota es mayor o igual a 70, debe hacer
        // ampliación si su nota es inferior a 70 pero superior o igual a 60, o reprueba
        // el curso si la nota es menor que 60.

        int i = 1, promedio, cantExamenes, notas, sumaNotasExamenes = 0;

        out.println("Ingrese la cantidad de Examenes");
        cantExamenes = Integer.parseInt(in.readLine());

        while (i <= cantExamenes) {

            out.println("Ingrese nota" + " " + i + ":");
            notas = Integer.parseInt(in.readLine());

            sumaNotasExamenes = sumaNotasExamenes + notas;
            i++;
        }
        promedio = sumaNotasExamenes / cantExamenes;

        if (promedio >= 70) {
            out.println("Ha aprobo el curso.");
        } else {
            if (promedio < 60) {
                out.println("Ha reprobado.");
            } else {
                out.println("Ha reprobado, y tendrá que ir a ampliación. ");
            }
        }
    }
}