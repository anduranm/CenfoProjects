package semana_11;

import java.io.*;

public class machoteDearreglos {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static int[] llenoArreglo() throws IOException {
        int tam;
        out.print("Ingrese la cantidad de numeros a almacenar: ");
        tam = Integer.parseInt(in.readLine());
        int[] numeros = new int[tam];
        for (int i = 0; i < numeros.length; i++) {
            out.print("Ingrese el valor a almacenar: ");
            numeros[i] = Integer.parseInt(in.readLine());
        }
        return numeros;
    }

    public static void imprimoArreglo(int[] nums) {
        out.println("Arreglo de numeros");
        for (int i = 0; i < nums.length; i++) {
            out.println(nums[i] + " ");
        }
    }

    public static int sumoArreglo(int[] nums) {
        int suma = 0;
        for (int i = 0; i < nums.length; i++) {
            suma += nums[i];
        }
        return suma;
    }

    public static void main(String[] args) throws Exception {

    }

}
