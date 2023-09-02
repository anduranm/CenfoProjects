package semana_4.Lunes;

import java.io.*;

public class menor_mayor {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int num1, num2, num3;

        out.print("Ingrese el primer numero: ");
        num1 = Integer.parseInt(in.readLine());

        out.print("Ingrese el segundo numero: ");
        num2 = Integer.parseInt(in.readLine());

        out.print("Ingrese el tercer numero: ");
        num3 = Integer.parseInt(in.readLine());

        if ((num1 != num2) && (num1 != num3) && (num2 != num3)) {
            if ((num1 > num2) && (num1 > num3)) {
                out.println("El mayor es: " + num1);
                if (num2 < num3) {
                    out.println("El menor es: " + num2);
                } else {
                    out.println("El menor es: " + num3);
                }
            } else {
                if (num2 > num3) {
                    out.println("El mayor es: " + num2);
                    if (num1 < num3) {
                        out.println("El menor es: " + num1);
                    } else {
                        out.println("El menor es: " + num3);
                    }
                } else {
                    out.println("El mayor es: " + num3);
                    if (num1 < num2) {
                        out.println("El menor es: " + num1);
                    } else {
                        out.println("El menor es: " + num2);
                    }
                }
            }
        } else {
            out.println("Los numeros ingresados NO son diferentes");
        }
    }

}