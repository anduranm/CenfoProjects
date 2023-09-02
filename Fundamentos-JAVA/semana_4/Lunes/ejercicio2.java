package semana_4.Lunes;

import java.io.*;

public class ejercicio2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int fechaPelicula, mayorEdad, promocion, rating;

        out.print("Digite 1 si la fecha de la funcion es despues del 15 del mes, de lo contrio ingrese 0: ");
        fechaPelicula = Integer.parseInt(in.readLine());

        out.print("Digite 1 si la pelicula no es para mayores de edad, de lo contrario ingrese 0: ");
        mayorEdad = Integer.parseInt(in.readLine());

        out.print("Digite 1 si hay promocion, de lo contrario digite 0: ");
        promocion = Integer.parseInt(in.readLine());

        out.print("Digite 1 si el rating de la pelicula es mayor a cuatro, de lo contrario ingrese 0 : ");
        rating = Integer.parseInt(in.readLine());

        if ((fechaPelicula == 1 || promocion == 1) && (rating == 1 || mayorEdad == 1)) {
            out.print("Usted Puede ir al cine");
        } else {
            out.print("No puede ir al cine");
        }
    }

}