package semana_10;

import java.io.*;

public class contarCantidadNum {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static int cuento_digitos(int numero) {

        int digitos = 0;

        while (numero > 0) {

            numero = numero / 10;
            digitos++;

        }

        return digitos;

    }

    public static void entrada_datos() throws IOException {

        int numero = 0;

        out.print("Ingrese el numero entero que desea contar:");
        numero = Integer.parseInt(in.readLine());

        out.print(cuento_digitos(numero));

    }

    public static void main(String[] args) throws IOException {
        entrada_datos();
    }

}