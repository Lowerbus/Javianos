public class Jugador {

    public static class Ficha {
        public int ladoA;
        public int ladoB;

        public Ficha(int ladoA, int ladoB) {
            this.ladoA = ladoA;
            this.ladoB = ladoB;
        }

        @Override
        public String toString() {
            String strA = (ladoA == 99) ? "C" : String.valueOf(ladoA);
            String strB = (ladoB == 99) ? "C" : String.valueOf(ladoB);
            return "[" + strA + "|" + strB + "]";
        }
    }

    private Ficha[] mano;

    public Jugador() {
        this.mano = new Ficha[7];
    }

    public Ficha[] getMano() {
        return mano;
    }

    public void elegirModo(int numero) {
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
            for (int k = 0; k < 7; k++) {
                int random;
                do {
                    random = (int) (Math.random() * totalPiezas);
                } while (usados[random]);

                usados[random] = true;
                this.mano[k] = a[random];

                System.out.print(k + ":" + this.mano[k] + " ");
            }
            System.out.println();
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
            for (int k = 0; k < 7; k++) {
                int random;
                do {
                    random = (int) (Math.random() * totalPiezas);
                } while (usados[random]);

                usados[random] = true;
                this.mano[k] = a[random];

                System.out.print(k + ":" + this.mano[k] + " ");
            }
            System.out.println();
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
            for (int k = 0; k < 7; k++) {
                int random;
                do {
                    random = (int) (Math.random() * totalPiezas);
                } while (usados[random]);

                usados[random] = true;
                this.mano[k] = a[random];

                System.out.print(k + ":" + this.mano[k] + " ");
            }
            System.out.println();
        }
    }

    public Ficha tomarDelPozo(int numero) {
        if (numero == 6) {
            int limite = 35;
            Ficha[] todas = new Ficha[limite];
            int idx = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = i; j < 7; j++) {
                    todas[idx++] = new Ficha(i, j);
                }
            }
            for (int i = 0; i < 7; i++) {
                todas[idx++] = new Ficha(99, i);
            }
            int aleatorio = (int) (Math.random() * limite);
            return todas[aleatorio];
        } else if (numero == 7) {
            int limite = 44;
            Ficha[] todas = new Ficha[limite];
            int idx = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = i; j < 8; j++) {
                    todas[idx++] = new Ficha(i, j);
                }
            }
            for (int i = 0; i < 8; i++) {
                todas[idx++] = new Ficha(99, i);
            }
            int aleatorio = (int) (Math.random() * limite);
            return todas[aleatorio];
        } else if (numero == 8) {
            int limite = 54;
            Ficha[] todas = new Ficha[limite];
            int idx = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = i; j < 9; j++) {
                    todas[idx++] = new Ficha(i, j);
                }
            }
            for (int i = 0; i < 9; i++) {
                todas[idx++] = new Ficha(99, i);
            }
            int aleatorio = (int) (Math.random() * limite);
            return todas[aleatorio];
        }
        return new Ficha(0, 0);
    }
}