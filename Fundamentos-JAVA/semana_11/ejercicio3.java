package semana_11;

import java.io.*;

public class ejercicio3 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        datosBanco();
    }

    public static void datosBanco() throws IOException {
        int tam;
        out.println("Ingrese la cantidad de clientes del banco: ");
        tam = Integer.parseInt(in.readLine());

        int[] cuenta = new int[tam];
        String[] cliente = new String[tam];

        for (int i = 0; i < cliente.length; i++) {
            out.print("Ingrese el nombre del cliente: ");
            cliente[i] = in.readLine();
            out.println("Ingrese el saldo de la cuenta: ");
            cuenta[i] = Integer.parseInt(in.readLine());
        }
        reporteBanco(cliente, cuenta);
    }

    public static void reporteBanco(String[] cliente, int[] cuenta) {
        for (int i = 0; i < cuenta.length; i++) {
            out.println("El cliente " + cliente[i] + ", tiene un saldo de: " + cuenta[i] + " colones.");
        }
    }
}