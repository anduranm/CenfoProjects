package semana_3;

import java.io.*;

public class TiposNumeros {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int numero;

        out.print("Ingrese un valor entero: ");
        numero = Integer.parseInt(in.readLine());

        if (numero > 0) {
            out.println("El numero es positivo");
        } else {
            out.println("El numero ingresado es negativo");
        }
    }

}
