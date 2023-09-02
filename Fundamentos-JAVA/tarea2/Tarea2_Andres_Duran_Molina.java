package tarea2;

import java.io.*;

public class Tarea2_Andres_Duran_Molina {
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        static PrintStream out = System.out;

        public static void main(String[] args) throws IOException {
                int pts;

                out.println(
                                "Bienvenido, a continuación se mostrara los requisitos para renovar la licencia, son los siguientes:");
                out.println(
                                "Tener documento de identificación al día y en buen estado, tener vigente el dictamen médico digital para licencia, pagar todas las multas de tránsito que tenga pendientes y no haber llegado a los 12 puntos acumulados por infracciones de tránsito.");
                out.println(
                                "Para los usuarios que llegaron a los 12 puntos o más por infracciones de tránsito, se les suspende la licencia y no puede hacer la renovación.");
                out.println("Para los usuarios cuya licencia no ha sido suspendida estos son los requisitos:");
                out.println(
                                "Pagar el monto a cancelar para la renovación de la licencia en colones, y se le indicara los años vigentes de esta, además si el usuario renueva la licencia en el Banco de Costa Rica, el costo tiene un recargo de 4.200 colones por el servicio prestado por el banco.");
                out.println("Los costes y vigencia de la licencia se define a continuación:");
                out.println(
                                " Si tiene menos de 4 puntos acumulados, tiene que pagar por la renovación 5.000 colones, y la licencia nueva tendrá vigencia por 6 años.");
                out.println(
                                " Si tiene entre 5 y 8 puntos acumulados, tiene que pagar 10.000 colones por la renovación de la licencia, y la licencia nueva tendrá vigencia por 4 años.");
                out.println(
                                " Si tiene entre 9 y 11 puntos acumulados a la hora de renovar la licencia, el costo de renovación es de 10.000 colones y la licencia nueva tendrá vigencia por 3 años.");

                out.println("Por favor ingrese la cantidad de puntos acumulados: ");
                pts = Integer.parseInt(in.readLine());

                if ((pts > 0)) {
                        if ((pts > 0) && (pts < 5)) {
                                out.println("No tiene suspendida la licencia y puede renovarla.");
                                out.println(
                                                "El monto a cancelar por la renovación es de 5.000 colones y la licencia será vigente por 6 años.");
                        }
                        if ((pts > 4) && (pts < 9)) {
                                out.println("No tiene suspendida la licencia y puede renovarla.");
                                out.println(
                                                "El monto a cancelar por la renovación es de 10.000 colones y la licencia será vigente por 4 años.");
                        }
                        if ((pts > 8) && (pts < 12)) {
                                out.println("No tiene suspendida la licencia y puede renovarla.");
                                out.println(
                                                "El monto a cancelar por la renovación es de 10.000 colones y la licencia será vigente por 3 años.");
                        }
                        if (pts > 11) {
                                out.println("Se le suspende la licencia y no puede renovarla.");
                        }
                } else {
                        out.println("Usted no tiene saldos pendientes.");
                }
        }// *Alison estuvo aqui xD//
}