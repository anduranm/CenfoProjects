package semana_9.lunes;

import java.io.*;

public class funcionesIntro {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void entradaDatos() throws IOException {
        int num1, num2;
        out.print("Ingrese el primer valor: ");
        num1 = Integer.parseInt(in.readLine());
        out.print("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(in.readLine());
        sumatoria(num1, num2);
    }

    public static void sumatoria(int n1, int n2) {
        int suma;
        suma = n1 + n2;
        out.println("El resultado de la suma es de: " + suma);
    }

    public static void main(String[] args) throws IOException {
        entradaDatos();
    }

}