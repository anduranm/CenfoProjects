package tarea1;

import java.io.*;

public class AndresDuranMolina_Tarea1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        /*
         * Haga un programa en Java que calcule el monto en colones de la liquidación de
         * un trabajador en Costa Rica en caso de que la terminación del contrato sea
         * con responsabilidad patronal.El monto de la liquidación se calcula sumando.
         * los siguientes montos: salarios pendientes, vacaciones no gozadas, aguinaldo
         * proporcional, preaviso y cesantía.
         */

        // declaracion de variantes
        int salario,
                salarioPendiente,
                mesesSalarioPendiente,
                saldoVacaciones,
                mesesVacaciones,
                mesesPendientesAguinaldo,
                aguinaldo,
                preaviso,
                anniosCesantia,
                cesantia,
                liquidacion,
                darPreaviso;

        // entradas
        out.print("Digite su salario:");
        salario = Integer.parseInt(in.readLine());

        out.print("Digite cuantos meses de salario tiene pendientes: ");
        mesesSalarioPendiente = Integer.parseInt(in.readLine());

        out.print("Digite cuantos dias de vacaciones tiene pendientes: ");
        mesesVacaciones = Integer.parseInt(in.readLine());

        out.print("Digite cuantos meses de aguinaldo proporcional tiene pendiente: ");
        mesesPendientesAguinaldo = Integer.parseInt(in.readLine());

        out.print("Realiza preaviso? responder con 0 o 1 (0=Si / 1=No)");
        darPreaviso = Integer.parseInt(in.readLine());

        out.print("Digite cuantos años tiene laborando en la empresa: ");
        anniosCesantia = Integer.parseInt(in.readLine());

        // proceeso
        salarioPendiente = salario * mesesSalarioPendiente;
        saldoVacaciones = (salario / 30) * mesesVacaciones;
        aguinaldo = (salario * mesesPendientesAguinaldo) / 12;
        preaviso = salario * darPreaviso;
        cesantia = (salario / 30) * (20 * anniosCesantia);
        liquidacion = salarioPendiente + saldoVacaciones + aguinaldo + preaviso + cesantia;

        // salida
        out.println("Su liquidación corresponde a:" + liquidacion);

    }
}
