package semana_3;

import java.io.*;

public class ejercicio11 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // *Una empresa que vende flores sacó una promoción para la última semana de
        // mayo. Si el cliente compra tres flores, le aplica un descuento del 10 %. El
        // programa recibe la cantidad de flores y el precio de cada flor. Se debe
        // imprimir el total a pagar. */

        // Entrada
        double precioFlor, cantidadFlores, precio, descuento = 0, precioFinal;

        out.print("Ingrese la cantidad de las flores: ");
        cantidadFlores = Double.parseDouble(in.readLine());

        out.print("Ingrese el precio de cada flor: ");
        precioFlor = Double.parseDouble(in.readLine());

        // proceso
        precio = precioFlor * cantidadFlores;
        precioFinal = precio - descuento;

        if (cantidadFlores >= 3) {
            descuento = (precio * 10) / 100;
            precioFinal = precio - descuento;
        }

        out.print("Su total a pagar es: " + precioFinal);

    }
}