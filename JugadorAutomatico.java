public class JugadorAutomatico { private Jugador.Ficha[] mano;
public JugadorAutomatico(Jugador.Ficha[] mano) {
    this.mano = mano;
}

public Jugador.Ficha responder(int valor) {
    for (int i = 0; i < mano.length; i++) {
        if (mano[i] != null) {
            if (mano[i].ladoA == valor || mano[i].ladoB == valor) {
                Jugador.Ficha elegida = mano[i];
                mano[i] = null;  // ya se jugó
                return elegida;
            }
        }
    }
    return null;  // no tiene ficha, pasa
}
}
