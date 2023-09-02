package semana_4.miercoles;

import java.io.*;

public class practica {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // A usted se le pide que realice un programa que, recibiendo la medida de tres
        // lados, se imprima si
        // estos tres lados pueden formar un triángulo. Tres lados forman un triángulo
        // si la suma de dos lados
        // de un triángulo siempre es mayor al tercer lado. Por ejemplo, si tenemos un
        // lado a que mide 7, un
        // lado b que mide 10 y un lado c que mide 5, se compara si la suma de los lados
        // b y c es mayor que la
        // medida del lado a. Luego si la suma de los lados a y b es mayor que la medida
        // del lado c y,
        // finalmente, si la suma del lado a y c es mayor que la medida del lado b. Si
        // las tres condiciones se
        // cumplen, entonces los tres lados conforman un triángulo.

        int lado_a, lado_b, lado_c;
        out.println("Digite la medida del lado A: ");
        lado_a = Integer.parseInt(in.readLine());
        out.println("Digite la medida del lado B: ");
        lado_b = Integer.parseInt(in.readLine());
        out.println("Digite la medida del lado C: ");
        lado_c = Integer.parseInt(in.readLine());
        if ((lado_a + lado_b) > lado_c) {
            if ((lado_b + lado_c) > lado_a) {
                if ((lado_c + lado_a) > lado_b) {
                    out.println("Las medidas dadas corresponden a un triangulo.");
                } else {
                    out.println("Las medidas dadas No corresponden a un triangulo.");
                }
            } else {
                out.println("Las medidas dadas No corresponden a un triangulo.");
            }
        } else {
            out.println("Las medidas dadas No corresponden a un triangulo.");
        }
    }

}