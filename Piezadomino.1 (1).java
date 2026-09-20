import java.util.Scanner;

public class Piezadomino {
    int ladoA;
    int ladoB;
    public int elegirModo(int numero){
    if(numero == 6){
        int[] a = new int[35];
        int totalPiezas = 0;
        
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                a[totalPiezas] = (i * 10) + j; 
                totalPiezas++;
            }
        }
        
        
        for(int i = 0; i < 7; i++){
            a[totalPiezas] = (99 * 10) + i; 
            
            int ladoA = a[totalPiezas] / 10;
            int ladoB = a[totalPiezas] % 10;
            totalPiezas++;
        }
        
        System.out.println("\n--- Fichas Aleatorias ---");
        for(int k = 0; k < 7; k++){
            int random = (int) (Math.random() * totalPiezas);
            int ladoA = a[random] / 10;
            int ladoB = a[random] % 10;
            System.out.print("[" + ladoA + "|" + ladoB + "]");
        }
        return totalPiezas;
    }
    else if(numero == 7){
        int[] a = new int[44];
        int totalPiezas = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = i; j < 8; j++) {
                a[totalPiezas] = (i * 10) + j;
                totalPiezas++;
            }
        }
        
        for(int i = 0; i < 8; i++){
            a[totalPiezas] = (99 * 10) + i;
            int ladoA = a[totalPiezas] / 10;
            int ladoB = a[totalPiezas] % 10;

            totalPiezas++;
        }
        
        System.out.println("\n--- Fichas Aleatorias ---");
        for(int k = 0; k < 7; k++){
            int random = (int) (Math.random() * totalPiezas);
            int ladoA = a[random] / 10;
            int ladoB = a[random] % 10;
            System.out.print("[" + ladoA + "|" + ladoB + "]");
        }
        return totalPiezas;
    }
    else if(numero == 8){
        int[] a = new int[54];
        int totalPiezas = 0;
        
        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                a[totalPiezas] = (i * 10) + j;
                totalPiezas++;
            }
        }
        
        for(int i = 0; i < 9; i++){
            a[totalPiezas] = (99 * 10) + i;
            int ladoA = a[totalPiezas] / 10;
            int ladoB = a[totalPiezas] % 10;
            totalPiezas++;
        }
        
        System.out.println("\n--- Fichas Aleatorias ---");
        for(int k = 0; k < 7; k++){
            int random = (int) (Math.random() * totalPiezas);
            int ladoA = a[random] / 10;
            int ladoB = a[random] % 10;
            System.out.print("[" + ladoA + "|" + ladoB + "]");
        }
        return totalPiezas;
    }
    return 0;
}
}
