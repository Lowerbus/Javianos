import java.util.Scanner;

public class Partida {
    public static void main(String[] args) {

        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Qué modo desea jugar? ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Cómo se llama el jugador 1? ");
        String nombre1 = scanner.nextLine();
        int puntajeJ1 = 0;

        System.out.print("¿Cómo se llama el jugador 2? ");
        String nombre2 = scanner.nextLine();
        int puntajeJ2 = 0;

        Jugador.Ficha[] tablero = new Jugador.Ficha[100];
        int turnoJugador = -1;
        int fichasJ1 = 0;
        int fichasJ2 = 0;
        int fichasLI = 0;
        int fichaLD = 0;

        while (puntajeJ1 < 70 && puntajeJ2 < 70) {
            System.out.println("\n--- NUEVA RONDA ---");
            System.out.println("Jugador 1: " + nombre1);
            u1.setnombre(nombre1);
            j1.elegirModo(numero);
            System.out.println("");

            System.out.println("Jugador 2: " + nombre2);
            u2.setnombre(nombre2);
            j2.elegirModo(numero);

            fichasJ1 = 7;
            fichasJ2 = 7;

            boolean encontradoDoble = false;
            int indiceDobleJugador = -1;
            int quienTieneElDoble = -1;
            int dobleBuscado = numero;


            while (dobleBuscado >= 0 && !encontradoDoble) {
                for (int i = 0; i < 7; i++) {
                    if (j1.getMano()[i] != null && j1.getMano()[i].ladoA == dobleBuscado && j1.getMano()[i].ladoB == dobleBuscado) {
                        encontradoDoble = true;
                        indiceDobleJugador = i;
                        quienTieneElDoble = 1;
                        break;
                    }
                }

                if (!encontradoDoble) {
                    for (int i = 0; i < 7; i++) {
                        if (j2.getMano()[i] != null && j2.getMano()[i].ladoA == dobleBuscado && j2.getMano()[i].ladoB == dobleBuscado) {
                            encontradoDoble = true;
                            indiceDobleJugador = i;
                            quienTieneElDoble = 2;
                            break;
                        }
                    }
                }

                if (!encontradoDoble) {
                    dobleBuscado--;
                }
            }

            fichasLI = 49;
            fichaLD = 51;

            if (encontradoDoble) {
                if (quienTieneElDoble == 1) {
                    tablero[50] = j1.getMano()[indiceDobleJugador];
                    j1.getMano()[indiceDobleJugador] = null;
                    fichasJ1--;
                    turnoJugador = 1;
                    System.out.println("¡" + nombre1 + " coloca el doble " + dobleBuscado + "|" + dobleBuscado + " y pasa el turno a " + nombre2 + "!");
                } else {
                    tablero[50] = j2.getMano()[indiceDobleJugador];
                    j2.getMano()[indiceDobleJugador] = null;
                    fichasJ2--;
                    turnoJugador = 0;
                    System.out.println("¡" + nombre2 + " coloca el doble " + dobleBuscado + "|" + dobleBuscado + " y pasa el turno a " + nombre1 + "!");
                }
            } else {
                tablero[50] = j1.getMano()[0];
                j1.getMano()[0] = null;
                fichasJ1--;
                turnoJugador = 1;
                System.out.println("Comienza " + nombre1 + " colocando " + tablero[50] + " y pasa el turno a " + nombre2);
            }

            System.out.println("tablero: " + tablero[50] + "\n");
            while (fichasJ1 > 0 && fichasJ2 > 0) {

                while (turnoJugador == 0 && fichasJ1 > 0 && fichasJ2 > 0) {
                    System.out.println("");
                    System.out.println(nombre1);
                    printTablero(tablero, fichasLI, fichaLD);
                    printManoJugador(j1, nombre1);

                    System.out.println("\n¿Qué desea hacer?");
                    System.out.println("1: Colocar una ficha");
                    System.out.println("2: Tomar del pozo");
                    System.out.println("3: Pasar");
                    int opcion = scanner.nextInt();

                    if (opcion == 1) {
                        System.out.println("¿Qué número de ficha de tu mano desea colocar? ");
                        int numero3 = scanner.nextInt();

                        System.out.println("¿De qué lado desea colocarlo? (1: Izquierdo, 2: Derecho)");
                        int lado = scanner.nextInt();

                        if (lado == 1) {
                            if (numero3 >= 0 && numero3 < 7 && j1.getMano()[numero3] != null &&
                                    (j1.getMano()[numero3].ladoB == 99 || tablero[fichasLI + 1].ladoA == 99 || j1.getMano()[numero3].ladoB == tablero[fichasLI + 1].ladoA)) {

                                tablero[fichasLI] = j1.getMano()[numero3];
                                j1.getMano()[numero3] = null;
                                fichasLI--;
                                fichasJ1--;
                                turnoJugador = 1;
                            } else {
                                System.out.println("Ficha inválida");
                            }
                        } else if (lado == 2) {
                            if (numero3 >= 0 && numero3 < 7 && j1.getMano()[numero3] != null &&
                                    (tablero[fichaLD - 1].ladoB == 99 || j1.getMano()[numero3].ladoA == 99 || tablero[fichaLD - 1].ladoB == j1.getMano()[numero3].ladoA)) {

                                tablero[fichaLD] = j1.getMano()[numero3];
                                j1.getMano()[numero3] = null;
                                fichaLD++;
                                fichasJ1--;
                                turnoJugador = 1;
                            } else {
                                System.out.println("Ficha inválida");
                            }
                        }
                    } else if (opcion == 2) {
                        Jugador.Ficha nuevaFicha = j1.tomarDelPozo(numero);
                        boolean agregado = false;
                        for (int i = 0; i < j1.getMano().length; i++) {
                            if (j1.getMano()[i] == null) {
                                j1.getMano()[i] = nuevaFicha;
                                fichasJ1++;
                                agregado = true;
                                System.out.println("Has tomado del pozo la ficha: " + nuevaFicha + " y se guardó en la posición [" + i + "]");
                                break;
                            }
                        }
                        if (!agregado) {
                            System.out.println("No hay espacios vacíos.");
                        }
                        turnoJugador = 1;
                    } else if (opcion == 3) {
                        turnoJugador = 1;
                    }
                }
                while (turnoJugador == 1 && fichasJ1 > 0 && fichasJ2 > 0) {
                    System.out.println("");
                    System.out.println(nombre2);
                    printTablero(tablero, fichasLI, fichaLD);
                    printManoJugador(j2, nombre2);

                    System.out.println("\n¿Qué desea hacer?");
                    System.out.println("1: Colocar una ficha");
                    System.out.println("2: Tomar del pozo");
                    System.out.println("3: Pasar");
                    int opcion = scanner.nextInt();

                    if (opcion == 1) {
                        System.out.println("¿Qué número de ficha de tu mano desea colocar? (0 a 6)");
                        int numero3 = scanner.nextInt();

                        System.out.println("¿De qué lado desea colocarlo? (1: Izquierdo, 2: Derecho)");
                        int lado = scanner.nextInt();

                        if (lado == 1) {
                            if (numero3 >= 0 && numero3 < 7 && j2.getMano()[numero3] != null &&
                                    (j2.getMano()[numero3].ladoB == 99 || tablero[fichasLI + 1].ladoA == 99 || j2.getMano()[numero3].ladoB == tablero[fichasLI + 1].ladoA)) {

                                tablero[fichasLI] = j2.getMano()[numero3];
                                j2.getMano()[numero3] = null;
                                fichasLI--;
                                fichasJ2--;
                                turnoJugador = 0;
                            } else {
                                System.out.println(" Ficha inválida.");
                            }
                        } else if (lado == 2) {
                            if (numero3 >= 0 && numero3 < 7 && j2.getMano()[numero3] != null &&
                                    (tablero[fichaLD - 1].ladoB == 99 || j2.getMano()[numero3].ladoA == 99 || tablero[fichaLD - 1].ladoB == j2.getMano()[numero3].ladoA)) {

                                tablero[fichaLD] = j2.getMano()[numero3];
                                j2.getMano()[numero3] = null;
                                fichaLD++;
                                fichasJ2--;
                                turnoJugador = 0;
                            } else {
                                System.out.println("Ficha inválida.");
                            }
                        }
                    } else if (opcion == 2) {
                        Jugador.Ficha nuevaFicha = j2.tomarDelPozo(numero);
                        boolean agregado = false;
                        for (int i = 0; i < j2.getMano().length; i++) {
                            if (j2.getMano()[i] == null) {
                                j2.getMano()[i] = nuevaFicha;
                                fichasJ2++;
                                agregado = true;
                                System.out.println(" Has tomado del pozo la ficha: " + nuevaFicha + " y se guardó en la posición [" + i + "]");
                                break;
                            }
                        }
                        if (!agregado) {
                            System.out.println("⚠️ No hay espacios vacíos en tu mano para tomar otra ficha.");
                        }
                        turnoJugador = 0;
                    } else if (opcion == 3) {
                        turnoJugador = 0;
                    }
                }
            }

            if (fichasJ1 <= 0) {
                System.out.println(" ¡" + nombre1 + " se ha quedado sin fichas y gana la ronda!");

                int puntosGanados = 0;
                for (Jugador.Ficha f : j2.getMano()) {
                    if (f != null) {

                        int valA = (f.ladoA == 99) ? 0 : f.ladoA;
                        int valB = (f.ladoB == 99) ? 0 : f.ladoB;
                        puntosGanados += (valA + valB);
                    }
                }
                puntajeJ1 += puntosGanados;
                System.out.println("Puntos sumados a " + nombre1 + ": +" + puntosGanados + " (Total acumulado: " + puntajeJ1 + ")");

            } else if (fichasJ2 <= 0) {
                System.out.println("\n ¡" + nombre2 + " se ha quedado sin fichas y gana la ronda!");

                int puntosGanados = 0;
                for (Jugador.Ficha f : j1.getMano()) {
                    if (f != null) {
                        int valA = (f.ladoA == 99) ? 0 : f.ladoA;
                        int valB = (f.ladoB == 99) ? 0 : f.ladoB;
                        puntosGanados += (valA + valB);
                    }
                }
                puntajeJ2 += puntosGanados;
                System.out.println("Puntos sumados a " + nombre2 + ": +" + puntosGanados + " (Total acumulado: " + puntajeJ2 + ")");
            }

            break;
        }

        if (70 <= puntajeJ1) {
            System.out.println(" ¡" + nombre1 + " gana la partida completa con " + puntajeJ1 + " puntos!");
        } else if (70 <= puntajeJ2) {
            System.out.println(" ¡" + nombre2 + " gana la partida completa con " + puntajeJ2 + " puntos!");
        }

        scanner.close();
    }

    public static void printManoJugador(Jugador j, String nombre) {
        System.out.println("Mano de " + nombre + ":");
        Jugador.Ficha[] mano = j.getMano();
        for (int i = 0; i < mano.length; i++) {
            if (mano[i] != null) {
                System.out.print(i + ":" + mano[i] + " ");
            } else {
                System.out.print(i + ":vacia ");
            }
        }
        System.out.println();
    }

    public static void printTablero(Jugador.Ficha[] tablero, int fichasLI, int fichaLD) {
        System.out.print("Tablero actual: ");
        for (int i = fichasLI + 1; i < fichaLD; i++) {
            if (tablero[i] != null) {
                System.out.print(tablero[i] + " ");
            }
        }
        System.out.println();
    }
}
