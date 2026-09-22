import java.util.Scanner;

public class Prueba {
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
        u1.setnombre(nombre1);
        j1.elegirModo(numero);
        
        System.out.print("¿Cómo se llama el jugador 2? ");
        String nombre2 = scanner.nextLine();
        u2.setnombre(nombre2);
        j2.elegirModo(numero);
        
    }
    
}
