import java.util.Scanner;

public class Prueba{
    public static void main(String [] args){
        Piezadomino piezita = new Piezadomino();
        Scanner scanner= new Scanner(System.in);
        System.out.print("que modo desea jugar? ");
        int numero = scanner.nextInt();
        
    piezita.elegirModo(numero);
    
    }
}