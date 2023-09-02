package apps;

import java.io.*;
import java.util.ArrayList;

public class validar {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        // Declarar todas las variables al principio
        int numero = 0, j = 0, encuesta = 0, exit; // Para almacenar el número
        boolean valido = false; // Para controlar el bucle interno
        ArrayList<Integer> numeros = new ArrayList<Integer>(); // Para almacenar los números válidos
        BufferedReader br = null; // Para leer desde la consola

        // Crear un bucle while que se repita hasta que el usuario quiera terminar
        while (encuesta >= 0) {
            j = j + 1;
            out.println("Estudiante número: " + j);

            // Crear un bucle while que se repita hasta que el número sea válido
            while (!valido) {
                // Intentar leer el número desde la entrada estándar
                out.println("Digite el número a cual nivel pertenece: \n 1 | 2 | 3 | 4 | 5 "); // Pedir al usuario una
                                                                                               // respuesta
                try {
                    // Inicializar el objeto BufferedReader para leer desde la consola
                    br = new BufferedReader(new InputStreamReader(System.in));

                    // Leer una línea y convertirla a entero
                    numero = Integer.parseInt(br.readLine());

                    // Comprobar si el número está en el rango 1 a 5
                    if (numero > 0 && numero < 6) {
                        // Si el número es válido, cambiar la variable booleana a true para salir del
                        // bucle interno
                        valido = true;
                        // Añadir el número al arreglo dinámico con el método add
                        numeros.add(numero);
                    } else {
                        // Si el número no es válido, lanzar una excepción personalizada con un mensaje
                        throw new Exception("El número debe estar entre 1 y 5.");
                    }
                } catch (NumberFormatException e) {
                    // Capturar la excepción que ocurre si la línea leída no es un entero válido
                    System.err.println("Debes ingresar un entero.");
                } catch (IOException e) {
                    // Capturar la excepción que ocurre si hay un error al leer desde la consola
                    System.err.println("Error al leer desde la consola.");
                } catch (Exception e) {
                    // Capturar cualquier otra excepción que ocurra al validar el número
                    System.err.println(e.getMessage());
                }
            }

            // Mostrar los números válidos en la consola con System.out.println y un bucle
            // for each
            System.out.println("Los números válidos son: ");
            for (int n : numeros) {
                System.out.print(n + " ");
            }
            System.out.println();

            out.println("Desea continuar agregando algún otro estudiante? \n 0 para No | 1 para Si");
            exit = Integer.parseInt(in.readLine());
            if (exit == 0) {
                encuesta--;
            }
        }
    }

}
