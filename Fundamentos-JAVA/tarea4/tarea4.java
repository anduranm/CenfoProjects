package tarea4;

import java.io.*;

public class tarea4 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static String elMayorConsumo;
    static double consumoPunta;
    static double consumoValle;
    static double consumoNoct;

    public static void entradaDatos() throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        String opcion;
        out.println("Bienvenido al Nacional de Fuerza y Luz de Costa Rica seleccione la opción a solicitar:");
        do {
            out.println("Ingrese una opción: ");
            out.println("A. Calcular el mes con más consumo");
            out.println("B. Calcular la eco-factura del mes");
            out.println("C. Calcular la eco-factura para locales comerciales");
            out.println("Q. Salir");
            opcion = in.readLine().toUpperCase();
            switch (opcion) {
                case "A":
                    mesMayorConsumo();
                    break;
                case "B":
                    calcularEcoFactura();
                    break;
                case "C":
                    calcularEcoFacturaComercial();
                    break;
                case "Q":
                    out.println("Saliendo del programa...");
                    break;
                default:
                    out.println("Opción inválida.");
                    break;
            }
        } while (!opcion.equals("Q"));
    }

    public static void mesMayorConsumo() throws IOException {
        int mayorConsumo = 0, consumo;
        String elMayorConsumo = "", nombreMes;
        for (int i = 1; i <= 6; i++) {
            out.println("Ingrese el nombre del mes #" + i + ": ");
            nombreMes = in.readLine();
            out.println("Ingrese el consumo en KWH para el mes de " + nombreMes + ": ");
            consumo = Integer.parseInt(in.readLine());
            if (consumo > mayorConsumo) {
                mayorConsumo = consumo;
                elMayorConsumo = nombreMes;
            }
        }
        out.println("El mes con mayor consumo fue " + elMayorConsumo);
    }

    public static void calcularEcoFactura() throws IOException {

        String mesEcofactura;
        double total, montoIVA, montoAlumbradoPublico, montoTributoBomberos,
                totalConsumidoEnMes,
                montoEnergia,
                consumoPunta,
                consumoValle,
                consumoNoct;

        out.print("Ingrese el nombre del mes que desea facturar: ");
        mesEcofactura = in.readLine();

        out.println("Ingrese el consumo en horario punta (KWH): ");
        consumoPunta = Integer.parseInt(in.readLine());

        out.println("Ingrese el consumo en horario valle (KWH): ");
        consumoValle = Integer.parseInt(in.readLine());

        out.println("Ingrese el consumo en horario nocturno (KWH): ");
        consumoNoct = Integer.parseInt(in.readLine());

        totalConsumidoEnMes = consumoPunta + consumoValle + consumoNoct;
        montoEnergia = montoEnergia(consumoPunta, consumoValle, consumoNoct);

        montoAlumbradoPublico = montoAlumbradoPublico(totalConsumidoEnMes);
        montoTributoBomberos = montoTributoBomberos(totalConsumidoEnMes);
        montoIVA = montoIVA(totalConsumidoEnMes, montoEnergia);
        total = montoEnergia + montoAlumbradoPublico + montoTributoBomberos + montoIVA;

        out.println("Eco-factura del mes de " + mesEcofactura);
        out.println("Consumo total de KWH consumidos en el mes: " + totalConsumidoEnMes + " KWH");
        out.println("Monto correspondiente a Energía: " + montoEnergia + " colones");
        out.println("Monto correspondiente a alumbrado público: " + montoAlumbradoPublico + " colones");
        out.println("Monto correspondiente al tributo a bomberos: " + montoTributoBomberos + " colones");
        out.println("Monto correspondiente al IVA: " + montoIVA + " colones");
        out.println("Total a pagar en la factura: " + total + " colones");
    }

    public static double montoEnergia(double consumoPunta, double consumoValle, double consumoNoct) {
        double monto = 0;
        if (consumoPunta + consumoValle + consumoNoct <= 500) {
            consumoPunta = consumoPunta * 167.72;
            consumoValle = consumoValle * 68.75;
            consumoNoct = consumoNoct * 28.77;

        } else {
            consumoPunta = consumoPunta * 207.39;
            consumoValle = consumoValle * 83.71;
            consumoNoct = consumoNoct * 38.74;
        }
        monto = consumoPunta + consumoValle + consumoNoct;
        return monto;
    }

    public static double montoAlumbradoPublico(double totalConsumidoEnMes) {
        double monto;
        monto = totalConsumidoEnMes * 3.37;
        return monto;
    }

    public static double montoTributoBomberos(double totalConsumidoEnMes) {
        double monto;
        monto = totalConsumidoEnMes * 0.0175;
        return monto;
    }

    public static double montoIVA(double totalConsumidoEnMes, double montoEnergia) {
        double monto;
        if (totalConsumidoEnMes >= 280) {
            monto = montoEnergia * 0.13;
        } else {
            monto = 0;
        }
        return monto;
    }

    public static void calcularEcoFacturaComercial() throws IOException {
        String mesEcofactura;
        double totalConsumidoEnMes, consumoPotencia, montoEnergia,
                montoPotencia, totalPagar,
                montoAlumbradoPublico,
                montoTributoBomberos,
                montoIVA;

        out.println("Ingrese el nombre del mes que desea facturar: ");
        mesEcofactura = in.readLine();

        out.println("Ingrese el total de KWH consumidos en el mes por energía: ");
        totalConsumidoEnMes = Double.parseDouble(in.readLine());

        out.println("Ingrese el total de KW consumidos en el mes por potencia: ");
        consumoPotencia = Double.parseDouble(in.readLine());

        montoEnergia = montoEnergiaComercial(totalConsumidoEnMes);
        montoPotencia = montoPotenciaComercial(consumoPotencia);

        montoAlumbradoPublico = montoAlumbradoPublico(totalConsumidoEnMes);
        montoTributoBomberos = montoTributoBomberos(totalConsumidoEnMes);

        montoIVA = montoIVA(totalConsumidoEnMes, montoPotencia);

        totalPagar = montoEnergia + montoPotencia + montoAlumbradoPublico + montoTributoBomberos + montoIVA;

        out.println("Eco-factura para locales comerciales del mes de " + mesEcofactura);
        out.println("Total de KWH consumidos en el mes: " + totalConsumidoEnMes);
        out.println("Total de KW consumidos por potencia en el mes: " + consumoPotencia);
        out.println("Monto correspondiente a energía: " + montoEnergia);
        out.println("Monto correspondiente a potencia: " + montoPotencia);
        out.println("Monto correspondiente a alumbrado público: " + montoAlumbradoPublico);
        out.println("Monto correspondiente al tributo a bomberos: " + montoTributoBomberos);
        out.println("Monto correspondiente al IVA: " + montoIVA);
        out.println("Total a pagar en la factura: " + totalPagar);
    }

    public static double montoEnergiaComercial(double totalConsumidoEnMes) {
        double monto;
        if (totalConsumidoEnMes <= 3000) {
            monto = 221160;
        } else {
            monto = 221160 + (totalConsumidoEnMes - 3000) * 73.72;
        }
        return monto;
    }

    public static double montoPotenciaComercial(double consumoPotencia) {
        double monto;
        if (consumoPotencia <= 8) {
            monto = 92311.68;
        } else {
            monto = 92311.68 + (consumoPotencia - 8) * 11538.96;
        }
        return monto;
    }

    public static void main(String[] args) throws IOException {
        entradaDatos();
    }
}
