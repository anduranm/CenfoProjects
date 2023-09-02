package semana_5.miercoles;

import java.io.*;

public class calculo_salario {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int codigoPuesto, salarioFinal, salarioBase = 0, horasExtraTrabajadas, valorHoraExtra = 0;

        out.println("Ingrese el código de puesto: ");
        codigoPuesto = Integer.parseInt(in.readLine());
        if (0 < codigoPuesto && codigoPuesto < 5) {
            switch (codigoPuesto) {
                case 1: /* ingieniero civil */
                    salarioBase = 750000;
                    valorHoraExtra = 6250;
                    break;
                case 2: /* ingeniero de software */
                    salarioBase = 1300000;
                    valorHoraExtra = 10800;
                    break;
                case 3: /* ingeniero electrico */
                    salarioBase = 675000;
                    valorHoraExtra = 5625;
                    break;
                case 4: /* ingeniero industrial */
                    salarioBase = 1150000;
                    valorHoraExtra = 0;
                    break;
                default:
                    break;
            }

            out.println("Ingrese las horas extra trabajadas: ");
            horasExtraTrabajadas = Integer.parseInt(in.readLine());
            if (horasExtraTrabajadas > 30) {
                horasExtraTrabajadas = 30;
            }

            salarioFinal = (horasExtraTrabajadas * valorHoraExtra) + salarioBase;

            out.println("Su salario mensual corresponde a: ¢" + salarioFinal);
        } else {
            out.println("El código de puesto es inválido.");
        }

    }
}