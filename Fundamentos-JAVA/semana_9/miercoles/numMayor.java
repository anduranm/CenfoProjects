package semana_9.miercoles;

import java.io.*;

/*Haga una función que reciba tres números enteros y retorne el mayor de ellos. Pruebe su función en un programa.*/
public class numMayor {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static int numeroMayor(int num1, int num2, int num3) {
        if (num1 > num2 && num1 > num3) {
            return num1;
        } else {
            if (num2 > num3) {
                return num2;
            }
            return num3;
        }

    }

    public static void entradaDatos() throws IOException {
        int num1, num2, num3;
        out.println("Ingrese el primer valor: ");
        num1 = Integer.parseInt(in.readLine());
        out.println("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(in.readLine());
        out.println("Ingrese el tercer valor: ");
        num3 = Integer.parseInt(in.readLine());

        out.println("El mayor de los numeros es: " + numeroMayor(num1, num2, num3));
    }

    public static void main(String[] args) throws IOException {
        entradaDatos();
    }

}