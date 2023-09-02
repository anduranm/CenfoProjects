package proyecto.entregable2;

import java.io.*;

public class ejemplobola {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        verificacionCompleja();
        versionMejorada();
    }

    public static void verificacionCompleja() throws IOException {
        String respuesta = "si"; // Asignar un valor a la variable respuesta (puede ser "si" o "no")
        out.println("¿Atrapo una bola? (si/no)"); // Imprimir en pantalla la pregunta
        respuesta = in.readLine(); // Imprimir en pantalla la respuesta
        if (respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("Si")) { // Si la respuesta es igual a
                                                                                          // "si"
            respuesta = "*"; // Cambiar el valor de la variable respuesta a "*"
        } else if (respuesta.equals("no") || respuesta.equals("NO") || respuesta.equals("No")) { // Si la respuesta es
                                                                                                 // igual a "no"
            respuesta = " "; // Cambiar el valor de la variable respuesta a un espacio vacío
        } else { // Si la respuesta no es ni "si" ni "no"
            System.out.println("Respuesta inválida"); // Imprimir en pantalla un mensaje de error
        }
        out.println(respuesta); // Imprimir en pantalla el nuevo valor de la variable respuesta
    }

    public static void versionMejorada() throws IOException {
        String respuesta = "si"; // Asignar un valor a la variable respuesta (puede ser "si" o "no")
        out.println("¿Atrapo una bola? (si/no)"); // Imprimir en pantalla la pregunta
        respuesta = in.readLine(); // Imprimir en pantalla la respuesta
        if (respuesta.equalsIgnoreCase("si")) { // Si la respuesta es igual a "si"
            respuesta = "*"; // Cambiar el valor de la variable respuesta a "*"
        } else if (respuesta.equalsIgnoreCase("no")) { // Si la respuesta es igual a "no"
            respuesta = " "; // Cambiar el valor de la variable respuesta a un espacio vacío
        } else { // Si la respuesta no es ni "si" ni "no"
            System.out.println("Respuesta inválida"); // Imprimir en pantalla un mensaje de error
        }
        out.println(respuesta); // Imprimir en pantalla el nuevo valor de la variable respuesta

    }

}