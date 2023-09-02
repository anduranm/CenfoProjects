package semana_11;

import java.io.*;

public class ejercicio2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int[] notas = reporteNotas();
        imprimoNotas(notas);
        out.println("\nLa nota mayor es: " + notaMayor(notas));
        out.println("La nota menor es: " + notaMenor(notas));
    }

    public static int[] reporteNotas() throws IOException {
        int tam;
        out.print("Ingrese la cantidad de notas a guardar: ");
        tam = Integer.parseInt(in.readLine());
        int[] notas = new int[tam];
        for (int i = 0; i < notas.length; i++) {
            out.print("Ingrese la nota: ");
            notas[i] = Integer.parseInt(in.readLine());
        }
        return notas;
    }

    public static void imprimoNotas(int[] notas) {
        out.println("Lista total de notas");
        for (int i = 0; i < notas.length; i++) {
            out.println(notas[i] + " ");
        }
    }

    public static int notaMayor(int[] notas) {
        int mayor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
        }
        return mayor;
    }

    public static int notaMenor(int[] notas) {
        int menor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }
}
