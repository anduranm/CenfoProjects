package semana_3;

import java.io.*;

public class ejercicio10 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Calcule la nota final de un estudiante para un curso de fundamentos de
        // programación. La rúbrica de evaluación del curso determina que hay solamente
        // tres exámenes y que la nota del curso se calcula por medio de un promedio
        // ponderado el(el primer examen vale un 30 %, el segundo un 20% y el último un
        // 50%). El estudiante aprueba si el promedio es igual o mayor a 70.
        double primerNota, segundaNota, terceraNota, promedioUno, promedioDos, promedioTres,
                promedioPonderado;

        out.println("Ingrese su primer nota: ");
        primerNota = Double.parseDouble(in.readLine());

        out.println("Ingrese su segunda nota: ");
        segundaNota = Double.parseDouble(in.readLine());

        out.println("Ingrese su tercera nota: ");
        terceraNota = Double.parseDouble(in.readLine());

        promedioUno = (primerNota * 30) / 100;
        promedioDos = (segundaNota * 20) / 100;
        promedioTres = (terceraNota * 50) / 100;

        promedioPonderado = promedioUno + promedioDos + promedioTres;

        if (promedioPonderado >= 70) {
            out.println("Ha aprobo el curso: " + promedioPonderado);
        }
        out.println("su promedio final es de: " + promedioPonderado);

    }
}