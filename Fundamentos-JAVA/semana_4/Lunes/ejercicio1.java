package semana_4.Lunes;

import java.io.*;

public class ejercicio1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        float monto, descuento = 0;
        int compras;
        out.print("Ingrese el numero de compras acumuladas: ");
        compras = Integer.parseInt(in.readLine());
        out.print("Ingrese el monto de la compra: ");
        monto = Integer.parseInt(in.readLine());
        if (monto >= 10000 && compras >= 6) {
            descuento = monto * 35 / 100;
        }
        monto = monto - descuento;
        out.println("Su factura es " + monto);

    }

}