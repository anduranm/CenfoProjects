package tarea2;

import java.io.*;

public class Tarea2_SwitchCase {
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        static PrintStream out = System.out;

        public static void main(String[] args) throws IOException {
                int pts;

                out.println(
                                "Bienvenido, a continuación se mostrara los requisitos para renovar la licencia, son los siguientes:\n Tener documento de identificación al día y en buen estado, tener vigente el dictamen médico digital para licencia, pagar todas las multas de tránsito que tenga pendientes y no haber llegado a los 12 puntos acumulados por infracciones de tránsito.\n Para los usuarios que llegaron a los 12 puntos o más por infracciones de tránsito, se les suspende la licencia y no puede hacer la renovación. \n Para los usuarios cuya licencia no ha sido suspendida estos son los requisitos: \n Pagar el monto a cancelar para la renovación de la licencia en colones, y se le indicara los años vigentes de esta, además si el usuario renueva la licencia en el Banco de Costa Rica, el costo tiene un recargo de 4.200 colones por el servicio prestado por el banco.\n Los costes y vigencia de la licencia se define a continuación: \n Si tiene menos de 4 puntos acumulados, tiene que pagar por la renovación 5.000 colones, y la licencia nueva tendrá vigencia por 6 años. \n Si tiene entre 5 y 8 puntos acumulados, tiene que pagar 10.000 colones por la renovación de la licencia, y la licencia nueva tendrá vigencia por 4 años. \n Si tiene entre 9 y 11 puntos acumulados a la hora de renovar la licencia, el costo de renovación es de 10.000 colones y la licencia nueva tendrá vigencia por 3 años.");

                out.println("Por favor ingrese la cantidad de puntos acumulados: ");
                pts = Integer.parseInt(in.readLine());

                switch ((0 < pts && pts < 5) ? 0
                                : (4 < pts && pts < 9) ? 1
                                                : (8 < pts && pts < 12) ? 2
                                                                : (11 < pts) ? 3
                                                                                : 4) {
                        case 0:
                                out.println("No tiene suspendida la licencia y puede renovarla.");
                                out.println(
                                                "El monto a cancelar por la renovación es de 5.000 colones y la licencia será vigente por 6 años.");
                                break;

                        case 1:
                                out.println("No tiene suspendida la licencia y puede renovarla.");
                                out.println(
                                                "El monto a cancelar por la renovación es de 10.000 colones y la licencia será vigente por 4 años.");
                                break;

                        case 2:
                                out.println("No tiene suspendida la licencia y puede renovarla.");
                                out.println(
                                                "El monto a cancelar por la renovación es de 10.000 colones y la licencia será vigente por 3 años.");
                                break;
                        case 3:
                                out.println("Se le suspende la licencia y no puede renovarla.");
                                break;

                        default:
                                out.println("No tiene saldo pendientes.");
                                break;
                }
        }
}