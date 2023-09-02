package semana_3;

import java.io.*;

public class ejercicio6 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // El Gobierno ha decidido que todas aquellas personas que tienen un salario
        // igual a superior
        // a un millón de colones deben pagar un impuesto del 10%. Calcule el salario
        // neto de un
        // trabajador. El sistema recibe el salario del trabajador como entrada
        float salario, salario_neto, impuesto = 0;
        out.print("ingrese su salario: ");
        salario = Float.parseFloat(in.readLine());
        if (salario >= 1000000) {
            impuesto = (salario * 10) / 100;

        }
        salario_neto = salario - impuesto;
        out.print("su salario neto es: " + salario_neto);

    }

}