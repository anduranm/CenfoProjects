package semana_4.miercoles;

import java.io.*;

public class ejer1 {
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

        switch (opcion) {
            case 1:
                out.println("Estoy sumando");
                break;

            case 2:
                out.println("Estoy restando");
                break;

            case 3:
                out.println("Estoy multiplicando");
                break;
            case 4:
                out.println("Estoy dividiendo");
                break;

            case 5:
                out.println("Hasta Luego");
                break;

            default:
                out.println("Opcion Invalida");
                break;
        }
    }

}