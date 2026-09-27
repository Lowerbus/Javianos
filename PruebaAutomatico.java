import java.util.Scanner;
public class PruebaAutomatico { public static void main(String[] args) { Scanner scanner = new Scanner(System.in); Jugador j1 = new Jugador(); Jugador j2 = new Jugador();
    System.out.print("Que modo desea jugar? ");
    int numero = scanner.nextInt();

    Jugador.Ficha[] miMano = j1.elegirModo(numero);
    JugadorAutomatico bot = new JugadorAutomatico(j2.elegirModo(numero));

    for (int turno = 0; turno < 7; turno++) {
        int k;
        do {
            System.out.print("Elija el numero de su ficha: ");
            k = scanner.nextInt();
        } while (k < 0 || k > 6 || miMano[k] == null);

        Jugador.Ficha mia = miMano[k];
        miMano[k] = null;  // ya la jugó
        System.out.println("Usted juega: " + mia);

        Jugador.Ficha respuesta = bot.responder(mia.ladoA);
        if (respuesta == null) {
            respuesta = bot.responder(mia.ladoB);
        }

        if (respuesta == null) {
            System.out.println("El automatico pasa");
        } else {
            System.out.println("El automatico juega: " + respuesta);
        }
    }
}
}
