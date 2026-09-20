import java.util.Scanner;
public class Piezadomino {
    private int numero;
    
    
    
    
    
    
    
 
 
 
    
public int elegirModo(int numero){
if(numero==6){
int[][] a = new int[35][2];
int totalPiezas= 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                a[totalPiezas][0]=i;
                a[totalPiezas][1]=j;
                totalPiezas++;
                
        }   }
        for(int i= 0; i < 7; i++){
            a[totalPiezas][0] = 99;
            a[totalPiezas][1] = i;
        
            System.out.print("["+a[totalPiezas][0]+"|"+a[totalPiezas][1]+"]");
            totalPiezas++;
        }
        for(int k = 0;k < 7;k++){
        int random = (int) (Math.random() * totalPiezas);

        System.out.print("["+a[random][0]+"|"+a[random][1]+ "]");
    }return totalPiezas;
}else if(numero==7){
    int[][] b = new int[44][2];
    int totalPiezas=0;
        for (int i = 0; i < 8; i++) {
            for (int j = i; j < 8; j++) {
                b[totalPiezas][0]=i;
                b[totalPiezas][1]=j;
                System.out.print("["+b[totalPiezas][0]+"|"+b[totalPiezas][1]+"]");
                totalPiezas++;
                
        }   }
        for(int i = 0; i < 8; i++){
            b[totalPiezas][0]= 99;
            b[totalPiezas][1]= i;
            System.out.print("["+b[totalPiezas][0]+"|"+b[totalPiezas][1]+"]");
            totalPiezas++;
        }
        for(int k = 0;k < 7;k++){
        int random = (int) (Math.random() * totalPiezas);

        System.out.print("["+b[random][0]+"|"+b[random][1]+ "]");
    
  
        }return totalPiezas;
}else if(numero==8){
    int [][] c = new int[54][2];
    int totalPiezas = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                c[totalPiezas][0]=i;
                c[totalPiezas][1]=j;
                
                
                
                System.out.print("["+i+"|"+j+"]");
                totalPiezas++;
        }   }
        for(int i = 0; i < 9; i++){
            c[totalPiezas][0]=99;
            c[totalPiezas][1]=i;
            System.out.print("["+c[totalPiezas][0]+"|"+c[totalPiezas][1]+"]"); 
               
                totalPiezas++;
                
           
        }
           for(int k = 0;k < 7;k++){
        int random = (int) (Math.random() * totalPiezas);

        System.out.print("["+c[random][0]+"|"+c[random][1]+ "]");
        
}
     return totalPiezas;
    
    } 
   return 0;
}

}
