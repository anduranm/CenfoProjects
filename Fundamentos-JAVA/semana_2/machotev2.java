package semana_2;

import java.io.*;

public class machotev2 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception {

        // declaracion de variables
        String nombre_producto;
        float precio_producto, impuesto, precio_final;

        // entrada de datos
        out.print("Ingrese el nombre del producto: ");
        nombre_producto = in.readLine();

        out.print("Ingrese el precio del producto: ");
        precio_producto = Float.parseFloat(in.readLine());
        // proceso
        impuesto = (precio_producto * 13) / 100;
        precio_final = precio_producto + impuesto;

        // salida
        out.println("El monto a pagar por " + nombre_producto + " es de: " + precio_final + " colones");
    }
}