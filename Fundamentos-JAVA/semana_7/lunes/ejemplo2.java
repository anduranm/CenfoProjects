package semana_7.lunes;

import java.io.*;

public class ejemplo2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        // Haga un programa que lea todos los retiros que un usuario quiere hacer de su
        // cuenta bancaria, hasta que la cuenta llegue a cero o se quiera hacer un
        // retiro mayor al saldo de la cuenta. Para esto usted debe leer del usuario el
        // saldo inicial de la cuenta y cada uno de los retiros que el usuario quiera
        // hacer, hasta que se cumpla la condición mencionada. Ejemplo: si el saldo
        // inicial y los retiros del usuario son los siguientes, el programa se comporta
        // de esta manera:

        int saldoInicial, retiro;

        out.print("Por favor escriba el saldo inicial: ");
        saldoInicial = Integer.parseInt(in.readLine());

        while (saldoInicial > 0) {
            out.print("Por favor escriba su retiro: ");
            retiro = Integer.parseInt(in.readLine());

            saldoInicial = saldoInicial - retiro;
        }
        out.print("Se terminaron sus fondos");

    }
}