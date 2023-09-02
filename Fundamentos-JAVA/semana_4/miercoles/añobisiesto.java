package semana_4.miercoles;

import java.io.*;

public class añobisiesto {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int dd, mm, aa, bisiesto, fecha_erronea = 1;

        out.print("Ingrese el dia: ");
        dd = Integer.parseInt(in.readLine());

        out.print("Ingrese el mes: ");
        mm = Integer.parseInt(in.readLine());

        out.print("Ingrese el annio: ");
        aa = Integer.parseInt(in.readLine());

        if ((aa % 4 == 0) && (aa % 100 != 0) || (aa % 400 == 0)) {
            bisiesto = 1;
        } else {
            bisiesto = 0;
        }

        if (bisiesto == 1) {
            if (mm == 2) {
                if (dd >= 1 && dd <= 28) {
                    dd = dd + 1;
                } else {
                    if (dd == 29) {
                        dd = 1;
                        mm = mm + 1;
                    } else {
                        out.println("Ingreso un dia invalido");
                        fecha_erronea = 0;
                    }
                }

            } else {
                if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
                    if (dd >= 1 && dd <= 30) {
                        dd = dd + 1;
                    } else {
                        if (dd == 31) {
                            if (mm == 12) {
                                dd = 1;
                                mm = 1;
                                aa = aa + 1;
                            } else {
                                dd = 1;
                                mm = mm + 1;
                            }
                        } else {
                            out.println("Ingreso un dia invalido");
                            fecha_erronea = 0;
                        }

                    }

                } else {
                    if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
                        if (dd >= 1 && dd <= 29) {
                            dd = dd + 1;
                        } else {
                            if (dd == 30) {
                                dd = 1;
                                mm = mm + 1;
                            } else {
                                out.println("Ingreso un dia invalido");
                                fecha_erronea = 0;
                            }
                        }
                    } else {
                        out.print("Ingreso un mes invalido");
                        fecha_erronea = 0;
                    }
                }
            }

        } else {
            if (mm == 2) {
                if (dd >= 1 && dd <= 27) {
                    dd = dd + 1;
                } else {
                    if (dd == 28) {
                        dd = 1;
                        mm = mm + 1;
                    } else {
                        out.println("Ingreso un dia invalido");
                        fecha_erronea = 0;
                    }
                }

            } else {
                if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
                    if (dd >= 1 && dd <= 30) {
                        dd = dd + 1;
                    } else {
                        if (dd == 31) {
                            if (mm == 12) {
                                dd = 1;
                                mm = 1;
                                aa = aa + 1;
                            } else {
                                dd = 1;
                                mm = mm + 1;
                            }
                        } else {
                            out.println("Ingreso un dia invalido");
                            fecha_erronea = 0;
                        }

                    }

                } else {
                    if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
                        if (dd >= 1 && dd <= 29) {
                            dd = dd + 1;
                        } else {
                            if (dd == 30) {
                                dd = 1;
                                mm = mm + 1;
                            } else {
                                out.println("Ingreso un dia invalido");
                                fecha_erronea = 0;
                            }
                        }
                    } else {
                        out.print("Ingreso un mes invalido");
                        fecha_erronea = 0;
                    }
                }
            }

        }
        if (fecha_erronea == 1) {
            out.println("Mañana es: " + dd + "/" + mm + "/" + aa);
        }

    }

}