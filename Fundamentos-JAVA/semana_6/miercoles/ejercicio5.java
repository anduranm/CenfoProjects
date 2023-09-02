package semana_6.miercoles;

import java.io.*;

public class ejercicio5 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Modifique el ejercicio anterior de la siguiente manera: el programa debe
        // calcular ahora la cantidad de estudiantes que aprobó el curso, la cantidad de
        // estudiantes que reprobó y la cantidad que fue a ampliación. Para esto el
        // programa ahora, adicionalmente recibe el número de estudiantes del curso. No
        // olvide tener en cuenta lo mencionado en el ejercicio anterior

        int i = 1, promedio, cantExamenes, sumaNotasExamenes = 0, notas, cantidad_estudiantes = 0,
                cantidad_aprobados = 0, cantidad_reprobados = 0, cantidad_ampliacion = 0, j = 1;

        out.println("ingrese la cantidad de estudiantes");
        cantidad_estudiantes = Integer.parseInt(in.readLine());

        while (j <= cantidad_estudiantes) {

            out.println("ingrese la cantidad de examenes: ");
            cantExamenes = Integer.parseInt(in.readLine());
            i = 1;
            sumaNotasExamenes = 0;

            while (i <= cantExamenes) {

                out.println("Ingrese las notas: ");
                notas = Integer.parseInt(in.readLine());

                sumaNotasExamenes = sumaNotasExamenes + notas;
                i = i + 1;
            }
            promedio = sumaNotasExamenes / cantExamenes;

            out.println("El promedio es: " + promedio);

            if (promedio >= 70) {
                out.println("El estudiante aprobo");
                
                cantidad_aprobados++;

            } else {
                if (promedio < 60) {
                    out.println("El estudiante reprobo");
                    cantidad_reprobados++;
                } else {
                    out.println("Debe ir a ampliacion");
                    cantidad_ampliacion++;
                }
            }

            j++; // j=j+1;

        }
        out.println("la cantidad de estudiantes que aprobaron es: " + cantidad_aprobados);
        out.println("la cantidad de estudiantes que reprobaron es: " + cantidad_reprobados);
        out.println("la cantidad de estudiantes que van a ampliacion son : " + cantidad_ampliacion);

    }
}
