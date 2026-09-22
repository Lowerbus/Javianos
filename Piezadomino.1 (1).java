import java.util.Scanner;

public class Piezadomino {

    public static class Ficha {
        int ladoA;
        int ladoB;

        public Ficha(int ladoA, int ladoB) {
            this.ladoA = ladoA;
            this.ladoB = ladoB;
        }

        @Override
        public String toString() {
            return "[" + ladoA + "|" + ladoB + "]";
        }
    }

    public Ficha[] elegirModo(int numero) {
        if (numero == 6) {
            Ficha[] a = new Ficha[35];
            int totalPiezas = 0;
            
            for (int i = 0; i < 7; i++) {
                for (int j = i; j < 7; j++) {
                    a[totalPiezas] = new Ficha(i, j); 
                    totalPiezas++;
                }
            }
            
            for (int i = 0; i < 7; i++) {
                a[totalPiezas] = new Ficha(99, i); 
                totalPiezas++;
            }
            
            boolean[] usados = new boolean[totalPiezas];
            Ficha[] fichasSeleccionadas = new Ficha[7];
            
            for (int k = 0; k < 7; k++) {
                int random;
                do {
                    random = (int) (Math.random() * totalPiezas);
                } while (usados[random]);
                
                usados[random] = true;
                fichasSeleccionadas[k] = a[random]; 
                
                
                System.out.println(k+":"+fichasSeleccionadas[k] + " ");
            }
            System.out.println(); 
            return fichasSeleccionadas; 
        }
        else if (numero == 7) {
            Ficha[] a = new Ficha[44];
            int totalPiezas = 0;
            
            for (int i = 0; i < 8; i++) {
                for (int j = i; j < 8; j++) {
                    a[totalPiezas] = new Ficha(i, j);
                    totalPiezas++;
                }
            }
            
            for (int i = 0; i < 8; i++) {
                a[totalPiezas] = new Ficha(99, i);
                totalPiezas++;
            }
            
            boolean[] usados = new boolean[totalPiezas];
            Ficha[] fichasSeleccionadas = new Ficha[7];
            
            for (int k = 0; k < 7; k++) {
                int random;
                do {
                    random = (int) (Math.random() * totalPiezas);
                } while (usados[random]);
                
                usados[random] = true;
                fichasSeleccionadas[k] = a[random];
                
                System.out.println(k+":"+fichasSeleccionadas[k] + " ");
            }
            System.out.println();
            return fichasSeleccionadas;
        }
        else if (numero == 8) {
            Ficha[] a = new Ficha[54];
            int totalPiezas = 0;
            
            for (int i = 0; i < 9; i++) {
                for (int j = i; j < 9; j++) {
                    a[totalPiezas] = new Ficha(i, j);
                    totalPiezas++;
                }
            }
            
            for (int i = 0; i < 9; i++) {
                a[totalPiezas] = new Ficha(99, i);
                totalPiezas++;
            }
            
            boolean[] usados = new boolean[totalPiezas];
            Ficha[] fichasSeleccionadas = new Ficha[7];
            
            for (int k = 0; k < 7; k++) {
                int random;
                do {
                    random = (int) (Math.random() * totalPiezas);
                } while (usados[random]);
                
                usados[random] = true;
                fichasSeleccionadas[k] = a[random];
                
                
                System.out.println(k+":"+fichasSeleccionadas[k] + " ");
            }
            System.out.println();
            return fichasSeleccionadas;
        }
        return null; 
    }
}
