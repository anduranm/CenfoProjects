package semana_3;

import java.io.*;

public class ejercicio13 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Haga un programa que reciba dos números e imprima si el primer número es
        // divisible entre el segundo, o no.
        int numA, numB, residuo;

        out.println("Ingrese el primer número: ");
        numA = Integer.parseInt(in.readLine());

        out.println("Ingrese el segundo número: ");
        numB = Integer.parseInt(in.readLine());

        residuo = numA % numB;

        if (residuo >= 1) {
            out.print("El numeroA ingresado NO es divisible por el numeroB");
        } else {
            out.print("El numeroA ingresado es divisible por el numeroB");
        }

    }

}