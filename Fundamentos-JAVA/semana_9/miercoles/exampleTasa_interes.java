package semana_9.miercoles;

import java.io.*;

/*
*Haga una función que calcule la cantidad de dinero que
*se tendría después de n años (a este valor se le llama valor future)
*, a una tasa de interés I, teniendo p dinero hoy (a este valor se le 
*llama valor presente). El valor futuro se calcula con la siguiente
*formula: 
*Para esta función utilice la función powde Math. 
*Pruebe la función en un programa.
*valorfuturo = p * (1 + i)𝝅
*/
public class exampleTasa_interes {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    // inicio de funciones

    public static void entradaDatos() throws IOException {

        int cantidad_de_annios;
        double cantidad_dinero_presente, dinero_futuro, tasa_de_interes;

        out.println("Ingrese el monto de dinero presente: ");
        cantidad_dinero_presente = Double.parseDouble(in.readLine());

        out.println("Ingrese el monto de tasa de interes: ");
        tasa_de_interes = Double.parseDouble(in.readLine());

        out.println("Ingrese el numero de años a proyectar: ");
        cantidad_de_annios = Integer.parseInt(in.readLine());

        dinero_futuro = valor_future(cantidad_de_annios, tasa_de_interes, cantidad_dinero_presente);

        out.println("La cantidad de dinero a futuro es: " + dinero_futuro);
    }

    public static double valor_future(int n, double i, double p) {

        double dinero_a_futuro;
        dinero_a_futuro = p * Math.pow((1 + (i / 100)), n);
        return dinero_a_futuro;

    }

    // fin de funciones
    public static void main(String[] args) throws IOException {
        entradaDatos();
    }

}