package semana_13;

import java.io.*;
import java.util.Random;

public class burbuja {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Random r = new Random();

    public static int[] llenoArreglo() {
        int tam;
        tam = (r.nextInt(20)) + 2;
        int[] numeros = new int[tam];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(99);
        }
        return numeros;
    }

    public static void imprimoArreglo(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            out.print(nums[i] + " ");
        }
    }

    /*
     * hacer un algoritmo que reciba un arreglo y coloque el
     * numero mayor del arreglo en la ultima posicion
     */
    /*
     * public static void metBurbuja(int[] numeros) {
     * int aux;
     * for (int j = 0; j < numeros.length; j++) {
     * for (int i = 0; i < (numeros.length) - 1; i++) {
     * if (numeros[i] > numeros[i + 1]) {
     * aux = numeros[i];
     * numeros[i] = numeros[i + 1];
     * numeros[i + 1] = aux;
     * }
     * }
     * }
     * }
     */

    /* burbuja con mejor eficiencia */
    public static void ordenoBurbuja(int[] numeros) {
        int aux;
        for (int i = numeros.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j]; // Se guarda temporalmente el valor mayor
                    numeros[j] = numeros[j + 1]; // El valor menor se mueve a la izquierda
                    numeros[j + 1] = aux; // El valor mayor se mueve a la derecha
                }
            }
        }
    }

    public static void algoritmoSeleccion(int[] numeros) {
        int i, j, temporal, mayor, posicion;
        // Contadores y variables intermedias
        for (i = numeros.length - 1; i > 0; i--) {
            for (j = 0, mayor = numeros[0], posicion = 0; j <= i; j++) {
                if (numeros[j] > mayor) { // Se compara la posici6n del arreglo con el mayor
                    mayor = numeros[j]; // Se guarda el valor del nuevo nümero mayor
                    posicion = j; // Se guarda la posici6n del nuevo nümero mayor
                }
            }
            temporal = numeros[posicion]; // Se guarda el valor del nümero mayor
            numeros[posicion] = numeros[i]; // Se guarda el nümero de la ültima posicién
            numeros[i] = temporal; // Se guarda en la ültima posici6n el nümero mayor

        }
    }

    public static void main(String[] args) throws IOException {
        int[] listas = llenoArreglo();
        out.println("Arreglo original");
        imprimoArreglo(listas);
        // metBurbuja(listas);
        // ordenoBurbuja(listas);
        out.println("\nArrelo ordenado");
        algoritmoSeleccion(listas);
        imprimoArreglo(listas);

    }

}