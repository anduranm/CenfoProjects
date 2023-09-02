package semana_8.lunes;
import java.io.*;

public class aerolinea {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        // Variables
        String ruta = "No hay ruta", rutaConMasViajes = "Ninguna";
        float kilometrajeTotal = 0, distancia = 0, total_ingresos = 0, monto_regular = 0,
                monto_preferencial = 0, monto_primera_clase = 0, ingresos_regular = 0, ingresos_preferencial = 0,
                ingresos_primera_clase = 0, kilometrajeTotalBelfast = 0, kilometrajeTotalReading = 0,
                kilometrajeTotalOrlando = 0, kilometrajeTotalCalifornia = 0, kilometrajeTotalTokio = 0;
        // generales
        int totalPasajeronDeTodosLosVuelos, pasajeros_regular = 0, pasajeros_preferencial = 0,
                pasajeros_primera_clase = 0, numMayor = 0;
        // segun el caso
        int pasajeros_regular_belfast = 0, pasajeros_regular_reading = 0, pasajeros_regular_orlando = 0,
                pasajeros_regular_california = 0, pasajeros_regular_tokio = 0,
                pasajeros_preferencial_belfast = 0, pasajeros_preferencial_reading = 0,
                pasajeros_preferencial_orlando = 0,
                pasajeros_preferencial_california = 0, pasajeros_preferencial_tokio = 0,
                pasajeros_primera_clase_belfast = 0, pasajeros_primera_clase_reading = 0,
                pasajeros_primera_clase_orlando = 0,
                pasajeros_primera_clase_california = 0, pasajeros_primera_clase_tokio = 0,
                totalPasajerosBelfast = 0, totalPasajerosOrlando = 0, totalPasajerosReading = 0,
                totalPasajerosTokio = 0, totalPasajerosCalifornia = 0, viajesRealizados,
                viajesRealizadosBelfast = 0, viajesRealizadosReading = 0,
                viajesRealizadosCalifornia = 0, viajesRealizadosOrlando = 0, viajesRealizadosTokio = 0;
        float montoTotalBelfastRegular = 0, montoTotalReadingRegular = 0, montoTotalOrlandoRegular = 0,
                montoTotalCaliforniaRegular = 0, montoTotalTokioRegular = 0;
        float montoTotalBelfastPreferencial = 0, montoTotalReadingPreferencial = 0, montoTotalOrlandoPreferencial = 0,
                montoTotalCaliforniaPreferencial = 0, montoTotalTokioPreferencial = 0;
        float montoTotalBelfastPrimeraClase = 0, montoTotalReadingPrimeraClase = 0, montoTotalOrlandoPrimeraClase = 0,
                montoTotalCaliforniaPrimeraClase = 0, montoTotalTokioPrimeraClase = 0;
        float montoTotalRegular = 0, montoTotalPreferencial = 0, montoTotalPrimeraClase = 0;
        // Entrada de datos
        for (int registros = 1; registros <= 5; registros++) {
            switch (registros) {
                case 1:
                    ruta = "Belfast";
                    break;
                case 2:
                    ruta = "Reading";
                    break;
                case 3:
                    ruta = "Orlando";
                    break;
                case 4:
                    ruta = "California";
                    break;
                case 5:
                    ruta = "Tokio";
                    break;
            }
            out.println("Esta digitando la ruta: " + ruta);

            out.println("Cuantos viajes se realizaron ");
            viajesRealizados = Integer.parseInt(in.readLine());
            for (int j = 1; j <= viajesRealizados; j++) {
                out.println("Usted esta digitando el vuelo:" + j);

                out.println("Ingrese la cantidad de pasajeros que viajaron en clase regular:");
                pasajeros_regular = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en clase preferencial:");
                pasajeros_preferencial = Integer.parseInt(in.readLine());

                out.println("Ingrese la cantidad de pasajeros que viajaron en primera clase:");
                pasajeros_primera_clase = Integer.parseInt(in.readLine());

            }

            switch (registros) {
                case 1:
                    pasajeros_regular_belfast = pasajeros_regular;
                    pasajeros_preferencial_belfast = pasajeros_preferencial;
                    pasajeros_primera_clase_belfast = pasajeros_primera_clase;

                    totalPasajerosBelfast = pasajeros_regular_belfast + pasajeros_preferencial_belfast
                            + pasajeros_primera_clase_belfast;

                    viajesRealizadosBelfast = viajesRealizados;
                    break;
                case 2:
                    pasajeros_regular_reading = pasajeros_regular;
                    pasajeros_preferencial_reading = pasajeros_preferencial;
                    pasajeros_primera_clase_reading = pasajeros_primera_clase;

                    totalPasajerosReading = pasajeros_regular_reading + pasajeros_preferencial_reading
                            + pasajeros_primera_clase_reading;

                    viajesRealizadosReading = viajesRealizados;
                    break;
                case 3:
                    pasajeros_regular_orlando = pasajeros_regular;
                    pasajeros_preferencial_orlando = pasajeros_preferencial;
                    pasajeros_primera_clase_orlando = pasajeros_primera_clase;

                    totalPasajerosOrlando = pasajeros_regular_orlando + pasajeros_preferencial_orlando
                            + pasajeros_primera_clase_orlando;
                    viajesRealizadosOrlando = viajesRealizados;
                case 4:
                    pasajeros_regular_california = pasajeros_regular;
                    pasajeros_preferencial_california = pasajeros_preferencial;
                    pasajeros_primera_clase_california = pasajeros_primera_clase;

                    totalPasajerosCalifornia = pasajeros_regular_california + pasajeros_preferencial_california
                            + pasajeros_primera_clase_california;

                    viajesRealizadosCalifornia = viajesRealizados;
                    break;
                case 5:
                    pasajeros_regular_tokio = pasajeros_regular;
                    pasajeros_preferencial_tokio = pasajeros_preferencial;
                    pasajeros_primera_clase_tokio = pasajeros_primera_clase;

                    totalPasajerosTokio = pasajeros_regular_tokio + pasajeros_preferencial_tokio
                            + pasajeros_primera_clase_tokio;

                    viajesRealizadosTokio = viajesRealizados;
                    break;
            }
            pasajeros_regular = 0;
            pasajeros_preferencial = 0;
            pasajeros_primera_clase = 0;
        }
        // PROCESO

