package semana_9.miercoles;

import java.io.*;

public class exampleVolumenEsfera {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static double volumenEsfera(double radio) {
        double volumen;
        volumen = (4 / 3) * Math.PI * Math.pow(radio, 3);

        return volumen;
    }

    public static double volumenCubo(double base, double ancho, double altura) {
        double volumen;

        volumen = base * altura * ancho;

        return volumen;
    }

    public static double volumenCilintro(double altura, double radio) {
        double volumen;

        volumen = altura * Math.PI * Math.pow(radio, 2);

        return volumen;
    }

    public static void entrada() throws IOException {
        double vEsfera, vCubo, vCilintro;
        double radioEsfera, baseCubo, anchoCubo, alturaCubo, alturaCilintro, radioCilintro, totalMaterial;
        int totalEsferas, totalCubos, totalCilintro;

        out.println("Ingrese el radio de la esfera");
        radioEsfera = Double.parseDouble(in.readLine());

        out.println("Ingrese la cantidad de esferas");
        totalEsferas = Integer.parseInt(in.readLine());

        vEsfera = totalEsferas * (volumenEsfera(radioEsfera));

        out.println("Ingrese la base del cubo");
        baseCubo = Double.parseDouble(in.readLine());

        out.println("Ingrese el ancho del cubo");
        anchoCubo = Double.parseDouble(in.readLine());

        out.println("Ingrese la altura del cubo");
        alturaCubo = Double.parseDouble(in.readLine());

        out.println("Ingrese la cantidad de cubos");
        totalCubos = Integer.parseInt(in.readLine());

        vCubo = totalCubos * volumenCubo(baseCubo, anchoCubo, alturaCubo);

        out.println("Ingrese la altura del cilindro");
        alturaCilintro = Double.parseDouble(in.readLine());

        out.println("Ingrese el radio del cilindro");
        radioCilintro = Double.parseDouble(in.readLine());

        out.println("Ingrese la cantidad de cilintros");
        totalCilintro = Integer.parseInt(in.readLine());

        vCilintro = totalCilintro * volumenCilintro(alturaCilintro, radioCilintro);

        totalMaterial = vEsfera + vCubo + vCilintro;

        out.print("El total de madera que se necesita es de: " + totalMaterial + " Metros cubicos");
    }

    public static void main(String[] args) throws IOException {

        entrada();

    }
}
