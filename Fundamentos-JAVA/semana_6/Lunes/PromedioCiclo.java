package semana_6.Lunes;

import java.io.*;

public class PromedioCiclo {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        /*
         * Se requiere calcular el promedio de una cantidad de números
         * enteros definida por el usuario por teclado.
         */

        int contador = 1, acumulador = 0, cantidad, promedio, numero;

        out.println("Indique la cantidad de numeros desea promediar: ");
        cantidad = Integer.parseInt(in.readLine());

        while (contador <= cantidad) {
            out.println("Ingrese un número entero: ");
            numero = Integer.parseInt(in.readLine());
            acumulador = acumulador + numero;

            contador = contador + 1;
        }
        promedio = acumulador / cantidad;
        out.println("El promedio de los números es de: " + promedio);
    }

}