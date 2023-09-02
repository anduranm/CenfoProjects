package semana_9.lunes;

import java.io.*;

public class funcionesIntro2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void entradaDatos() throws IOException {
        int num1, num2, resultado;
        out.print("Ingrese el primer valor: ");
        num1 = Integer.parseInt(in.readLine());
        out.print("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(in.readLine());
        // informativo
        // out.println("El resultado de la suma es: " + sumatoria(num1,num2));

        // asingado a una variable
        resultado = sumatoria(num1, num2);
        out.println("El resultado de la suma es: " + resultado);
    }

    public static int sumatoria(int n1, int n2) {
        int suma;
        suma = n1 + n2;
        return suma;
    }

    public static void main(String[] args) throws IOException {
        entradaDatos();
    }

}