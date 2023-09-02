package semana_7.miercoles;

import java.io.*;

public class cuentaregresivafor {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int numero, contador = 0;
        out.print("Ingrese un numero entero: ");
        numero = Integer.parseInt(in.readLine());
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

}
