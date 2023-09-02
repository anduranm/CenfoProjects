package semana_4.miercoles;

import java.io.*;

public class menu {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int opcion;

        out.println("Calculadora Basica");
        out.println("1. Suma");
        out.println("2. Resta");
        out.println("3. Multiplicacion");
        out.println("4. Division");
        out.println("5. Salir");
        out.print("Seleccione la opcion a realizar: ");
        opcion = Integer.parseInt(in.readLine());

        if (opcion == 1) {
            out.println("Eligio sumar");
        } else {
            if (opcion == 2) {
                out.println("Eligio restar");
            } else {
                if (opcion == 3) {
                    out.println("Eligio multiplicar");
                } else {
                    if (opcion == 4) {
                        out.println("Eligio dividir");
                    } else {
                        if (opcion == 5) {
                            out.println("Hasta Luego");
                        } else {
                            out.println("Ingreso una opcion invalida");
                        }
                    }
                }
            }
        }
    }

}