package semana_9.miercoles;

import java.io.*;

/*Haga una función que reciba una distancia en metros y calcule el equivalente en pies y
*otra función que recibe una distancia en metros y calcule el equivalente en pulgadas. 
*Pruebe las dos funciones en un programa. Tenga en cuenta que:
*/
public class exampleMetros_Pies {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    // inicio de funciones
    public static void converetirPies(double metros) {
        double pies;
        pies = metros * 39.3701;
        out.println("La distancia de pies a metros es: " + pies);
    }

    public static void converetirPulgadas(double metros) {
        double pulgadas;
        pulgadas = metros * 3.28084;
        out.println("La distancia de pulgadas a metros es: " + pulgadas);
    }

    public static void entradaDatos() throws IOException {
        double metros;
        out.print("ingrese los metros: ");
        metros = Double.parseDouble(in.readLine());
        converetirPies(metros);
        converetirPulgadas(metros);
    }

    // fin de funciones
    public static void main(String[] args) throws IOException {
        entradaDatos();
    }

}
