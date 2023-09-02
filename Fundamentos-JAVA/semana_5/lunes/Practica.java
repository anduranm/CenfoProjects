package semana_5.lunes;

import java.io.*;

public class Practica {
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        static PrintStream out = System.out;

        public static void main(String[] args) throws IOException {
                // Variables

                int ruta, totalPasajerosBelfast, totalPasajerosReading,
                                totalPasajerosOrlando, totalPasajerosCalifornia, totalPasajerosTokio, pasajerosRegular,
                                pasajerosClase,
                                pasajerosPreferencial;
                float IngresoRegularBelfast, IngresoRegularReading,
                                IngresoRegularOrlando, IngresoRegularCalifornia, IngresoRegularTokio,
                                IngresoPreferencialBelfast,
                                IngresoPreferencialReading, IngresoPreferencialOrlando, IngresoPreferencialCalifornia,
                                IngresoPreferencialTokio, IngresoClaseBelfast, IngresoClaseReading, IngresoClaseOrlando,
                                IngresoClaseCalifornia, IngresoClaseTokio, totalIngresoBelfast,
                                totalIngresoReading, totalIngresoOrlando, totalIngresoCalifornia, totalIngresoTokio;

                // Entrada de datos
                out.println("Generador de Reportes de Vuelos  \n Seleccione la Ciudad destino: \n 1.Bealfast \n 2.Reading \n 3.Orlando \n 4.California \n 5.Tokio");
                out.println("Seleccione el número de la ciudad destino:");
                ruta = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en clase regular:");
                pasajerosRegular = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en clase preferencial:");
                pasajerosPreferencial = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en primera clase:");
                pasajerosClase = Integer.parseInt(in.readLine());

                IngresoRegularBelfast = pasajerosRegular * 465;
                IngresoRegularReading = pasajerosRegular * 470;
                IngresoRegularOrlando = pasajerosRegular * 375;
                IngresoRegularCalifornia = pasajerosRegular * 390;
                IngresoRegularTokio = pasajerosRegular * 650;

                IngresoPreferencialBelfast = pasajerosPreferencial * 365;
                IngresoPreferencialReading = pasajerosPreferencial * 370;
                IngresoPreferencialOrlando = pasajerosPreferencial * 275;
                IngresoPreferencialCalifornia = pasajerosPreferencial * 290;
                IngresoPreferencialTokio = pasajerosClase * 550;

                IngresoClaseBelfast = pasajerosClase * 665;
                IngresoClaseReading = pasajerosClase * 670;
                IngresoClaseOrlando = pasajerosClase * 575;
                IngresoClaseCalifornia = pasajerosClase * 590;
                IngresoClaseTokio = pasajerosClase * 850;

                totalPasajerosBelfast = pasajerosRegular + pasajerosPreferencial + pasajerosClase;
                totalPasajerosReading = pasajerosRegular + pasajerosPreferencial + pasajerosClase;
                totalPasajerosOrlando = pasajerosRegular + pasajerosPreferencial + pasajerosClase;
                totalPasajerosCalifornia = pasajerosRegular + pasajerosPreferencial + pasajerosClase;
                totalPasajerosTokio = pasajerosRegular + pasajerosPreferencial + pasajerosClase;

                totalIngresoBelfast = IngresoRegularBelfast + IngresoPreferencialBelfast + IngresoClaseBelfast;
                totalIngresoReading = IngresoRegularReading + IngresoPreferencialReading + IngresoClaseReading;
                totalIngresoOrlando = IngresoRegularOrlando + IngresoPreferencialOrlando + IngresoClaseOrlando;
                totalIngresoCalifornia = IngresoRegularCalifornia + IngresoPreferencialBelfast + IngresoClaseBelfast;
                totalIngresoTokio = IngresoRegularTokio + IngresoPreferencialTokio + IngresoClaseTokio;

                switch (ruta) {
                        case 1:
                                out.println(
                                                "La distancia de la ruta BFS a Belfast es de: 83331 Km \n El ingreso generado de clase regular es de: "
                                                                + IngresoRegularBelfast + " Dólares"
                                                                + "\n El ingreso generado por la clase preferencial es de: "
                                                                + IngresoPreferencialBelfast + " Dólares"
                                                                + ("\n El ingreso generado por la primera clase es de: "
                                                                                + IngresoClaseBelfast)
                                                                + " Dólares"
                                                                + ("\nEl total de pasajeros que viajaron por la ruta: ")
                                                                + totalPasajerosBelfast
                                                                + " Pasajeros"
                                                                + ("\n El total de ingresos fueron: ")
                                                                + totalIngresoBelfast + " Dólares");
                                break;
                        case 2:
                                out.println(
                                                "La distancia de la ruta LHR a Reading es de: 8707 Km \n El ingreso generado de clase regular es de: "
                                                                + IngresoRegularReading + " Dólares"
                                                                + "\n El ingreso generado por la clase preferencial es de: "
                                                                + IngresoPreferencialReading + " Dólares"
                                                                + ("\n El ingreso generado por la primera clase es de: "
                                                                                + IngresoClaseReading)
                                                                + " Dólares"
                                                                + ("\nEl total de pasajeros que viajaron por la ruta: ")
                                                                + totalPasajerosReading
                                                                + " Pasajeros"
                                                                + ("\n El total de ingresos fueron: ")
                                                                + totalIngresoReading + " Dólares");
                                break;
                        case 3:
                                out.println(
                                                "La distancia de la ruta MCO a Orlando es de: 2077 Km \n El ingreso generado de clase regular es de:"
                                                                + IngresoRegularOrlando + " Dólares"
                                                                + "\n El ingreso generado por la clase preferencial es de: "
                                                                + IngresoPreferencialOrlando + " Dólares"
                                                                + ("\n El ingreso generado por la primera clase es de: "
                                                                                + IngresoClaseOrlando)
                                                                + " Dólares"
                                                                + ("\nEl total de pasajeros que viajaron por la ruta: ")
                                                                + totalPasajerosOrlando
                                                                + " Pasajeros"
                                                                + ("\n El total de ingresos fueron: ")
                                                                + totalIngresoOrlando + " Dólares");
                                break;
                        case 4:
                                out.println(
                                                "La distancia de la ruta SJC a California es de: 4861 KM \n El ingreso generado de la clase regular es de:"
                                                                + IngresoRegularCalifornia + " Dólares"
                                                                + "\n El ingreso generado por la clase preferencial es de: "
                                                                + IngresoPreferencialCalifornia + " Dólares"
                                                                + ("\n El ingreso generado por la primera clase es de: "
                                                                                + IngresoClaseCalifornia)
                                                                + " Dólares"
                                                                + ("\nEl total de pasajeros que viajaron por la ruta: ")
                                                                + totalPasajerosCalifornia
                                                                + " Pasajeros"
                                                                + ("\n El total de ingresos fueron: ")
                                                                + totalIngresoCalifornia + " Dólares");
                                break;
                        case 5:
                                out.println(
                                                "La distancia de la ruta HND a Tokio es de: 13183 Km \n El ingreso generado por la clase regular es de:"
                                                                + IngresoRegularTokio + " Dólares"
                                                                + "\n El ingreso generado por la clase preferencial es de: "
                                                                + IngresoPreferencialTokio + " Dólares"
                                                                + ("\n El ingreso generado por la primera clase es de: "
                                                                                + IngresoClaseTokio)
                                                                + " Dólares"
                                                                + ("\nEl total de pasajeros que viajaron por la ruta: ")
                                                                + totalPasajerosTokio
                                                                + " Pasajeros"
                                                                + ("\n El total de ingresos fueron: ")
                                                                + totalIngresoTokio + " Dólares");
                                break;

                        default:
                                break;
                }

        }

}