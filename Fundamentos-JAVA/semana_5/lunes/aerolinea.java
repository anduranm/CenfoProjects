package semana_5.lunes;

import java.io.*;

public class aerolinea {
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        static PrintStream out = System.out;

        public static void main(String[] args) throws IOException {
                // Variables

                int ruta, total_pasajeros, pasajeros_regular = 0, pasajeros_preferencial = 0,
                                pasajeros_primera_clase = 0;
                float distancia = 0, total_ingresos, monto_regular = 0, monto_preferencial = 0, monto_primera_clase = 0,
                                ingresos_regular = 0, ingresos_preferencial = 0, ingresos_primera_clase = 0;
                String ciudad = "destino no seleccionado", aeropuerto = "no encontrado.";

                // Entrada de datos
                out.println(
                                "Las ciudades destino son: \n 1.Bealfast \n 2.Reading \n 3.Orlando \n 4.California \n 5.Tokio");
                out.println("Seleccione el número de la ciudad destino:");
                ruta = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en clase regular:");
                pasajeros_regular = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en clase preferencial:");
                pasajeros_preferencial = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en primera clase:");
                pasajeros_primera_clase = Integer.parseInt(in.readLine());

                // proceso

                switch (ruta) {

                        case 1:
                                ciudad = "Bealfast";
                                aeropuerto = "BFS";
                                distancia = 8331;
                                monto_regular = 365;
                                monto_preferencial = 465;
                                monto_primera_clase = 665;
                                break;

                        case 2:
                                ciudad = "Reading";
                                aeropuerto = "LHR";
                                distancia = 8707;
                                monto_regular = 470;
                                monto_preferencial = 370;
                                monto_primera_clase = 670;
                                break;

                        case 3:
                                ciudad = "Orlando";
                                aeropuerto = "MCO";
                                distancia = 2077;
                                monto_regular = 375;
                                monto_preferencial = 275;
                                monto_primera_clase = 575;
                                break;

                        case 4:
                                ciudad = "California";
                                aeropuerto = "SJC";
                                distancia = 4861;
                                monto_regular = 390;
                                monto_preferencial = 290;
                                monto_primera_clase = 590;
                                break;

                        case 5:
                                ciudad = "Tokio";
                                aeropuerto = "HND";
                                distancia = 13183;
                                monto_regular = 650;
                                monto_preferencial = 550;
                                monto_primera_clase = 850;
                                break;

                }

                ingresos_regular = monto_regular * pasajeros_regular;
                ingresos_preferencial = monto_preferencial * pasajeros_preferencial;
                ingresos_primera_clase = monto_primera_clase * pasajeros_primera_clase;

                total_ingresos = ingresos_regular + ingresos_preferencial + ingresos_primera_clase;
                total_pasajeros = pasajeros_regular + pasajeros_preferencial + pasajeros_primera_clase;

                // Espacio para que se vea mas ordenado
                out.println("    ");

                // Salida

                out.println("El reporte de la ruta selecionada es el siguiente: \n");
                out.println("La distancia recorrida hasta " + ciudad + " fue de " + distancia
                                + " kilometros y el aeropuerto de destino fue " + aeropuerto + ".");
                out.println("El ingreso generado por los pasajeros que viajaron en clase regular es: "
                                + ingresos_regular
                                + " dólares.");
                out.println("El ingreso generado por los pasajeros que viajaron en clase preferencial es: "
                                + ingresos_preferencial + " dólares.");
                out.println("El ingreso generado por los pasajeros que viajaron en clase primera clase es: "
                                + ingresos_primera_clase + " dólares.");
                out.println(
                                "El total de pasajeros que viajaron en la ruta selecionada fue de: " + total_pasajeros
                                                + " pasajeros.");

                out.println("El total de ingresos genereados para la aerolínea en esa ruta fue de: " + total_ingresos
                                + " dólares.\n");
        }

}