        for (int registros = 1; registros <= 5; registros++) {
            switch (registros) {
                case 1:
                    distancia = 8331;
                    monto_regular = 365;
                    monto_preferencial = 465;
                    monto_primera_clase = 665;
                    break;
                case 2:
                    distancia = 8707;
                    monto_regular = 470;
                    monto_preferencial = 370;
                    monto_primera_clase = 670;
                    break;
                case 3:
                    distancia = 2077;
                    monto_regular = 375;
                    monto_preferencial = 275;
                    monto_primera_clase = 575;
                    break;
                case 4:
                    distancia = 4861;
                    monto_regular = 390;
                    monto_preferencial = 290;
                    monto_primera_clase = 590;
                    break;
                case 5:
                    distancia = 13183;
                    monto_regular = 650;
                    monto_preferencial = 550;
                    monto_primera_clase = 850;
                    break;
            }
            switch (registros) {
                case 1:
                    kilometrajeTotalBelfast = distancia * viajesRealizadosBelfast;
                    montoTotalBelfastRegular = pasajeros_regular_belfast * monto_regular;
                    montoTotalBelfastPreferencial = pasajeros_preferencial_belfast * monto_preferencial;
                    montoTotalBelfastPrimeraClase = pasajeros_primera_clase_belfast * monto_primera_clase;
                    break;
                case 2:
                    kilometrajeTotalReading = distancia * viajesRealizadosReading;
                    montoTotalReadingRegular = pasajeros_regular_reading * monto_regular;
                    montoTotalReadingPreferencial = pasajeros_preferencial_reading * monto_preferencial;
                    montoTotalReadingPrimeraClase = pasajeros_primera_clase_reading * monto_primera_clase;
                    break;
                case 3:
                    kilometrajeTotalOrlando = distancia * viajesRealizadosOrlando;
                    montoTotalOrlandoRegular = pasajeros_regular_orlando * monto_regular;
                    montoTotalOrlandoPreferencial = pasajeros_preferencial_orlando * monto_preferencial;
                    montoTotalOrlandoPrimeraClase = pasajeros_primera_clase_orlando * monto_primera_clase;
                    break;
                case 4:
                    kilometrajeTotalCalifornia = distancia * viajesRealizadosCalifornia;
                    montoTotalCaliforniaRegular = pasajeros_regular_california * monto_regular;
                    montoTotalCaliforniaPreferencial = pasajeros_preferencial_california * monto_preferencial;
                    montoTotalCaliforniaPrimeraClase = pasajeros_primera_clase_california * monto_primera_clase;
                    break;
                case 5:
                    kilometrajeTotalTokio = distancia * viajesRealizadosTokio;
                    montoTotalTokioRegular = pasajeros_regular_tokio * monto_regular;
                    montoTotalTokioPreferencial = pasajeros_preferencial_tokio * monto_preferencial;
                    montoTotalTokioPrimeraClase = pasajeros_primera_clase_tokio * monto_primera_clase;
                    break;
            }

        } // fin de for

        // 1 total pasajeros de todos los vuelos
        totalPasajeronDeTodosLosVuelos = totalPasajerosBelfast + totalPasajerosCalifornia + totalPasajerosOrlando
                + totalPasajerosTokio + totalPasajerosReading;
        // 2 total kilometraje de todos los vuelos
        kilometrajeTotal = kilometrajeTotalBelfast + kilometrajeTotalCalifornia + kilometrajeTotalOrlando
                + kilometrajeTotalReading + kilometrajeTotalTokio;
        // 3
        // numero mayor de todos los pasajeros de las diferentes clases
        // sacamos numero mayor
        if (viajesRealizadosBelfast > numMayor) {
            numMayor = viajesRealizadosBelfast;
            rutaConMasViajes = "Belfast";
        }
        if (viajesRealizadosReading > numMayor) {
            numMayor = viajesRealizadosReading;
            rutaConMasViajes = "Reading";
        }
        if (viajesRealizadosOrlando > numMayor) {
            numMayor = viajesRealizadosOrlando;
            rutaConMasViajes = "Orlando";
        }
        if (viajesRealizadosCalifornia > numMayor) {
            numMayor = viajesRealizadosCalifornia;
            rutaConMasViajes = "California";
        }
        if (viajesRealizadosTokio > numMayor) {
            numMayor = viajesRealizadosTokio;
            rutaConMasViajes = "Tokio";
        }

