package semana_2;

import java.io.*;

public class machote {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // hacer programa que le solicite al usuario el ingreso de su nombre, annio,
        // nacimiento altura y genero
        // declaracion de variables
        String nombre;
        int annio_nacimiento, edad;
        // char genero;
        // float altura;

        // entrada de datos
        out.println("Ingrese su nombre: ");
        nombre = in.readLine(); // asi se lee la variable de tipo String

        out.print("Ingrese su año de nacimiento: ");
        annio_nacimiento = Integer.parseInt(in.readLine()); // asi leemos un int
        // out.print("Ingrese su genero (M/F/I): ");
        // genero = in.readLine().charAt(0); // asi leo un char

        // out.print("Ingrese su altura: ");
        // altura = Float.parseFloat(in.readLine()); // asi leo un float

        // proceso
        edad = 2023 - annio_nacimiento;

        // salida
        out.println("Buenas tardes " + nombre + " su edad es de: " + edad + " años");

    }
}