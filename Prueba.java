import java.util.Scanner;

public class Prueba{
    public static void main(String [] args){
        
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        
        Scanner scanner= new Scanner(System.in);
        System.out.print("que modo desea jugar? ");
        int numero = scanner.nextInt();
        
        
        j1.elegirModo(numero);
        
        j2.elegirModo(numero);
        
        
        
        
    
    
    }
}
