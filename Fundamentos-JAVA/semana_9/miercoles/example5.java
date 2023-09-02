package semana_9.miercoles;

import java.io.*;

public class example5 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /*
     * Haga una función que reciba un número entero y determine si el número es
     * primo o no. Recuerde que por definición un número es primo si es divisible
     * solamente por 1 y por él mismo, es decir, que no es divisible por ningún
     * número entre 2 y el número-1. Pruebe su función en un programa.
     * 
     * int numero, contador = 0;
     * out.print("Ingrese un numero entero: ");
     * numero = Integer.parseInt(in.readLine());
     * for (int i = 1; i <= numero; i++) {
     * if (numero % i == 0) {
     * contador++;
     * }
     * }
     * if (contador == 2) {
     * out.println("El numero es primo.");
     * } else {
     * out.println("El numero no es primo.");
     * }
     */
    public static void primo(int numero) {
        int contador = 0;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                contador++;
            }
        }
        if (contador == 2) {
            out.println("El numero es primo.");
        } else {
            out.println("El numero no es primo.");
        }

    }

    public static void entradaDatos() throws IOException {
        int numero;
        out.println("Ingrese el numero para verificar si es primo o no: ");
        numero = Integer.parseInt(in.readLine());

        primo(numero);
    }

    public static void main(String[] args) throws IOException {
        entradaDatos();
    }

}