        // 4 total de dinero todos los pasajeros regular
        montoTotalRegular = montoTotalBelfastRegular + montoTotalReadingRegular + montoTotalOrlandoRegular
                + montoTotalCaliforniaRegular + montoTotalTokioRegular;
        // 5 total de dinero todos los pasajeros preferencial
        montoTotalPreferencial = montoTotalBelfastPreferencial + montoTotalReadingPreferencial
                + montoTotalOrlandoPreferencial
                + montoTotalCaliforniaPreferencial + montoTotalTokioPreferencial;
        // 5 total de dinero todos los pasajeros primera clase
        montoTotalPrimeraClase = montoTotalBelfastPrimeraClase + montoTotalReadingPrimeraClase
                + montoTotalOrlandoPrimeraClase
                + montoTotalCaliforniaPrimeraClase + montoTotalTokioPrimeraClase;
        //
        //
        // SALIDAS
        // salida de todos los pasajeros
        out.println("El total de pasajeros de todos los vuelos es: " + totalPasajeronDeTodosLosVuelos + " pasajeros");
        // salida de kilometraje total
        out.println("El kilometraje total recorrido entre todos los vuelos en ese día es: " + kilometrajeTotal
                + " kilometros");
        // salida del numero de pasajeros mayor por aerolinea
        out.println("La ruta con más viajes pertenece a: " + rutaConMasViajes + " el cual tuvo un total de viajes de "
                + numMayor);
        // salida de numero de regular, preferencial, y de primera clase
        out.println("El monto total de todos los pasajeros de la clase regular es: " + montoTotalRegular);
        out.println("El monto total de todos los pasajeros de la clase preferencial es: " + montoTotalPreferencial);
        out.println("El monto total de todos los pasajeros de la primera clase es: " + montoTotalPrimeraClase);
        // ingreso generado por cada ruta
        for (int k = 1; k <= 5; k++) {
            switch (k) {
                case 1:
                    ruta = "Belfast";
                    ingresos_regular = montoTotalBelfastRegular;
                    ingresos_preferencial = montoTotalBelfastPreferencial;
                    ingresos_primera_clase = montoTotalBelfastPrimeraClase;
                    total_ingresos = montoTotalBelfastRegular + montoTotalBelfastPreferencial
                            + montoTotalBelfastPrimeraClase;
                    break;
                case 2:
                    ruta = "Reading";
                    ingresos_regular = montoTotalReadingRegular;
                    ingresos_preferencial = montoTotalReadingPreferencial;
                    ingresos_primera_clase = montoTotalReadingPrimeraClase;
                    total_ingresos = montoTotalReadingRegular + montoTotalReadingPreferencial
                            + montoTotalReadingPrimeraClase;
                    break;
                case 3:
                    ruta = "Orlando";
                    ingresos_regular = montoTotalOrlandoRegular;
                    ingresos_preferencial = montoTotalOrlandoPreferencial;
                    ingresos_primera_clase = montoTotalOrlandoPrimeraClase;
                    total_ingresos = montoTotalOrlandoRegular + montoTotalOrlandoPreferencial
                            + montoTotalOrlandoPrimeraClase;
                    break;
                case 4:
                    ruta = "California";
                    ingresos_regular = montoTotalCaliforniaRegular;
                    ingresos_preferencial = montoTotalCaliforniaPreferencial;
                    ingresos_primera_clase = montoTotalCaliforniaPrimeraClase;
                    total_ingresos = montoTotalCaliforniaRegular + montoTotalCaliforniaPreferencial
                            + montoTotalCaliforniaPrimeraClase;
                    break;
                case 5:
                    ruta = "Tokio";
                    ingresos_regular = montoTotalTokioRegular;
                    ingresos_preferencial = montoTotalTokioPreferencial;
                    ingresos_primera_clase = montoTotalTokioPrimeraClase;
                    total_ingresos = montoTotalTokioRegular + montoTotalTokioPreferencial + montoTotalTokioPrimeraClase;
                    break;
            }
            out.println("El registro solo de la ruta:" + ruta);
            out.println("El total de ingresos generados por los pasajeros regular  es de:"
                    + ingresos_regular);
            out.println("El total de ingresos generados por los pasajeros preferencial es de:"
                    + ingresos_preferencial);
            out.println(
                    "El total de ingresos generados por los pasajeros de primera clase es de:"
                            + ingresos_primera_clase);
            out.println("Y el total de ingresos es de " + total_ingresos);
        }

    }
}
